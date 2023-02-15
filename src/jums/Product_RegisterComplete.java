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
            //アクセスルートチェック
            String accesschk = request.getParameter("ac");
            if(accesschk ==null ||session.getAttribute("ac")==null|| (Integer)session.getAttribute("ac")!=Integer.parseInt(accesschk)){
                throw new Exception("不正なアクセスです");
            }

			ArrayList<ProductDataBeans> pdl1 = (ArrayList<ProductDataBeans>)session.getAttribute("productList1");
			ArrayList<ProductDataBeans>  pdl2 = (ArrayList<ProductDataBeans>)session.getAttribute("productList2");
			ArrayList<ProductDataBeans>  pdl3 = (ArrayList<ProductDataBeans>)session.getAttribute("productList3");
			ProductDataBeans pdbMaster = (ProductDataBeans)session.getAttribute("registerPro");

	        //DTOオブジェクトにマッピング。DB専用のパラメータに変換
	        ProductMasterDTO pmd = new ProductMasterDTO();
	        pdbMaster.ProductMasterMapping(pmd);
	        AdminDataDTO loginAdmin = (AdminDataDTO)session.getAttribute("AdExist");
	        int adminId = loginAdmin.getAdmin_id();
	        System.out.println(adminId);

	        ArrayList<String> imgLists = (ArrayList<String>) session.getAttribute("imgList");

	        //DBへデータの挿入 //DBへ登録したmasteridを返してもらう
	        ProductMasterDTO pmdResult = ProductMasterDAO .getInstance().insert(pmd,imgLists,adminId);

	        int masterId = pmdResult.getMasterId();
	        System.out.print("DBへ登録したmasteridを返してもらった");

	        //表に出す用
	        request.setAttribute("registerPro", pdbMaster);

	        ArrayList<ProductDataDTO> pddList1 = new ArrayList<ProductDataDTO>();
	        for (int i=0; i<pdl1.size(); i++) {
	        	ProductDataDTO pdd1 = new ProductDataDTO();
	        	//色、サイズ、在庫セットで配列に入れる
	        	pdd1.setPColor(pdl1.get(i).getPColor());
	        	pdd1.setSize(pdl1.get(i).getSize());
	        	pdd1.setStock(pdl1.get(i).getStock());

	        	//配列を親配列に入れてネストにする
	        	pddList1.add(pdd1);
	        }
		        //masteridも一緒に渡す
		        ProductDataDAO .getInstance().insertProduct(pddList1,masterId,adminId);
		        session.setAttribute("pddList1", pddList1);


	        if(pdl2 !=null) {
		        ArrayList<ProductDataDTO> pddList2 = new ArrayList<ProductDataDTO>();
		        for (int i=0; i<pdl2.size(); i++) {
		        	ProductDataDTO pdd2 = new ProductDataDTO();
		        	//色、サイズ、在庫セットで配列に入れる
		        	pdd2.setPColor(pdl2.get(i).getPColor());
		        	pdd2.setSize(pdl2.get(i).getSize());
		        	pdd2.setStock(pdl2.get(i).getStock());

		        	//配列を親配列に入れてネストにする
		        	pddList2.add(pdd2);
		        }
		        //masteridも一緒に渡す
		        ProductDataDAO .getInstance().insertProduct(pddList2,masterId,adminId);
		        session.setAttribute("pddList2", pddList2);
	        }

	        if(pdl3 !=null) {
		        ArrayList<ProductDataDTO> pddList3 = new ArrayList<ProductDataDTO>();
		        for (int i=0; i<pdl3.size(); i++) {
		        	ProductDataDTO pdd3 = new ProductDataDTO();
		        	//色、サイズ、在庫セットで配列に入れる
		        	pdd3.setPColor(pdl3.get(i).getPColor());
		        	pdd3.setSize(pdl3.get(i).getSize());
		        	pdd3.setStock(pdl3.get(i).getStock());

		        	//配列を親配列に入れてネストにする
		        	pddList3.add(pdd3);
		        }
		        //masteridも一緒に渡す
		        ProductDataDAO .getInstance().insertProduct(pddList3,masterId,adminId);
		        session.setAttribute("pddList3", pddList3);
	        }

	        request.getRequestDispatcher("/productRegisterComplete.jsp").forward(request, response);

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
