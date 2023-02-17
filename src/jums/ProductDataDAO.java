package jums;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import base.DBManager;

public class ProductDataDAO {
	    public static ProductDataDAO getInstance(){
	        return new ProductDataDAO();
	    }

	    //商品登録用
	    public void insertProduct(ArrayList<ProductDataDTO> pdd, int masterId, int adminId) throws SQLException{
	        Connection con = null;
	        PreparedStatement st = null;

	        try{
	            con = DBManager.getConnection();

	    		for (int i=0; i<pdd.size(); i++) {
	    			String sql = "INSERT INTO Products(product_master_id,product_color_id,product_size,stock_quantity,admin_id) VALUES(?,?,?,?,?)";
	    			st =  con.prepareStatement(sql);

		            st.setInt(1,masterId);
		            st.setInt(2,pdd.get(i).getPColor());
		            st.setString(3,pdd.get(i).getSize());
		            st.setInt(4, pdd.get(i).getStock());
		            st.setInt(5,adminId);
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
        //商品詳細表示用
        public ArrayList<ProductDataDTO> proDetailInfo(int masterId) throws SQLException{
            Connection con = null;
            PreparedStatement st = null;

            try{
            	con = DBManager.getConnection();
            	st =  con.prepareStatement ("SELECT * FROM Products WHERE product_master_id = ?");

            	st.setInt(1, masterId);
                ResultSet rs = st.executeQuery();

                ArrayList<ProductDataDTO> resultList = new ArrayList<ProductDataDTO>();

                while(rs.next()) {
                	ProductDataDTO resultPd = new ProductDataDTO();


	           	 //resultPd(javabeans)(のアレイリスト)に結果をセットしていく
	           	 resultPd.setPColor(rs.getInt("product_color_id"));
	           	 resultPd.setSize(rs.getString("product_size"));
	           	 resultPd.setStock(rs.getInt("stock_quantity"));

	           	 resultList.add(resultPd);
                }
                System.out.println("詳細用見つけた4product");
                return resultList;

            }catch(SQLException e){
                System.out.println(e.getMessage());
                throw new SQLException(e);
            }finally{
                if(con != null){
                    con.close();
                }
            }

    }

	    public ArrayList<ProductDataDTO> UserIndexProduct(ProductMasterDTO PmDTO) throws SQLException{
			 Connection con = null;
			 PreparedStatement st = null;


		        try{
		            con = DBManager.getConnection();

		            String sql = "SELECT product_color_id,product_size FROM Products where product_master_id = ?;";
		            st =  con.prepareStatement(sql);
		            st.setInt(1,PmDTO.getMasterId());

		            System.out.println(st);

		            ResultSet rs = st.executeQuery();
		            ArrayList<ProductDataDTO> PdCSList = new ArrayList<ProductDataDTO>();

		        while(rs.next()) {
	           	 //繰り返しinstanceを生成し続ける
		        	ProductDataDTO resultUd = new ProductDataDTO();

	           	 //resultUd(dto)(のアレイリスト)に結果をセットしていく

		        	resultUd.setPColor(rs.getInt(1));
		            resultUd.setSize(rs.getString(2));

	                //resultUd(インスタンス1）に結果が入ったリストをセットする→インスタンス2以降も格納続ける
	                PdCSList.add(resultUd);
	            }

		        return PdCSList;

		        }catch(SQLException e){
		            System.out.println(e.getMessage());
		            throw new SQLException(e);
		        }finally{
		            if(con != null){
		                con.close();
		            }
		        }
		 }

        //削除用
        public void deleteProduct(int masterId) throws SQLException{
            Connection con = null;
            PreparedStatement st = null;

            try{
                con = DBManager.getConnection();
                st =  con.prepareStatement ("UPDATE Products SET product_delete_flag = 1 WHERE product_master_id=?");
                st.setInt(1, masterId);
                st.executeUpdate();

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
