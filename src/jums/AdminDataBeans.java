package jums;

import java.io.Serializable;

public class AdminDataBeans implements Serializable{
	private String admin_name;
	private String admin_email;
	private String admin_password;
	private boolean admin_delete_flag;

	public AdminDataBeans() {
		this.setAdmin_name("");
		this.setAdmin_email("");
		this.setAdmin_password("");
		this.setAdmin_delete_flag("0");
	}

	//getter setter + trim
	public String getAdmin_name() {
		return admin_name;
	}

	public void setAdmin_name(String admin_name) {
		if(admin_name.trim().length()==0){
            this.admin_name = "";
        }else{
        	this.admin_name = admin_name;
        }
	}

	public String getAdmin_email() {
		return admin_email;
	}

	public void setAdmin_email(String admin_email) {
		if(admin_email.trim().length()==0){
            this.admin_email = "";
        }else{
        	this.admin_email = admin_email;
        }
	}

	public String getAdmin_password() {
		return admin_password;
	}

	public void setAdmin_password(String admin_password) {
		if(admin_password.trim().length()==0){
            this.admin_password = "";
        }else{
        	this.admin_password = admin_password;
        }
    }

	public boolean isAdmin_delete_flag() {
		return admin_delete_flag;
	}

	public void setAdmin_delete_flag(String admin_delete_flag) {
		if(admin_delete_flag.equals("1")) {
			this.admin_delete_flag = true;
		}else {
			this.admin_delete_flag = false;
		}
	}

	// 引数（DTO）にBeansをSetするメソッド
		public void AdAcSearchFMTMap(AdminDataDTO add){
		    add.setAdmin_name(this.admin_name);
		    add.setAdmin_email(this.admin_email);
		    add.setAdmin_password(this.admin_password);
		    add.setAdmin_delete_flag(this.admin_delete_flag);
		}



}
