package servlet;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginTimeServlet
 */
@WebServlet("/LoginTimeServlet")
public class LoginTimeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginTimeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=utf-8");
//		// 设置时间格式
//					SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
//			 
//					// 获取当前时间
//					String cutTime = sdf.format(new Date());
//			 
//					/**
//					 * 先把所有的cookie放入数组
//					 * */
//			          Cookie[] cookies = request.getCookies();
//			          
//					  String lastTime = null;
//					 /**
//					   * 查询数组是否有lastTime的cookie
//			         */
//
//			          if (cookies != null) {
//				         for (Cookie cookietime : cookies) {
//					      // 如果有上次的登陆痕迹
//					          if (cookietime.getName().equals("lastTime")) {
//
//						        // 把时间显示在浏览器
//						       lastTime = cookietime.getValue();
//						       // 更新cookie
//						       cookietime.setValue(cutTime);
//						       // 设置过期时间一个月
//						       cookietime.setMaxAge(1 * 30 * 24 * 60 * 60);
//						       // 把更新的数据发送到浏览器储存起来
//						       response.addCookie(cookietime);
//					         }
//		                   }
//			             }
//		     	      if (cookies == null || lastTime == null) {
//
//				        // 没有cookie 创建对象
//				         // 显示当前时间
//				         response.getWriter().write("你好,欢迎登录 这是您的第一次" + cutTime);
//				         // 把数据存储到cookie中
//		                Cookie cookietime= new Cookie("lastTime", cutTime);
//				        // 设置过期时间
//				       cookietime.setMaxAge(1 * 30 * 60 * 24 * 60);
//				       // 存储到服务器
//				       response.addCookie(cookietime);
//				        }
		HttpSession session = request.getSession();
		Cookie cookies[]=request. getCookies();//遍历cookies找到lastAccessTime这个cookie
		for (int i=0;cookies!= null &&i< cookies.length; i++){
			
		     if(cookies[i]. getName().equals("lastAccessTime")) {
		      //得到最后访问时间的毫秒数
		      long cookieValue=Long.parseLong(cookies[i].getValue());//将最后访问时间变成一个日期类型
		      Date date=new Date(cookieValue);//格式化这个日期
		      SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		      String lastAccessTime = sdf.format(date); 
		      System.out.println("上次时间是"+lastAccessTime );
		      session.setAttribute("lastTime", lastAccessTime); 
		     }
		}
		
		      //将最新的访问时间设置回去
		Cookie cookie = new Cookie("lastAccessTime", System.currentTimeMillis()  
                + "");  
		   //设置有效期为一个月
		   cookie.setMaxAge(1*3600*24*38);
		   //设置有效访问路径为/day07这个项目下的所有资源
		   cookie.setPath("/ghj"); 
		   //在response中增加一个cookie.服务器会自动增加Set-Cookie头字段
		   response.addCookie(cookie);
		    int loginNumber=cookies.length;
		    System.out.println("登录次数："+loginNumber);
		    session.setAttribute("loginNumber", loginNumber);   
		    response.sendRedirect("index.jsp");
		    //request.getRequestDispatcher("index.jsp").forward(request, response);
		}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
