

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/")
public class PostServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public  PostDAO postdao;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public PostServlet() {
        super();
       this.postdao= new PostDAO();
     
    }


	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		doGet(request, response);
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action= request.getServletPath();
		System.out.println("action"+action);
		switch(action) {
		case "/new":
			createForm(request, response);
			break;
		case "/login":
			login(request, response);
			break;
			
		case "/logout":
			logout(request, response);
			break;
		case "/insert":
			try {
				insertDB(request, response);
			} catch (SQLException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
			
		case "/edit":
			try {
				editPost(request, response);
			} catch (ServletException | IOException | SQLException e3) {
				// TODO Auto-generated catch block
				e3.printStackTrace();
			}
			
			break;
		case "/update":
			try {
				updatePost(request, response);
			} catch (ServletException | IOException | SQLException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
			break;
		case "/delete":
			try {
				deletePost(request, response);
			} catch (ServletException | IOException | SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			break;
			
		case "/loginheck":
			try {
				loginCheck(request, response);
			} catch (ServletException | IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			break;
			default:
	
			try {
				ListAllPost(request, response);
			} catch (SQLException | ServletException | IOException e) {
				e.printStackTrace();
			}
			break;

		
		
		}
		
	}


	private void logout(HttpServletRequest request, HttpServletResponse response)  throws ServletException, IOException  {
		
			HttpSession session = request.getSession();
			session.removeAttribute("username");
			session.invalidate();
			response.sendRedirect("Login.jsp");
		}
		
	




	private void loginCheck(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username= request.getParameter("username");
		String password= request.getParameter("password");
		
		boolean liberal = false;

		HttpSession session= request.getSession();
		
		LoginCheck logchck= new LoginCheck();
		try {
			liberal=logchck.check(username, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println(liberal);
		if (liberal) {
			
			session.setAttribute("username", username);
			RequestDispatcher dispatcher= request.getRequestDispatcher("/");
			 dispatcher.forward(request, response);
			
		}
		else {
			
			RequestDispatcher dispatcher= request.getRequestDispatcher("Login.jsp");
			 dispatcher.forward(request, response);
			
		}
		
	}


	private void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
			RequestDispatcher dispatcher= request.getRequestDispatcher("Login.jsp");
			 dispatcher.forward(request, response);
			
		
		
	}




	private void insertDB(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		String postName=request.getParameter("postName");
		String postAuthor= request.getParameter("postAuthor");
		 Post post = new Post(postName, postAuthor);
		 postdao.addNew(post);
		 response.sendRedirect("list");
		
	}

	private void deletePost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
		int postId=Integer.parseInt(request.getParameter("id")); 
		boolean res=postdao.deletePost(postId);
		
		if(res){
			RequestDispatcher dispatcher= request.getRequestDispatcher("/");
			 dispatcher.forward(request, response);
		};
	}
	
	private void updatePost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
		String postName=request.getParameter("postName");
		String postAuthor= request.getParameter("postAuthor");
		
		int postId=Integer.parseInt(request.getParameter("postId")); 
		Post post = new Post(postId,postName, postAuthor);
		boolean res=postdao.updatePost(post);
		if(res){
			RequestDispatcher dispatcher= request.getRequestDispatcher("/");
			 dispatcher.forward(request, response);
		};
	}
	
	
	private void editPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
		int postId=Integer.parseInt(request.getParameter("id")); 

		 Post list=postdao.retrieve( postId);
		 request.setAttribute("postlist", list);
		 RequestDispatcher dispatcher= request.getRequestDispatcher("CreateForm.jsp");
		 dispatcher.forward(request, response);
	}

	private void createForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher= request.getRequestDispatcher("CreateForm.jsp");
		dispatcher.forward(request, response);
		
	}
	
	private void ListAllPost(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
		
		List<Post> lists=postdao.getAllData();
	
		
		RequestDispatcher dispatcher= request.getRequestDispatcher("Welcome.jsp");
		request.setAttribute("postlist", lists);
		dispatcher.forward(request, response);
		

	}





}
