package com.User;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.User.Model.User;
import com.User.Repository.UserRepository;
import com.User.service.UserService;

@SpringBootTest(classes= {ServiceMockitoTest.class})
public class ServiceMockitoTest {
	
	@Mock
	UserRepository userRepository;
	
	@InjectMocks
	UserService userService;
	
	public List<User> users;
	
	
	@Test
	@Order(1)
	public void test_getAllUsers() {
		
		List<User> users=new ArrayList<User>();
		
		users.add(new User("01","nilesh","mondal","7352","m","23","customer","nil","nil123"));
		users.add(new User("02","sid","sid","7353","m","22","customer","sid","sid123"));
		
		when(userRepository.findAll()).thenReturn(users);  //mocking statement
		assertEquals(2,userService.getAllUsers().size());
		}
	
	
	@Test
	@Order(2)
	public void test_addUser() {
		
		User user=new User("03","vin","kuch","7354","m","224","customer","vin","vin123");
		
		when(userRepository.save(user)).thenReturn(user);
		assertEquals(user,userService.addUser(user));
		
	}
	
	@Test
	@Order(3)
	public void test_updateUser() {
		
		User user = new User("03","vin","kuch","7354","m","224","customer","vin","vin123");
		String id = "03";
		when(userRepository.save(user)).thenReturn(user);
		assertEquals((user),userService.updateUser(user,id));
	}
	
	@Test
	@Order(4)
	public void test_deleteUser() {
		String id = "03";
		userService. deleteUser(id);
		verify(userRepository,times(1)).deleteById(id);
	}
	
		
		
	

}
