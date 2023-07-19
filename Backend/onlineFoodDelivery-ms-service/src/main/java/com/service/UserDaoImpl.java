package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.entity.User;
import com.exception.UserExistsException;
import com.exception.UserInfoInvalidException;
import com.exception.UserNotFoundException;
import com.repository.UserRepository;

@Service
public class UserDaoImpl implements UserDao {
	
	//USER
		@Autowired
		private UserRepository userRepo;
		
		@Override
		public List<User> getAllUsers() {
			return userRepo.findAll();
		}

		@Override
		public User createUser(User user) {
			List<User> userList = userRepo.findAll();
			
			for(User usr: userList)
			{
				if(usr.getUserName().equals(user.getUserName()))
				{
					throw new UserExistsException(user.getUserName());
				}
			}
			return userRepo.save(user);
		}

		@Override
		public User updateUser(User user) {
			List<User> userList = userRepo.findAll();
			
			for(User usr: userList) {
				if(usr.getUserName().equals(user.getUserName()) && usr.getEmail().equals(user.getEmail())
						&& usr.getSecurityQuestion().equals(user.getSecurityQuestion())
						&& usr.getAnswer().equals(user.getAnswer())) {
					usr.setPassword(user.getPassword());
					userRepo.save(usr);
					return usr;
				}
			}
			throw new UserInfoInvalidException(user.getUserName(), user.getEmail(), 
					user.getSecurityQuestion(), user.getAnswer());
		}

		
		@Override
		public boolean deleteUserById(int userId) {
			if (userRepo.findById(userId).isPresent()) {
				userRepo.deleteById(userId);
				return true;
			}
			else {
				throw new UserNotFoundException(userId);
			}
		}
	

		@Override
		public User loginUser(User user) {
			List<User> userList = userRepo.findAll();
			for(User usr: userList)
			{
				if(usr.getUserName().equals(user.getUserName()) && usr.getPassword().equals(user.getPassword()))
				{
					return usr;
				}
			}
			throw new UserNotFoundException(user.getUserId());
		}
}
