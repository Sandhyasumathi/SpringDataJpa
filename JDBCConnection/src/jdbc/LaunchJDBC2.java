package jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

/**
 * PreparedStatement is the child Interface of Statement
 * It can be used to pass values during the runtime 
 */
public class LaunchJDBC2 {

	public static void main(String[] args) {

		Connection connect=null;
		PreparedStatement state = null;
		
		try {
			connect = JDBCUtil.getConnection();
//			String sql = "Select * from studentinfo;";
//			String sql = "UPDATE studentinfo set sage=? where id=?;";
//			String sql = "Insert into studentinfo(id,sname,sage,scity) values(?,?,?,?);";
			String sql = "DELETE from studentinfo where id=?";
			state = connect.prepareStatement(sql);
			
			Scanner sc = new Scanner(System.in);
			System.out.println("Kindly enter the user id:");
			int id = sc.nextInt();
//			System.out.println("Kindly enter the name :");
//			String name = sc.next();
//			System.out.println("Kindly enter the age :");
//			int age = sc.nextInt();
//			System.out.println("Kindly enter the city :");
//			String city = sc.next();
			
			state.setInt(1, id);
//			state.setString(2, name);
//			state.setInt(3, age);
//			state.setString(4, city);
			
		 
//			ResultSet result = state.executeQuery();
//			 while(result.next()) {
//				 System.out.println(result.getInt(1) + " " + result.getString(2) + " " + result.getInt(3) + " " + result.getString(4));
//			 }
			
			int result = state.executeUpdate();
			if(result==0) {
				System.out.println("No update has been done");
			}else {
				System.out.println(result + " rows has been deleted");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		
		finally {
			try {
				JDBCUtil.closeConnections(connect, state);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}

}
