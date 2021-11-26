package com.mobileapp.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.mobileapp.exceptions.MobileNotFoundException;
import com.mobileapp.model.Mobile;

public class OrderDetails {
	/**
	 * 
	 */
	IMobileService mobileService;

	/**
	 * 
	 * @param mobileService
	 */
	public void setMobileService(IMobileService mobileService) {
		this.mobileService = mobileService;
	}

	/**
	 * 
	 * @param mobileId
	 * @return
	 */
	public String orderMobile(int mobileId) {
		try {
			Mobile mobile = mobileService.getById(mobileId);

		} catch (MobileNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 
	 * @param brand
	 * @return
	 * @throws MobileNotFoundException
	 */
	public List<Mobile> showMobiles(String brand) throws MobileNotFoundException {
		List<Mobile> mobileList = new ArrayList<>();
		try {
			mobileList = mobileService.getByBrand(brand);
		} catch (MobileNotFoundException e) {

			throw e;
		}

		if (mobileList != null) {
			return mobileList.stream().sorted((item1, item2) -> item1.getModel().compareTo(item2.getBrand()))
					.collect(Collectors.toList());
		} else {
			return mobileList;
		}

	}

}
