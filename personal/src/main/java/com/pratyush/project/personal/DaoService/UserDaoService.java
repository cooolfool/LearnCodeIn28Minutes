package com.pratyush.project.personal.DaoService;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

import com.pratyush.project.personal.Beans.User;

@Component
public class UserDaoService {

	public static List<User> userList = new ArrayList<>();
	private static int userCount=0;
	
	static {
		userList.add(new User(++userCount,"Pratyush",LocalDate.now().minusYears(25)));
		userList.add(new User(++userCount,"Nidhi",LocalDate.now().minusYears(26)));
		userList.add(new User(++userCount,"Ram",LocalDate.now().minusYears(250)));
		userList.add(new User(++userCount,"Hanuman",LocalDate.now().minusYears(250)));
	}
	
	public List<User> findAll(){
		return userList;
	}
	
	public Optional<User> find(Integer id) {
		return Optional.of(userList.stream()
        .filter(u -> u.getId().equals(id))
        .findFirst().orElse(null));
		
//		if(user==null)
//			throw new userNotFoundException("id :"+ id);
//		
//		return user;	
		
	}
	
	public User save(User user) {
		user.setId(++userCount);
		userList.add(user);
		return user;
	}
	
}
