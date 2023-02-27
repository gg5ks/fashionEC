package jums;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class User_CartAdd
 */
@WebServlet("/User_CartAdd")
public class User_CartAdd extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public User_CartAdd() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();

			//formの取得
			int colorid = Integer.parseInt(request.getParameter("colorid"));
			String size = request.getParameter("size");
			int Quantity = Integer.parseInt(request.getParameter("amount"));
			User_ProductDetailBeans UPMD = (User_ProductDetailBeans)session.getAttribute("UPDB");
			UserDataDTO UDD = (UserDataDTO)session.getAttribute("UserExist");

			try {
				//insert処理 userid,productid,quantity
				//引数のセット
				CartDataDTO CDD = new CartDataDTO();

				//userid
				CDD.setUser_id(UDD.getUser_id());

				//productid
				int productID = ProductDataDAO.getInstance().ProductIDSearch(colorid, UPMD.getMasterId(), size);
				CDD.setProduct_id(productID);

				//quantity
				CDD.setQuantity(Quantity);

				//カートテーブルへのインサート
				CartDataDAO.getInstance().insertCart(CDD);

				//商品詳細へ戻す
				String URL = "User_ProductDetail?id="+String.valueOf(UPMD.getMasterId());
				request.getRequestDispatcher(URL).forward(request, response);
			}catch (SQLException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
				request.getRequestDispatcher("./error.jsp").forward(request, response);
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
