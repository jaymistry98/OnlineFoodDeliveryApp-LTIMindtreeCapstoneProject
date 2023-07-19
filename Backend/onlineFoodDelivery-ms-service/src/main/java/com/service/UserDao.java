package com.service;

import java.util.List;
import com.entity.User;

public interface UserDao {
	public List<User> getAllUsers();
	public User createUser(User user);
	public User updateUser(User user);
	public boolean deleteUserById(int userId);
	public User loginUser(User user);
}
