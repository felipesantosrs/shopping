package ca.shopping.repository;

import java.io.Serializable;
import java.util.LinkedList;

import org.apache.commons.collections.CollectionUtils;

import ca.shopping.repository.entity.User;
/**
 * UserRepository
 * @author Felipe
 *
 */
public class UserRepository implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 4899374744145229562L;
	private static LinkedList<User> userList;
	
	/**
	 * 
	 */
	public static void createUserData(){
		userList = new LinkedList<User>();
		userList.add(new User("Test1", "test1@mytest.com"));
		userList.add(new User("Test2", "test2@mytest.com"));

	}
	
	/**
	 * Verify that user there in the data base
	 * @param user
	 * @return
	 */
	public Boolean isUser(User user){
		if (CollectionUtils.isEmpty(userList)) {
			createUserData();
		}
		return userList.stream().filter(u -> u.equals(user)).findAny().isPresent();
		
	}
	
}
