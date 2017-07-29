package aop;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PlainObject {

	private String plainText;
	private String password;
	
	public String getPlainText() {		
		return plainText.toLowerCase();
	}
	
	public void setPlainText(String plainText) {
		this.plainText = removeSpecialCharacters(plainText);
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String removeSpecialCharacters(String s) {
		Pattern pattern = Pattern.compile("[^0-9 ^a-z A-Z]");
		Matcher matcher = pattern.matcher(s);
		String result = matcher.replaceAll("");
		return result.replaceAll("\\s+", "");
	}
}
