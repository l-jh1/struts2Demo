package mysql.jdbc;
import java.sql.*;

public class MySQLConnBean {
    Connection conn = null;
    Statement stmt = null;
    ResultSet rs = null;
    public MySQLConnBean() {
	}
    public void OpenConn() throws Exception{
        try {
            String URL = "jdbc:mysql://localhost:3306/struts2_demo";
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            conn = DriverManager.getConnection(URL, "root", "1234");   
        }
        catch (SQLException e) {
			System.out.println("Data.executeQuery:"+ e.getMessage());
		}
    }
    public ResultSet executeQuery(String sql){
    	rs = null;
    	try {
    		stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
    		rs= stmt.executeQuery(sql);
			
		} catch (SQLException e) {
			System.out.println("Data.executeQuery:"+ e.getMessage());
		}
    	return rs;
    }
    public void closeStmt(){
    	try {
			stmt.close();
		} catch (SQLException e) {
			System.out.println("Data.executeQuery:"+ e.getMessage());
		}
    }
    public void closeConn(){
    	try {
			conn.close();
		} catch (SQLException e) {
			System.out.println("Data.executeQuery:"+ e.getMessage());
		}
    }
	public boolean execute(String sql) {
    	rs = null;
    	try {
    		stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
    		stmt.execute(sql);
			return true;
		} catch (SQLException e) {
			System.out.println("Data.executeQuery:"+ e.getMessage());
		}
    	return false;
	}
    
    
    
}
