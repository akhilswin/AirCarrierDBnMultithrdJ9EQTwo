package yaksha;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class AirCarrier {
	public ResultSet viewCallDetails() throws Exception {
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		con = DB.getConnection();
		stmt = con.createStatement();
		rs = stmt.executeQuery("select * from CallDetails where callId=102");
		return rs;
	}
}
