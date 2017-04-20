package com.wyln.common.page;

import java.util.ArrayList;
import java.util.List;

public class Pagination extends SimplePage {
	
	private static final long serialVersionUID = 1L;
	private List<?> list;
	private List<String> pageView;

	public Pagination() {
	}

	public Pagination(int pageNo, int pageSize, int totalCount) {
		super(pageNo, pageSize, totalCount);
	}

	public Pagination(int pageNo, int pageSize, int totalCount, List<?> list) {
		super(pageNo, pageSize, totalCount);
		this.list = list;
	}

	public List<?> getList() {
		return list;
	}

	@SuppressWarnings("rawtypes")
	public void setList(List list) {
		this.list = list;
	}

	public List<String> getPageView() {
		return pageView;
	}

	public void setPageView(List<String> pageView) {
		this.pageView = pageView;
	}

	public void pageView(String url, String params) {

		pageView = new ArrayList<String>();

		if (this.pageNo != 1) {
			pageView.add("<a href=\"javascript:void(0);\" onclick=\"javascript:window.location.href='" + url + "?"
					+ params + "&pageNo=" + (this.pageNo - 1) + "'\"><font size=2>Pre</font></a>");
		} else {
			pageView.add("<font size=2>Pre</font>");
		}

		if (this.getTotalPage() <= 10) {
			for (int i = 0; i < this.getTotalPage(); i++) {
				if ((i + 1) == this.pageNo) {
					pageView.add("<strong>" + this.pageNo + "</strong>");
					i = i + 1;
					if (this.pageNo == this.getTotalPage())
						break;
				}
				pageView.add("<a href=\"javascript:void(0);\" onclick=\"javascript:window.location.href='" + url + "?"
						+ params + "&pageNo=" + (i + 1) + "'\">" + (i + 1) + "</a>");
			}
		} else if (this.getTotalPage() <= 20) {
			// 没有把...加上
			int l = 0;
			int r = 0;
			if (this.pageNo < 5) {
				l = this.pageNo - 1;
				r = 10 - l - 1;
			} else if (this.getTotalPage() - this.pageNo < 5) {
				r = this.getTotalPage() - this.pageNo;
				l = 10 - 1 - r;
			} else {
				l = 4;
				r = 5;
			}
			int tmp = this.pageNo - l;
			for (int i = tmp; i < tmp + 10; i++) {
				if (i == this.pageNo) {
					pageView.add("<strong>" + this.pageNo + "</strong>");
					i = i + 1;
					if (this.pageNo == this.getTotalPage())
						break;
				}
				pageView.add("<a href=\"javascript:void(0);\" onclick=\"javascript:window.location.href='" + url + "?"
						+ params + "&pageNo=" + (i) + "'\">" + (i) + "</a>");
			}

		} else if (this.pageNo < 7) {
			for (int i = 0; i < 8; i++) {
				if (i + 1 == this.pageNo) {
					pageView.add("<strong>" + this.pageNo + "</strong>");
					i = i + 1;
				}
				pageView.add("<a href=\"javascript:void(0);\" onclick=\"javascript:window.location.href='" + url + "?"
						+ params + "&pageNo=" + (i + 1) + "'\">" + (i + 1) + "</a>");
			}
			pageView.add("...");
			pageView.add("<a href=\"javascript:void(0);\" onclick=\"javascript:window.location.href='" + url + "?"
					+ params + "&pageNo=" + (this.getTotalPage() - 1) + "'\">" + (this.getTotalPage() - 1) + "</a>");
			pageView.add("<a href=\"javascript:void(0);\" onclick=\"javascript:window.location.href='" + url + "?"
					+ params + "&pageNo=" + (this.getTotalPage()) + "'\">" + (this.getTotalPage()) + "</a>");
		} else if (this.pageNo > this.getTotalPage() - 6) {
			pageView.add("<a href=\"javascript:void(0);\" onclick=\"javascript:window.location.href='" + url + "?"
					+ params + "&pageNo=" + (1) + "'\">" + (1) + "</a>");
			pageView.add("<a href=\"javascript:void(0);\" onclick=\"javascript:window.location.href='" + url + "?"
					+ params + "&pageNo=" + (2) + "'\">" + (2) + "</a>");
			pageView.add("...");
			for (int i = this.getTotalPage() - 8; i < this.getTotalPage(); i++) {
				if (i + 1 == this.pageNo) {
					pageView.add("<strong>" + this.pageNo + "</strong>");
					i = i + 1;
					if (this.pageNo == this.getTotalPage())
						break;
				}
				pageView.add("<a href=\"javascript:void(0);\" onclick=\"javascript:window.location.href='" + url + "?"
						+ params + "&pageNo=" + (i + 1) + "'\">" + (i + 1) + "</a>");
			}
		} else {
			pageView.add("<a href=\"javascript:void(0);\" onclick=\"javascript:window.location.href='" + url + "?"
					+ params + "&pageNo=" + (1) + "'\">" + (1) + "</a>");
			pageView.add("<a href=\"javascript:void(0);\" onclick=\"javascript:window.location.href='" + url + "?"
					+ params + "&pageNo=" + (2) + "'\">" + (2) + "</a>");
			pageView.add("...");

			pageView.add("<a href=\"javascript:void(0);\" onclick=\"javascript:window.location.href='" + url + "?"
					+ params + "&pageNo=" + (this.pageNo - 2) + "'\">" + (this.pageNo - 2) + "</a>");
			pageView.add("<a href=\"javascript:void(0);\" onclick=\"javascript:window.location.href='" + url + "?"
					+ params + "&pageNo=" + (this.pageNo - 1) + "'\">" + (this.pageNo - 1) + "</a>");
			pageView.add("<strong>" + this.pageNo + "</strong>");
			pageView.add("<a href=\"javascript:void(0);\" onclick=\"javascript:window.location.href='" + url + "?"
					+ params + "&pageNo=" + (this.pageNo + 1) + "'\">" + (this.pageNo + 1) + "</a>");
			pageView.add("<a href=\"javascript:void(0);\" onclick=\"javascript:window.location.href='" + url + "?"
					+ params + "&pageNo=" + (this.pageNo + 2) + "'\">" + (this.pageNo + 2) + "</a>");

			pageView.add("...");
			pageView.add("<a href=\"javascript:void(0);\" onclick=\"javascript:window.location.href='" + url + "?"
					+ params + "&pageNo=" + (this.getTotalPage() - 1) + "'\">" + (this.getTotalPage() - 1) + "</a>");
			pageView.add("<a href=\"javascript:void(0);\" onclick=\"javascript:window.location.href='" + url + "?"
					+ params + "&pageNo=" + (this.getTotalPage()) + "'\">" + (this.getTotalPage()) + "</a>");
		}
		if (this.pageNo != this.getTotalPage()) {
			pageView.add("<a href=\"javascript:void(0);\" onclick=\"javascript:window.location.href='" + url + "?"
					+ params + "&pageNo=" + (this.pageNo + 1) + "'\"><font size=2>Next</font></a>");
		} else {
			pageView.add("<font size=2>Next</font>");
		}
		pageView.add("Total<var>" + getTotalPage() + "</var>");
	}
}
