package model;

import java.io.File;

import java.time.LocalDate;

import javax.servlet.http.Part;

import util.stringUtil;

public class AccessoriesUserModel {
	private String user_Name;
	private String full_Name;
	private String email;
	private String phone_Number;
	private LocalDate dob;
	private String address;
	private String password;
	private String gender;
	private String userImageUrl;
	private String role;
	// New field for address

	public AccessoriesUserModel() {
	}

	public AccessoriesUserModel(String user_Name, String full_Name, String email, String phone_Number, LocalDate dob,
			String address, String password, String gender, Part user_image, String role) {
		super();
		this.user_Name = user_Name;
		this.full_Name = full_Name;
		this.email = email;
		this.phone_Number = phone_Number;
		this.dob = dob;
		this.password = password;
		this.gender = gender;
		this.address = address;
		this.userImageUrl = getImageUrl(user_image);
		this.role = role;
	}

	public String getUser_Name() {
		return user_Name;
	}

	public void setUser_Name(String user_Name) {
		this.user_Name = user_Name;
	}

	public String getFull_Name() {
		return full_Name;
	}

	public void setFull_Name(String full_Name) {
		this.full_Name = full_Name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone_Number() {
		return phone_Number;
	}

	public void setPhone_Number(String phone_Number) {
		this.phone_Number = phone_Number;
	}

	public LocalDate getDob() {
		return dob;
	}

	public void setDob(LocalDate dob) {
		this.dob = dob;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getUserImageUrl() {
		return userImageUrl;
	}

	public void setUserImageUrl(Part part) {
		this.userImageUrl = getImageUrl(part);
	}

	public void setImageUrlFromDB(String imageUrl) {
		this.userImageUrl = imageUrl;
	}

	private String getImageUrl(Part part) {
		String savePath = stringUtil.IMAGE_DIR_SAVE_PATH;
		File fileSaveDir = new File(savePath);
		String userImageUrl = null;
		if (!fileSaveDir.exists()) {
			fileSaveDir.mkdir();
		}
		String contentDisp = part.getHeader("content-disposition");
		String[] items = contentDisp.split(";");
		for (String s : items) {
			if (s.trim().startsWith("filename")) {
				userImageUrl = s.substring(s.indexOf("=") + 2, s.length() - 1);
			}
		}
		if (userImageUrl == null || userImageUrl.isEmpty()) {
			userImageUrl = "download.jpg";
		}
		return userImageUrl;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

}
