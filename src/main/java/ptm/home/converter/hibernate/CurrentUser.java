package ptm.home.converter.hibernate;

public class CurrentUser {
	public static final CurrentUser INSTANCE = new CurrentUser();
	private static final ThreadLocal<Integer> storage = new ThreadLocal<>();

	public void logIn(Integer user) {
		storage.set(user);
	}

	public void logOut() {
		storage.remove();
	}

	public Integer get() {
		return storage.get();
	}
}
