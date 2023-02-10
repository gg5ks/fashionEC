package base;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBManager {
    public static Connection getConnection(){

        Connection con = null;

        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/fashionEC_db","root","");
            // ?useUnicode=true&characterEncoding=UTF8
            System.out.println("DBConnected!!");
            return con;

        }catch(ClassNotFoundException e){
        	System.out.println("ClassNotFound");
            throw new IllegalMonitorStateException();
        }catch(SQLException e){
        	System.out.println("SQLException");
            throw new IllegalMonitorStateException();
        }catch(Exception e){
        	System.out.println("Exception");
            throw new IllegalMonitorStateException();
        }
    }
}
