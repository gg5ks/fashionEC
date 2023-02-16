package jums;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class AdminProductSearch
 */
@WebServlet("/AdminProductSearch")
public class AdminProductSearch extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminProductSearch() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@SuppressWarnings("null")
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");//リクエストパラメータの文字コードをUTF-8に変更
		HttpSession session = request.getSession();

		try{
            //アクセスルートチェック
            String accesschk = request.getParameter("ac");
            if(accesschk ==null ||session.getAttribute("ac")==null|| (Integer)session.getAttribute("ac")!=Integer.parseInt(accesschk)){
                throw new Exception("不正なアクセスです");
            }

            String searchMaster = request.getParameter("searchMaster");
            String searchMasterName = request.getParameter("searchMasterName");
            String searchColor = request.getParameter("searchColor");
            String searchSize = request.getParameter("searchSize");
            String searchPublish = request.getParameter("searchPublish");


            ProductMasterDTO pmd4s = new ProductMasterDTO();
            ProductDataDTO pdd4s = new ProductDataDTO();

            if(searchMaster != null || searchMaster!="0") {
            	pmd4s.setMasterId(Integer.parseInt(searchMaster));
            }
            if(searchMasterName != null) {
            	pmd4s.setMasterName(searchMasterName);
            }
            if(searchColor != null||searchColor!="0") {
            	pdd4s.setPColor(Integer.parseInt(searchColor));
            }
            if(searchSize != null) {
            	pdd4s.setSize(searchSize);
            }
            if(searchPublish != null||searchPublish!="9") {
            	pmd4s.setPublish(Integer.parseInt(searchPublish));
            }
            int publishCheck = (Integer.parseInt(searchPublish));
            ArrayList<ProductMasterDTO> searchResult = ProductMasterDAO.getInstance().searchProduct(pmd4s,pdd4s,publishCheck);
            session.setAttribute("searchResult",searchResult);

            request.getParameter("searching");
            request.getRequestDispatcher("/Admin_Product_Index.jsp").forward(request, response);


		}catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("error", e.toString());
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
