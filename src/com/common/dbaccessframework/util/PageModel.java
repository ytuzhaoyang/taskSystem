package com.common.dbaccessframework.util;

import java.util.List;

public class PageModel<E>{

	private int itemCount;//总数据条数
	private int totlePage;//总页数
	private int perIndex;//上一页
	private int nextIndex;//下一页
	private int curPage;//当前页
	private int pageSize;//页长
	private List<E> reList;//结果集对象
	
	public int getItemCount() {
		return itemCount;
	}
	public void setItemCount(int itemCount) {
		this.itemCount = itemCount;
	}
	public int getTotlePage() {
		return totlePage;
	}
	public void setTotlePage(int totlePage) {
		this.totlePage = totlePage;
	}
	public int getPerIndex() {
		return perIndex;
	}
	public void setPerIndex(int perIndex) {
		this.perIndex = perIndex;
	}
	public int getNextIndex() {
		return nextIndex;
	}
	public void setNextIndex(int nextIndex) {
		this.nextIndex = nextIndex;
	}
	public int getCurPage() {
		return curPage;
	}
	public void setCurPage(int curPage) {
		this.curPage = curPage;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public List<E> getReList() {
		return reList;
	}
	public void setReList(List<E> reList) {
		this.reList = reList;
	}
}
