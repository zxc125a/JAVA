package info;

import java.util.HashSet;
import java.util.Vector;

import view.MainForm;

import com.sun.org.apache.bcel.internal.generic.NEW;

public class User {
	
	private int id;
	private String username;
	private String password;
	private String mail;
	private String phone;
	private Vector<Contacts> contactsGrounp;
	private HashSet<String> allGroupName = new HashSet<String>();  //������ϵ�˵ķ��鼯��
	private MainForm mainForm;

	/**
	 * �û�������Ϣ
	 * @return
	 */
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public Vector<Contacts> getContactsGrounp() {
		return contactsGrounp;
	}
	public void setContactsGrounp(Vector<Contacts> contactsGrounp) {
		this.contactsGrounp = contactsGrounp;
	}
	public HashSet<String> getAllGroupName() {
		return allGroupName;
	}
	public void setAllGroupName(HashSet<String> allGroupName) {
		this.allGroupName = allGroupName;
	}
	/**
	 * ������
	 * @return
	 */
	public MainForm getMainForm() {
		return mainForm;
	}
	public void setMainForm(MainForm mainForm) {
		this.mainForm = mainForm;
	}
}
