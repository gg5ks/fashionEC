package jums;

import java.io.Serializable;
import java.util.ArrayList;

public class ProductMasterDTO implements Serializable{

	//商品マスター
	private int masterId;
	private String masterName;
	private int listPrice;
	private int cost;
	private String productDescript;
	private int publish;
	private ArrayList<Integer> masters;

	//商品
	private int pColor;
	private String size;
	private int stock;

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

	public ArrayList<Integer> setMasters(ArrayList<Integer> masters){
		return this.masters = masters;
	}
	public ArrayList<Integer> getMasters(){
		return masters;
	}

	public void setProductDescript(String productDescript) {
		this.productDescript = productDescript;
	}
	public String getProductDescript() {
		return productDescript;
	}

	public void setPColor(int pColor) {
		this.pColor = pColor;
	}

	public int getPColor() {
		return pColor;
	}
	public void setSize(String size) {
		this.size = size;
	}
	public String getSize() {
		return size;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	public int getStock() {
		return stock;
	}
    public void setProductList(int masterId,int listPrice,int publish,String masterName,int pColor, String size,int stock) {
		this.pColor = pColor;
		this.size = size;
		this.stock = stock;
    }
}
