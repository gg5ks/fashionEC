package jums;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import base.DBManager;

public class ProductDataDAO {
	    public static ProductDataDAO getInstance(){
	        return new ProductDataDAO();
	    }

	    //商品登録用
	    public void insertProduct(ArrayList<ProductDataDTO> pdd) throws SQLException{
	        Connection con = null;
	        PreparedStatement st = null;

	        try{
	            con = DBManager.getConnection();

	    		for (int i=0; i<pdd.size(); i++) {
	    			String sql = "INSERT INTO Products(userID,itemCode,type,cartID) VALUES(?,?,?,?)";
	    			st =  con.prepareStatement(sql);

		            st.setInt(1,userID);
		            st.setString(2,udd.get(i).getItemCode());
		            st.setInt(3,udd.get(i).getType());
		            st.setInt(4, udd.get(i).getCartID());
		            st.executeUpdate();
	    		}
	    		System.out.println("商品データを入力しました");
	        }


}
