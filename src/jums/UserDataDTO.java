package jums;

import java.sql.Timestamp;

public class UserDataDTO {
	private int user_id;
	private String user_name;
	private boolean user_delete_flag;
	private String user_email;
	private String user_password;
	private int user_postid;
	private String user_address;
	private String user_tell;
	private Timestamp user_created_at;


	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public boolean isUser_delete_flag() {
		return user_delete_flag;
	}
	public void setUser_delete_flag(boolean user_delete_flag) {
		this.user_delete_flag = user_delete_flag;
	}

	public String getUser_email() {
		return user_email;
	}
	public void setUser_email(String user_email) {
		this.user_email = user_email;
	}

	public String getUser_password() {
		return user_password;
	}
	public void setUser_password(String user_password) {
		this.user_password = user_password;
	}

	public int getUser_postid() {
		return user_postid;
	}
	public void setUser_postid(int user_postid) {
		this.user_postid = user_postid;
	}

	public String getUser_address() {
		return user_address;
	}
	public void setUser_address(String user_address) {
		this.user_address = user_address;
	}

	public String getUser_tell() {
		return user_tell;
	}
	public void setUser_tell(String user_tell) {
		this.user_tell = user_tell;
	}

	public Timestamp getUser_created_at() {
		return user_created_at;
	}
	public void setUser_created_at(Timestamp user_created_at) {
		this.user_created_at = user_created_at;
	}


}
