package com.example.domain;


public class BookWrapper {

	private String title;
	private String author;
	private long priceGreater;
	private long priceLess;

	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public long getPriceGreater() {
		return priceGreater;
	}
	public void setPriceGreater(long priceGreater) {
		this.priceGreater = priceGreater;
	}
	public long getPriceLess() {
		return priceLess;
	}
	public void setPriceLess(long priceLess) {
		this.priceLess = priceLess;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
}
