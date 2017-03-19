package dbTool;

import info.Contacts;
import info.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

public class LoginCon {
	
	/**
	 * ����tb_user���ݱ�У���û���¼��Ϣ
	 * ���У��ɹ�������User����
	 * @param con
	 * @param username
	 * @param password
	 * @return
	 * @throws SQLException
	 */
	public static User loginCheck(Connection con, String username, String password) throws SQLException {
		String sql = "select * from tb_user where username = ? and password = ?";
		PreparedStatement pstm = con.prepareStatement(sql);
		pstm.setString(1, username);
		pstm.setString(2, password);
		ResultSet rs = null;
		rs= pstm.executeQuery();
		User user = null;
		try{
			//�˺�����У��ɹ�
			if(rs.next()){
				user = new User();
				user.setId(rs.getInt("id"));
				user.setUsername(rs.getString("username"));
				user.setMail(rs.getString("mail"));
				user.setPhone(rs.getString("mobilephone"));
				user.setContactsGrounp(getContacts(con, username));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return user;
	}
	
	/**
	 * ��ȡ�û�����ϵ����Ϣ,����װ�ɶ���
	 * @param conn
	 * @param username
	 * @return
	 * @throws SQLException
	 */
	private static Vector<Contacts> getContacts(Connection conn, String username) throws SQLException{
		Vector<Contacts> vContactsGroup = new Vector<Contacts>();
		int i = 0;
		String sql = "select * from tb_contacts where username = ?";
		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setString(1, username);
		ResultSet rs = pstm.executeQuery();
		while(rs.next()){
			Contacts contacts = new Contacts();
				contacts.setUid(rs.getInt("uid"));
				contacts.setUsername(rs.getString("username"));
				contacts.setName(rs.getString("name"));
				contacts.setPhone(rs.getInt("phone"));
				contacts.setSex(rs.getString("sex"));
				contacts.setBirthday(rs.getString("birthday"));
				contacts.setAddress(rs.getString("address"));
				contacts.setPostcode(rs.getString("postcode"));
				contacts.setWorkplace(rs.getString("workplace"));
				contacts.setWorkphone(rs.getString("workphone"));
				contacts.setGroupName(rs.getString("groupname"));
				vContactsGroup.add(contacts);
		} 
		return vContactsGroup;
	}
}
