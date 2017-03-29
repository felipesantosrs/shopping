package ca.shopping.util;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

public class ViewUtils implements Serializable {

	private static final long serialVersionUID = 8495727399607765986L;

	public static void mensage(String msg) {

		FacesContext facesContext = FacesContext.getCurrentInstance();

		facesContext.addMessage(null, new FacesMessage("Alert: ", msg));
	}

	public static void errorMessage(String msg) {

		FacesContext facesContext = FacesContext.getCurrentInstance();

		facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error: ", msg));
	}

	public static void infoMessage(String msg) {

		FacesContext facesContext = FacesContext.getCurrentInstance();

		facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "", msg));
	}
}
