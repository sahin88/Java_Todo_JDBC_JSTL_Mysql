

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Login
 */
//@WebServlet("/Login")
//public class Login extends HttpServlet {
//
//	
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//	
//		String username= request.getParameter("username");
//		String password= request.getParameter("password");
//		
//		boolean liberal = false;
//
//		HttpSession session= request.getSession();
//		
//		LoginCheck logchck= new LoginCheck();
//		try {
//			liberal=logchck.check(username, password);
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		if (liberal) {
//			
//			session.setAttribute("username", username);
//			response.sendRedirect("Welcome.jsp");
//		}
//		else {
//			response.sendRedirect("Login.jsp");
//		}
//		
//	}
//	
//	
//
//
//
//
//}
