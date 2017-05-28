package info;

public class Contacts {
	
	private int uid;   //该联系人唯一的标识符
	private String username;
	private String name;
	private String phone;
	private String telephone;
	private String sex;
	private String birthday;
	private String address;
	private String email;
	private String workplace;
	private String workphone;
	private String groupName;
	private String remark;
	private int gid;
	private String imgPath;


	public String getImgPath() {
		return imgPath;
	}

	public void setImgPath(String imgPath) {
		this.imgPath = imgPath;
	}

	public String getName() {
		return name;
	}

	public int getGid() {
		return gid;
	}

	public void setGid(int gid) {
		this.gid = gid;
	}

	/**
	 * 保存联系人的信息
	 * @return
	 */
	
	public Contacts(int uid, String username, String name, String phone,
			String sex, String birthday, String address, String email,
			String workplace, String workphone, String groupName) {
		super();
		this.uid = uid;
		this.username = username;
		this.name = name;
		this.phone = phone;
		this.sex = sex;
		this.birthday = birthday;
		this.address = address;
		this.email = email;
		this.workplace = workplace;
		this.workphone = workphone;
		this.groupName = groupName;
	}
	
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public Contacts() {
		super();
		this.imgPath = "";
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String str1() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String s() {
		return phone;
	}
	public String getPhone() {
		return this.phone;
	}
	public void setPhone(String phone) {
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
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
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String toString(){
		return this.groupName;
	}
	
	public int hashCode(){
		return uid;
	}
	
	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		Contacts contact = (Contacts)obj;
		Boolean flag = (this.uid == contact.uid) && (this.gid == contact.getGid());
		return flag;
	}
}


