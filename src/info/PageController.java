package info;

import java.util.Vector;

public class PageController {
	private Vector<Contacts> bigList = new Vector<Contacts>();  //大集合，从数据库获取记录数
	private Vector<Contacts> smallList = new Vector<Contacts>();  //小集合，从大集合中获取当前页面的记录数
	private int CurrentPage;  //当前页面
	private int recordCounter;  //总记录数
	private int countPerPage = 10;     //每一页的记录数
	private int pageCounter;  //总页数
	private User user;
	
	
	public PageController(User user){
		this.CurrentPage = 1;
		this.user = user;
	}
	
	/**
	 * 第一页
	 */
	public void setFirstPrevious(){
		this.CurrentPage = 1;
	}
	
	//上一页
	public void setPreviousPage(){
		if(this.CurrentPage > 1) {
			this.CurrentPage--;
			System.out.println("当前页面是 ：" + CurrentPage);
		}
	}
	
	//下一页
	public void setNextPage(){
		if(this.CurrentPage < this.pageCounter){
			this.countPerPage++;
			System.out.println("当前页面是 ：" + CurrentPage);
		}
	}
	
	/**
	 * 最后一页
	 * @return
	 */
	public void setLastPage(){
		this.CurrentPage = this.pageCounter;
		System.out.println(this.CurrentPage);
	}
	
	
	/*
	 * 获取当前页面的所有记录数
	 */
	public Vector<Contacts> getCurrentRecord(){
		return select();
	}
	
	//初始化大集合,页面总数，总记录数
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
	 * 初始化小集合，保存当前页面的所有记录
	 * (CurrentPage-1)*countPerPage 当前页面的第一记录
	 * CurrentPage*countPerPage  当前页面的最后一条记录
	 */
	public Vector<Contacts> select(){
		smallList.removeAllElements();
        for(int i=(CurrentPage-1)*countPerPage; i<recordCounter&&i<CurrentPage*countPerPage; i++){  
            smallList.add(bigList.get(i));  
        }   
        return smallList;
	}
}
