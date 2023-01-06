package dataAccessLayer;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;


public class MySQLConnection implements DBConnection {
    private static Connection con = null;
    private MySQLConnection() { }
    public static Connection getConnection(String str) {
    	String user = "root";
        String password = "";
        String url = "jdbc:mysql://localhost:3306/"+str;
        String unicode= "?useUnicode=yes&characterEncoding=UTF-8";
        String driver = "com.mysql.jdbc.Driver";
        try {
			Class.forName(driver).newInstance();
		} catch (InstantiationException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IllegalAccessException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
        try {
			con = DriverManager.getConnection(url+unicode, user, password);
			con.setAutoCommit(false);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	return con;
    }
}