package dbTool;

import java.sql.*;

import org.omg.CORBA.PRIVATE_MEMBER;

import util.Check;

public class DbCon {
	private static String username = "root";
	private static String password = "root";
	private static String dbUrl = "jdbc:mysql://127.0.0.1:3306/respondence";
	private static String jdbcName = "com.mysql.jdbc.Driver";
	
	/**
	 * 建立数据库连接，并返回
	 * @return
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public static Connection getCon() throws ClassNotFoundException, SQLException{
		Class.forName(jdbcName);
		Connection con = DriverManager.getConnection(dbUrl, username, password);
		return con;
		
	}
	
	
	/**
	 * 关闭数据库
	 * @param con
	 */
	public static void closeCon(Connection con) {
		if(con != null){
			try{
				con.close();
			}catch(Exception e) {
				
			}
		} else {
			System.out.println("数据库关闭失败!");
		}
	}
	
}
