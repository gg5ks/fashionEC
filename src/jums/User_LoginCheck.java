package jums;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet Filter implementation class User_LoginCheck
 */
@WebFilter("/User_LoginCheck")
public class User_LoginCheck implements Filter {

    /**
     * Default constructor.
     */
    public User_LoginCheck() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here
		 System.out.println("ログインチェック");
	        HttpServletRequest req = (HttpServletRequest) request;
	        HttpServletResponse res = (HttpServletResponse) response;

	        // セッションが存在しない場合NULLを返す
	        HttpSession session = req.getSession();

	        if(session != null){
	        	Object UserLogin = session.getAttribute("UserExist");
	        	if(UserLogin == null) {
	        		// （ログインしてねえなあ！！）
	        		res.sendRedirect("User_Login");
	        	}
	        }else{
	            // セッションがNull（セッションできてねえぞ！！）
	        	res.sendRedirect("User_Login");
	        }
		// pass the request along the filter chain
		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
