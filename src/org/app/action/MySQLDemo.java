package org.app.action;
import java.sql.*;

public class MySQLDemo {
	 
    // JDBC 驱动名及数据库 URL
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
    static final String DB_URL = "jdbc:mysql://localhost:3306/struts2_demo";
 
    // 数据库的用户名与密码，需要根据自己的设置
    static final String USER = "root";
    static final String PASS = "1234";
 
    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;
        try{
            // 注册 JDBC 驱动
            Class.forName("com.mysql.jdbc.Driver");
        
            // 打开链接
            System.out.println("连接数据库...");
            conn = DriverManager.getConnection(DB_URL,USER,PASS);
            PreparedStatement ptmt = null;
        
            // 执行查询
            System.out.println(" 实例化Statement对...");
            stmt = conn.createStatement();
            String sql;
            String user1 = "admin";
            sql = "SELECT * FROM users where user ='"+user1 + "' and password ='"+user1+"'";
            ResultSet rs = stmt.executeQuery(sql);
            //ptmt = conn.prepareStatement(sql);
            //ptmt.setString(1, user1);
            
           /* sql = "SELECT * FROM users where user ='?' and password ='?'";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, user1);
            ps.setString(2, user1);
            ResultSet rs = ps.executeQuery();
        */
        
            // 展开结果集数据库
            while(rs.next()){
                // 通过字段检索
                int id  = rs.getInt("id");
                String user = rs.getString("user");
                String password = rs.getString("password");
    
                // 输出数据
                System.out.print("ID: " + id);
                System.out.print(", 站点名称: " + user);
                System.out.print(", 站点 URL: " + password);
                System.out.print("\n");
            }
            // 完成后关闭
            rs.close();
            stmt.close();
            conn.close();
        }catch(SQLException se){
            // 处理 JDBC 错误
            se.printStackTrace();
        }catch(Exception e){
            // 处理 Class.forName 错误
            e.printStackTrace();
        }finally{
            // 关闭资源
            try{
                if(stmt!=null) stmt.close();
            }catch(SQLException se2){
            }// 什么都不做
            try{
                if(conn!=null) conn.close();
            }catch(SQLException se){
                se.printStackTrace();
            }
        }
        System.out.println("Goodbye!");
    }
}