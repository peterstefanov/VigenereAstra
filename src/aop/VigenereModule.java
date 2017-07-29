package aop;


public interface VigenereModule {

	void sendToEncrypt(PlainObject plainObject);
	
	void sendToDecrypt(CipherObject cipherObject);

	void sendToCrack(CipherObject cipherObject);
}

