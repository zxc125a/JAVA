package info;

import java.util.Vector;

public class PageController {
	private Vector<Contacts> bigList = new Vector<Contacts>();  //�󼯺ϣ������ݿ��ȡ��¼��
	private Vector<Contacts> smallList = new Vector<Contacts>();  //С���ϣ��Ӵ󼯺��л�ȡ��ǰҳ��ļ�¼��
	private int CurrentPage;  //��ǰҳ��
	private int recordCounter;  //�ܼ�¼��
	private int countPerPage = 10;     //ÿһҳ�ļ�¼��
	private int pageCounter;  //��ҳ��
	private User user;
	
	
	public PageController(User user){
		this.CurrentPage = 1;
		this.user = user;
	}
	
	/**
	 * ��һҳ
	 */
	public void setFirstPrevious(){
		this.CurrentPage = 1;
	}
	
	//��һҳ
	public void setPreviousPage(){
		if(this.CurrentPage > 1) {
			this.CurrentPage--;
			System.out.println("��ǰҳ���� ��" + CurrentPage);
		}
	}
	
	//��һҳ
	public void setNextPage(){
		if(this.CurrentPage < this.pageCounter){
			this.countPerPage++;
			System.out.println("��ǰҳ���� ��" + CurrentPage);
		}
	}
	
	/**
	 * ���һҳ
	 * @return
	 */
	public void setLastPage(){
		this.CurrentPage = this.pageCounter;
		System.out.println(this.CurrentPage);
	}
	
	
	/*
	 * ��ȡ��ǰҳ������м�¼��
	 */
	public Vector<Contacts> getCurrentRecord(){
		return select();
	}
	
	//��ʼ���󼯺�,ҳ���������ܼ�¼��
	public Vector<Contacts> initList(){
		this.bigList.removeAllElements();
		this.bigList.addAll(this.user.getContactsGrounp());
		this.recordCounter = this.bigList.size();
		if(this.bigList.size() > 0 ){
			this.pageCounter = (int)Math.ceil(1.0*this.recordCounter / this.countPerPage);
		} else {
			this.pageCounter = 0;
		}
		return select();
	}
	
	/**
	 * ��ʼ��С���ϣ����浱ǰҳ������м�¼
	 * (CurrentPage-1)*countPerPage ��ǰҳ��ĵ�һ��¼
	 * CurrentPage*countPerPage  ��ǰҳ������һ����¼
	 */
	public Vector<Contacts> select(){
		smallList.removeAllElements();
        for(int i=(CurrentPage-1)*countPerPage; i<recordCounter&&i<CurrentPage*countPerPage; i++){  
            smallList.add(bigList.get(i));  
        }   
        return smallList;
	}
}
