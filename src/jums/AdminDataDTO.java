package jums;

public class AdminDataDTO {
	private int admin_id;
	private String admin_name;
	private String admin_email;
	private String admin_password;
	private boolean admin_delete_flag;

	public int getAdmin_id() {
		return admin_id;
	}
	public void setAdmin_id(int admin_id) {
		this.admin_id = admin_id;
	}

	public String getAdmin_name() {
		return admin_name;
	}
	public void setAdmin_name(String admin_name) {
		this.admin_name = admin_name;
	}

	public String getAdmin_email() {
		return admin_email;
	}
	public void setAdmin_email(String admin_email) {
		this.admin_email = admin_email;
	}

	public String getAdmin_password() {
		return admin_password;
	}
	public void setAdmin_password(String admin_password) {
		this.admin_password = admin_password;
	}

	public boolean isAdmin_delete_flag() {
		return admin_delete_flag;
	}
	public void setAdmin_delete_flag(boolean admin_delete_flag) {
		this.admin_delete_flag = admin_delete_flag;
	}


}
