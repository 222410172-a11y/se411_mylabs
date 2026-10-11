package edu.psu.se411.lab09_inventory;

import edu.psu.se411.lab09_inventory.model.Book;
import edu.psu.se411.lab09_inventory.model.ElectronicDevice;
import edu.psu.se411.lab09_inventory.model.Inventory;
import edu.psu.se411.lab09_inventory.model.Item;

import edu.psu.se411.lab09_inventory.model.SearchByName;
import edu.psu.se411.lab09_inventory.model.SearchBookByAuthor;
import edu.psu.se411.lab09_inventory.model.SearchByCategory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class App {

	static Logger logger = LoggerFactory.getLogger(App.class);
	
	public static void main(String[] args) {
		logger.info("Application is starting...");
		Inventory<Item> inventory = new Inventory<Item>();

		inventory.add(
		        new Book(
		                "B001",
		                "Concurrency in Java",
		                "Salah Obeid"
		        )
		);

		inventory.add(
		        new ElectronicDevice(
		                "M001",
		                "USB drive 256Gb",
		                "Toshiba"
		        )
		);

		System.out.println(inventory);
		
		
		System.out.println(
		        inventory.findItems(
		                new SearchByName("Concurrency in Java")
		        )
		);

		System.out.println(
		        inventory.findItems(
		                new SearchBookByAuthor("Salah Obeid")
		        )
		);

		System.out.println(
		        inventory.findItems(
		                new SearchByCategory("Toshiba")
		        )
		);
		
		System.out.println(
		        inventory.findItems(
		                item -> item.getName().contains("USB")
		        )
		);
		
		displayInventory(inventory);
		logger.info("Application is closing...");
	}
	
	public static void displayInventory(Inventory<?> inventory) {

	    for (Object item : inventory.getElements()) {
	        System.out.println(item);
	    }
	}

}
