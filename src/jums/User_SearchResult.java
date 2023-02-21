package jums;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class User_SearchResult
 */
@WebServlet("/User_SearchResult")
public class User_SearchResult extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public User_SearchResult() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		try {
			//戻り値のセット
			ArrayList<UserProductListBeans> UPLB = new ArrayList<UserProductListBeans>();

			//フォーム値の取得
			String keyword = request.getParameter("keyword");
			int pricerange[] = User_ProductHelper.getInstance().PriceRange(request.getParameter("price"));
			int color = Integer.parseInt(request.getParameter("color"));
			String size = request.getParameter("size");

			//System.out.print(pricerange[0]);

			//Masterの絞り込み検索＋一覧表示の取得
			ArrayList<ProductMasterDTO> PdList = ProductMasterDAO.getInstance().UserIndexProduct(keyword, pricerange);

			//Productの絞り込み検索＋一覧表示の取得
			//MasterIDを基にColor & SizeセットしているProductDataDTOを取得
			//色とサイズの重複をなくす
			//UserProductListBeansにセット
			for(ProductMasterDTO a:PdList) {
				ArrayList<ProductDataDTO> PdCSList = ProductDataDAO.getInstance().UserIndexProduct(a, color, size);

				//Colorを配列にして重複をなくす
				ArrayList<Integer> AllColor = new ArrayList<Integer>();
				ArrayList<String> AllSize = new ArrayList<String>();
				for(ProductDataDTO b:PdCSList) {
					AllColor.add(b.getPColor());
					AllSize.add(b.getSize());
				}
				Set<Integer> colorset = new HashSet<>(AllColor);
				ArrayList<Integer> ViewColor = new ArrayList<Integer>(colorset);

				Set<String> sizeset = new HashSet<>(AllSize);
				ArrayList<String> ViewSize = new ArrayList<String>(sizeset);

				UserProductListBeans uplb = new UserProductListBeans();
				uplb.setpColor(ViewColor);
				uplb.setSize(ViewSize);
				uplb.setMasterId(a.getMasterId());
				uplb.setMasterName(a.getMasterName());
				uplb.setListPrice(a.getListPrice());
				uplb.setMasterImg(a.getImg1());
				UPLB.add(uplb);
			}


			request.setAttribute("UPLB", UPLB);

			request.getRequestDispatcher("/User_SearchResult.jsp").forward(request, response);

		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
