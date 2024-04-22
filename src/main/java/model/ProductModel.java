package model;

import java.io.File;

import javax.servlet.http.Part;

import util.stringUtil;

public class ProductModel {
    private String computer_name;
    private double price;

    private String userImageUrl;

    public ProductModel(String computer_name, double price, Part user_image) {
        super();
        this.computer_name = computer_name;
        this.price = price;
     
        this.userImageUrl = getImageUrl(user_image);
    }

	public String getComputer_name() {
		return computer_name;
	}

	public void setComputer_name(String computer_name) {
		this.computer_name = computer_name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
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
    	if (part == null) {
            return "default_image.jpg"; // Return a default image URL or handle this case as per your requirement
        }
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
        if ( userImageUrl== null || userImageUrl.isEmpty()) {
            userImageUrl = "download.jpg";
        }
        return userImageUrl;
    }

	
}
