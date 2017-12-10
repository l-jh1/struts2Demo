package org.app.action;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import mysql.jdbc.*;
import com.opensymphony.xwork2.ActionSupport;

import java.util.List;
import User.User;
public class LoginAction extends ActionSupport {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String username;  
    private String password;  
    private String id;  
    private String roleid; 
    HttpSession session = ServletActionContext.getRequest().getSession();
      
    public String getUsername()  
    {  
        return username;  
    }  
    public void setUsername(String username)  
    {  
        this.username = username;  
    }  
      
    public String getPassword()  
    {  
        return password;  
    }  
    public void setPassword(String password)  
    {  
        this.password = password;  
    }  
    public String getId() {
    	return id;
    }
    public void setId(String id) {
    	this.id = id;
    }
    public String getRoleid() {
    	return roleid;
    }
    public void setRoleid(String roleid) {
    	this.roleid = roleid;
    }
//µÇÂ½
   public String execute()throws Exception {
      String user = getUsername();
      String pass = getPassword();
      boolean vail = false;
      MySQLConnBean mySqlBean = new MySQLConnBean();
      String sql = "SELECT * FROM users where user ='"+user + "' and password ='"+pass+"'";
      mySqlBean.OpenConn();
      ResultSet rs = mySqlBean.executeQuery(sql);

      if(rs.next()) {
			vail = true;
		    session.setAttribute("username", rs.getString("user"));   //´æ
		    session.setAttribute("roleid", rs.getString("roleid"));   //´æ
		    session.setAttribute("id", rs.getString("id"));   //´æ
		    session.setAttribute("type", "1");   //´æ
      }
      rs.close();
      mySqlBean.closeStmt();
      mySqlBean.closeConn();

      if (vail) 
		return "success";
      else 
		return "error";
     }
   public String add()throws Exception {
	      String user = getUsername();
	      String pass = getPassword();
	      boolean vail = false;
	      MySQLConnBean mySqlBean = new MySQLConnBean();
	      String sql = "INSERT into users  (user,password,roleid) Values ('"+user + "','"+pass+"','user')";
	      mySqlBean.OpenConn();
	      vail=mySqlBean.execute(sql);//²åÈë×´Ì¬
	      mySqlBean.closeStmt();
	      mySqlBean.closeConn();
	      if (vail) {
	    	  session.setAttribute("type", "2");   //´æ
	    	  return "success";
	      }
	      else 
			return "error";
	     }
   @SuppressWarnings("rawtypes")
public List selectAll()throws Exception {
	   List<User> list =new ArrayList<User>();
	   
	      MySQLConnBean mySqlBean = new MySQLConnBean();
	      String sql = "SELECT * FROM users ";
	      mySqlBean.OpenConn();
	      ResultSet rs = mySqlBean.executeQuery(sql);
	      while(rs.next()) {
	    	  int id=rs.getInt("id");
	    	  String username=rs.getString("user");
	    	  String password=rs.getString("password");
	    	  String roleid=rs.getString("roleid");
	    	  User user = new User(id,username,password,roleid);
	    	  list.add(user);
	      }
	      rs.close();
	      mySqlBean.closeStmt();
	      mySqlBean.closeConn();

		  return list;
	     }
   	public List selectById(String id1)throws Exception {
	   List<User> list =new ArrayList<User>();
	      MySQLConnBean mySqlBean = new MySQLConnBean();
	      String sql = "SELECT * FROM users where id = "+id1;
	      mySqlBean.OpenConn();
	      ResultSet rs = mySqlBean.executeQuery(sql);
	      while(rs.next()) {
	    	  int id=rs.getInt("id");
	    	  String username=rs.getString("user");
	    	  String password=rs.getString("password");
	    	  String roleid=rs.getString("roleid");
	    	  User user = new User(id,username,password,roleid);
	    	  list.add(user);
	      }
	      rs.close();
	      mySqlBean.closeStmt();
	      mySqlBean.closeConn();

		  return list;
	     }
   	public List select()throws Exception {
   		String user1 = getUsername();
   		List<User> list =new ArrayList<User>();
	      MySQLConnBean mySqlBean = new MySQLConnBean();
	      String sql = "SELECT * FROM users where id = '"+user1+"'";
	      mySqlBean.OpenConn();
	      ResultSet rs = mySqlBean.executeQuery(sql);
	      while(rs.next()) {
	    	  int id=rs.getInt("id");
	    	  String username=rs.getString("user");
	    	  String password=rs.getString("password");
	    	  String roleid=rs.getString("roleid");
	    	  User user = new User(id,username,password,roleid);
	    	  list.add(user);
	      }
	      session.setAttribute("type", "5");   //´æ
	      rs.close();
	      mySqlBean.closeStmt();
	      mySqlBean.closeConn();

		  return list;
	     }
   public String delete()throws Exception {
	   	  String id=getId();
	      boolean vail = false;
	      MySQLConnBean mySqlBean = new MySQLConnBean();
	      String sql = "DELETE from users where id="+id ;
	      mySqlBean.OpenConn();
	      vail=mySqlBean.execute(sql);//É¾³ý²Ù×÷½á¹û
	      mySqlBean.closeStmt();
	      mySqlBean.closeConn();
	      if (vail) {
	    	  session.setAttribute("type", "3");   //´æ
	    	  return "success";
	      }
	      else 
			return "error";
	     }
   public String edit()throws Exception {
	   	  String id=getId();
	   	  String pass = getPassword();
	      boolean vail = false;
	      MySQLConnBean mySqlBean = new MySQLConnBean();
	      String sql = "UPDATE users set password= '"+ pass+"' where id="+id ;
	      mySqlBean.OpenConn();
	      vail=mySqlBean.execute(sql);//ÐÞ¸Ä²Ù×÷½á¹û
	      mySqlBean.closeStmt();
	      mySqlBean.closeConn();
	      if (vail) {
	    	  session.setAttribute("type", "4");   //´æ
	    	  return "success";
	      }
	      else 
			return "error";
	     }
   public String logout()throws Exception {
	/*   	  String id=getId();
	   	  String pass = getPassword();
	      boolean vail = false;
	      MySQLConnBean mySqlBean = new MySQLConnBean();
	      String sql = "UPDATE users set password= '"+ pass+"' where id="+id ;
	      mySqlBean.OpenConn();
	      vail=mySqlBean.execute(sql);//ÐÞ¸Ä²Ù×÷½á¹û
	      mySqlBean.closeStmt();
	      mySqlBean.closeConn();
	   */ session.invalidate();
	      return "success";

	     }



}