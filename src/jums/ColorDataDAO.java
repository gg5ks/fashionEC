package jums;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import base.DBManager;

public class ColorDataDAO {
    public static ColorDataDAO getInstance(){
        return new ColorDataDAO();
    }

	 public ArrayList<ColorDataDTO> colorReceive(ColorDataDTO color) throws SQLException{
		 Connection con = null;
		 PreparedStatement st = null;


	        try{
	            con = DBManager.getConnection();

	            String sql = "SELECT * FROM Colors;";
	            st =  con.prepareStatement(sql);
	            System.out.println(st);

	            ResultSet rs = st.executeQuery();
	            ArrayList<ColorDataDTO> resultList = new ArrayList<ColorDataDTO>();

	        while(rs.next()) {
           	 //繰り返しinstanceを生成し続ける
	        	ColorDataDTO resultUd = new ColorDataDTO();

           	 //resultUd(dto)(のアレイリスト)に結果をセットしていく

	        	resultUd.setColorId(rs.getInt("color_id"));
	            resultUd.setColorName(rs.getString("color_name"));
	            resultUd.setColorCate(rs.getInt("color_category"));
	            resultUd.setColorCss(rs.getString("color_css_number"));

                //resultUd(インスタンス1）に結果が入ったリストをセットする→インスタンス2以降も格納続ける
                resultList.add(resultUd);
            }

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
}