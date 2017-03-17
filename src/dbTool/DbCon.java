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
	 * �������ݿ����ӣ�������
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
	 * �ر����ݿ�
	 * @param con
	 */
	public static void closeCon(Connection con) {
		if(con != null){
			try{
				con.close();
			}catch(Exception e) {
				
			}
		} else {
			System.out.println("���ݿ�ر�ʧ��!");
		}
	}
	
}
