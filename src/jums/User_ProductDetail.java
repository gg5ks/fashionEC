package jums;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class User_ProductDetail
 */
@WebServlet("/User_ProductDetail")
public class User_ProductDetail extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public User_ProductDetail() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//System.out.print(request.getParameter("id"));
		int PMID = Integer.parseInt(request.getParameter("id"));
		try {
			User_ProductDetailBeans UPDB = new User_ProductDetailBeans();
			ProductMasterDTO PMDLeft = ProductMasterDAO.getInstance().searchProDetail(PMID);

			UPDB.setMasterId(PMID);
			UPDB.setMasterName(PMDLeft.getMasterName());
			UPDB.setMasterDiscript(PMDLeft.getProductDescript());
			UPDB.setPrice(PMDLeft.getListPrice());

			ArrayList<String> ImgList = new ArrayList<String>();
			ImgList.add(PMDLeft.getImg1());
			if(PMDLeft.getImg2() != null) {
				ImgList.add(PMDLeft.getImg2());
			}
			if(PMDLeft.getImg3() != null) {
				ImgList.add(PMDLeft.getImg3());
			}
			if(PMDLeft.getImg4() != null) {
				ImgList.add(PMDLeft.getImg4());
			}
			if(PMDLeft.getImg5() != null) {
				ImgList.add(PMDLeft.getImg5());
			}

			UPDB.setImgList(ImgList);

			//System.out.print("到達しています");

			ArrayList<ProductDataDTO> PdList = ProductDataDAO.getInstance().proDetailInfo(PMID);
			ArrayList<Integer> Color = User_ProductHelper.getInstance().ColorList(PdList);
			ArrayList<ArrayList<ProductDataDTO>> SizeAmount = User_ProductHelper.getInstance().SAList(PdList, Color);

			UPDB.setColorIdList(Color);
			UPDB.setListSizeAmount(SizeAmount);

			request.setAttribute("UPDB", UPDB);
			request.setAttribute("SizeAmount", SizeAmount);
			request.setAttribute("ImgList", ImgList);
			request.getRequestDispatcher("/User_ProductDetail.jsp").forward(request, response);

		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}finally {
			request.getRequestDispatcher("/error.jsp").forward(request, response);
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
