package org.techhub.Model;

public class BookModel {

	private int Bid;
	private String Bname;
	private String Btype;
	private String Author;
	private int Edyear;
	private int Bprice;
	private int Cid;
	
	
	public BookModel()
	{
		
	}
	public BookModel(int Bid, String Bname,String Btype,int Edyear,int Bprice,String Author)
	{
		
		this.Bid=Bid;
		this.Bname=Bname;
		this.Btype=Btype;
		this.Author=Author;
		this.Edyear=Edyear;
		this.Bprice=Bprice;
		
	}
	
	public int getBid() {
		return Bid;
	}
	public void setBid(int bid) {
		Bid = bid;
	}
	public String getBname() {
		return Bname;
	}
	public void setBname(String bname) {
		Bname = bname;
	}
	public String getBtype() {
		return Btype;
	}
	public void setBtype(String btype) {
		Btype = btype;
	}
	public String getAuthor() {
		return Author;
	}
	public void setAuthor(String author) {
		Author = author;
	}
	public int getEdyear() {
		return Edyear;
	}
	public void setEdyear(int edyear) {
		Edyear = edyear;
	}
	public int getBprice() {
		return Bprice;
	}
	public void setBprice(int bprice) {
		Bprice = bprice;
	}
	public int getCid() {
		return Cid ;
	}
	public void setCid(int cid) {
		Cid = cid;
	}
	@Override
	public String toString() {
		return "BookModel [Bid=" + Bid + ", Bname=" + Bname + ", Btype=" + Btype + ", Author=" + Author + ", Edyear="
				+ Edyear + ", Bprice=" + Bprice + ", Cid=" + Cid + "]";
	}
	
	
	
}
