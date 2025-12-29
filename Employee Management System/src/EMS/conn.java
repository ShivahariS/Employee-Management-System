package EMS;

import java.sql.*;

public class conn {
	
	Connection con;
	Statement st;
	
	public conn() {
		try {
			String url = "jdbc:mysql://localhost:3306/employee_management";
			String username = "root";
			String password = "";	
			con = DriverManager.getConnection(url, username, password);
			st = con.createStatement();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	public void close() {
        try {
            if (st != null) st.close();
            if (con != null) con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
	}
}
