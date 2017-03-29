package ca.shopping.controller;

import java.io.Serializable;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.apache.commons.lang3.StringUtils;

import ca.shopping.business.UserBusiness;
import ca.shopping.repository.entity.User;
import ca.shopping.util.ViewUtils;

/**
 * LoginController - It controls view tier
 * @author Felipe
 *
 */
@Named(value = "loginController")
@RequestScoped
public class LoginController implements Serializable {

	private static final long serialVersionUID = 1931151044688160637L;

	@Inject
	private UserBusiness business;

	@Inject
	private User user;

	@Inject
	private MainController mainController;

	/**
	 * Method that log in the application
	 * @return
	 */
	public String loginIn() {
		if (StringUtils.isEmpty(getUser().getPassword()) || StringUtils.isEmpty(getUser().getUsername())) {
			ViewUtils.errorMessage("Username or password invalid");
		}
		if (business.isUser(getUser())) {
			ViewUtils.infoMessage("Welcome " + user.getUsername());
			mainController.init();
			return "/main?faces-redirect=true";
		} else {
			ViewUtils.errorMessage("User has not been found");

		}
		return null;

	}

	/**
	 * Method that log out of aplication
	 * @return
	 */
	public String loginOut() {
		return "/index?faces-redirect=true";
	}
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
