package jdbc_p;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Date;

public class JDBCMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "hr", "hr");
			Statement stmt = con.createStatement();
			
			ResultSet rs = stmt.executeQuery("select * from test"); //�ͽ�ťƮ������ �����Ҷ� ��, ������ �����ö�.
			
			System.out.println("ID\t���Գ�¥\t\t���");
			while(rs.next()) {
				String id = rs.getString("ID");
				Date reg_date = rs.getDate("REG_DATE");
				int grade = rs.getInt("GRADE"); 
				
				System.out.println(id + "\t" + reg_date + "\t" + grade);
			}

			
			
			rs.close();
			stmt.close();
			con.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
