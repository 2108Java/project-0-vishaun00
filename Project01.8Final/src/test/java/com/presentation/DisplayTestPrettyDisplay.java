package com.presentation;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import Constructor.Item;

class DisplayTestPrettyDisplay {

	@Test
	void test() {
		 class Display implements Menu{
		 void prettyDisplay(Item[] array) {
			for(int i =0;i<array.length;i++) {
				if(array[i]!= null ) {
					System.out.println(array[i].getAccountID());
					System.out.println(array[i].getName());
					System.out.println(array[i].getAccount());
					System.out.println(array[i].isApproved());
					System.out.println(array[i].getDeposit());
					System.out.println(array[i].getWithdraw());
					System.out.println(array[i].getBalance());
					System.out.println(array[i].isRequestJointAccount());
					System.out.println(array[i].isApproveJoint());



				}
			}
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