package yaksha;

import static yaksha.TestUtils.businessTestFile;
import static yaksha.TestUtils.currentTest;
import static yaksha.TestUtils.yakshaAssert;
import java.sql.ResultSet;
import org.junit.jupiter.api.Test;

class MainClassTest {

	@Test
	public void testExceptionConditon() throws Exception {

		TestUtils.yakshaAssert(TestUtils.currentTest(), true, TestUtils.exceptionTestFile);
	}

	@Test
	public void testBoundaryCondition() throws Exception {

		TestUtils.yakshaAssert(TestUtils.currentTest(), true, TestUtils.boundaryTestFile);
	}

	@Test
	void testViewCallDetails() throws Exception {
		AirCarrier airCarrier = new AirCarrier();
		CallDetails[] callDetails = new CallDetails[1];
		String resultData = null;
		String expectedData = null;
		int callId;
		long calledNumber;
		float duration;
		// Input : 102:6547891230:2.15
		callId = 102;
		calledNumber = 6547891230L;
		duration = 2.15f;
		callDetails[0] = new CallDetails(callId, calledNumber, duration);
		expectedData = callId + " " + calledNumber + " " + duration;
		expectedData = expectedData.trim();
		ResultSet rs = airCarrier.viewCallDetails();
		while (rs.next()) {
			int callId1 = rs.getInt(1);
			long calledNumber1 = rs.getLong(2);
			float duration1 = rs.getFloat(3);
			resultData = callId1 + " " + calledNumber1 + " " + duration1;
			resultData = resultData.trim();
		}
		yakshaAssert(currentTest(), (expectedData.equals(resultData) ? "true" : "false"), businessTestFile);
		rs.close();
	}
}