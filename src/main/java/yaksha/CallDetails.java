package yaksha;

public class CallDetails {
	private int callId;
	private long calledNumber;
	private float duration;

	public CallDetails() {
		super();
	}

	public CallDetails(int callId, long calledNumber, float duration) {
		super();
		this.callId = callId;
		this.calledNumber = calledNumber;
		this.duration = duration;
	}

	public int getCallId() {
		return callId;
	}

	public void setCallId(int callId) {
		this.callId = callId;
	}

	public long getCalledNumber() {
		return calledNumber;
	}

	public void setCalledNumber(long calledNumber) {
		this.calledNumber = calledNumber;
	}

	public float getDuration() {
		return duration;
	}

	public void setDuration(float duration) {
		this.duration = duration;
	}

	public void parseData(String callDetails) {
		String s[] = callDetails.split(":");
		callId = Integer.parseInt(s[0]);
		calledNumber = Long.parseLong(s[1]);
		duration = Float.parseFloat(s[2]);
	}
}
