package com.mobileapp.testcases;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.mobileapp.exceptions.EmptyCartException;
import com.mobileapp.exceptions.MobileNotFoundException;
import com.mobileapp.model.Mobile;
import com.mobileapp.service.CartDetails;
import com.mobileapp.service.ICartService;

@ExtendWith(MockitoExtension.class)
@RunWith(JUnitPlatform.class)
class CartDetailsTest {

	@Mock
	ICartService cartService;

	@InjectMocks
	CartDetails cartDetails;
	Mobile mobile1, mobile2, mobile3, mobile4, mobile5, mobile6;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
		mobile1 = new Mobile(1, "Samsung", "O32", 32000);
		mobile2 = new Mobile(2, "Xiaomi", "L42", 36000);
		mobile3 = new Mobile(3, "realme", "K76", 72000);
		mobile4 = new Mobile(4, "Xiaomi", "M98", 80000);
		mobile5 = new Mobile(5, "Xiaomi", "J76", 70000);
		mobile6 = new Mobile(6, "Samsung", "K72", 33000);
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testAddcart() throws MobileNotFoundException {
		Mockito.doNothing().when(cartService).addToCart(mobile1);
		String actual = cartDetails.addCart(mobile1);
		String expected = "added successfully";
		assertEquals(expected, actual, "Invalid");
	}

	@Test
	void testAddcartException() throws MobileNotFoundException {
		// calling here cartservice using mock
		// pass the object inside when

		Mockito.doThrow(new MobileNotFoundException("invalid")).when(cartService).addToCart(mobile3);
		assertThrows(MobileNotFoundException.class, () -> cartDetails.addCart(mobile3));
	}

	@Test
	void testShowCart() throws MobileNotFoundException, EmptyCartException {
		List<Mobile> expectedMobile = Arrays.asList(mobile3, mobile2, mobile1);
		doReturn(Arrays.asList(mobile1, mobile2, mobile3)).when(cartService).showCart();
		List<Mobile> actualMobiles = cartDetails.showCart();
		assertEquals(expectedMobile, actualMobiles, "Not equal");
	}

	@Test
	void testShowCartNull() throws MobileNotFoundException, EmptyCartException {
		doReturn(null).when(cartService).showCart();
		assertNull(cartDetails.showCart());
	}

	@Test
	void testShowCartEmpty() throws EmptyCartException {
		Mockito.doThrow(new EmptyCartException("Invalid")).when(cartService).showCart();
		// when(cartService.showCart()).thenThrow(new EmptyCartException());
		assertThrows(EmptyCartException.class, () -> cartDetails.showCart());
	}

	@Test
	void testRemoveCart() throws EmptyCartException, MobileNotFoundException {
		doReturn(true).when(cartService).removeFromCart(mobile1);
		assertEquals(true, cartDetails.removeFromTheCart(mobile1));
	}

	@Test
	void testRemoveCartEmpty() throws EmptyCartException, MobileNotFoundException {
		doThrow(new MobileNotFoundException()).when(cartService).removeFromCart(mobile3);
		assertThrows(MobileNotFoundException.class, () -> cartDetails.removeFromTheCart(mobile3));
	}

}
