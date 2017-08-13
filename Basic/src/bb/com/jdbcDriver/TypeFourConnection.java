/*
Type 4 Connection

*/
package bb.com.jdbcDriver;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.SQLException;

public class TypeFourConnection{
	public static void main(String[] args){
		Connection con = null;
		Statement stmt = null;
		
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@localhost:1521:XE";
			String user = "system";
			String password = "root";
			
			con = DriverManager.getConnection(url, user, password);
			
			System.out.println("Connection Established");
		}catch(ClassNotFoundException e){
			System.out.println("Class not found Error " + e.getMessage());
		}catch(SQLException e){
			System.out.println("sql error " + e.getMessage());
		}finally{
			
			if(con != null){
				try{
					con.close();
					System.out.println("Disconnected");
				}catch(SQLException e){
					System.out.println("Connection closing error " + e.getMessage());
				}
			}
			
		}
	}
}