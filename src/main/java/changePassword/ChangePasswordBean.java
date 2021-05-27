package changePassword;

import java.io.Serializable;

public class ChangePasswordBean implements Serializable{

	/**
	 * 
	 */
	
	private static final long serialVersionUID = 1L;
	
	public String newPass;

	
	public String getNewPass() {
		return newPass;
	}

	public void setNewPass(String newPass) {
		this.newPass = newPass;
	}
	
	
	
}
