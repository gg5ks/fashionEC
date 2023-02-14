package jums;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class User_NewAcountRegi
 */
@WebServlet("/User_NewAcountRegi")
public class User_NewAcountRegi extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public User_NewAcountRegi() {
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
		try{
			//form値の受け取り
			String name = request.getParameter("name");
			String mail = request.getParameter("mail");
			String pass = request.getParameter("pass");
			Integer post = Integer.parseInt(request.getParameter("post"));
			String address = request.getParameter("address");
			String tell = request.getParameter("tell");
			
            //DTOオブジェクトにマッピング。DB専用のパラメータに変換
            UserDataDTO udd = new UserDataDTO();
            udd.setUser_name(name);
            udd.setUser_email(mail);
            udd.setUser_password(mail);
            udd.setUser_postid(post);
            udd.setUser_address(address);
            udd.setUser_tell(tell);

            //DBへデータの挿入
            UserDataDAO .getInstance().NewUser(udd);

            //結果画面での表示用に入力パラメータ―をリクエストパラメータとして保持
            //request.setAttribute("AcCompUDB", AcCompUDB);

            request.getRequestDispatcher("/User_TopPage.jsp").forward(request, response);
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
