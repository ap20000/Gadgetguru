// GadgetDbController.java
package controller.database;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.LoginResult;
import model.PasswordEncryptionWithAes;
import model.ProductModel;
import model.ProductModeldata;
import model.UserLoginModel;
import model.AccessoriesUserModel;

import util.stringUtil;

public class GadgetDbController {

	private static final String url = "jdbc:mysql://localhost:3306/gadgetguru_accessories";
	private static final String user = "root";
	private static final String pass = "";

	public Connection getConnection() throws SQLException, ClassNotFoundException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		return DriverManager.getConnection(url, user, pass);
	}

	public ArrayList<AccessoriesUserModel> getAllStudent() {
		try (Connection con = getConnection();
				PreparedStatement st = con.prepareStatement(stringUtil.GET_LOGIN_STUDENT_INFO)) {
			ResultSet rs = st.executeQuery();
			ArrayList<AccessoriesUserModel> users = new ArrayList<>();

			while (rs.next()) {
				AccessoriesUserModel user = new AccessoriesUserModel();
				user.setUser_Name(rs.getString("User_name"));
				user.setFull_Name(rs.getString("first_name"));
				user.setEmail(rs.getString("email"));
				user.setPhone_Number(rs.getString("Phone_number"));
				user.setDob(rs.getDate("dob").toLocalDate());

				user.setAddress(rs.getString("Address"));
				user.setGender(rs.getString("gender"));
				user.setImageUrlFromDB(rs.getString("user_image"));

				users.add(user);
			}
			return users;

		} catch (SQLException | ClassNotFoundException ex) {
			ex.printStackTrace();
			return null;
		}

	}

	public boolean isUsernameExists(String username) {
		try (Connection con = getConnection();
				PreparedStatement st = con.prepareStatement("SELECT COUNT(*) FROM user WHERE user_Name = ?")) {
			st.setString(1, username);
			try (ResultSet rs = st.executeQuery()) {
				if (rs.next()) {
					int count = rs.getInt(1);
					return count > 0;
				}
			}
		} catch (SQLException | ClassNotFoundException ex) {
			ex.printStackTrace();
		}
		return false;
	}

	public boolean isEmailExists(String email) {
		try (Connection con = getConnection();
				PreparedStatement st = con.prepareStatement("SELECT COUNT(*) FROM user WHERE email = ?")) {
			st.setString(1, email);
			try (ResultSet rs = st.executeQuery()) {
				if (rs.next()) {
					int count = rs.getInt(1);
					return count > 0;
				}
			}
		} catch (SQLException | ClassNotFoundException ex) {
			ex.printStackTrace();
		}
		return false;
	}

	public boolean isPhoneNumberExists(String phoneNumber) {
		try (Connection con = getConnection();
				PreparedStatement st = con.prepareStatement("SELECT COUNT(*) FROM user WHERE phone_Number = ?")) {
			st.setString(1, phoneNumber);
			try (ResultSet rs = st.executeQuery()) {
				if (rs.next()) {
					int count = rs.getInt(1);
					return count > 0;
				}
			}
		} catch (SQLException | ClassNotFoundException ex) {
			ex.printStackTrace();
		}
		return false;
	}

	public int addUser(AccessoriesUserModel userModel) {
		try (Connection con = getConnection(); PreparedStatement st = con.prepareStatement(stringUtil.INSERT_User)) {
			st.setString(1, userModel.getUser_Name());
			st.setString(2, userModel.getFull_Name());
			st.setString(3, userModel.getEmail());
			st.setString(4, userModel.getPhone_Number());
			st.setDate(5, Date.valueOf(userModel.getDob()));
			st.setString(6, userModel.getAddress());
			st.setString(7, PasswordEncryptionWithAes.encrypt(userModel.getUser_Name(), userModel.getPassword()));
			st.setString(8, userModel.getGender());
			st.setString(9, userModel.getUserImageUrl()); // Store file path instead of image data
			st.setString(10, userModel.getRole());
			int result = st.executeUpdate();

			if (result > 0) {
				return 1; // Success
			} else {
				return 0; // No rows affected
			}
		} catch (ClassNotFoundException | SQLException ex) {
			ex.printStackTrace();
			return -1; // Error
		}
	}

//	public int getUserLoginInfo(UserLoginModel loginModel) {
//	    try (Connection con = getConnection()) {
//	        PreparedStatement st = getConnection().prepareStatement(stringUtil.GET_LOGIN_STUDENT_INFO);
//
//	        // Set the username in the first parameter of the prepared statement
//	        st.setString(1, loginModel.getUser_name());
//
//	        ResultSet rs = st.executeQuery();
//	        if (rs.next()) {
//
//	            String userDb = rs.getString("user_name");
//
//	            String encryptedPwd = rs.getString(stringUtil.password);
//
//	            System.out.println("encryptedPwd: " + encryptedPwd);
//	            String decryptedPwd = PasswordEncryptionWithAes.decrypt(encryptedPwd, userDb);
//	            System.out.println("decryptedPwd: " + decryptedPwd);
//
//	            if (userDb.equalsIgnoreCase(loginModel.getUser_name()) && decryptedPwd != null && decryptedPwd.equals((loginModel).getPassword())) {
//	                // Login successful, return 1
//	                return 1;
//	            } else {
//	                // Username or password mismatch, return 0
//	                return 0;
//	            }
//	        } else {
//	            // Username not found in the database, return -1
//	            return -1;
//	        }
//	    } catch (SQLException | ClassNotFoundException ex) {
//	        ex.printStackTrace();
//	        return -2;
//	    }
//	}

	public LoginResult getUserLoginInfo(UserLoginModel loginModel) {
		try (Connection con = getConnection()) {
			PreparedStatement st = con.prepareStatement(stringUtil.GET_LOGIN_STUDENT_INFO);

			// Set the username in the first parameter of the prepared statement
			st.setString(1, loginModel.getUser_Name());

			ResultSet rs = st.executeQuery();
			if (rs.next()) {

				String userDb = rs.getString("user_name");

				String encryptedPwd = rs.getString(stringUtil.password);

				String decryptedPwd = PasswordEncryptionWithAes.decrypt(encryptedPwd, userDb);

				if (userDb.equalsIgnoreCase(loginModel.getUser_Name()) && decryptedPwd != null
						&& decryptedPwd.equals((loginModel).getPassword())) {
					String role = rs.getString("role"); // Assuming 'role' is the column name for the user's role
					if (role != null) {
						// User role found, return login result with role
						return new LoginResult(1, role); // 1 indicates successful login
					} else {
						// Role not found, return login result without role
						return new LoginResult(1, null); // 1 indicates successful login
					}
				} else {
					// Username or password mismatch, return login result without role
					return new LoginResult(0, null); // 0 indicates username or password mismatch
				}
			} else {
				// Username not found in the database, return login result without role
				return new LoginResult(-1, null); // -1 indicates username not found
			}
		} catch (SQLException | ClassNotFoundException ex) {
			ex.printStackTrace();
			return new LoginResult(-2, null); // -2 indicates error
		}
	}

	public AccessoriesUserModel getuserprofile(String username) {
        try (Connection con = getConnection()) {
            PreparedStatement st = con.prepareStatement("SELECT * FROM user WHERE user_Name = ?");
            st.setString(1, username);
            ResultSet rs = st.executeQuery();

            if (rs.next()) {
            	AccessoriesUserModel userprofile = new AccessoriesUserModel();
            	userprofile.setUser_Name(rs.getString("user_Name"));
            	userprofile.setFull_Name(rs.getString("full_Name"));
            	userprofile.setEmail(rs.getString("email"));
            	userprofile.setPhone_Number(rs.getString("phone_Number"));
            	userprofile.setDob(rs.getDate("dob").toLocalDate());
            	userprofile.setGender(rs.getString("address"));
            	userprofile.setAddress(rs.getString("gender"));
//                userProfile.setImageUrlFromDB(rs.getString("user_image"));
                return userprofile;
            } else {
                // User not found in the database
                return null;
            }
        } catch (SQLException | ClassNotFoundException ex) {
            ex.printStackTrace();
            return null;
        }
    }
	 public int Profileupdate(AccessoriesUserModel user) {
	        try (Connection con = getConnection();
	             PreparedStatement st = con.prepareStatement("UPDATE user SET full_Name=?, email=?, phone_Number=?, address=? WHERE user_Name=?")) {                 
	            st.setString(1, user.getFull_Name());
	            st.setString(2, user.getEmail());
	            st.setString(3, user.getPhone_Number());
	            st.setString(4, user.getAddress());
	            st.setString(5, user.getUser_Name());

	            return st.executeUpdate();
	        } catch (SQLException | ClassNotFoundException e) {
	            e.printStackTrace();
	            return -1; // Error
	        }
	    }
	public int updateUserPassword(String username, String newPassword) {
		try (Connection con = getConnection();
				PreparedStatement st = con.prepareStatement("UPDATE user SET password = ? WHERE user_Name = ?")) {
			st.setString(1, PasswordEncryptionWithAes.encrypt(username, newPassword));
			st.setString(2, username);

			int result = st.executeUpdate();

			if (result > 0) {
				return 1; // Password updated successfully
			} else {
				return 0; // No rows affected (username not found)
			}
		} catch (ClassNotFoundException | SQLException ex) {
			ex.printStackTrace();
			return -1; // Error
		}
	}

	public int  updateUserPasswordIfValid(String username, String newPassword) {
		try (Connection con = getConnection()) {
			// Check if the username exists in the database
			if (isUsernameExists(username)) {
				// Username exists, update the password
				return updateUserPassword(username, newPassword);
			} else {
				// Username not found, return -1
				return -1;
			}
		} catch (SQLException | ClassNotFoundException ex) {
			ex.printStackTrace();
			return -3; // Error
		}
	}

	public int deletegadgetguru(int deleteId) {
        try (Connection con = getConnection(); 
             PreparedStatement st = con.prepareStatement("DELETE FROM computer WHERE computer_Id = ?")) {
            st.setInt(1, deleteId);
            
            return st.executeUpdate();

        } catch (ClassNotFoundException | SQLException ex) {
            ex.printStackTrace();
            return -1; // Error
        }
    }

//	public int isAdmin(String username) {
//		try (Connection con = getConnection();
//				PreparedStatement st = con.prepareStatement("SELECT role FROM user WHERE user_Name = ?")) {
//			st.setString(1, username);
//			ResultSet rs = st.executeQuery();
//			if (rs.next()) {
//				// User name match in the database
//				String thisRole = rs.getString("role");
//				if (thisRole.equalsIgnoreCase("admin")) {
//					return 1;
//				} else {
//					return 0;
//				}
//			} else {
//				// No matching record found
//				return -2;
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} catch (ClassNotFoundException ex) {
//			ex.printStackTrace();
//		}
//		return -1;
//	}

	public int addProduct(ProductModel productModel) {
		try (Connection con = getConnection();
				PreparedStatement st = con.prepareStatement(
						"INSERT INTO computer (computer_name, price,  product_image) VALUES (?, ?,  ?)")) {
			st.setString(1, productModel.getComputer_name());
			st.setDouble(2, productModel.getPrice());
			st.setString(3, productModel.getUserImageUrl());
			int result = st.executeUpdate();

			if (result > 0) {
				return 1; // Success
			} else {
				return 0; // No rows affected
			}
		} catch (ClassNotFoundException | SQLException ex) {
			ex.printStackTrace();
			return -1; // Error
		}
	}

	public ArrayList<ProductModeldata> getAllProducts() {
	    try (Connection conn = getConnection();
	            PreparedStatement stmt = conn.prepareStatement("SELECT * FROM computer");
	            ResultSet rs = stmt.executeQuery()) {

	        ArrayList<ProductModeldata> prods = new ArrayList<>();
	        while (rs.next()) {
	            ProductModeldata prod = new ProductModeldata();
	            prod.setProductId(rs.getInt("computer_Id"));
	            prod.setProductName(rs.getString("computer_name"));
	            prod.setPrice(rs.getDouble("price"));
	            prod.setImageUrl(rs.getString("product_image"));
	            prods.add(prod);
	        }

	        return prods;
	    } catch (SQLException | ClassNotFoundException e) {
	        e.printStackTrace();
	        // Handle the exception appropriately, such as logging or throwing a custom exception
	    }
	    return null;
	}
	public int updateAccessories(ProductModeldata accessories) {
        try (Connection con = getConnection();
             PreparedStatement rs = con.prepareStatement("UPDATE computer SET computer_name = ?, price = ? WHERE computer_Id = ?")) {
        	rs.setString(1, accessories.getProductName());
            rs.setDouble(2, accessories.getPrice());
          
            rs.setInt(3, accessories.getProductId());


            int result = rs.executeUpdate();

            if (result > 0) {
                System.out.println("Database updated successfully");
                return 1; // Success
            } else {
                System.out.println("No rows affected, database not updated");
                return 0; // No rows affected
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            return -1; // Error
        }
    }
	
	

}
