package jums;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Product_DeleteConfirm
 */
@WebServlet("/Product_DeleteConfirm")
public class Product_DeleteConfirm extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public Product_DeleteConfirm() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
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
                if(request.getParameter("delete")!= null ||request.getParameter("delete")== "yes") {
        			ProductMasterDTO resultMaster = (ProductMasterDTO)session.getAttribute("resultMaster");
        			int masterId = resultMaster.getMasterId();
        			ProductDataDAO.getInstance().deleteProduct(masterId);
                	ProductMasterDTO deleteChk = ProductMasterDAO.getInstance().deleteMaster(masterId);
                    resultMaster.setDeleteProduct(deleteChk.getDeleteProduct());
                    session.setAttribute("resultMaster", resultMaster);
                	request.getRequestDispatcher("/product_Detail.jsp").forward(request, response);

                }else {
                	request.getRequestDispatcher("/productDeleteConfirm.jsp").forward(request, response);
                }

        }catch(Exception e){
            //何らかの理由で失敗したらエラーページにエラー文を渡して表示。想定は不正なアクセスとDBエラー
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
