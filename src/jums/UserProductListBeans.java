package jums;

import java.io.Serializable;
import java.util.ArrayList;

public class UserProductListBeans implements Serializable{
	private int masterId;
	private String masterName;
	private ArrayList<Integer> pColor;
	private ArrayList<String> size;
	private int listPrice;
	private String masterImg;

	public UserProductListBeans() {
		this.masterId = 0;
		this.masterName = "";
		this.pColor = new ArrayList<Integer>();
		this.listPrice = 0;
		this.masterImg ="";
	}

	public int getMasterId() {
		return masterId;
	}
	public void setMasterId(int masterId) {
		this.masterId = masterId;
	}
	public String getMasterName() {
		return masterName;
	}
	public void setMasterName(String masterName) {
		this.masterName = masterName;
	}
	public ArrayList<Integer> getpColor() {
		return pColor;
	}
	public void setpColor(ArrayList<Integer> pColor) {
		this.pColor = pColor;
	}
	public ArrayList<String> getSize() {
		return size;
	}
	public void setSize(ArrayList<String> size) {
		this.size = size;
	}
	public int getListPrice() {
		return listPrice;
	}
	public void setListPrice(int listPrice) {
		this.listPrice = listPrice;
	}
	public String getMasterImg() {
		return masterImg;
	}
	public void setMasterImg(String masterImg) {
		this.masterImg = masterImg;
	}
}
