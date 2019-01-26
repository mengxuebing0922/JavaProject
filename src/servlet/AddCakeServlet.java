package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Dao.CakeDao;

/**
 * Servlet implementation class AddCakeServlet
 */
@WebServlet("/AddCakeServlet")
public class AddCakeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddCakeServlet() {
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
	    String cakeName=request.getParameter("cakeName");
	    String cakeSize=request.getParameter("cakeSize");
		String cakeprice=request.getParameter("cakePrice");
		if(cakeName.length()<=0||cakeSize.length()<=0||cakeprice.length()<=0) {
			response.sendRedirect("cakenameNotNull.jsp");
		}else {
			
			double cakePrice = new Double(cakeprice);
			String cakeImageUrl=request.getParameter("cakeImageUrl");
			String caketypeId=request.getParameter("cakeTypeId");
			int cakeTypeId= Integer.parseInt(caketypeId); 
				CakeDao cake=new CakeDao();
				   int cakeId=cake.SelectId();
				   int p=cake.insert(cakeId, cakeName, cakeSize, cakePrice, cakeImageUrl, cakeTypeId);
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
