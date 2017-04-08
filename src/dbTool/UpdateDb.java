package dbTool;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import info.Contacts;
import info.User;
import view.AddContact;

public class UpdateDb {
	/**
	 * 添加用户的联系人
	 * @throws ClassNotFoundException 
	 * @throws SQLException 
	 */
	public static boolean addContactToDb (User user, Contacts contact) throws SQLException, ClassNotFoundException{
		 String sql = "insert into tb_contacts(username, name, email, phone, groupName,remark, birthday, workplace, address, " +
		 		"telephone,sex, gid) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		 		
		 PreparedStatement pstm = DbCon.getCon().prepareStatement(sql);
		 pstm.setString(1, user.getUsername());
		 pstm.setString(2, contact.getName());
		 pstm.setString(3, contact.getEmail());
		 pstm.setString(4, contact.getPhone());
		 pstm.setString(5, contact.getGroupName());
		 pstm.setString(6, contact.getRemark());
		 pstm.setString(7, contact.getBirthday());
		 pstm.setString(8, contact.getWorkplace());
		 pstm.setString(9, contact.getAddress());
		 pstm.setString(10, contact.getTelephone());
		 pstm.setString(11, contact.getSex());
		 pstm.setInt(12, contact.getGid());
		 int n = 0;
		 try{
			 n = pstm.executeUpdate();
		 }catch (Exception e) {
			 JOptionPane.showConfirmDialog(null, "数据添加失败");
		}
		 if(n != 0) {
			 return true;
		 } else {
			 return false;
		 } 
		 
	} 
	
	/**
	 * 删除联系人
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
		public static void deleContactFromDb(int uid) throws SQLException, ClassNotFoundException{
	    	String sql = "delete from tb_contacts where uid = ? ";
	    	PreparedStatement pstm = DbCon.getCon().prepareStatement(sql);
	    	pstm.setInt(1, uid);
	    	try{
	    		pstm.execute();
	    	}catch(Exception ex){
	    		ex.printStackTrace();
	    		System.out.println("数据删除失败");
	    	}
		}
     /**
      * 更新联系人数据
     * @throws SQLException 
     * @throws ClassNotFoundException 
      */
    	public static int updateContactToDb(User user, Contacts contact) throws SQLException, ClassNotFoundException{
    		String sql = "update tb_contacts set name = ?, phone = ?, sex = ?, birthday = ?, address = ?, " +
    				"email = ?, workplace = ?, telephone = ?, groupname = ?, remark = ?, gid = ? where uid = ?";
	    	 PreparedStatement pstm = DbCon.getCon().prepareStatement(sql);
	   		 pstm.setString(1, contact.getName());
	   		 pstm.setString(2, contact.getPhone());
	   		 pstm.setString(3, contact.getSex());
	   		 pstm.setString(4, contact.getBirthday());
	   		 pstm.setString(5, contact.getAddress());
			 pstm.setString(6, contact.getEmail());
			 pstm.setString(7, contact.getWorkplace());
			 pstm.setString(8, contact.getTelephone());
			 pstm.setString(9, contact.getGroupName());
			 pstm.setString(10, contact.getRemark());
			 pstm.setInt(11, contact.getGid());
			 pstm.setInt(12, contact.getUid());
			 int n = 0;
			 try{
				 n = pstm.executeUpdate();
			 }catch(Exception e){
				 System.out.println("联系人信息更新失败！");
				 e.printStackTrace();
			 }
			 System.out.println(contact.getUid());
			 return n;
    	}
}
