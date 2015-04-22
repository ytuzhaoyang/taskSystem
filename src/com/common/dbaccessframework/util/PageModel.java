package com.common.dbaccessframework.util;

import java.util.List;

public class PageModel<E>{

	private int itemCount;//����������
	private int totlePage;//��ҳ��
	private int perIndex;//��һҳ
	private int nextIndex;//��һҳ
	private int curPage;//��ǰҳ
	private int pageSize;//ҳ��
	private List<E> reList;//���������
	
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
