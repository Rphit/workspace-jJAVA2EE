package comm.example.model;

import java.io.Serializable;

public class Customer implements Serializable {
	
	public Customer(String cName, String cAddress, String item) {
		super();
	//	this.cId = cId;
		this.cName = cName;
		this.cAddress = cAddress;
		this.item = item;
	}
	//private int cId;
	private String cName;
	private String cAddress;
	private String item;
	public Customer() {
		super();
	}
	
	/*
	 * public int getcId() { return cId; } public void setcId(int cId) { this.cId =
	 * cId; }
	 */
	public String getcName() {
		return cName;
	}
	public void setcName(String cName) {
		this.cName = cName;
	}
	public String getcAddress() {
		return cAddress;
	}
	public void setcAddress(String cAddress) {
		this.cAddress = cAddress;
	}
	public String getItem() {
		return item;
	}
	public void setItem(String item) {
		this.item = item;
	}
	

}
