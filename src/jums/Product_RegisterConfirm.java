package jums;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Product_RegisterConfirm
 */
@WebServlet("/Product_RegisterConfirm")
public class Product_RegisterConfirm extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public Product_RegisterConfirm() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
        request.setCharacterEncoding("UTF-8");//リクエストパラメータの文字コードをUTF-8に変更
		//セッションスタート
        HttpSession session = request.getSession();

        //フォーム値からデータを取得
        ProductDataBeans pdb = new ProductDataBeans();
        pdb.setMasterName(request.getParameter("masterName"));
        pdb.setListPrice(Integer.parseInt(request.getParameter("listPrice")));
        pdb.setCost(Integer.parseInt(request.getParameter("cost")));
        pdb.setProductDescript(request.getParameter("productDescript"));

        //フォーム値が入ったbeansをセッションに格納
        session.setAttribute("registerPro",pdb);
        System.out.println("フォーム値のセッション登録完了");

        request.getRequestDispatcher("/productRegisterConfirm.jsp").forward(request, response);


	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
