package jums;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import base.DBManager;

public class ProductMasterDAO {

    //インスタンスオブジェクトを返却させてコードの簡略化
    public static ProductMasterDAO getInstance(){
        return new ProductMasterDAO();
    }

    public void insert(ProductMasterDTO pmd) throws SQLException{
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
