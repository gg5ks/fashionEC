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
 * Servlet implementation class Admin_Product_Index
 */
@WebServlet("/Admin_Product_Index")
public class Admin_Product_Index extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public Admin_Product_Index() {
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

		try {
	        session.setAttribute("ac", (int) (Math.random() * 1000));


			//色を呼び出してbeansに保管する
			ColorDataDTO color = new ColorDataDTO();
			color.setColorName("");
			ArrayList<ColorDataDTO> colorList = ColorDataDAO.getInstance().colorReceive(color);
			session.setAttribute("colorList", colorList);


			String mail = request.getParameter("mail");
			System.out.println(mail);


			AdminDataDTO AdExist = AdminDataDAO.getInstance().IDPWCheck(mail);
           //セッションにログイン者の情報を保存する→ログイン情報を確認したいときに使う
			session.setAttribute("AdExist", AdExist);
			System.out.println(AdExist.getAdmin_id());

            //DBからのパスワード結果と入力パスワードの判定素材を揃える
            //DBからの返事
            String passwordA = AdExist.getAdmin_password();
            //フォームに入力されたもの
			String passwordW = request.getParameter("pass");


            //導線に応じた遷移先の指定
            //EnabledがTrueの間はelse前まで処理される
            //userIDのセッション保存はここで行う→login画面でのジャッジに使ってるため
			//deleteFlg見直し！
            if (passwordA !=null){
    			request.getRequestDispatcher("/Admin_Product_Index.jsp").forward(request, response);

           	//パスワードが一致しなかったら
            }else if (passwordA != passwordW){
            	request.setAttribute("deny", "NO");
            	request.setAttribute("userID",mail);
    			System.out.println("ぱすあってない");
            	request.getRequestDispatcher("/Admin_Login.jsp").forward(request, response);

            //DBからの返事が空っぽ且つEnalbedがtrue(=有効アカウントだったら)
            //userIDが存在しないケースはenabledも存在しないので且つ条件なし
            }else if(passwordA == null) {
            	request.setAttribute("find", "NO");
    			System.out.println("ユーザー無効だよ");
            	request.getRequestDispatcher("/Admin_Login.jsp").forward(request, response);

            //enabledがfalseだったら(退会済みのアカウント)
            }else {
            	request.setAttribute("quit", "YES");
            	request.getRequestDispatcher("/Admin_Login.jsp").forward(request, response);
            }


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
