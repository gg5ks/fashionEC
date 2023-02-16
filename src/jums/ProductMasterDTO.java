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

    private String img1;
    private String img2;
    private String img3;
    private String img4;
    private String img5;


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

	public void setImg1(String img1) {
		this.img1 = img1;
	}
	public String getImg1() {
		return img1;
	}
	public void setImg2(String img2) {
		this.img2 = img2;
	}
	public String getImg2() {
		return img2;
	}
	public void setImg3(String img3) {
		this.img3 = img3;
	}
	public String getImg3() {
		return img3;
	}
	public void setImg4(String img4) {
		this.img4 = img4;
	}
	public String getImg4() {
		return img4;
	}
	public void setImg5(String img5) {
		this.img5 = img5;
	}
	public String getImg5() {
		return img5;
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
