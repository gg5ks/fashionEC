package jums;

import java.io.Serializable;
import java.util.ArrayList;

public class ProductDataDTO implements Serializable{

	//商品
	private int pColor;
	private String size;
	private int stock;
    private ArrayList<ProductDataDTO> productInfo = new ArrayList <ProductDataDTO>();


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
}
