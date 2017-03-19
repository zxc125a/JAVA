package info;

public class Contacts {
	
	private int uid;
	private String username;
	private String name;
	private int phone;
	private String sex;
	private String birthday;
	private String address;
	private String postcode;
	private String workplace;
	private String workphone;
	private String groupName;
	private String num;

	public String getNum() {
		return num;
	}
	public void setNum(String num) {
		this.num = num;
	}
	/**
	 * 保存联系人的信息
	 * @return
	 */
	

	public Contacts(int uid, String username, String name, int phone,
			String sex, String birthday, String address, String postcode,
			String workplace, String workphone, String groupName) {
		super();
		this.uid = uid;
		this.username = username;
		this.name = name;
		this.phone = phone;
		this.sex = sex;
		this.birthday = birthday;
		this.address = address;
		this.postcode = postcode;
		this.workplace = workplace;
		this.workphone = workphone;
		this.groupName = groupName;
	}
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public Contacts() {
		super();
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPhone() {
		return phone;
	}
	public void setPhone(int phone) {
		this.phone = phone;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPostcode() {
		return postcode;
	}
	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}
	public String getWorkplace() {
		return workplace;
	}
	public void setWorkplace(String workplace) {
		this.workplace = workplace;
	}
	public String getWorkphone() {
		return workphone;
	}
	public void setWorkphone(String workphone) {
		this.workphone = workphone;
	}
	public String getGroupName() {
		return groupName;
	}
	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}
	
}
