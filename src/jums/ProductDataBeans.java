package jums;

import java.io.Serializable;
import java.util.ArrayList;

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
	private int pColor;
	private String size;
	private int stock;
    private ArrayList<ProductDataDTO> productInfo = new ArrayList <ProductDataDTO>();


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

    public void setProductInfo(int pColor, String size,int stock) {
		this.pColor = pColor;
		this.size = size;
		this.stock = stock;
    }

    public ArrayList<ProductDataDTO> getProductInfo(){
		return productInfo;
    }

    public void ProductMasterMapping(ProductMasterDTO pmd){
    	pmd.setMasterName(this.masterName);
    	pmd.setListPrice(this.listPrice);
    	pmd.setCost(this.cost);
    	pmd.setProductDescript(this.productDescript);
    }

    public void ProductMapping(ProductDataDTO pdd){
    	pdd.setPColor(this.pColor);
    	pdd.setSize(this.size);
    	pdd.setStock(this.stock);
    }

}