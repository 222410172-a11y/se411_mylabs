package edu.psu.se411;

import edu.psu.se411.exceptions.InsufficientFundsException;
import edu.psu.se411.wallet.Wallet;


public class EX2 {

	public static void main(String[] args) {
		

        Wallet wallet = new Wallet(100);

        try {
            wallet.withdraw(150);
        } catch (InsufficientFundsException e) {
            System.out.println(e.getMessage());
        }
		

	}

}
