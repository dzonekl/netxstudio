package com.netxforge.netxstudio.emf.teneo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


/**
 * FIXME. DO NOT USE, DOESN't WORK (yet). 
 * 
 * @author dzonekl
 *
 */
public class DBService {

	public static final DBService INSTANCE = new DBService();
	
	
	public Connection connect(String url, String uid, String pass) {

		Connection con = null;
		try {
			con = DriverManager.getConnection(url,uid, pass);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return con;
	}

	public void drop(Connection con, String dbName) {
		Statement stmt;
		try {
			stmt = con.createStatement();
			stmt.executeQuery("DROP DATABASE " + dbName);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void create(Connection con, String dbName) {
		Statement stmt;
		try {
			stmt = con.createStatement();
			stmt.executeQuery("CREATE DATABASE " + dbName);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
}
