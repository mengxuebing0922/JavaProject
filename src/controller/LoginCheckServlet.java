package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import Dao.AdminDao;
import bean.AdminBean;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginCheckServlet
 */
@WebServlet("/LoginCheckServlet")
public class LoginCheckServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginCheckServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		response.setContentType("tect/html;charset=utf-8");
        String userName=request.getParameter("userName");
        String password=request.getParameter("password");
        String autoLogin=request.getParameter("autoLogin");
           
        AdminDao user=new AdminDao();
        if(userName.equals(user.SelectUser(userName))&&password.equals(user.Selectpassword(password))) {
        	if("on".equals(autoLogin)) {
				session.setMaxInactiveInterval(60*60*24*7);
				Cookie cookie = new Cookie("JSESSIONID",session.getId());
				cookie.setMaxAge(60*60*24*7);
				response.addCookie(cookie);
			}
    	   session.setAttribute("userName", userName); 
    	  response.sendRedirect("index.jsp");
    	  
           // request.getRequestDispatcher("LoginTimeServlet").forward(request, response);	
        }else if(!userName.equals(user.SelectUser(userName))) {
        	response.sendRedirect("error3.jsp");
        } else if(userName.equals(user.SelectUser(userName))&&!password.equals(user.Selectpassword(password)))  {
        	response.sendRedirect("error2.jsp");
        }else {
        	response.sendRedirect("error1.jsp");        	       	
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
