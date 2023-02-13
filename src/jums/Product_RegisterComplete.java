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
 * Servlet implementation class Product_RegisterComplete
 */
@WebServlet("/Product_RegisterComplete")
public class Product_RegisterComplete extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public Product_RegisterComplete() {
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
			ArrayList<ProductDataBeans> pdl1 = (ArrayList<ProductDataBeans>)session.getAttribute("productList1");
			ArrayList<ProductDataBeans>  pdl2 = (ArrayList<ProductDataBeans>)session.getAttribute("productList2");
			ArrayList<ProductDataBeans>  pdl3 = (ArrayList<ProductDataBeans>)session.getAttribute("productList3");
			ProductDataBeans pdbMaster = (ProductDataBeans)session.getAttribute("registerPro");

	        //DTOオブジェクトにマッピング。DB専用のパラメータに変換
	        ProductMasterDTO pmd = new ProductMasterDTO();
	        pdbMaster.ProductMasterMapping(pmd);


	        //DBへデータの挿入
	        ProductMasterDAO .getInstance().insert(pmd);

	        //DBへ登録したmasteridを返してもらう
	        System.out.print("DBへ登録したmasteridを返してもらう");

	        //表に出す用
	        request.setAttribute("registerPro", pdbMaster);

	        //masteridも一緒に渡す
	        ArrayList<ProductDataDTO> pddList1 = new ArrayList<ProductDataDTO>();
	        for (int i=0; i<pdl1.size(); i++) {
	        	ProductDataDTO pdd1 = new ProductDataDTO();
	        	//色、サイズ、在庫セットで配列に入れる
	        	pdd1.setPColor(pdl1.get(i).getPColor());
	        	pdd1.setSize(pdl1.get(i).getSize());
	        	pdd1.setStock(pdl1.get(i).getStock());

	        	System.out.println(pdl1.get(i).getSize());

	        	//配列を親配列に入れてネストにする
	        	pddList1.add(pdd1);


		        ProductDataDAO .getInstance().insertProduct(pddList1);


	        if(pdl2 !=null) {
		        ProductDataDTO pdd2 = new ProductDataDTO();
	        }

	        if(pdl3 !=null) {
		        ProductDataDTO pdd3 = new ProductDataDTO();
	        }
            request.getRequestDispatcher("/productRegisterComplete.jsp").forward(request, response);

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
