package ptm.home.common.constant;

public enum EmpDisabledReason {
	MAX_INCORRECT_PASSWORD("max.incorrect.password"), LWD("last.working.day");

	private String reason;

	private EmpDisabledReason(String reason) {
		this.reason = reason;
	}

	@Override
	public String toString() {
		return reason;
	}
}
