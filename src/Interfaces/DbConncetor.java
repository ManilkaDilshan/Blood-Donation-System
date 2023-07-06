package Interfaces;
import java.sql.Connection;
import java.sql.DriverManager;

public class DbConncetor {
	
	public static Connection getConnection() {
		
		Connection con = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/bloodDonation", "root", "");
        } catch (Exception ex) {
            System.out.println(ex);
        }
        
        return con;
        
	}
	

	
}
