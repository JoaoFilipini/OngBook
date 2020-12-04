package br.com.ong.domain;

public class Login {

	private int Id_Login;
	private String Username;
	private String Password;

	public String getUsername() {
		return Username;
	}

	public void setUsername(String username) {
		Username = username;
	}

	public String getPassword() {
		return Password;
	}
	
	public void setPassword(String password) {
		Password = password;
	}

	public int getId_Login() {
		return Id_Login;
	}

	public void setId_Login(int id_Login) {
		Id_Login = id_Login;
	}

}
