package com.presentation;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import Service.canDo;

class DisplayCustomerTest {

	@Test
	void test() {
		class DisplayCustomer implements Menu {
		canDo service;
		public DisplayCustomer(canDo service) {
			this.service= service;
		}
		@Override
		public void display() {
			// TODO Auto-generated method stub
			
		}
		@Override
		public void displayCustomer() {
			// TODO Auto-generated method stub
			
		}
		@Override
		public void login() {
			// TODO Auto-generated method stub
			
		}
	}

}
}
