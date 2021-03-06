package main;

import java.util.HashMap;
import java.util.Map;

public class AccountService {
	private Map<String, UserProfile> users = new HashMap<>();

	public boolean addUser(String userName, UserProfile userProfile) {
		if (users.containsKey(userName))
			return false;
		users.put(userName, userProfile);
		return true;
	}

}
