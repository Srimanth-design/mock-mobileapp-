package com.mobileapp.service;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import com.mobileapp.exceptions.MobileNotFoundException;
import com.mobileapp.model.Mobile;

public class MobileService implements IMobileService {
	
	/**
	 * 
	 */

	private List<Mobile> mobileList = Arrays.asList(new Mobile(1, "Samsung", "K42", 32000),
			new Mobile(2, "Xiaomi", "L42", 66000), new Mobile(3, "realme", "M42", 42000),
			new Mobile(4, "Xiaomi", "I43", 40000), new Mobile(5, "Xiaomi", "L98", 70000),
			new Mobile(6, "Samsung", "Z32", 83000));

	public List<Mobile> showMobiles() {
		Collections.sort(mobileList, (mobile1, mobile2) -> {
			return mobile1.getBrand().compareTo(mobile2.getBrand());
		});
		return mobileList;
	}

	/**
	 * 
	 */
	public List<Mobile> getByBrand(String brand) throws MobileNotFoundException {

		List<Mobile> getByBrand = showMobiles().stream().filter(mobile -> mobile.getBrand().equals(brand))
				.collect(Collectors.toList());
		if (mobileList.isEmpty()) {
			throw new MobileNotFoundException("brand not found");
		}
		return getByBrand;
	}

	public Mobile getById(int mobileId) throws MobileNotFoundException {

		return showMobiles().stream().filter((mobile) -> mobile.getMobileId() == mobileId).findFirst()
				.orElseThrow(() -> new MobileNotFoundException("mobile id not available"));
	}
}
