package jums;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class User_Login_Judge
 */
@WebServlet("/User_Login_Judge")
public class User_Login_Judge extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public User_Login_Judge() {
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

		String mail = request.getParameter("mail");
		String pass = request.getParameter("pass");
		System.out.println(mail);
		System.out.println(pass);

		try {
			UserDataDTO UserExist = UserDataDAO.getInstance().LoginCheck(mail,pass);
			if(UserExist != null) {
				session.setAttribute("UserExist", UserExist);
				request.getRequestDispatcher("/User_TopPage.jsp").forward(request, response);
			}else {
				request.setAttribute("error", "error");
				request.getRequestDispatcher("/User_Login.jsp").forward(request, response);
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
