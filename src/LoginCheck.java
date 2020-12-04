import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;



public class LoginCheck {
			String user;
			String userpass;
			String url;
			Connection conn;
	public LoginCheck() {
				super();
				this.user ="alex@localhost";;
				this.userpass ="sahin";
				this.url = "jdbc:mysql://localhost:3306/studb?useTimezone=true&serverTimezone=UTC";
				
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 
				try {
					conn= DriverManager.getConnection(url,user, userpass);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

	public boolean check(String username, String password) throws SQLException {
			
	
		
			
			String queryRetrive="select username,password from logintb where  username =? and password =? "; 
			PreparedStatement pst= conn.prepareStatement(queryRetrive);
			pst.setString(1,username);
			pst.setString(2,password);
			ResultSet rst= pst.executeQuery();
			while(rst.next()) {
				
				return true;
				
			}
			pst.close();
			return false;
			
	
	}
	public boolean register(String username, String password) throws SQLException {
		
		
		String queryPost = "insert into logintb (username,password) values(?,?);";
		PreparedStatement pst= conn.prepareStatement(queryPost);
		
		pst.setString(1, username);
		pst.setString(2, password);
		int count=pst.executeUpdate();
		System.out.println("Data  has been added up"+count);
		pst.close();
		if(count==1) {
			
			return true;
			
		}
		
		return false;
		

}
	
}
