package jums;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Product_Update
 */
@WebServlet("/Product_Update")
public class Product_Update extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public Product_Update() {
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

                ArrayList<ProductDataDTO> resultProducts = (ArrayList<ProductDataDTO>)session.getAttribute("resultProducts");
                ArrayList<Integer> singleColors = (ArrayList<Integer>) session.getAttribute("singleColors");

            	ArrayList<String> sizes1 = new ArrayList<String>();
            	Map<String,Integer> map1 = new HashMap<>();
            	ArrayList<String> sizes2 = new ArrayList<String>();
            	Map<String,Integer> map2 = new HashMap<>();
            	ArrayList<String> sizes3= new ArrayList<String>();
            	Map<String,Integer> map3 = new HashMap<>();

                for(int h=0; h<resultProducts.size(); h++) {
                	if(resultProducts.get(h).getPColor()== singleColors.get(0)) {
                		String size = resultProducts.get(h).getSize();
                		sizes1.add(size);

                    	int stock = resultProducts.get(h).getStock();
                    	map1.put(size, stock);
                	}
                }
            	session.setAttribute("sizes1", sizes1);
            	session.setAttribute("stocks1", map1);

                if(singleColors.size()>=2) {
                    for(int h=0; h<resultProducts.size(); h++) {
                    	if(resultProducts.get(h).getPColor()== singleColors.get(1)) {
                    		String size = resultProducts.get(h).getSize();
                    		sizes2.add(size);

                        	int stock = resultProducts.get(h).getStock();
                        	map2.put(size, stock);
                    	}
                    }
                    session.setAttribute("sizes2", sizes2);
                	session.setAttribute("stocks2", map2);
                }

                if(singleColors.size()==3) {
                    for(int h=0; h<resultProducts.size(); h++) {
                    	if(resultProducts.get(h).getPColor()== singleColors.get(2)) {
                    		String size = resultProducts.get(h).getSize();
                    		sizes3.add(size);

                        	int stock = resultProducts.get(h).getStock();
                        	map3.put(size, stock);
                    	}
                    }
                    session.setAttribute("sizes3", sizes3);
                	session.setAttribute("stocks3", map3);
                }


            request.getRequestDispatcher("/productUpdate.jsp").forward(request, response);

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
