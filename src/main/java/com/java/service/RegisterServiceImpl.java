package com.java.service;

import com.java.dto.User;
import com.java.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class RegisterServiceImpl implements RegisterService{

	@Autowired
	private UserRepository rep;
	@Override
	public User addUser(User user) {
		System.out.println("register service");

		System.out.println(user);
		if(rep.getUserByUsername(user.getUsername()) != null){
			System.out.println("Already registered userName");
			return null;
		}else {
//			return rep.registerUser(user);
			return null;
		}
	}
}
