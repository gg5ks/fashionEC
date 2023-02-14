package jums;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import base.DBManager;

public class ProductMasterDAO {

    //インスタンスオブジェクトを返却させてコードの簡略化
    public static ProductMasterDAO getInstance(){
        return new ProductMasterDAO();
    }

    //マスターの登録と登録idの返却
    public ProductMasterDTO insert(ProductMasterDTO pmd) throws SQLException{
        Connection con = null;
        PreparedStatement st = null;
        try{
            con = DBManager.getConnection();
            st =  con.prepareStatement("INSERT INTO ProductMasters(product_master_name,product_price,product_cost,product_description) VALUES(?,?,?,?)");
            st.setString(1, pmd.getMasterName());
            st.setInt(2, pmd.getListPrice());
            st.setInt(3, pmd.getCost());
            st.setString(4, pmd.getProductDescript());

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
            resultUd.setMasterId(rs.getInt(1));

            System.out.println("マスターidをセット");

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
