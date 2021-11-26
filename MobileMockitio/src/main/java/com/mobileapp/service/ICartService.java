package com.mobileapp.service;

import java.util.List;

import com.mobileapp.exceptions.EmptyCartException;
import com.mobileapp.exceptions.MobileNotFoundException;
import com.mobileapp.model.Mobile;

public interface ICartService {

	/**
	 * 
	 * @return
	 * @throws EmptyCartException
	 */
	List<Mobile> showCart() throws EmptyCartException;

	/**
	 * 
	 * @param mobile
	 * @throws MobileNotFoundException
	 */

	void addToCart(Mobile mobile) throws MobileNotFoundException;

	/**
	 * 
	 * @param mobile
	 * @return
	 * @throws MobileNotFoundException
	 */

	boolean removeFromCart(Mobile mobile) throws MobileNotFoundException;

}
