package com.flipkart.business;

import java.util.List;
import java.util.Scanner;

import com.flipkart.bean.Gym;
import com.flipkart.bean.GymOwner;
import com.flipkart.dao.AdminDAOImplementation;
import com.flipkart.dao.AdminDAOInterface;

public class AdminService implements AdminInterface {

	AdminDAOInterface adminDaoInterface = new AdminDAOImplementation();
	Scanner obj = new Scanner(System.in);

	@Override
	public void viewGymOwners() {
		adminDaoInterface.viewGymOwners();
	}

	@Override
	public void viewGyms() {
		adminDaoInterface.viewGyms();
	}

	@Override
	public void viewUsers() {
		adminDaoInterface.viewUsers();
	}

	@Override
	public void verifyGym(int gymId) {
		adminDaoInterface.verifyGyms(gymId);
	}

	@Override
	public void verifyGymOwner(int gymOwnerId) {
		adminDaoInterface.verifyGymOwners(gymOwnerId);
	}

	@Override
	public List<GymOwner> getUnverifiedGymOwners() {
		return adminDaoInterface.getUnverifiedGymOwner();
	}

	@Override
	public List<Gym> getUnverifiedGyms() {
		return adminDaoInterface.getUnverifiedGyms();
	}

}
