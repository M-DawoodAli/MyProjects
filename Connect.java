import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JOptionPane;;

public class Connect {
		static Connection con=null;
		public static Connection dbConnect()
		{
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","dawood");
			if(con!=null)
			{
				//JOptionPane.showMessageDialog(null, "connection is successfull");
			}
	
		}catch(Exception e)
		{
			JOptionPane.showMessageDialog(null, "connection is not successfull");
		}
		return con;
		
	}
}