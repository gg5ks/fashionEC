package jums;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import base.DBManager;

public class ProductMasterDAO {

    //インスタンスオブジェクトを返却させてコードの簡略化
    public static ProductMasterDAO getInstance(){
        return new ProductMasterDAO();
    }

    //マスターの登録と登録idの返却
    public ProductMasterDTO insert(ProductMasterDTO pmd, ArrayList<String> imgList, int adminId) throws SQLException{
        Connection con = null;
        PreparedStatement st = null;
        try{
            con = DBManager.getConnection();
            st =  con.prepareStatement
            		("INSERT INTO ProductMasters(product_master_name,product_price,product_cost,product_description,product_image1,product_exibition_status,admin_id) VALUES(?,?,?,?,?,?,?)");
            st.setString(1, pmd.getMasterName());
            st.setInt(2, pmd.getListPrice());
            st.setInt(3, pmd.getCost());
            st.setString(4, pmd.getProductDescript());
            st.setString(5, imgList.get(0));
            st.setBoolean(6, pmd.getPublish());
            st.setInt(7, adminId);
            st.executeUpdate();


            System.out.println("insert completed");


    		String sql = "SELECT product_master_id FROM ProductMasters WHERE product_master_name=? AND product_price=? AND product_cost=? AND product_description=?";

            st =  con.prepareStatement(sql);
            st.setString(1, pmd.getMasterName());
            st.setInt(2, pmd.getListPrice());
            st.setInt(3, pmd.getCost());
            st.setString(4, pmd.getProductDescript());

            ResultSet rs = st.executeQuery();
            rs.next();
            ProductMasterDTO resultPd = new ProductMasterDTO();
            int masterid = rs.getInt(1);
            resultPd.setMasterId(masterid);

            System.out.println("マスターidをセット");

            //画像入れるやつ(メソッドわけてもいいかも)
            if(imgList.size()>1) {

            	String imgs = "UPDATE ProductMasters SET ";
            	String addword = "";

            	//1は登録済みで、2からなのでiは2
            	for (int i=2; i<imgList.size()+1; i++) {
            		if(i==2) {
                		addword = "product_image"+i+"=?";
                		imgs += addword;
                		continue;
            		}

            		addword = ",product_image"+i+"=?";
            		imgs += addword;

            	}

            	String sql4img = imgs + " WHERE product_master_id=" + masterid;

            	st =  con.prepareStatement(sql4img);

            	for (int i=1; i<imgList.size(); i++) {
            		st.setString(i, imgList.get(i));
            	}

            	System.out.println(st);
                st.executeUpdate();
                System.out.println("imgいれた");
            }

            return resultPd;

        }catch(SQLException e){
            System.out.println(e.getMessage());
            throw new SQLException(e);
        }finally{
            if(con != null){
                con.close();
            }
        }
    }
        //マスターの登録と登録idの返却
        public ArrayList<ProductMasterDTO> searchMasterId() throws SQLException{
            Connection con = null;
            PreparedStatement st = null;
            try{
            	con = DBManager.getConnection();
                st =  con.prepareStatement ("SELECT product_master_id FROM ProductMasters");
                ResultSet rs = st.executeQuery();

                ArrayList<ProductMasterDTO> resultPd = new ArrayList<ProductMasterDTO> ();

                while(rs.next()) {
                int masterid = rs.getInt("product_master_id");
                ProductMasterDTO masters = new ProductMasterDTO();
                masters.setMasterId(masterid);
                resultPd.add(masters);

                }

                return resultPd;

            }catch(SQLException e){
                System.out.println(e.getMessage());
                throw new SQLException(e);
            }finally{
                if(con != null){
                    con.close();
                }
            }
        }

        //商品登録の検索
        public ArrayList<ProductMasterDTO> searchProduct(ProductMasterDTO pmd,ProductDataDTO pdd, int publishCheck) throws SQLException{
            Connection con = null;
            PreparedStatement st = null;

            //product_master_id,product_master_name,product_cost,integer,product_color_id,product_size,stock_quantity, product_exibition_status
    		//?の位置を判定するために配列を用意
    		ArrayList<String> params = new ArrayList<>();

            try{
            	con = DBManager.getConnection();

            	String sql ="SELECT * FROM Products INNER JOIN ProductMasters on Products.product_master_id = ProductMasters.product_master_id";
                boolean flag = false;

                if (pmd.getMasterId()!=0) {
                    sql += " WHERE Products.product_master_id = ?";
                    flag = true;
    				params.add("materId");
                }
                if (!pmd.getMasterName().equals("")) {
                    if(!flag){
                        sql += " WHERE product_master_name like ?";
                        flag = true;
                    }else{
                        sql += " AND product_master_name like ?";
                    }
        			params.add("masterName");
                }
                if (pdd.getPColor()!=0) {
                    if(!flag){
                        sql += " WHERE product_color_id =?";
                        flag = true;
                    }else{
                        sql += " AND product_color_id = ?";
                    }
        			params.add("color");
                }
                if (!pdd.getSize().equals("")) {
                    if(!flag){
                        sql += " WHERE product_size = ?";
                        flag = true;
                    }else{
                        sql += " AND product_size =?";
                    }
        			params.add("size");
                }
                if (publishCheck != 9) {
                    if(!flag){
                        sql += " WHERE product_exibition_status = ?";
                        flag = true;
                    }else{
                        sql += " AND product_exibition_status =?";
                    }
        			params.add("publish");
                }
                st =  con.prepareStatement(sql);

                int index = 0;
                if (params.contains("materId")) {
                	st.setInt(++index, pmd.getMasterId());
                }
                if (params.contains("masterName")) {
                    st.setString(++index, "%"+pmd.getMasterName()+"%");

            	}
                if (params.contains("color")) {
                	st.setInt(++index, pdd.getPColor());
                }
                if (params.contains("size")) {
                    st.setString(++index, pdd.getSize());
                }
                if (params.contains("publish")) {
                    st.setBoolean(++index, pmd.getPublish());
                }
                System.out.println(st);
                ResultSet rs = st.executeQuery();
                ArrayList<ProductMasterDTO> productList = new ArrayList<ProductMasterDTO> ();

                while(rs.next()) {

                ProductMasterDTO resultPd = new ProductMasterDTO();

	           	 //resultPd(javabeans)(のアレイリスト)に結果をセットしていく
	           	 resultPd.setMasterId(rs.getInt("product_master_id"));
	           	 resultPd.setMasterName(rs.getString("product_master_name"));
	           	 resultPd.setListPrice(rs.getInt("product_price"));
	           	 Boolean p = rs.getBoolean("product_exibition_status");
	           	 if (p) {
	           		resultPd.setPublish(1);
	           	 }else {
	           		resultPd.setPublish(0);
	           	 }
	           	 resultPd.setSize(rs.getString("product_size"));
	           	 resultPd.setPColor(rs.getInt("product_color_id"));
	           	 resultPd.setStock(rs.getInt("stock_quantity"));
	           	System.out.println(rs.getInt("stock_quantity"));
	           	productList.add(resultPd);

                }
                System.out.println("検索終了");
                return productList;

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
