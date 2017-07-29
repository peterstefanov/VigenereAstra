package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;

import aop.CipherObject;
import aop.PlainObject;
import aop.VigenereGUIInterface;
import aop.VigenereModule;

import javax.swing.UnsupportedLookAndFeelException;

public class JFrameVigenere extends JFrame implements VigenereGUIInterface {

	private final static long serialVersionUID = -2941460502747314396L;

	private VigenereModule module;

	private JPanel buttonpanelCipher;
	private JPanel buttonpanel_dialog;
	private JButton buttonsCipher[];
	private JButton buttons_dialog[];
	private String names[] = { "Clear", "Encrypt", "Decrypt", "Cracker" };
	private String names1[] = { "Open", "Save" };
	private  JTextArea screenPlain;
	private JTextArea screenCipher;
	private JTextField passwordField;
	private Container container;
	private ArrayList<String> text;
	private long time;
	
	private ButtonHandler handler = new ButtonHandler();

	/**
	 * Create the GUI and show it. For thread safety, this method should be
	 * invoked from the event-dispatching thread.
	 */
	public JFrameVigenere() {
		for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
			if ("Nimbus".equals(info.getName())) {
				try {
					UIManager.setLookAndFeel(info.getClassName());
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				} catch (InstantiationException e) {
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					e.printStackTrace();
				} catch (UnsupportedLookAndFeelException e) {
					e.printStackTrace();
				}
				break;
			}
		}
		text = new ArrayList<String>();
		container = getContentPane();
		buttonpanelCipher = new JPanel();
		buttonpanel_dialog = new JPanel();

		buttonsCipher = new JButton[names.length];
		createEncryptionButtons();

		buttons_dialog = new JButton[names1.length];
		createOpenSaveButtons();

		screenPlain = new JTextArea(300, 40);
		screenPlain.setLineWrap(true);
		screenPlain.setText("\n" + "Type in/paste text to be encrypted or use the resorces! If you want to cracked latter, the text should be at least 400 words!");
		JScrollPane scrollingArea = new JScrollPane(screenPlain);
		container.add(scrollingArea, BorderLayout.WEST);

		screenCipher = new JTextArea(100, 40);
		screenCipher.setLineWrap(true);
		screenCipher.setText("\n" + " Encrypted text will be displayed here!");
		JScrollPane scrollingAreaDe = new JScrollPane(screenCipher);
		container.add(scrollingAreaDe, BorderLayout.EAST);

		passwordField = new JTextField(38);
		passwordField.setToolTipText("Letters only");
		passwordField.setText("Type in your password, should contains only letters");

		passwordField.addFocusListener( new FocusListener() {
			@Override
			public void focusGained(FocusEvent e) {
				passwordField.setText("");				
			}
			
			@Override
			public void focusLost(FocusEvent e) {}			
		});
		passwordField.setFocusable(true);
		buttonpanelCipher.add(passwordField);

		container.add(buttonpanelCipher, BorderLayout.SOUTH);
		container.add(buttonpanel_dialog, BorderLayout.NORTH);

		setTitle("Vigenere");
		setSize(1000, 420);
		setVisible(true);
	}

	private void createOpenSaveButtons() {
		for (int i = 0; i < names1.length; i++) {
			buttons_dialog[i] = new JButton(names1[i]);
			buttons_dialog[i].addActionListener(handler);
			buttonpanel_dialog.add(buttons_dialog[i], BorderLayout.NORTH);
		}
	}

	private void createEncryptionButtons() {
		for (int i = 0; i < names.length; i++) {
			buttonsCipher[i] = new JButton(names[i]);
			buttonsCipher[i].addActionListener(handler);
			buttonpanelCipher.add(buttonsCipher[i], BorderLayout.SOUTH);
		}
	}

	public void readFile(File aFile) {

		BufferedReader input = null;
		try {
			text.clear();
			input = new BufferedReader(new FileReader(aFile));
			String line = null;
			while ((line = input.readLine()) != null) {
				if (line.trim().length() != 0)
					text.add(line);
			}

		} catch (FileNotFoundException ex) {
			ex.printStackTrace();
		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {
			try {
				if (input != null) {
					input.close();
				}
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
	}

	public void writeFile(File newFile) {
		try {
			BufferedWriter bufferedWriter = null;
			bufferedWriter = new BufferedWriter(new FileWriter(newFile));
			if (bufferedWriter != null) {
				bufferedWriter.write(screenPlain.getText());
				bufferedWriter.close();
			}
		} catch (IOException e) {

		}
	}

	public class ButtonHandler implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			if (event.getSource() == buttonsCipher[0]) {//clear left screen
				screenPlain.setText("");
			} else if (event.getSource() == buttonsCipher[1]) { // encrypt
				time = System.currentTimeMillis();
				screenCipher.setText("");
				PlainObject plainObject = new PlainObject();
				plainObject.setPassword(passwordField.getText().trim());
				plainObject.setPlainText(screenPlain.getText().trim());
				module.sendToEncrypt(plainObject);
				buttonsCipher[0].setEnabled(false);

			} else if (event.getSource() == buttonsCipher[2]) { // decrypt
				time = System.currentTimeMillis();

				CipherObject cipherObject = new CipherObject();
				cipherObject.setCipherText(screenCipher.getText().trim());
				cipherObject.setPassword(passwordField.getText().trim());
				module.sendToDecrypt(cipherObject);
				buttonsCipher[1].setEnabled(false);

			} else if (event.getSource() == buttonsCipher[3]) { // crack
				time = System.currentTimeMillis();
				screenPlain.setText("");
				CipherObject cipherObject = new CipherObject();
				cipherObject.setCipherText(screenCipher.getText().trim());
				module.sendToCrack(cipherObject);
				buttonsCipher[2].setEnabled(false);

			} else if (event.getSource() == buttons_dialog[0]) {// button open
				String cwd = System.getProperty("user.dir");
				final JFileChooser jfc = new JFileChooser(cwd);

				if (jfc.showOpenDialog(container) != JFileChooser.APPROVE_OPTION)
					return;
				File f = jfc.getSelectedFile();
				readFile(f);
				screenPlain.setText("");
				for (int i = text.size() - 1; i >= 0; i--) {
					screenPlain.insert(text.get(i), 0);
				}

			} else if (event.getSource() == buttons_dialog[1]) {// button save
				String c = System.getProperty("user.dir");
				final JFileChooser jfc1 = new JFileChooser(c);
				if (jfc1.showSaveDialog(container) != JFileChooser.APPROVE_OPTION)
					return;
				File file = jfc1.getSelectedFile();
				writeFile(file);

			}
		}
	}

	@Override
	public void sendString(String key, String value) {
		if (key.equals("decryptor")) {
			String s = screenPlain.getText();
			screenPlain.setForeground(Color.RED);
			if (value.contains("agreed")){
				if (s.contains("cracker agreed")) {
					screenPlain.append("\n\n" + value);
				} else {
					screenPlain.setText("");
					screenPlain.setText(value);
				}
			} else if (value.contains("fails") || value.contains("refused")) {
				if (s.contains("cracker agreed")) {
					screenPlain.append("\n\n" + value);
				} else {
					screenPlain.setText("");
					screenPlain.setText(value);
				}
				
			}else {
				long timeTook = System.currentTimeMillis() - time;
				
				if (s.contains("cracker agreed")) {
					screenPlain.setText(value + "\n\n" + s);
					screenPlain.append("\n\nTime taken to decrypt: " + timeTook + "ms");	
				} else {
					screenPlain.setText(value);
					screenPlain.append("\n\nTime taken to decrypt: " + timeTook + "ms");	
				}							
			}
			buttonsCipher[1].setEnabled(true);
			
		} else if (key.equals("encryptor")) {
			screenCipher.setForeground(Color.BLACK);
			if (value.contains("agreed")) {								
				screenCipher.append(value);
			} else if (value.contains("fails") || value.contains("refused")) {
				screenCipher.setText(value);
			} else {
				String s = screenCipher.getText();
				long timeTook = System.currentTimeMillis() - time;
				screenCipher.setText("");
				screenCipher.append(value + "\n\n" + s);
				screenCipher.append("\n\nTime taken to encrypt: " + timeTook + "ms");				
			}
			buttonsCipher[0].setEnabled(true);
			
		} else if (key.equals("cracker")) {
			screenPlain.setForeground(Color.RED);
			if (value.contains("agreed")){				
				screenPlain.append("\n\n" + value);
			}else if (value.contains("fails") || value.contains("refused")){	
				screenPlain.append("\n\nSomething went wrong: " + value);
			} else {	
				
				screenPlain.append("\n\nPassword is: " + value);
				long timeTook = System.currentTimeMillis() - time;
				time = System.currentTimeMillis();
				screenPlain.append("\n\nTime taken to crack the password: " + timeTook + "ms");
			}

			buttonsCipher[2].setEnabled(true);
		} 
	}

	@Override
	public void sendInt(String key, int value) {
		screenPlain.setForeground(Color.RED);
		if (key.equals("cracker")) {
			screenPlain.setText("\n" + screenPlain.getText());
			screenPlain.append("\n\nPassword length is: " + String.valueOf(value));
			
			long timeTook = System.currentTimeMillis() - time;
			screenPlain.append("\n\nTime taken to get the length of the password: " + timeTook + "ms");
			time = System.currentTimeMillis();
		} 
	}

	@Override
	public void setModule(VigenereModule module) {
		this.module = module;
	}
}
