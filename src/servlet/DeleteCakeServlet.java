package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.CakeDao;

/**
 * Servlet implementation class DeleteCakeServlet
 */
@WebServlet("/DeleteCakeServlet")
public class DeleteCakeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteCakeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String id = request.getParameter("cid");
		if(id ==null || "".equals(id)) {
			System.out.println(id);
			response.getWriter().write("id不能为空");
		}else {
			//进行删除
			CakeDao cakedao=new CakeDao();
			int cakeId=Integer.parseInt(id);
			int p=cakedao.delete(cakeId);
			if (p==1) {
				  response.sendRedirect("ondelete.jsp");
			    }else {
				  response.sendRedirect("undelete.jsp");
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
