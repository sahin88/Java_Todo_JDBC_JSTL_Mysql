

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Register
 */
@WebServlet("/Register")
public class Register extends HttpServlet {

       

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String username= request.getParameter("username");
		String password= request.getParameter("password");
		String password2= request.getParameter("password2");
		String error1="Passwords don't match";
		String error2="Passwords cannot be longer than 11 or shorter than 6 Charecter";
		String error3="Passwords must have at least 1 Uppercase, 1 Lowercase, 1 Digists";
		boolean liberal = false;
		boolean checkPass = false;
		boolean errFlag=false;
		HttpSession session= request.getSession();
		if(!password.equals(password2)) {
			session.setAttribute("error", error1);
			//response.sendRedirect("Register.jsp");
			errFlag=true;
			System.out.println(error1);
			
		}
		
		if(password.length() < 6 || password.length() > 11) {
			session.setAttribute("error", error2);
			errFlag=true;
			//response.sendRedirect("Register.jsp");
			System.out.println(error2);
		}
		checkPass=checkString(password);
		if(!checkPass) {
			session.setAttribute("error", error3);
			//response.sendRedirect("Register.jsp");
			errFlag=true;
			System.out.println(error3);
		}
		
		LoginCheck logchck= new LoginCheck();
		try {
			liberal=logchck.register(username, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	
		String page;
		if (liberal&&!errFlag) {
			
//			page="Login.jsp";
			
			response.sendRedirect("Login.jsp");
		}
		else {
			//page="Register.jsp";
			response.sendRedirect("Register.jsp");
		}
//		RequestDispatcher dd=request.getRequestDispatcher(page);
//		dd.forward(request, response);

	}
		
		
	
	
	private static boolean checkString(String str) {
	    char ch;
	    boolean capitalFlag = false;
	    boolean lowerCaseFlag = false;
	    boolean numberFlag = false;
	    for(int i=0;i < str.length();i++) {
	        ch = str.charAt(i);
	        if( Character.isDigit(ch)) {
	            numberFlag = true;
	        }
	        else if (Character.isUpperCase(ch)) {
	            capitalFlag = true;
	        } else if (Character.isLowerCase(ch)) {
	            lowerCaseFlag = true;
	        }
	        if(numberFlag && capitalFlag && lowerCaseFlag)
	            return true;
	    }
	    return false;
	}

}
