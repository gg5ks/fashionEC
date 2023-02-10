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

	 public AdminDataDTO IDPWCheck(String MailPara, String PassPara) throws SQLException{
		 Connection con = null;
		 PreparedStatement st = null;
		 AdminDataDTO resultUd = new AdminDataDTO();

		 try{
	        con = DBManager.getConnection();
        	st = con.prepareStatement("select * from user where mail=? and pass=? and deleteflag = false");
        	st.setString(1, MailPara);
        	st.setString(2, PassPara);
        	ResultSet rs = st.executeQuery();

	        if(rs.next()) {
	            resultUd.setUserID(rs.getInt(1));
	            resultUd.setUserName(rs.getString(2));
	            resultUd.setMail(rs.getString(3));
	            resultUd.setPass(rs.getString(4));
	            resultUd.setDeleteFlag(rs.getBoolean(5));
	            if(!(rs.getDate(6) == null)) {
		            resultUd.setBirthday(rs.getDate(6));
	            }
	            if(!(rs.getTimestamp(7) == null)) {
	            	resultUd.setLoginAt(rs.getTimestamp(7));
	            }
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
}
