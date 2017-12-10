package org.app.action;
import java.sql.*;

public class MySQLDemo {
	 
    // JDBC �����������ݿ� URL
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
    static final String DB_URL = "jdbc:mysql://localhost:3306/struts2_demo";
 
    // ���ݿ���û��������룬��Ҫ�����Լ�������
    static final String USER = "root";
    static final String PASS = "1234";
 
    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;
        try{
            // ע�� JDBC ����
            Class.forName("com.mysql.jdbc.Driver");
        
            // ������
            System.out.println("�������ݿ�...");
            conn = DriverManager.getConnection(DB_URL,USER,PASS);
            PreparedStatement ptmt = null;
        
            // ִ�в�ѯ
            System.out.println(" ʵ����Statement��...");
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
        
            // չ����������ݿ�
            while(rs.next()){
                // ͨ���ֶμ���
                int id  = rs.getInt("id");
                String user = rs.getString("user");
                String password = rs.getString("password");
    
                // �������
                System.out.print("ID: " + id);
                System.out.print(", վ������: " + user);
                System.out.print(", վ�� URL: " + password);
                System.out.print("\n");
            }
            // ��ɺ�ر�
            rs.close();
            stmt.close();
            conn.close();
        }catch(SQLException se){
            // ���� JDBC ����
            se.printStackTrace();
        }catch(Exception e){
            // ���� Class.forName ����
            e.printStackTrace();
        }finally{
            // �ر���Դ
            try{
                if(stmt!=null) stmt.close();
            }catch(SQLException se2){
            }// ʲô������
            try{
                if(conn!=null) conn.close();
            }catch(SQLException se){
                se.printStackTrace();
            }
        }
        System.out.println("Goodbye!");
    }
}