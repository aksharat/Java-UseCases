package com.deloitte;

import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.deloitte.bean.User;
import com.deloitte.bean.Users;
import com.deloitte.service.LoginService;
import com.deloitte.service.LoginServiceImpl;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet(urlPatterns = { "/details" })
public class EmployeesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private LoginService lService;

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		System.out.println("init called");
		lService = new LoginServiceImpl();
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		System.out.println("destroy called");
		lService.closeConnection();

	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("doGet called");
		String path = request.getServletPath();
		System.out.println("path "+path);
	
		HttpSession session = request.getSession();
		String name = request.getParameter("name");
		String desig = request.getParameter("desig");
		Users user = new Users(name,desig);
		String empname=user.getName();
		String empdesig=user.getDesig();
	
		String displayPage = "desig.jsp";
		
		request.setAttribute("usertype", ("Welcome "+empname+" ,You are a "+empdesig));
		request.getRequestDispatcher(displayPage).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("doPost called");
		doGet(request, response);
	}

}
