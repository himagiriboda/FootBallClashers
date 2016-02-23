package de.footballclashers.exceptions;

public class CurrentPasswordNotCorrect extends RuntimeException{

	private static final long serialVersionUID = 1L;
	private String keyMessage = null;
	private String extraMesaage = null;
	
	public CurrentPasswordNotCorrect(String keyMessage,String extraMesaage){
		super();
		this.extraMesaage = extraMesaage;
		this.keyMessage = keyMessage;
	}

	public String getKeyMessage() {
		return keyMessage;
	}

	public void setKeyMessage(String keyMessage) {
		this.keyMessage = keyMessage;
	}

	public String getExtraMesaage() {
		return extraMesaage;
	}

	public void setExtraMesaage(String extraMesaage) {
		this.extraMesaage = extraMesaage;
	}

	
}
