package com.mobileapp.service;

import java.util.List;
import java.util.stream.Collectors;

import com.mobileapp.exceptions.EmptyCartException;
import com.mobileapp.exceptions.MobileNotFoundException;
import com.mobileapp.model.Mobile;

public class CartDetails {
	ICartService cartService;

	public void setCartService(ICartService cartService) {
		this.cartService = cartService;
	}

	public List<Mobile> showCart() throws EmptyCartException {
		List<Mobile> mobileList = cartService.showCart();

		if (mobileList != null) {
			return mobileList.stream().sorted((item1, item2) -> item2.getMobileId().compareTo(item1.getMobileId()))
					.collect(Collectors.toList());
		}

		return mobileList;

	}

	public String addCart(Mobile mobile) throws MobileNotFoundException {
		cartService.addToCart(mobile);
		return "added successfully";
	}

	public boolean removeFromTheCart(Mobile mobile) throws MobileNotFoundException {
		Boolean result = false;
		try {
			result = cartService.removeFromCart(mobile);
		} catch (MobileNotFoundException e) {
			throw e;
		}

		return result;
	}

}