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

	



	public boolean UsernameExists(String user_Name) {
		try (Connection con = getConnection();
				PreparedStatement st = con.prepareStatement("SELECT COUNT(*) FROM user WHERE user_Name = ?")) {
			st.setString(1, user_Name);
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

	public boolean EmailExists(String user_email) {
		try (Connection con = getConnection();
				PreparedStatement st = con.prepareStatement("SELECT COUNT(*) FROM user WHERE email = ?")) {
			st.setString(1, user_email);
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

	public boolean PhoneNumberExists(String phone_Number) {
		try (Connection con = getConnection();
				PreparedStatement st = con.prepareStatement("SELECT COUNT(*) FROM user WHERE phone_Number = ?")) {
			st.setString(1, phone_Number);
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

	public int AddUserNew(AccessoriesUserModel userModel) {
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

	public LoginResult getUserInfo(UserLoginModel accessoriesLogin) {
		try (Connection con = getConnection()) {
			PreparedStatement st = con.prepareStatement(stringUtil.GET_LOGIN_STUDENT_INFO);

			// Set the username in the first parameter of the prepared statement
			st.setString(1, accessoriesLogin.getUser_Name());

			ResultSet rs = st.executeQuery();
			if (rs.next()) {

				String accessoriesuser = rs.getString("user_name");

				String encryptedPwd = rs.getString(stringUtil.password);

				String decryptedPwd = PasswordEncryptionWithAes.decrypt(encryptedPwd, accessoriesuser);

				if (accessoriesuser.equalsIgnoreCase(accessoriesLogin.getUser_Name()) && decryptedPwd != null
						&& decryptedPwd.equals((accessoriesLogin).getPassword())) {
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
            	AccessoriesUserModel useraaprofile = new AccessoriesUserModel();
            	useraaprofile.setUser_Name(rs.getString("user_Name"));
            	useraaprofile.setFull_Name(rs.getString("full_Name"));
            	useraaprofile.setEmail(rs.getString("email"));
            	useraaprofile.setPhone_Number(rs.getString("phone_Number"));
            	useraaprofile.setDob(rs.getDate("dob").toLocalDate());
            	useraaprofile.setGender(rs.getString("address"));
            	useraaprofile.setAddress(rs.getString("gender"));
//                userProfile.setImageUrlFromDB(rs.getString("user_image"));
                return useraaprofile;
            } else {
                // User not found in the database
                return null;
            }
        } catch (SQLException | ClassNotFoundException ex) {
            ex.printStackTrace();
            return null;
        }
    }
	 public int Profileupdate(AccessoriesUserModel accessoriesuser) {
	        try (Connection con = getConnection();
	             PreparedStatement st = con.prepareStatement("UPDATE user SET full_Name=?, email=?, phone_Number=?, address=? WHERE user_Name=?")) {                 
	            st.setString(1, accessoriesuser.getFull_Name());
	            st.setString(2, accessoriesuser.getEmail());
	            st.setString(3, accessoriesuser.getPhone_Number());
	            st.setString(4, accessoriesuser.getAddress());
	            st.setString(5, accessoriesuser.getUser_Name());

	            return st.executeUpdate();
	        } catch (SQLException | ClassNotFoundException e) {
	            e.printStackTrace();
	            return -1; // Error
	        }
	    }
	public int updateUseraccessoriesPassword(String username, String newPassword) {
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

	public int  ValidupdateUserPassword(String username, String newPassword) {
		try (Connection con = getConnection()) {
			// Check if the username exists in the database
			if (UsernameExists(username)) {
				// Username exists, update the password
				return updateUseraccessoriesPassword(username, newPassword);
			} else {
				// Username not found, return -1
				return -1;
			}
		} catch (SQLException | ClassNotFoundException ex) {
			ex.printStackTrace();
			return -3; // Error
		}
	}

	public int deletegadgetguru(int accessoriesId) {
        try (Connection con = getConnection(); 
             PreparedStatement st = con.prepareStatement("DELETE FROM computer WHERE computer_Id = ?")) {
            st.setInt(1, accessoriesId);
            
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

	public int AddProductAccessories(ProductModel accessoriesModel) {
		try (Connection con = getConnection();
				PreparedStatement st = con.prepareStatement(
						"INSERT INTO computer (computer_name, price,  product_image) VALUES (?, ?,  ?)")) {
			st.setString(1, accessoriesModel.getComputer_name());
			st.setDouble(2, accessoriesModel.getPrice());
			st.setString(3, accessoriesModel.getUserImageUrl());
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

	public ArrayList<ProductModeldata> getAllAccessories() {
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
