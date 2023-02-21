package jums;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class User_ProductHelper {

	public static User_ProductHelper getInstance(){
        return new User_ProductHelper();
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

		int aaa = color.get(0);
		int colorsize = color.size();

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

	public int[] PriceRange(String s) {
		int i = Integer.parseInt(s);
		int pr[] = new int[2];
		if(i == 1) {
			pr[0] = 1;
			pr[1] = 5000;
		}else if(i == 2) {
			pr[0] = 5001;
			pr[1] = 10000;
		}else if(i == 3) {
			pr[0] = 10001;
			pr[1] = 15000;
		}else if(i == 4) {
			pr[0] = 15001;
			pr[1] = 20000;
		}else if(i == 5) {
			pr[0] = 20001;
			pr[1] = 25000;
		}else {
			pr[0] = 0;
			pr[0] = 0;
		}
		return pr;
	}

	public ArrayList<Integer> AmountPullDown(int i) {
		ArrayList<Integer> Amount = new ArrayList<Integer>();
		for(int t=1; t<=i; t++) {
			Amount.add(t);
		}
		return Amount;
	}

}
