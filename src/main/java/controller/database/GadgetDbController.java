// GadgetDbController.java
package controller.database;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.PasswordEncryptionWithAes;
import model.UserLoginModel;
import model.UserModel;

import util.stringUtil;

public class GadgetDbController {

	private static final String url = "jdbc:mysql://localhost:3306/gadgetguru_accessories";
	private static final String user = "root";
	private static final String pass = "";

	public Connection getConnection() throws SQLException, ClassNotFoundException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		return DriverManager.getConnection(url, user, pass);
	}

	public ArrayList<UserModel> getAllStudent() {
		try (Connection con = getConnection();
				PreparedStatement st = con.prepareStatement(stringUtil.GET_LOGIN_STUDENT_INFO)) {
			ResultSet rs = st.executeQuery();
			ArrayList<UserModel> users = new ArrayList<>();

			while (rs.next()) {
				UserModel user = new UserModel();
				user.setUser_name(rs.getString("User_name"));
				user.setFull_name(rs.getString("first_name"));
				user.setEmail(rs.getString("email"));
				user.setPhone_number(rs.getString("Phone_number"));
				user.setDob(rs.getDate("dob").toLocalDate());

				user.setPhone_number(rs.getString("Address"));
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
				PreparedStatement st = con.prepareStatement("SELECT COUNT(*) FROM user WHERE user_name = ?")) {
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
				PreparedStatement st = con.prepareStatement("SELECT COUNT(*) FROM user WHERE phone_number = ?")) {
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

	public int addUser(UserModel userModel) {
		try (Connection con = getConnection(); PreparedStatement st = con.prepareStatement(stringUtil.INSERT_User)) {
			st.setString(1, userModel.getUser_name());
			st.setString(2, userModel.getFull_name());
			st.setString(3, userModel.getEmail());
			st.setString(4, userModel.getPhone_number());
			st.setDate(5, Date.valueOf(userModel.getDob()));
			st.setString(6, userModel.getAddress());
			st.setString(7, PasswordEncryptionWithAes.encrypt(userModel.getUser_name(), userModel.getPassword()));
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

	public int getUserLoginInfo(UserLoginModel loginModel) {
	    try (Connection con = getConnection()) {
	        PreparedStatement st = getConnection().prepareStatement(stringUtil.GET_LOGIN_STUDENT_INFO);

	        // Set the username in the first parameter of the prepared statement
	        st.setString(1, loginModel.getUser_name());

	        ResultSet rs = st.executeQuery();
	        if (rs.next()) {

	            String userDb = rs.getString("user_name");

	            String encryptedPwd = rs.getString(stringUtil.password);

	            String decryptedPwd = PasswordEncryptionWithAes.decrypt(encryptedPwd, userDb);

	            if (userDb.equalsIgnoreCase(loginModel.getUser_name()) && decryptedPwd != null && decryptedPwd.equals((loginModel).getPassword())) {
	                // Login successful, return 1
	                return 1;
	            } else {
	                // Username or password mismatch, return 0
	                return 0;
	            }
	        } else {
	            // Username not found in the database, return -1
	            return -1;
	        }
	    } catch (SQLException | ClassNotFoundException ex) {
	        ex.printStackTrace();
	        return -2;
	    }
	}

	public int updateUserPassword(String username, String newPassword) {
        try (Connection con = getConnection();
             PreparedStatement st = con.prepareStatement("UPDATE user SET password = ? WHERE user_name = ?")) {
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

    public int updateUserPasswordIfValid(String username, String newPassword) {
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



    


}
