package jums;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import base.DBManager;

public class CartDataDAO {
	public static CartDataDAO getInstance(){
        return new CartDataDAO();
    }

	public void insertCart(CartDataDTO CDD) throws SQLException{
		Connection con = null;
        PreparedStatement st = null;

        try{
            con = DBManager.getConnection();
            String sql = "INSERT INTO Cart_Items(user_id,product_id,product_quantity) VALUES(?,?,?)";
            st =  con.prepareStatement(sql);
            st.setInt(1, CDD.getUser_id());
            st.setInt(2, CDD.getProduct_id());
            st.setInt(3, CDD.getQuantity());

            st.executeUpdate();

            System.out.println("カートに登録しました");

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
