package aop;

import javax.swing.SwingUtilities;

import astra.core.Module;
import astra.event.GoalEvent;
import astra.formula.Goal;
import astra.formula.Predicate;
import astra.term.Primitive;
import astra.term.Term;

public class GUIModule extends Module implements VigenereModule {

	private VigenereGUIInterface vigenereGuiInterface;

	@SuppressWarnings("unchecked")
	@ACTION
	public boolean launch(String className) {		
		try {
			Class<VigenereGUIInterface> clazz = (Class<VigenereGUIInterface>) Class.forName(className);
			SwingUtilities.invokeLater(new Runnable() {
	            public void run() {
	            	try {
						GUIModule.this.vigenereGuiInterface = (VigenereGUIInterface)clazz.newInstance();
						GUIModule.this.vigenereGuiInterface.setModule(GUIModule.this);
					} catch (InstantiationException | IllegalAccessException e) {
						e.printStackTrace();						
					}
	            }
			});

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	@ACTION
	public boolean sendString(String key, String value) {            	
        GUIModule.this.vigenereGuiInterface.sendString(key, value);				
		return true;
	}

	@ACTION
	public boolean sendInt(String key, int value) {
        GUIModule.this.vigenereGuiInterface.sendInt(key, value);
		return true;
	}
	
	@TERM
	public String getStringValue(VigenereGUIEvent event, String key) {
		return (String)event.value;
	}

	@TERM
	public int getIntValue(VigenereGUIEvent event, String key) {
		return (int)event.value;
	}

	@TERM
	public String getPassword(PlainObject crypto) {
		return (String)crypto.getPassword();
	}
	@TERM
	public String getPlainText(PlainObject crypto) {
		return (String)crypto.getPlainText();
	}
	
	@TERM
	public String getPassword(CipherObject crypto) {
		return (String)crypto.getPassword();
	}
	@TERM
	public String getCipherText(CipherObject crypto) {
		return (String)crypto.getCipherText();
	}

	@Override
	public void sendToEncrypt(PlainObject plainObject) {
		agent.addEvent(new GoalEvent(GoalEvent.ADDITION,
				new Goal(new Predicate("encrypt", new Term[] { Primitive.newPrimitive(plainObject) }))));
	}

	@Override
	public void sendToDecrypt(CipherObject cipherObject) {
		agent.addEvent(new GoalEvent(GoalEvent.ADDITION,
				new Goal(new Predicate("decrypt", new Term[] { Primitive.newPrimitive(cipherObject) }))));		
	}
	
	@Override
	public void sendToCrack(CipherObject cipherObject) {
		agent.addEvent(new GoalEvent(GoalEvent.ADDITION,
				new Goal(new Predicate("crack", new Term[] { Primitive.newPrimitive(cipherObject) }))));		
	}
}
