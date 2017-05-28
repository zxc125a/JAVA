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
	 * ���ڽ�������CVS�ļ���ʽ����
	 * @throws FileNotFoundException 
	 */
	public static void exportCVS(String filename, String pathname, Vector<Contacts> contacts) throws FileNotFoundException{
		
		boolean flag = mkdirs(pathname);
		if(flag&&!Check.isEmpty(filename)){
			File cvsFile = new File(new File(pathname), filename+".csv");
		    BufferedWriter buf = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(cvsFile)));
			String str = new String("�û���,����,�Ա�,�ֻ�,����,��ַ,����,������λ,��ϵ�绰,��ע,uid,gid");
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
			   JOptionPane.showMessageDialog(null, "��Ϣ�����ɹ�");
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
	 * ����CVS�ļ�
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
				boolean flag = hSet.add(contact);    //�жϵ�ǰ��ϵ���Ƿ��Ѿ����ڣ�������������������жϣ�������������ӵ����������������ڣ���ֱ�����
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
	 * ����һ�ַ�·��Ϊpathname��Ŀ¼
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
