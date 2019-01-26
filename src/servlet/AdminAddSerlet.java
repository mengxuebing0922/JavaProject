package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Dao.AdminDao;
import Dao.CakeDao;

/**
 * Servlet implementation class AdminAddSerlet
 */
@WebServlet("/AdminAddSerlet")
public class AdminAddSerlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminAddSerlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		HttpSession session=request.getSession();
		response.setContentType("tect/html;charset=utf-8");
	    String adminName=request.getParameter("adminName");
		String adminpassword=request.getParameter("adminpassword");
		String adminrealName=request.getParameter("adminrealName");
		String adminEmail=request.getParameter("adminEmail"); 
		if(adminName.length()<=0||adminpassword.length()<=0||adminEmail.length()<=0) {
			response.sendRedirect("NameNotnNull.jsp");
		}else {
			 AdminDao admin=new AdminDao();
			   int adminId=admin.SelectId();
			   int p=admin.insert(adminId,adminName,adminpassword,adminrealName,adminEmail);
			   if (p==1) {
				 response.sendRedirect("oninsert.jsp");
				
			   }else {
				  response.sendRedirect("uninsert.jsp");
				
			   }
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
