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
	    public void insertProduct(ArrayList<ProductDataDTO> pdd, int masterId) throws SQLException{
	        Connection con = null;
	        PreparedStatement st = null;

	        try{
	            con = DBManager.getConnection();

	    		for (int i=0; i<pdd.size(); i++) {
	    			String sql = "INSERT INTO Products(product_master_id,product_color_id,product_size,stock_quantity) VALUES(?,?,?,?)";
	    			st =  con.prepareStatement(sql);

		            st.setInt(1,masterId);
		            st.setInt(2,pdd.get(i).getPColor());
		            st.setString(3,pdd.get(i).getSize());
		            st.setInt(4, pdd.get(i).getStock());
		            st.executeUpdate();
	    		}
	    		System.out.println("商品データを入力しました");
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
