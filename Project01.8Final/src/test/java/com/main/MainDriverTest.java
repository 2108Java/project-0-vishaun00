package com.main;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Scanner;

import org.junit.jupiter.api.Test;
import com.main.*;
import com.presentation.Display;
import com.presentation.DisplayCustomer;
import com.presentation.Menu;

import DAOIMPL.ItemDataBaseDAOIMPL;
import DAOIMPL.canDOIMPL;
import DAOInterface.ItemDataBaseDAO;
import Service.canDo;
class MainDriverTest {

	@Test
	void test() {
		Scanner scan = new Scanner(System.in);
		ItemDataBaseDAO database = new ItemDataBaseDAOIMPL();
		canDo service = new canDOIMPL(database);
		Menu mainMenu = new Display(service);
		Menu mainMenu1 = new DisplayCustomer(service);
		System.out.println("Are you an employee(1) or customer(2)");
		Scanner input = new Scanner(System.in);
		boolean running = true;
		while(running) {
		String user = input.nextLine();	
		switch(user) {
		case"1":System.out.println("You are an emplyee");
		mainMenu.display();
		break;
		case"2":System.out.println("You are a customer");
		mainMenu1.displayCustomer();
		break;
		default:System.out.println("Invalid option");
				System.out.println("employee(1) customer(2)");
		}
		}


		}
	}
		
	


