package main;

public class UserProfile {
	private String name;
	private String familyName;
	private String age;
	private String adress;
	private String data;

	public UserProfile(String name, String familyName, String age, String adress, String data) {
		this.name = name;
		this.familyName = familyName;
		this.age = age;
		this.adress = adress;
		this.data = data;
	}

	public String getLogin() {
		return name;
	}

	public String getPassword() {
		return familyName;
	}

	public String getEmail() {
		return age;
	}

	public String getAdress() {
		return adress;
	}

	public String getData() {
		return data;
	}
}
