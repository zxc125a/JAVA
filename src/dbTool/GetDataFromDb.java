package dbTool;

import info.Contacts;
import info.User;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLClientInfoException;
import java.sql.SQLException;

import view.ContactInfo;

public class GetDataFromDb {
	 public static int getGid(Contacts contact, User user) throws SQLException, ClassNotFoundException {
		 String sql = "select * from tb_group where username = ? and groupname = ?";
		 PreparedStatement pstm = DbCon.getCon().prepareStatement(sql);
		 pstm.setString(1, user.getUsername()); 
		 pstm.setString(2, contact.getGroupName());
		 ResultSet rs = pstm.executeQuery();
		 if(rs.next()){
			 return rs.getInt(1);
		 }
		 return 0;
	 }
}
