package com.testing;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.BDDMockito.given;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.entity.User;
import com.exception.UserExistsException;
import com.exception.UserInfoInvalidException;
import com.exception.UserNotFoundException;
import com.repository.UserRepository;
import com.service.UserDaoImpl;

@ExtendWith(MockitoExtension.class)
 class UserTests {
	@Mock
	private UserRepository userRepo;
	
	@InjectMocks
	private UserDaoImpl userService;
	
	@Test
	 void createUsersSucessTest() throws Exception {
		List<User> userList = new ArrayList<>();
		User vendor = new User(1, "vendor@mail.com", "vendor", "vendor123", "pet", "Tommy", "vendor");
		User user = new User(2, "user@mail.com", "user", "user123", "maiden", "Peters", "user");
		userList.add(user);
		
		given(userRepo.save(user)).willReturn(user);
		assertEquals(userService.createUser(user), user);
		
		given(userRepo.findAll()).willReturn(userList);
		given(userRepo.save(vendor)).willReturn(vendor);
		
		assertEquals(userService.createUser(vendor), vendor);
	}
	
	@Test
	 void createUsersExceptionTest() throws Exception {
		List<User> userList = new ArrayList<>();
		User vendor1 = new User(1, "vendor1@mail.com", "vendor", "vendor123", "pet", "Tommy", "vendor");
		User vendor2 = new User(2, "vendor2@mail.com", "vendor", "user123", "maiden", "Peters", "user");
		userList.add(vendor1);
		
		given(userRepo.findAll()).willReturn(userList);
		
		UserExistsException except = assertThrows(UserExistsException.class, () -> userService.createUser(vendor2));
		assertTrue(except.getMessage().contentEquals("User with name vendor exists"));
	}

	@Test
	 void getUserListTest() throws Exception {
		List<User> userList = new ArrayList<>();
		User admin = new User(1, "admin@mail.com", "admin", "admin123", "pet", "Tommy", "admin");
		User user = new User(2, "user@mail.com", "user", "user123", "school", "Montgomery", "user");
		userList.add(admin);
		userList.add(user);
		
		given(userRepo.findAll()).willReturn(new ArrayList<User>());
		assertEquals(userService.getAllUsers(), new ArrayList<User>());
		
		given(userRepo.findAll()).willReturn(userList);
		assertEquals(userService.getAllUsers(), userList);
	}
	
	@Test
	 void updateUserSuccessTest() throws Exception {
		List<User> userList = new ArrayList<>();
		User admin = new User(1, "admin@mail.com", "admin", "admin123", "pet", "Tommy", "admin");
		User admin_update = new User(5, "admin@mail.com", "admin", "admin321", "pet", "Tommy", "user");
		userList.add(admin);
		
		given(userRepo.findAll()).willReturn(userList);
		
		User usr = userService.updateUser(admin_update);
		
		assertEquals(usr, admin);
		
		//password changes while other fields remain the same
		assertEquals(1, usr.getUserId());
		assertEquals("admin@mail.com", usr.getEmail());
		assertEquals("admin", usr.getUserName());
		assertEquals("admin321", usr.getPassword());
		assertEquals("pet", usr.getSecurityQuestion());
		assertEquals("Tommy", usr.getAnswer());
		assertEquals("admin", usr.getType());
	}
	
	@Test
	 void updateUserExceptionTest() throws Exception {
		List<User> userList = new ArrayList<>();
		User admin = new User(1, "admin@mail.com", "admin", "admin123", "pet", "Tommy", "admin");
		
		//username does not match
		User admin_update = new User(5, "admin@mail.com", "not_admin", "admin321", "pet", "Tommy", "user");
		userList.add(admin);
		
		given(userRepo.findAll()).willReturn(userList);
		
		UserInfoInvalidException except = assertThrows(UserInfoInvalidException.class, () -> userService.updateUser(admin_update));
		assertTrue(except.getMessage().contentEquals(
				"User with username not_admin, email admin@mail.com, security question pet, and answer Tommy does not exist"));
	}
	
	@Test
	 void deleteUserByIdSuccessTest() throws Exception {
		User admin = new User(1, "admin@mail.com", "admin", "admin123", "pet", "Tommy", "admin");
		
		given(userRepo.findById(1)).willReturn(Optional.of(admin));
		assertTrue(userService.deleteUserById(1));;
	}
	
	@Test
	 void deleteUserByIdExceptionTest() throws Exception {
		given(userRepo.findById(5)).willReturn(Optional.empty());
		
		UserNotFoundException except = assertThrows(UserNotFoundException.class, () -> userService.deleteUserById(5));
		assertTrue(except.getMessage().contentEquals("Could not find the user with id 5"));
	}
	
	@Test
	 void loginUserSuccessTest() throws Exception {
		List<User> userList = new ArrayList<>();
		User admin = new User(1, "admin@mail.com", "admin", "admin123", "pet", "Tommy", "admin");
		userList.add(admin);
		
		given(userRepo.findAll()).willReturn(userList);
		
		assertEquals(userService.loginUser(admin), admin);
	}
	
	@Test
	 void loginUserExceptionTest() throws Exception {
		List<User> userList = new ArrayList<>();
		User admin = new User(1, "admin@mail.com", "admin", "admin123", "pet", "Tommy", "admin");
		userList.add(admin);
		User otherUser = new User(2, "user@mail.com", "admin", "user321", "pet", "Tommy", "user");
		
		given(userRepo.findAll()).willReturn(userList);
		
		UserNotFoundException exception = assertThrows(UserNotFoundException.class, () -> userService.loginUser(otherUser));
		assertTrue(exception.getMessage().contentEquals("Could not find the user with id 2"));
	}
}
