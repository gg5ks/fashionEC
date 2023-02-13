package jums;

import java.io.Serializable;

public class ProductDataBeans implements Serializable {

	//管理者
	private int admin_id;
	private String admin_name;
	private String admin_email;

	//商品マスター
	private String masterName;
	private int listPrice;
	private int cost;
	private String productDescript;

	//商品



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

	public void setProductDescript(String productDescript) {
		this.productDescript = productDescript;
	}
	public String getProductDescript() {
		return productDescript;
	}
}