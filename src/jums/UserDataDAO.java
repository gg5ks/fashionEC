package jums;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import base.DBManager;

public class UserDataDAO {

	public static UserDataDAO getInstance(){
        return new UserDataDAO();
    }

	 public UserDataDTO LoginCheck(String mail, String pass) throws SQLException{
		 Connection con = null;
		 PreparedStatement st = null;
		 UserDataDTO resultUd = new UserDataDTO();

		 try{
	        con = DBManager.getConnection();
        	st = con.prepareStatement("select * from Users where user_email=? and user_password=? and user_delete_flag = false");
        	st.setString(1, mail);
        	st.setString(2, pass);
        	ResultSet rs = st.executeQuery();

	        if(rs.next()) {
	            resultUd.setUser_id(rs.getInt(1));
	            resultUd.setUser_name(rs.getString(2));
	            resultUd.setUser_delete_flag(rs.getBoolean(3));
	            resultUd.setUser_email(rs.getString(4));
	            resultUd.setUser_password(rs.getString(5));
	            resultUd.setUser_postid(rs.getInt(6));
	            resultUd.setUser_address(rs.getString(7));
	            resultUd.setUser_tell(rs.getString(8));
	            resultUd.setUser_created_at(rs.getTimestamp(9));
	        }else {
	        	return null;
	        }

	            return resultUd;

	        }catch(SQLException e){
	            System.out.println(e.getMessage());
	            throw new SQLException(e);
	        }finally{
	            if(con != null){
	                con.close();
	            }
	        }
	 }

	 public void NewUser(UserDataDTO udd) throws SQLException{
	        Connection con = null;
	        PreparedStatement st = null;
	        try{
	            con = DBManager.getConnection();
	            st =  con.prepareStatement("INSERT INTO Users(user_name,user_email,user_password,user_postid,user_address,user_tell) VALUES(?,?,?,?,?,?)");

	            // ? => set
	            st.setString(1, udd.getUser_name());
	            st.setString(2, udd.getUser_email());
	            st.setString(3, udd.getUser_password());
	            st.setInt(4, udd.getUser_postid());
	            st.setString(5, udd.getUser_address());
	            st.setString(6, udd.getUser_tell());

	            st.executeUpdate();

	            System.out.println("insert completed");

	        }catch(SQLException e){
	            System.out.println(e.getMessage());
	            throw new SQLException(e);
	        }finally{
	            if(con != null){
	                con.close();
	            }
	        }
	 }
}
