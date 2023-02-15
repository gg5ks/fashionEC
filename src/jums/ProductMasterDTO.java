package jums;

import java.io.Serializable;

public class ProductMasterDTO implements Serializable{

	//商品マスター
	private int masterId;
	private String masterName;
	private int listPrice;
	private int cost;
	private String productDescript;
	private int publish;

	public void setMasterId(int masterId) {
		this.masterId = masterId;
	}
	public int getMasterId() {
		return masterId;
	}

	public void setMasterName(String masterName) {
		this.masterName = masterName;
	}
	public String getMasterName() {
		return masterName;
	}

	public void setListPrice(int listPrice) {
		this.listPrice = listPrice;
	}
	public int getListPrice() {
		return listPrice;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}
	public int getCost() {
		return cost;
	}
	public void setPublish(int publish) {
		this.publish = publish;
	}
	public boolean getPublish() {
		boolean publishStatus = false;
		if (publish == 1) {
			publishStatus = true;
			return publishStatus;
		} else {
		return publishStatus;
		}
	}


	public void setProductDescript(String productDescript) {
		this.productDescript = productDescript;
	}
	public String getProductDescript() {
		return productDescript;
	}
}
