package com.mobileapp.client;

import com.mobileapp.exceptions.MobileNotFoundException;
import com.mobileapp.service.IMobileService;
import com.mobileapp.service.MobileService;

public class Client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		IMobileService mobileService = new MobileService();
		try {
			System.out.println(mobileService.getById(2));
		} catch (MobileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		try {
//			mobileService.findMobileByBrand("Samsung").forEach(System.out::println);
//		} catch (MobileNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		

	}

}
