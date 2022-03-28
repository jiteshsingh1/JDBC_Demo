package jdbc.com.app;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;



public class JDBC_demo {
	public static void main(String[] args) {
		String url = "jdbc:mysql://localhost:3306/student";
		String Uname = "root";
		String Password ="User@684";
		String query = "Select * from studentdata";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		}catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		try {
			Connection con = DriverManager.getConnection(url,Uname,Password);
			Statement statement = con.createStatement();
			ResultSet result = statement.executeQuery(query);
			while (result.next()){
				String student_data = "";
				for(int i = 1 ;i<=4;i++) {
					student_data += result.getString(i)+ ":";
				}
				System.out.println(student_data);
			}
			
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}