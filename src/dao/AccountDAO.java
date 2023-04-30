package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import model.Account;
import model.Login;
import model.Registration;

public class AccountDAO {
	private final String JDBC_URL = "jdbc:h2:tcp://localhost/~/3ch";
	private final String DB_USER = "sa";
	private final String DB_PASS = "";

	public Account findByLogin(Login login) {
		Account account = null;

		try(Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)){

			String sql = "SELECT USER_ID, PASS FROM ACCOUNT WHERE USER_ID = ? AND PASS = ?";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, login.getUserId());
			pStmt.setString(2, login.getPass());

			ResultSet rs = pStmt.executeQuery();

			if(rs.next()) {
				String userId = rs.getString("USER_ID");
				String pass = rs.getString("PASS");
				account = new Account(userId, pass);
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
			return null;
		}

		return account;
	}

	public boolean registrationUser(Registration registration) {

		try(Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)){

			String sql = "INSERT INTO ACCOUNT (USER_ID, PASS) VALUES ('"+registration.getUserId()+"','"+registration.getPass()+"')";
			Statement pStmt = conn.createStatement();
			pStmt.executeUpdate(sql);
		}
		catch(SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
}
