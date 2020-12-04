import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PostDAO {
	
	String url;
	String username;
	String password;
	String ALL_DATA="select * from Posttb;";
	String retrieve=" select postId,postName,postAuthor from Posttb where postId=?;";
	String update_post="update Posttb set postName=?, postAuthor=? where postId=?;";
	String delete_post="delete from Posttb where postId=?;";
	String add_new="insert into Posttb (postName,postAuthor) values(?,?);";
	Connection conn;
	public PostDAO() {
		this.username ="alex@localhost";;
		this.password ="sahin";
		this.url = "jdbc:mysql://localhost:3306/studb?useTimezone=true&serverTimezone=UTC";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		try {
			conn=DriverManager.getConnection(this.url, this.username,this.password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		
	}

	public boolean addNew(Post p) throws SQLException {
		PreparedStatement ppst= conn.prepareStatement(add_new);
		ppst.setString(1, p.getPostName());
		ppst.setString(2, p.getPostAuthor());
		int result= ppst.executeUpdate();
		
		if (result==1) {
			return true;
		}
		else {
			return false;
		}
	}
	
	
	public boolean  deletePost(int i) throws SQLException {
		PreparedStatement ppst= conn.prepareStatement(delete_post);
		ppst.setInt(1, i);
		int result= ppst.executeUpdate();
		if (result==1) {
			return true;
		}
		else {
			return false;
		}
		
	}
	public boolean  updatePost(Post p) throws SQLException {
		PreparedStatement ppst= conn.prepareStatement(update_post);
		ppst.setString(1, p.getPostName());
		ppst.setString(2, p.getPostAuthor());
		ppst.setInt(3, p.getPostId());
		
		System.out.println(p.getPostName()+ p.getPostAuthor()+p.getPostId());
		int result= ppst.executeUpdate();
		System.out.println(result+"********************");
		if (result==1) {
			return true;
		}
		else {
			return false;
		}
		
		
	}
	
	public Post retrieve(int i) throws SQLException {
		Post post=null;
		//List<Post> posts= new ArrayList<>();
		PreparedStatement ppst= conn.prepareStatement(retrieve);
		ppst.setInt(1, 1);
		ResultSet rs=ppst.executeQuery();
		while(rs.next()) {
			int postId= rs.getInt("postId");
			String postName= rs.getString("postName");
			String postAuthor= rs.getString("postAuthor");
			post=new Post(postId, postName, postAuthor);
			//posts.add(post);
		}
		
		
		return post;
		
	}
	
	
	

	public List<Post> getAllData() throws SQLException {
		List<Post> posts= new ArrayList<>();
		
		
		
			
		PreparedStatement pst= conn.prepareStatement(ALL_DATA);
	
		ResultSet rst=pst.executeQuery();
		while(rst.next()) {
			int postId=rst.getInt("postId");
			String postName=rst.getString("postName");
			String postAuthor= rst.getString("postAuthor");
			posts.add(new Post(postId, postName,postAuthor));
		}
		return posts;
		
	}

}
