package dbTool;

import info.Contacts;
import info.User;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;


import util.Check;

public class GetDataFromDb {
	
	
	/**
	 * 根据组外键关联，获取分组ID号
	 * @param contact
	 * @param user
	 * @return
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
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
	 
	 /**
	  * 根据查询条件，从数据库获取指定记录
	  * @param contact
	  * @param user
	  * @return
	  * @throws SQLException
	  * @throws ClassNotFoundException
	  */
	 public static Vector<Contacts> getInfoFromdb(Contacts contact, User user) throws SQLException, ClassNotFoundException {
		 StringBuffer sql =  new StringBuffer("select * from tb_contacts where username = '" + user.getUsername() + "'");
		 Vector<Contacts> contacts =  new Vector<Contacts>();
		 if(!Check.isEmpty(contact.getName())){
			 sql.append(" and name like '%" + contact.getName() + "%'");
		 }
		 if(!Check.isEmpty(contact.getPhone())){
			 sql.append(" and phone like '%" + contact.getPhone() + "%'");
		 }
		 if(!Check.isEmpty(contact.getTelephone())){
			 sql.append(" and telephone like '%" + contact.getTelephone() + "%'");
		 }
		 if(!Check.isEmpty(contact.getSex())){
			 sql.append(" and sex like '%" + contact.getSex() + "%'");
		 }
		 if(!Check.isEmpty(contact.getGroupName())){
			 sql.append(" and groupName like '%" + contact.getGroupName() + "%'");
		 }
		 PreparedStatement pstm = DbCon.getCon().prepareStatement(sql.toString());
		 ResultSet rs = pstm.executeQuery();
		 while(rs.next()){
				Contacts newContacts = new Contacts();
				newContacts.setUid(rs.getInt("uid"));
				newContacts.setUsername(rs.getString("username"));
				newContacts.setName(rs.getString("name"));
				newContacts.setPhone(rs.getString("phone"));
				newContacts.setSex(rs.getString("sex"));
				newContacts.setBirthday(rs.getString("birthday"));
				newContacts.setAddress(rs.getString("address"));
				newContacts.setEmail(rs.getString("email"));
				newContacts.setWorkplace(rs.getString("workplace"));
				newContacts.setTelephone(rs.getString("telephone"));
				newContacts.setGroupName(rs.getString("groupname"));
				newContacts.setGid(rs.getInt("gid"));
				newContacts.setImgPath(rs.getString("imgPath"));
				user.getAllGroupName().add(rs.getString("groupname"));
				contacts.add(newContacts);
		 }
		 return contacts;
	 }
	 
	 /**
	  * 判断tb_group表中是否存在groupname的联系组名,存在该组名返回true,不存在该组名返回false
	 * @throws ClassNotFoundException 
	 * @throws SQLException 
	  */
	public static boolean existGroupName(User user, String groupname) throws SQLException, ClassNotFoundException{
		
		Boolean flag = false;
		String sql = "select * from tb_group where username = ? and groupname = ?";
		PreparedStatement pstm = DbCon.getCon().prepareStatement(sql);
		pstm.setString(1, user.getUsername());
		pstm.setString(2, groupname);
		ResultSet rs = pstm.executeQuery();
		if(rs.next()) {
			flag = true;
		}
		return flag;
	}
	
	/**
	 * 获取用户所有联系组
	 */
	public static Vector<String> getGroupName(User user) throws SQLException, ClassNotFoundException{
		
		//Boolean flag = false;
		String sql = "select * from tb_group where username = ?";
		PreparedStatement pstm = DbCon.getCon().prepareStatement(sql);
		pstm.setString(1, user.getUsername());
		ResultSet rs = pstm.executeQuery();
		Vector<String> groupname = new Vector<String>();
		while(rs.next()){
			groupname.add(rs.getString("groupname"));
		}
		return groupname;
	}

/**
 * 获取用户某一分组下的所有联系人
 */
	public static Vector<Contacts> getContactsOfGroup(String groupname) throws SQLException, ClassNotFoundException{
	
	//	Boolean flag = false;
		String sql = "select * from tb_contacts where groupname = ?";
		PreparedStatement pstm = DbCon.getCon().prepareStatement(sql);
		pstm.setString(1, groupname);
		ResultSet rs = pstm.executeQuery();
		Vector<Contacts> contacts = new Vector<Contacts>();
		while(rs.next()){
			Contacts newContacts = new Contacts();
			newContacts.setUid(rs.getInt("uid"));
			newContacts.setUsername(rs.getString("username"));
			newContacts.setName(rs.getString("name"));
			newContacts.setPhone(rs.getString("phone"));
			newContacts.setSex(rs.getString("sex"));
			newContacts.setBirthday(rs.getString("birthday"));
			newContacts.setAddress(rs.getString("address"));
			newContacts.setEmail(rs.getString("email"));
			newContacts.setWorkplace(rs.getString("workplace"));
			newContacts.setTelephone(rs.getString("telephone"));
			newContacts.setGroupName(rs.getString("groupname"));
			newContacts.setGid(rs.getInt("gid"));
			newContacts.setImgPath(rs.getString("imgPath"));
			contacts.add(newContacts);
		}
		return contacts;
	}
}
