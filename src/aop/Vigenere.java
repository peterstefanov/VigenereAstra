package aop;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import astra.core.Module;

public class Vigenere extends Module{

	private final static String ALPHABET = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
	private final static int ETAONISRH = 70;
	private final static int ETAON = 45;
	private final static int LNRST = 33;
	private final static int AEIOU = 38;
	private final static int JKQXZ = 1;
	Map<String, List<Integer>> passFrequency = new LinkedHashMap<String, List<Integer>>();
	
	/**
	 * Accepts cipherText as a string and passLength as an int
	 * and returns the password or empty string if fails to find the
	 * password.
	 * @param cipherText
	 * @param passLength
	 * @return 
	 */
	@TERM
	public String getPassword(String cipherText, int passLength) {
		String password = "";
		int eachEntryOfThePassword = 0;
		while (eachEntryOfThePassword < passLength) {
			StringBuffer result = new StringBuffer();
			for (int i = eachEntryOfThePassword; i < cipherText.length() - passLength; i = i + passLength) {
				result.append(cipherText.substring(i, i + 1));
			}
			String partialCipher = result.toString();
			int lengthOfSubCipher = partialCipher.length();
			String[] a = new String[ALPHABET.length()];
			for (int x = 0; x < ALPHABET.length(); x++) {
				String longKey = ALPHABET.substring(x, x + 1);
				String decr = doDecrypt(longKey, partialCipher);
				a[x] = decr;
			}
			doFrequencyAnalysisPerEntry(a, lengthOfSubCipher);
			String letter = getLetter();
			if (letter.isEmpty()) {
				return "";
			}
			password += letter;
			eachEntryOfThePassword++;
		}
		return password;
	}
	
	/**
	 * This method iterating through the string and counting in percentage the
	 * five different patterns ETAONISRH 70% ETAON 45% LNRST 33% AEIOU 38% JKQXZ
	 * 1%
	 */
	private void doFrequencyAnalysisPerEntry(String[] a, int lengthOfSubCipher) {
		Map<String, List<Integer>> frequency = new LinkedHashMap<String, List<Integer>>();

		for (int i = 0; i < a.length; i++) {
			Matcher ETAONISRH = Pattern.compile("[etaonisrhETAONISRH]").matcher(a[i]);// 70%
			double count = 0;
			while (ETAONISRH.find())
				count++;
			Integer pr = ((int) ((count / lengthOfSubCipher) * 100));

			Matcher ETAON = Pattern.compile("[etaonETAON]").matcher(a[i]);// 45%
			double count1 = 0;
			while (ETAON.find())
				count1++;
			Integer pr1 = ((int) ((count1 / lengthOfSubCipher) * 100));
			Matcher LNRST = Pattern.compile("[lnrstLNRST]").matcher(a[i]);// 33%
			double count2 = 0;
			while (LNRST.find())
				count2++;
			Integer pr2 = ((int) ((count2 / lengthOfSubCipher) * 100));
			Matcher AEIOU = Pattern.compile("[aetouAEIOU]").matcher(a[i]);// 38%
			double count3 = 0;
			while (AEIOU.find())
				count3++;
			Integer pr3 = ((int) ((count3 / lengthOfSubCipher) * 100));
			Matcher JKQXZ = Pattern.compile("[jkqxzJKQXZ]").matcher(a[i]);// 1%
			double count4 = 0;
			while (JKQXZ.find())
				count4++;
			Integer pr4 = ((int) ((count4 / lengthOfSubCipher) * 100));

			List<Integer> counts = new ArrayList<Integer>();
			counts.add(pr);
			counts.add(pr1);
			counts.add(pr2);
			counts.add(pr3);
			counts.add(pr4);

			frequency.put(ALPHABET.substring(i, i + 1), counts);
		}
		setPasswordAnalysis(frequency);
	}
	
	private String doDecrypt(String password, String cipherText) {
		String longKey = password;
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < cipherText.length(); i++) {
			char c = cipherText.charAt(i);
			
			if (i > password.length() - 1) {
				String temp = sb.substring(i - password.length(), i - password.length() + 1);
				longKey += temp;
			}

			if (c >= 32) {
				int keyCharValue = longKey.charAt(i % longKey.length()) - 'A';
				c -= keyCharValue;
				if (c < 32) {
					c = (char) (c + 127 - 32);
				}
			}
			sb.append(c);
		}
		return sb.toString();
	}
	
	private void setPasswordAnalysis(Map<String, List<Integer>> passFrequency) {
		this.passFrequency = passFrequency;
	}
	
	private String getLetter() {
		String letter = "";
	    for(Entry<String, List<Integer>> map : passFrequency.entrySet()){
	    	List<Integer> list = map.getValue();
	    	
	    	Integer firstEntry = list.get(0);
	    	Integer secondEntry = list.get(1);
	    	Integer thirdEntry = list.get(2);
	    	Integer fourthEntry = list.get(3);
	    	Integer fifthEntry = list.get(4);
			if (((ETAONISRH - 7) <= firstEntry && firstEntry <= (ETAONISRH + 7))
					&& ((ETAON - 7) <= secondEntry && secondEntry <= (ETAON + 7))
					&& ((LNRST - 7) <= thirdEntry && thirdEntry <= (LNRST + 7))
					&& ((AEIOU - 7) <= fourthEntry && fourthEntry <= (AEIOU + 7))
					&& (0 <= fifthEntry && fifthEntry <= (JKQXZ + 7))) {
	    		letter = map.getKey();
	    	}    	
	    }
		return letter;
	}
}
