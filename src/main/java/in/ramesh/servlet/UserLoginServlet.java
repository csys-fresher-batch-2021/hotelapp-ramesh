package in.ramesh.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import in.ramesh.service.UserLoginService;
import in.ramesh.util.Logger;

/**
 * Servlet implementation class UserLogin
 */
@WebServlet("/UserLoginServlet")
public class UserLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		boolean flag=UserLoginService.addUserLogin(username,password);
		Logger log=new Logger();
		log.print(flag);
		if (flag) {
			HttpSession session = request.getSession();
			session.setAttribute("LOGGED_IN_USER", username);
			response.sendRedirect("BillCalculator.jsp");

		} else {
			String errorMessage = "Invalid Login Credentials";
			response.sendRedirect("UserLogin.jsp?errorMessage=" + errorMessage);
		}
	}

}
