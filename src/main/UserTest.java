package main;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.Test;

class UserTest {
	User users = new User(null, null, null, 0, 0, 0, 0, null, null);
	private final ByteArrayOutputStream output = new ByteArrayOutputStream();
	@Before
	public void setUpStreams() {
		System.setOut(new PrintStream(output));
	}
	
	@After
	public void cleanUpStreams() {
		System.setOut(null);
	}

	@Test
	void testGetUserName() {
		users.setUsername("test");
		String get = users.getUsername();
		assertEquals("test", get);
	}
	
	@Test
	void testGetPassword() {
		users.setPassword("testpassword");
		String get = users.getPassword();
		assertEquals("testpassword", get);
	}
	
	@Test 
	void testGetEmail() {
		users.setEmail("email@gmail.com");
		String get = users.getEmail();
		assertEquals("email@gmail.com", get);
	}
	
	@Test
	void testGetAge() {
		users.setAge(12);
		int get = users.getAge();
		assertEquals(12, get);
	}
	
	@Test
	void testGetPoints() {
		users.setPoints(5000);
		int get = users.getPoints();
		assertEquals(5000,get);
	}
	
	@Test
	void testGetEmployeeID() {
		users.setEmployeeID(123123);
		int get = users.getEmployeeID();
		assertEquals(123123, get);
	}
	
	@Test
	void testGetShoppingCart() {
		ArrayList<String> shoppingCart = new ArrayList<String>();
		shoppingCart.add("Item 1");
		shoppingCart.add("Item 2");
		users.setShoppingCart(shoppingCart);
		ArrayList<String> testCart = users.getShoppingCart();
		assertEquals(shoppingCart,testCart);
	}
	
	@Test
	void testGetTicketCart() {
		ArrayList<String> ticketCart = new ArrayList<String>();
		ticketCart.add("Item 1");
		ticketCart.add("Item 2");
		users.setTicketCart(ticketCart);
		ArrayList<String> testCart = users.getTicketCart();
		assertEquals(ticketCart,testCart);
	}
	
	@Test
	void testGetDiscoutType() {
		users.setDiscountType(1);
		int get = users.getDiscountType();
		assertEquals(1,get);
	}
	
	
	

}
