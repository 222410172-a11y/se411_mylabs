package edu.spu.se411.lab06_logging;

import edu.spu.se411.lab06_logging.exceptions.InsufficientFundsException;

import edu.spu.se411.lab06_logging.model.WalletAccount;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class App {
	
	static Logger logger = LoggerFactory.getLogger(App.class);
	

	public static void main(String[] args) {
		
		logger.info("Application is starting...");
		
		
		WalletAccount account = new WalletAccount(1000);
		logger.debug("Wallet account created");
        try {
        	logger.debug("Withdrawing from wallet account");
            account.withdraw(1500);
        } catch (InsufficientFundsException e) {
        	logger.error("Exception caught: " + e.getMessage());
            System.out.println("Exception caught: " + e.getMessage());
        }

        try {
        	logger.debug("Depositing into wallet account");
            account.deposit(-100);
        } catch (IllegalArgumentException e) {
            System.out.println("Exception caught: " + e.getMessage());
       
            logger.info("Application is ending...");
        }
	}

}
