package yaksha;

import java.sql.Connection;
import java.sql.Statement;
import java.util.Scanner;

public class MainClass {

	public static void main(String[] args) throws Exception {
		Connection con = null;
		Statement stmt = null;
		Scanner sc = new Scanner(System.in);
		CallDetails call = new CallDetails();
		System.out.println("Enter the call details:");
		String input = sc.next();
		call.parseData(input);
		con = DB.getConnection();
		stmt = con.createStatement();
		int callId = call.getCallId();
		long calledNumber = call.getCalledNumber();
		float duration = call.getDuration();
		stmt.executeUpdate(
				"insert into CallDetails values('" + callId + "','" + calledNumber + "','" + duration + "')");
		System.out.println("\nCall Details:");
		System.out.println("Call id:" + callId);
		System.out.println("Called number:" + calledNumber);
		System.out.println("Duration:" + duration);
		sc.close();
	}
}
