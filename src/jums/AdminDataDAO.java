package jums;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import base.DBManager;

public class AdminDataDAO {
	public static AdminDataDAO getInstance(){
        return new AdminDataDAO();
    }

	 public AdminDataDTO IDPWCheck(String mail) throws SQLException{
		 Connection con = null;
		 PreparedStatement st = null;
		 AdminDataDTO resultUd = new AdminDataDTO();

		 try{
	        con = DBManager.getConnection();
        	st = con.prepareStatement("select * from Admins where admin_email=?");
        	st.setString(1, mail);
        	ResultSet rs = st.executeQuery();

	        if(rs.next()) {
	            resultUd.setAdmin_id(rs.getInt(1));
	            resultUd.setAdmin_name(rs.getString(2));
	            resultUd.setAdmin_email(rs.getString(3));
	            resultUd.setAdmin_password(rs.getString(4));
	            resultUd.setAdmin_delete_flag(rs.getBoolean(5));
	        }else {
	        	return null;
	        }
        	System.out.println("ユーザーを検索しました");
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
}
