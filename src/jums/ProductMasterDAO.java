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
    public ProductMasterDTO insert(ProductMasterDTO pmd, ArrayList<String> imgList) throws SQLException{
        Connection con = null;
        PreparedStatement st = null;
        try{
            con = DBManager.getConnection();
            st =  con.prepareStatement
            		("INSERT INTO ProductMasters(product_master_name,product_price,product_cost,product_description,product_image1,product_exibition_status) VALUES(?,?,?,?,?,?)");
            st.setString(1, pmd.getMasterName());
            st.setInt(2, pmd.getListPrice());
            st.setInt(3, pmd.getCost());
            st.setString(4, pmd.getProductDescript());
            st.setString(5, imgList.get(0));
            st.setBoolean(6, pmd.getPublish());

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
            ProductMasterDTO resultUd = new ProductMasterDTO();
            int masterid = rs.getInt(1);
            resultUd.setMasterId(masterid);

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
