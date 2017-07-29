package aop;

public class CipherObject {
	
	private String cipherText;
	private String password;
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getCipherText() {
		return cipherText;
	}
	
	public void setCipherText(String cipherText) {
		this.cipherText = cipherText;
	}
}
