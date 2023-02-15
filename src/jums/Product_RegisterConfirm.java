package jums;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

/**
 * Servlet implementation class Product_RegisterConfirm
 */
@WebServlet("/Product_RegisterConfirm")
@MultipartConfig
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

		HttpSession session = request.getSession();
        try{
            //アクセスルートチェック
            String accesschk = request.getParameter("ac");
            if(accesschk ==null ||session.getAttribute("ac")==null|| (Integer)session.getAttribute("ac")!=Integer.parseInt(accesschk)){
                throw new Exception("不正なアクセスです");
            }

        //フォーム値からデータを取得
        ProductDataBeans pdb = new ProductDataBeans();

        pdb.setMasterName(request.getParameter("masterName"));
        pdb.setListPrice(Integer.parseInt(request.getParameter("listPrice")));
        pdb.setCost(Integer.parseInt(request.getParameter("cost")));
        pdb.setProductDescript(request.getParameter("productDescript"));

        //1つめの色型を配列にセットする
        int color1 = Integer.parseInt(request.getParameter("productColor1"));

        //チェックボックスのチェックされた値を見つける
        String[] checkedSize1 = request.getParameterValues("checkbox1");
        ArrayList<ProductDataBeans> pdbList1 = new ArrayList<ProductDataBeans>();
        for (String size1 : checkedSize1) {
        	ProductDataBeans ppp = new ProductDataBeans();
        	//チェックのついたサイズの対象となる在庫数を取りだす
        	String stock = size1 + "1stock";
        	int stock1 = Integer.parseInt(request.getParameter(stock));

        	//色、サイズ、在庫セットで配列に入れる
        	ppp.setPColor(color1);
        	ppp.setSize(size1);
        	ppp.setStock(stock1);

        	System.out.println(color1);
        	System.out.println(size1);
        	System.out.println(stock1);


        	//配列を親配列に入れてネストにする
        	pdbList1.add(ppp);
        }

        //商品のフォーム値が入ったbeansをセッションに格納
        session.setAttribute("productList1", pdbList1);

        String[] checkedSize2 = request.getParameterValues("checkbox2");
    	ArrayList<ProductDataBeans> pdbList2 = new ArrayList<ProductDataBeans>();

        if (checkedSize2 !=null ) {
            //2つめの色型を配列にセットする
        	int color2 = Integer.parseInt(request.getParameter("productColor2"));

        	for (String size2 : checkedSize2) {
	        	ProductDataBeans ppp = new ProductDataBeans();
	        	//チェックのついたサイズの対象となる在庫数を取りだす
	        	String stock = size2 + "2stock";
	        	int stock2 = Integer.parseInt(request.getParameter(stock));

	        	//色、サイズ、在庫セットで配列に入れる
	        	ppp.setPColor(color2);
	        	ppp.setSize(size2);
	        	ppp.setStock(stock2);

	        	//配列を追加で親配列に入れてネストにする
	        	pdbList2.add(ppp);
	        }
            session.setAttribute("productList2", pdbList2);
        }

        String[] checkedSize3 = request.getParameterValues("checkbox3");
    	ArrayList<ProductDataBeans> pdbList3 = new ArrayList<ProductDataBeans>();

        if (checkedSize3 !=null) {
            //3つめの色型を配列にセットする
        	int color3 = Integer.parseInt(request.getParameter("productColor3"));

        	for (String size3 : checkedSize3) {
	        	ProductDataBeans ppp = new ProductDataBeans();
	        	//チェックのついたサイズの対象となる在庫数を取りだす
	        	String stock = size3 + "3stock";
	        	int stock3 = Integer.parseInt(request.getParameter(stock));

	        	//色、サイズ、在庫セットで配列に入れる
	        	ppp.setPColor(color3);
	        	ppp.setSize(size3);
	        	ppp.setStock(stock3);

	        	//配列を追加で親配列に入れてネストにする
	        	pdbList3.add(ppp);
	        }
            session.setAttribute("productList3", pdbList3);
        }

        //画像のはなし
		//name属性がimg1のファイルをPartオブジェクトとして取得
        ArrayList<String> imgList = new ArrayList<String>();
        for(int i=1; i<=5; i++) {
        	String img = "img"+i;
        	Part part=request.getPart(img);

        	if(part.getSize() ==0) {
        		break;
        	}

			System.out.println(part);
			//ファイル名を取得
			//String filename=part.getSubmittedFileName();//ie対応が不要な場合
			String filename =Paths.get(part.getSubmittedFileName()).getFileName().toString();		//アップロードするフォルダ
			System.out.println(filename);
			String path=getServletContext().getRealPath("/img");
			//実際にファイルが保存されるパス確認
			System.out.println(path);
			//書き込み
			part.write(path+File.separator+filename);

			imgList.add(filename);

        }

			session.setAttribute("imgList", imgList);

        //商品マスターのフォーム値が入ったbeansをセッションに格納
        session.setAttribute("registerPro",pdb);
        System.out.println("商品マスターフォーム値のセッション登録完了");

        request.getRequestDispatcher("/productRegisterConfirm.jsp").forward(request, response);

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
