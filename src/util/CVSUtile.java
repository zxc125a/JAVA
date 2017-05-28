package util;

import info.Contacts;
import info.User;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Vector;

import javax.swing.JOptionPane;

import dbTool.GetDataFromDb;
import dbTool.UpdateDb;

public class CVSUtile {
	
	
	/**
	 * 用于将数据以CVS文件格式导出
	 * @throws FileNotFoundException 
	 */
	public static void exportCVS(String filename, String pathname, Vector<Contacts> contacts) throws FileNotFoundException{
		
		boolean flag = mkdirs(pathname);
		if(flag&&!Check.isEmpty(filename)){
			File cvsFile = new File(new File(pathname), filename+".csv");
		    BufferedWriter buf = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(cvsFile)));
			String str = new String("用户组,姓名,性别,手机,生日,地址,邮箱,工作单位,联系电话,备注,uid,gid");
		    try {
				buf.write(str);
				buf.newLine();
				Iterator<Contacts> it = contacts.iterator();
				while(it.hasNext()){
					str = "";
					Contacts contact = it.next();
					str += (contact.getGroupName() + ",");
					str += (contact.getName() + ",");
					str += (contact.getSex() + ",");
					str += (contact.getPhone() + ",");
					str += (contact.getBirthday() + ",");
					str += (contact.getAddress() + ",");
					str += (contact.getEmail() + ",");
					str += (contact.getWorkplace() + ",");
					str += (contact.getTelephone() + ",");
					str += (contact.getRemark() + ",");
					str += (contact.getUid() + ",");
					str += (contact.getGid());
					buf.write(str);
					buf.newLine();
				}
			   JOptionPane.showMessageDialog(null, "信息导出成功");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally{
				try {
					buf.close();
					buf = null;
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		    
		}
	}
	
	
	/**
	 * 导入CVS文件
	 * @throws FileNotFoundException 
	 */
	public static void importCSV(String pathname,  User user) throws FileNotFoundException{
		File csvFile = new File(pathname);
		HashSet<Contacts> hSet= new HashSet<Contacts>();
		Iterator<Contacts> it = user.getContactsGrounp().iterator();
		while(it.hasNext()){
			hSet.add(it.next());
		}
		BufferedReader bufr = new BufferedReader(new InputStreamReader(new FileInputStream(csvFile)));
		String line = null;
		try{
			bufr.readLine();
			while((line = bufr.readLine()) != null){
				String[] str = line.split(",");
				Contacts contact = new Contacts();
				contact.setGroupName(str[0]);
				contact.setName(str[1]);
				contact.setSex(str[2]);
				contact.setPhone(str[3]);
				contact.setBirthday(str[4]);
				contact.setAddress(str[5]);
				contact.setEmail(str[6]);
				contact.setWorkplace(str[7]);
				contact.setTelephone(str[8]);
				contact.setRemark(str[9]);
				contact.setUid(Integer.parseInt(str[10]));
				contact.setGid(Integer.parseInt(str[11]));
				boolean flag = hSet.add(contact);    //判断当前联系人是否已经存在，不存在则对组名进行判断，组名不存则添加到新组名，组名存在，则直接添加
				if(flag){
					contact.setUsername(user.getUsername());
					
						try {
							boolean sign = GetDataFromDb.existGroupName(user, contact.getGroupName());
							if (sign) {
								UpdateDb.addContactToDb(user, contact);
								return;
							}
							int n = UpdateDb.insertNewGroup(user, contact.getGroupName());
							contact.setGid(n);
							UpdateDb.addContactToDb(user, contact);
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (ClassNotFoundException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					} 
			}
			user.getMainForm().paintTable();
			user.getMainForm().paintJTree();
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {
				bufr.close();
				bufr = null;
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	
	/**
	 * 创建一字符路径为pathname的目录
	 * @param pathname
	 * @return
	 */
	private static boolean mkdirs(String pathname){
		if(Check.isEmpty(pathname)){
			return false;
		}
		File dirFile = new File(pathname);
		return (dirFile.exists() && dirFile.isDirectory())? true : dirFile.mkdirs();
	} 
	
}
