package com.common.dbaccessframework.util;

import java.io.Serializable;
import java.util.List;

public class ComplexPageModel<T> implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int curPage;//��ǰҳ
	private int ItemCount;//����������
	private int TotalPage;//��ҳ��
	private int perGroup;//��һ��
	private int nextGroup;//��һ��
	private int pageSize;//ÿҳ��ʾ����������
	private List<T> reList;//�����
	private int totalGroup;
	private int curGroup;
	private int beginPag;
	private int endPag;
	
	public int getCurPage() {
		return curPage;
	}
	public void setCurPage(int curPage) {
		this.curPage = curPage;
	}
	public int getItemCount() {
		return ItemCount;
	}
	public void setItemCount(int itemCount) {
		ItemCount = itemCount;
	}
	public int getTotalPage() {
		return TotalPage;
	}
	public void setTotalPage(int totalPage) {
		TotalPage = totalPage;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public List<T> getReList() {
		return reList;
	}
	public void setReList(List<T> reList) {
		this.reList = reList;
	}
	public int getTotalGroup() {
		return totalGroup;
	}
	public void setTotalGroup(int totalGroup) {
		this.totalGroup = totalGroup;
	}
	public int getCurGroup() {
		return curGroup;
	}
	public void setCurGroup(int curGroup) {
		this.curGroup = curGroup;
	}
	public int getBeginPag() {
		return beginPag;
	}
	public void setBeginPag(int beginPag) {
		this.beginPag = beginPag;
	}
	public int getEndPag() {
		return endPag;
	}
	public void setEndPag(int endPag) {
		this.endPag = endPag;
	}
	public int getPerGroup() {
		return perGroup;
	}
	public void setPerGroup(int perGroup) {
		this.perGroup = perGroup;
	}
	public int getNextGroup() {
		return nextGroup;
	}
	public void setNextGroup(int nextGroup) {
		this.nextGroup = nextGroup;
	}
}
