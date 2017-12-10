package User;

public class User {
	String id = null;
	String username = null;
	String password= null;
	String roleid = null;
	public User() {
		// TODO 自动生成的构造函数存根
	}
	public User(int id,String user,String pass,String roleid){
		this.id =  Integer.toString(id);
		this.username = user;
		this.password =pass;
		this.roleid = roleid;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRoleid() {
		return roleid;
	}
	public void setRoleid(String roleid) {
		this.roleid = roleid;
	}

}