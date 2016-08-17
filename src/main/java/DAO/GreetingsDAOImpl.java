package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;




import java.sql.SQLException;
import java.sql.Statement;

import DBConnection.DatabaseConnection;
import DTO.GreetingsDTO;

public class GreetingsDAOImpl implements GreetingsDAO{

	
	public GreetingsReponse insertRow(GreetingsDTO greeting) {
		
		GreetingsReponse response = new GreetingsReponse();
		DatabaseConnection db_cn = new DatabaseConnection();
		Connection cn= db_cn.getConnection();
		String sql = "INSERT INTO greetings (greeting) values(?)";
		PreparedStatement stmt;
		ResultSet rs;
		try {
			stmt = cn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			stmt.setString(1,greeting.getGreeting());
			stmt.executeUpdate();
			rs = stmt.getGeneratedKeys();

			 while (rs.next()) {
	             System.out.println("Key returned from getGeneratedKeys():"
	                     + rs.getInt(1));
	             response.setPrimary_key(rs.getInt(1));
	         } 
			 
			 response.setResponse(greeting.getGreeting());
	         rs.close();
	         
		} catch (SQLException e1) {
			
			response.setResponse("Failed to execute greeting");
			e1.printStackTrace();
		}
		
		return response;
	}


}
