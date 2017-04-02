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
		 String sql = "insert into tb_contacts(username, name, email, phone, groupName,remark) values(?, ?, ?, ?, ?, ?)";
		 PreparedStatement pstm = DbCon.getCon().prepareStatement(sql);
		 pstm.setString(1, user.getUsername());
		 pstm.setString(2, contact.getName());
		 pstm.setString(3, contact.getEmail());
		 pstm.setLong(4, contact.getPhone());
		 pstm.setString(5, contact.getGroupName());
		 pstm.setString(6, contact.getRemark());
		 int n = 0;
		 try{
			 n = pstm.executeUpdate();
		 }catch (Exception e) {
			// TODO: handle exception
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
}
