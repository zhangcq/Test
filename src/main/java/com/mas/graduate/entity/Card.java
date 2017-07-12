package com.mas.graduate.entity;

public class Card {

	private int cardId;
	private String cardNum;
	private int balance;
	private String uname;
	private String companyName;
	private int cardType;
	private int pageSize;
	private int pageNumber;
	public Card() {
		super();
	}
	public Card(int cardId, String cardNum, int balance, String uname,
			String companyName, int cardType, int pageSize, int pageNumber) {
		super();
		this.cardId = cardId;
		this.cardNum = cardNum;
		this.balance = balance;
		this.uname = uname;
		this.companyName = companyName;
		this.cardType = cardType;
		this.pageSize = pageSize;
		this.pageNumber = pageNumber;
	}
	public int getCardId() {
		return cardId;
	}
	public void setCardId(int cardId) {
		this.cardId = cardId;
	}
	public String getCardNum() {
		return cardNum;
	}
	public void setCardNum(String cardNum) {
		this.cardNum = cardNum;
	}
	public int getBalance() {
		return balance;
	}
	public void setBalance(int balance) {
		this.balance = balance;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public int getCardType() {
		return cardType;
	}
	public void setCardType(int cardType) {
		this.cardType = cardType;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getPageNumber() {
		return pageNumber;
	}
	public void setPageNumber(int pageNumber) {
		this.pageNumber = pageNumber;
	}
	
}
