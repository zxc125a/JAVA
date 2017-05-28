package dbTool;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JOptionPane;


import info.Contacts;
import info.User;

public class UpdateDb {
	/**
	 * ����û�����ϵ��
	 * @throws ClassNotFoundException 
	 * @throws SQLException 
	 */
	public static boolean addContactToDb (User user, Contacts contact) throws SQLException, ClassNotFoundException{
		 String sql = "insert into tb_contacts(username, name, email, phone, groupName,remark, birthday, workplace, address, " +
		 		"telephone,sex, gid, imgPath) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		 		
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
		 pstm.setString(13, "");
		// System.out.println(pstm.toString());
		 int n = 0;
		 try{
			 n = pstm.executeUpdate();
		 }catch (Exception e) {
			 JOptionPane.showConfirmDialog(null, "�������ʧ��");
		}
		 if(n != 0) {
			 return true;
		 } else {
			 return false;
		 } 
		 
	} 
	
	/**
	 * ɾ����ϵ��
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
	    		System.out.println("��ϵ��ɾ��ʧ��");
	    	}
		}
     /**
      * ������ϵ������
     * @throws SQLException 
     * @throws ClassNotFoundException 
      */
    	public static int updateContactToDb(User user, Contacts contact) throws SQLException, ClassNotFoundException{
    		String sql = "update tb_contacts set name = ?, phone = ?, sex = ?, birthday = ?, address = ?, " +
    				"email = ?, workplace = ?, telephone = ?, groupname = ?, remark = ?, gid = ?, imgPath = ? where uid = ?";
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
			 pstm.setString(12, contact.getImgPath());
			 pstm.setInt(13, contact.getUid());
			 System.out.println(contact.getImgPath());
			 int n = 0;
			 try{
				 n = pstm.executeUpdate();
			 }catch(Exception e){
				 System.out.println("��ϵ����Ϣ����ʧ�ܣ�");
				 e.printStackTrace();
			 }
			 return n;
    	}
    	
    	/**
    	 * ����µ���ϵ��
    	 * @throws ClassNotFoundException 
    	 * @throws SQLException 
    	 */
    	public static int insertNewGroup(User user, String groupname) throws SQLException, ClassNotFoundException{
    		String  sql = "insert into tb_group(username, groupname) values(?, ?)";
    		PreparedStatement pstm = DbCon.getCon().prepareStatement(sql);
    		pstm.setString(1,	user.getUsername());
    		pstm.setString(2, groupname);
    		int flag = pstm.executeUpdate();
    		return flag;
    	}
    	
    	public static int deteGroup(User user, String groupname) throws SQLException, ClassNotFoundException{
	    	String sql = "delete from tb_group where username = ? and groupname = ?";
	    	PreparedStatement pstm = DbCon.getCon().prepareStatement(sql);
	    	pstm.setString(1, user.getUsername());
    		pstm.setString(2, groupname);
    		int flag = pstm.executeUpdate();
    		return flag;
    	}
}
