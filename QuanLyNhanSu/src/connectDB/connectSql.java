package connectDB;

import java.sql.Connection;
import java.sql.DriverManager;

public class connectSql {
	public static Connection getConnectionSqlServer() {
		Connection cnt = null;
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			String url = "jdbc:sqlserver://DESKTOP-O1QGA3D\\SQLEXPRESS:1433;databaseName=dbQUANLYNHANSU;"
					+ "encrypt=true;trustServerCertificate=true;sslProtocol=TLSv1.2";
			String userName = "sa";
			String passWord = "thanhtuan123";
			cnt = DriverManager.getConnection(url,userName,passWord);
			return cnt;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static void closeConnectionSqlSever(Connection cnt) {
		if(cnt != null) {
			try {
				cnt.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
