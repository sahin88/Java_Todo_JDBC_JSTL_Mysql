
public class Post {
	int postId;
	String postName;
	String postAuthor;
	
	public Post(int postId, String postName, String postAuthor) {
		super();
		this.postId = postId;
		this.postName = postName;
		this.postAuthor = postAuthor;
	}

	public Post( String postName, String postAuthor) {
		super();
		this.postName = postName;
		this.postAuthor = postAuthor;
	}



	public int getPostId() {
		return postId;
	}

	public void setPostId(int postId) {
		this.postId = postId;
	}

	public String getPostName() {
		return postName;
	}

	public void setPostName(String postName) {
		this.postName = postName;
	}

	public String getPostAuthor() {
		return postAuthor;
	}

	public void setPostAuthor(String postAuthor) {
		this.postAuthor = postAuthor;
	}
	
	
	

}
