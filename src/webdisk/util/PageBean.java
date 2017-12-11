package webdisk.util;
//import webdisk.bean.Foreign;

import java.util.List;

public class PageBean {
	/*
	private List<Foreign> list;// 通过hql从数据库查出来的list集合
	
	private int allRow; // 总计录数
	
	private int totalPage; //总页数
	
	private int currentPage; //当前页

	public List<Foreign> getList() {
		return list;
	}

	public void setList(List<Foreign> list) {
		this.list = list;
	}

	public int getAllRow() {
		return allRow;
	}

	public void setAllRow(int allRow) {
		this.allRow = allRow;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	*/
	/**
	 * 得到总页数
	 * @param pageSize
	 * @param allRows
	 * @return
	 */
	public int getTotalPages(int pageSize,int allRows) {
		int totalPage = (allRows%pageSize==0)?(allRows/pageSize):(allRows/pageSize)+1;		
		return totalPage;		
	}
	/**
	 * 得到当前开始记录号
	 * @param pageSize
	 * @param currentPage
	 * @return
	 */
	public int getCurrentPageOffset(int pageSize,int currentPage) {
		int offset = pageSize*(currentPage-1);		
		return offset;		
	}
	/**
	 * 得到当前页 ，如果为0 则开始第一页  ，否则为当前页
	 * @param page
	 * @return
	 */
	public int getCurPage(int page) {
		int currentPage = (page ==0)?1:page;
		return currentPage;
		
	}
	
}
