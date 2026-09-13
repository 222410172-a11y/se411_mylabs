package edu.psu.se411;

import edu.psu.se411.exceptions.InvalidAgeException;

public class EX1 {

	public static void main(String[] args) {
		
		

		        try {
		            validateAge(0);
		        } catch (InvalidAgeException e) {
		            System.out.println(e.getMessage());
		        }

	}
	
	public static void validateAge(int age) throws InvalidAgeException {
        if (age < 18) {
            throw new InvalidAgeException("Invalid age");
        } else {
            System.out.println("Age valid");
        }
        
	}	
	}


