package dbTool;

import info.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginCon {
	
	public static User loginCheck(Connection con, String username, String password) throws SQLException {
		String sql = "select * from tb_user where username = ? and username = ?";
		PreparedStatement pstm = con.prepareStatement(sql);
		pstm.setString(1, username);
		pstm.setString(2, username);
		ResultSet rs = null;
		rs= pstm.executeQuery();
		User user = null;
		try{
			if(rs.next()){
				user = new User();
				user.setId(rs.getInt("id"));
				user.setUsername(rs.getString("username"));
				user.setPassword(rs.getString("password"));
				user.setMail(rs.getString("mail"));
				user.setPhone(rs.getString("mobilephone"));
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return user;
	}
}
