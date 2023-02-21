package jums;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Product_Detail
 */
@WebServlet("/Product_Detail")
public class Product_Detail extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public Product_Detail() {
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

            //正常遷移と戻る時の判断
            if (request.getParameter("mId")!=null) {
            int masterId = Integer.parseInt(request.getParameter("mId"));
            ProductMasterDTO resultMaster = ProductMasterDAO.getInstance().searchProDetail(masterId);
            ArrayList<ProductDataDTO> resultProducts = ProductDataDAO.getInstance().proDetailInfo(masterId);
            session.setAttribute("resultMaster", resultMaster);
            session.setAttribute("resultProducts", resultProducts);

            ArrayList<Integer> chkColors = new ArrayList<Integer>();
            for(int i=0; i<resultProducts.size(); i++) {
	            int checkColor = resultProducts.get(i).getPColor();
	            chkColors.add(checkColor);
            }
            ArrayList<Integer> singleColors = new ArrayList<Integer>(new LinkedHashSet<>(chkColors));
            session.setAttribute("singleColors", singleColors);

            	ArrayList<String> sizes1 = new ArrayList<String>();
            	ArrayList<Integer> stocks1 = new ArrayList<Integer>();
            	ArrayList<String> sizes2 = new ArrayList<String>();
            	ArrayList<Integer> stocks2 = new ArrayList<Integer>();
            	ArrayList<String> sizes3= new ArrayList<String>();
            	ArrayList<Integer> stocks3 = new ArrayList<Integer>();

                for(int h=0; h<resultProducts.size(); h++) {
                	if(resultProducts.get(h).getPColor()== singleColors.get(0)) {
                		String size = resultProducts.get(h).getSize();
                		sizes1.add(size);

                    	int stock = resultProducts.get(h).getStock();
                    	stocks1.add(stock);
                	}
                }
            	session.setAttribute("sizes1", sizes1);
            	session.setAttribute("stocks1", stocks1);

                if(singleColors.size()>=2) {
                    for(int h=0; h<resultProducts.size(); h++) {
                    	if(resultProducts.get(h).getPColor()== singleColors.get(1)) {
                    		String size = resultProducts.get(h).getSize();
                    		sizes2.add(size);

                        	int stock = resultProducts.get(h).getStock();
                        	stocks2.add(stock);
                    	}
                    }
                    session.setAttribute("sizes2", sizes2);
                	session.setAttribute("stocks2", stocks2);
                }

                if(singleColors.size()==3) {
                    for(int h=0; h<resultProducts.size(); h++) {
                    	if(resultProducts.get(h).getPColor()== singleColors.get(2)) {
                    		String size = resultProducts.get(h).getSize();
                    		sizes3.add(size);

                        	int stock = resultProducts.get(h).getStock();
                        	stocks3.add(stock);
                    	}
                    }
                    session.setAttribute("sizes3", sizes3);
                	session.setAttribute("stocks3", stocks3);
                }
            }
                request.getRequestDispatcher("/productDetail.jsp").forward(request, response);
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
