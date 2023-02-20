package jums;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class User_ProductDetailBeans implements Serializable{
	private int masterId;
	private String masterName;
	private String masterDiscript;
	private int price;
	private ArrayList<String> imgList;
	private int colorId;
	private String size;
	private int PdAmount;
	private ArrayList<Integer> colorIdList;
	private ArrayList<ArrayList<ProductDataDTO>> ListSizeAmount;


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
	public String getMasterDiscript() {
		return masterDiscript;
	}
	public void setMasterDiscript(String masterDiscript) {
		this.masterDiscript = masterDiscript;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public ArrayList<String> getImgList() {
		return imgList;
	}
	public void setImgList(ArrayList<String> imgList) {
		this.imgList = imgList;
	}
	public int getColorId() {
		return colorId;
	}
	public void setColorId(int colorId) {
		this.colorId = colorId;
	}
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
	public int getPdAmount() {
		return PdAmount;
	}
	public void setPdAmount(int pdAmount) {
		PdAmount = pdAmount;
	}

	public ArrayList<Integer> getColorIdList() {
		return colorIdList;
	}
	public void setColorIdList(ArrayList<Integer> colorIdList) {
		this.colorIdList = colorIdList;
	}

	public ArrayList<ArrayList<ProductDataDTO>> getListSizeAmount() {
		return ListSizeAmount;
	}
	public void setListSizeAmount(ArrayList<ArrayList<ProductDataDTO>> listSizeAmount) {
		ListSizeAmount = listSizeAmount;
	}



	public ArrayList<Integer> ColorList(ArrayList<ProductDataDTO> Apdd) {
		//戻り値
		ArrayList<Integer> ColorSet = new ArrayList<Integer>();

		for(ProductDataDTO pdd:Apdd) {
			ColorSet.add(pdd.getPColor());
		}
		Set<Integer> colorset = new HashSet<>(ColorSet);
		ArrayList<Integer> ViewColor = new ArrayList<Integer>(colorset);

		return ViewColor;
	}

	public ArrayList<ArrayList<ProductDataDTO>> SAList(ArrayList<ProductDataDTO> Apdd, ArrayList<Integer> color) {
		//戻り値
		ArrayList<ArrayList<ProductDataDTO>> SASet = new ArrayList<ArrayList<ProductDataDTO>>();
		ArrayList<ProductDataDTO> SA1 = new ArrayList<ProductDataDTO>();
		ArrayList<ProductDataDTO> SA2 = new ArrayList<ProductDataDTO>();
		ArrayList<ProductDataDTO> SA3 = new ArrayList<ProductDataDTO>();

		int aaa = 0;
		int colorsize = color.size();

		aaa = color.get(0);

		for(ProductDataDTO pdd:Apdd) {
			if(aaa == pdd.getPColor()) {
				SA1.add(pdd);
			}
		}
		SASet.add(SA1);

		if(colorsize == 2) {
			aaa = color.get(1);
			for(ProductDataDTO pdd:Apdd) {
				if(aaa == pdd.getPColor()) {
					SA2.add(pdd);
				}
			}
			SASet.add(SA2);
		}

		if(colorsize == 3) {
			aaa = color.get(2);
			for(ProductDataDTO pdd:Apdd) {
				if(aaa == pdd.getPColor()) {
					SA3.add(pdd);
				}
			}
			SASet.add(SA3);
		}

		return SASet;
	}


}
