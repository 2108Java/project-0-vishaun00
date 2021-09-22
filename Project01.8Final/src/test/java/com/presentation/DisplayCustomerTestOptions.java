package com.presentation;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class DisplayCustomerTestOptions {

	@Test
	void test() {
		class DisplayCustomer implements Menu {
		public boolean options() {
			System.out.println("1) Create Account");
			System.out.println("2) View Account");	
			System.out.println("3) Deposit Money");
			System.out.println("4) Withdraw Money");
			System.out.println("5) Request joint account");
			System.out.println("6) Back ");


            return true;
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