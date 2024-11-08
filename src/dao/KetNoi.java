package dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class KetNoi {
	public Connection cn;
	public void KetNoi() {
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			System.out.print("Xong b1");
			String url = "jdbc:sqlserver://DESKTOP-RQV86U4:1433;databaseName=sinhviencachingproxy;user=sa; password=truongminhhung";
			cn = DriverManager.getConnection(url);
			System.out.println("Xong b2");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		KetNoi kn = new KetNoi();
		kn.KetNoi();
	}
}
