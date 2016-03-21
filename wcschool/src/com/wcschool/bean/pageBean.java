package com.wcschool.bean;

import java.util.List;

public class pageBean {
      
	private static final long serialVersionUID = 1L;
	private List list;//要返回的某一页的记录列表
	private int allRow;//总记录数
	private int currentPage;//当前页数
	private int totalPage;//总页数
	private int pageSize;//每页记录数
	private boolean isFirstPage;//是否是第一页
	private boolean isLastPage;//是否是最后一页
	private boolean hasFromPage;//是否有前一页
	private boolean hasNextPage;//是否有下一页
	public pageBean(){}
	public void init()//初始化分页信息
	{
		this.isFirstPage=isFirstPage();
		this.isLastPage=isLastPage();
		this.setHasFromPage(isHasFromPage());
		this.setHasNextPage(isHasNextPage());
	}
	public static int countTotalPage(final int pageSize,final int allRow)
	{
		int totalpage = allRow%pageSize==0?allRow/pageSize:allRow/pageSize+1;
		return totalpage;
	}
	//计算当前页开始记录
	public static int countStartIndex(final int pageSize,final int currentPage)
	{
		final int startIndex=pageSize*(currentPage-1);
		return startIndex;
	}
	public static int currentPage(int page)
	{
		final int curpage=(page==0?1:page);
		return curpage;
	}
	public List getList() {
		return list;
	}
	public void setList(List list) {
		this.list = list;
	}
	public int getAllRow() {
		return allRow;
	}
	public void setAllRow(int allRow) {
		this.allRow = allRow;
	}
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public int getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public boolean isFirstPage() {
		return isFirstPage;
	}
	public void setFirstPage(boolean isFirstPage) {
		this.isFirstPage = isFirstPage;
	}
	public boolean isLastPage() {
		return isLastPage;
	}
	public void setLastPage(boolean isLastPage) {
		this.isLastPage = isLastPage;
	}
	public boolean isHasFromPage() {
		return hasFromPage;
	}
	public void setHasFromPage(boolean hasFromPage) {
		this.hasFromPage = hasFromPage;
	}
	public boolean isHasNextPage() {
		return hasNextPage;
	}
	public void setHasNextPage(boolean hasNextPage) {
		this.hasNextPage = hasNextPage;
	}
}
