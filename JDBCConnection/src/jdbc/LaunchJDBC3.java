package jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

/**
 * Batch update can be used to update bulk values at a time
 * This can be done for Insert, update and delete 
 */
public class LaunchJDBC3 {

	public static void main(String[] args) {

		Connection connect=null;
		PreparedStatement state = null;
		
		try {
			connect = JDBCUtil.getConnection();
//			String sql = "Select * from studentinfo;";
			String sql = "UPDATE studentinfo set sage=? where id=?;";
//			String sql = "Insert into studentinfo(id,sname,sage,scity) values(?,?,?,?);";
//			String sql = "DELETE from studentinfo where id=?";
			state = connect.prepareStatement(sql);
						
			state.setInt(1, 55);
			state.setInt(2, 1);
			state.addBatch();
			state.setInt(1, 56);
			state.setInt(2, 2);
			state.addBatch();
			state.setInt(1, 57);
			state.setInt(2, 3);
			state.addBatch();
			state.setInt(1, 58);
			state.setInt(2, 5);
			state.addBatch();
			
			state.executeBatch();
		 
			System.out.println("Uptation completed");
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
