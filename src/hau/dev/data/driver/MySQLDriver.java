package hau.dev.data.driver;

import java.sql.Connection;
import java.sql.DriverManager;
import static hau.dev.util.Constants.*;

public class MySQLDriver {
     private static MySQLDriver instance;
     private MySQLDriver() {
    	 
     }
     public static MySQLDriver getInstance() {
    	 if(instance == null) instance = new MySQLDriver();
    	 return instance;
     }
     public Connection getConnection() {
         try {
             Class.forName("com.mysql.cj.jdbc.Driver");
             Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
             System.out.println("Kết nối MySQL thành công!");
             return conn;
         } catch (Exception e) {
             e.printStackTrace();
             return null; // Hoặc throw RuntimeException để dễ debug hơn
         }
     }
}
