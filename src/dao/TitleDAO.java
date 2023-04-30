package dao;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TitleDAO {
	private final String JDBC_URL = "jdbc:h2:tcp://localhost/~/3ch";
	private final String DB_USER = "sa";
	private final String DB_PASS = "";

	public boolean registerTitle(Thread thread) {

		try(Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)){

			String sql = "INSERT INTO TITLE (NAME) VALUES ('"+thread.getName()+"')";
			Statement pStmt = conn.createStatement();
			pStmt.executeUpdate(sql);
		}
		catch(SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public boolean TitleIntoFile() {
		try {
			PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("タイトル.txt")));

			try(Connection conn = DriverManager.getConnection(JDBC_URL,DB_USER,DB_PASS)) {
				PreparedStatement ps = conn.prepareStatement("SELECT NAME FROM TITLE");
				ResultSet rs = ps.executeQuery();
				while(rs.next()) {
					pw.write(rs.getString("NAME")+"\n");
				}
			}
			catch(SQLException e) {
				e.printStackTrace();
				return false;
			}
			pw.close();
		}
		catch(IOException e) {
			e.printStackTrace();
			return false;
		}

		return true;
	}

	public boolean SerchTitle(String title) {
		try {
			PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("サーチ.txt")));

			try(Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)){
				PreparedStatement ps = conn.prepareStatement("SELECT NAME FROM TITLE WHERE NAME LIKE '%"+title+"%'");
				ResultSet rs = ps.executeQuery();
				while(rs.next()) {
					pw.write(rs.getString("NAME")+"\n");
				}
			}
			catch(SQLException e) {
				e.printStackTrace();
				return false;
			}
			pw.close();
		}
		catch(IOException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public int CommentNumber(String title) {
		int num = 0;
		try(Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)){
			PreparedStatement ps = conn.prepareStatement("SELECT NUMBER FROM TITLE WHERE NAME = '"+title+"'");
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				num = rs.getInt("NUMBER");
				num++;
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
			return -1;
		}

		try(Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)){
			String sql = "UPDATE Title SET NUMBER ='"+num+"' WHERE NAME = '"+title+"'";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			pStmt.executeUpdate();
			conn.commit();
		}
		catch(SQLException e) {
			e.printStackTrace();
			return -1;
		}
		return num;
	}
}
