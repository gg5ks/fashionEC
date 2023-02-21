package jums;

import java.io.Serializable;
import java.util.ArrayList;

public class ColorDataDTO implements Serializable {

	//色
	private int colorId;
	private String colorName;
	private int colorCate;
	private String colorCss;
	private ArrayList<ColorDataDTO> color = new ArrayList <ColorDataDTO>();

	public void setColorId(int colorId) {
		this.colorId = colorId;
	}
	public int getColorId() {
		return colorId;
	}

	public void setColorName(String colorName) {
		this.colorName = colorName;
	}
	public String getColorName() {
		return colorName;
	}

	public void setColorCate(int colorCate) {
		this.colorCate = colorCate;
	}
	public int getColorCate() {
		return colorCate;
	}

	public void setColorCss(String colorCss) {
		this.colorCss = colorCss;
	}
	public String getColorCss() {
		return colorCss;
	}
    public ArrayList<ColorDataDTO> getColor() {
        return color;
    }

    //uddを生成して、arraylistにsetし続ける
    public void setColor(int colorId, String colorName,int colorCate,String colorCss) {
		this.colorId = colorId;
    	this.colorName = colorName;
		this.colorCate = colorCate;
		this.colorCss = colorCss;
    }

}
