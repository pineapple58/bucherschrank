package model;

public class LoginForm {

	private int EMP_ID;
	private String userName;
	private String password;
	private int ATSUKAI_F;

	public LoginForm(String userName, String password) {
		this.userName = userName;
		this.password = password;
	}

	public LoginForm(int EMP_ID, int ATSUKAI_F) {
		this.EMP_ID = EMP_ID;
		this.ATSUKAI_F = ATSUKAI_F;
	}

	public LoginForm() {
		// TODO 自動生成されたコンストラクター・スタブ
	}

	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	public int getEMP_ID() {
		return EMP_ID;
	}
	public void setEMP_ID(int EMP_ID) {
		this.EMP_ID = EMP_ID;
	}

	public int getATSUKAI_F() {
		return ATSUKAI_F;
	}
	public void setATSUKAI_F(int ATSUKAI_F) {
		this.ATSUKAI_F = ATSUKAI_F;
	}

}