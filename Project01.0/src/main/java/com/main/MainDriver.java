package com.main;

import com.presentation.Menu;
import com.presentation.MenuV1;

import DAOIMPL.ItemDataBaseDAOIMPL;
import DAOIMPL.canDOIMPL;
import DAOInterface.ItemDataBaseDAO;
import Service.canDo;

public class MainDriver {

	public static void main(String[] args) {
		ItemDataBaseDAO database = new ItemDataBaseDAOIMPL();
	canDo service = new canDOIMPL(database);
	Menu mainMenu = new MenuV1(service);
	mainMenu.display();
	}

}
