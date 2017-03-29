package ca.shopping.business;


import java.io.Serializable;

import javax.inject.Inject;

import ca.shopping.repository.UserRepository;
import ca.shopping.repository.entity.User;

/**
 * User Business class
 * @author Felipe
 *
 */
public class UserBusiness implements  Serializable {
	
	private static final long serialVersionUID = -3968505240460780099L;
	
	@Inject
	UserRepository repository;
	
	
	public Boolean isUser(User user){
	 return repository.isUser(user);
	}
	

}
