package jdbc;

import java.sql.*;

/**
 * Steps for creating the DB connection to our java application by using JDBC
 */
public class LaunchJDBC1 {

	public static void main(String[] args) {
		
		/**
		 * Step - 1 : Import all the required packages and jar files to the class path
		 */
		
		Connection connect = null;
		Statement statement = null;
		try {
			/**
			 * Step - 2 : Loading & Register the Driver class
			 */
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			/**
			 * Step - 3 : Establish the Connection to the DB
			 */
			 connect = DriverManager.getConnection("jdbc:mysql://localHost:3306/jdbcconnection","root","root");
			 /**
			  * Step - 4 : Creating the Statement
			  */
			 statement = connect.createStatement();
			 
			 
			 //String sql = "Insert into studentinfo(id,sname,sage,scity) values(4,'Name4',18,'city4');";
			 
			// String sql = "UPDATE studentinfo set sage=21 where id=2;";
			 
			 //String sql = "DELETE from studentinfo where id=4";
			 
			 String sql = "Select * from studentinfo;";
			 
			 /**
			  * Step - 5 : Executing the statement
			  */
			 //execute() is the common method for all the operations
			 //int rowsinserted = statement.executeUpdate(sql); (method for Insert, update and delete)
			 ResultSet result = statement.executeQuery(sql); //(method for select)
			 
			 /**
			  * Step - 6 : Processing the Statement
			  */
			 while(result.next()) {
				 System.out.println(result.getInt(1) + " " + result.getString(2) + " " + result.getInt(3) + " " + result.getString(4));
			 }
			 
//			 System.out.println("No of rows inserted " + rowsinserted);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}  catch (Exception e) {
			e.printStackTrace();
		}
		
		/**
		 * Closing the resources
		 */
		finally {
			try {
				connect.close();
				statement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
		

	}

}
