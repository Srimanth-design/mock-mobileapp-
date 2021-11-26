package com.mobileapp.service;

import java.util.List;

import com.mobileapp.exceptions.MobileNotFoundException;
import com.mobileapp.model.Mobile;

public interface IMobileService {
	/**
	 * 
	 * @param brand
	 * @return
	 * @throws MobileNotFoundException
	 */

	public List<Mobile> getByBrand(String brand) throws MobileNotFoundException;

	/**
	 * 
	 * @param id
	 * @return
	 * @throws MobileNotFoundException
	 */

	public Mobile getById(int id) throws MobileNotFoundException;

	/**
	 * 
	 * @return
	 */

	List<Mobile> showMobiles();
}
