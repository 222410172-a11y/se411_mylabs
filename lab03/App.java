package lab03;

import java.util.List;

public class App {
	public static void main(String[] args) {
		
		
		String[] names = {"Nora", "Sara", "Lama"};

		PrintableList<String> stringList =
		        new PrintableList<>(names);

		stringList.printList();
		
		
		Integer[] numbers = {10, 20, 30};

		PrintableList<Integer> integerList =
		        new PrintableList<>(numbers);

		integerList.printList();
		
		
		NumberBox<Integer> intBox =
		        new NumberBox<>(10);

		System.out.println(intBox.getItem());

		System.out.println(intBox.sum(5));
		
		
		
		NumberBox<Double> doubleBox =
		        new NumberBox<>(10.5);

		System.out.println(doubleBox.getItem());

		System.out.println(doubleBox.sum(5.5));
		
		

		printList(stringList.getList());

		printList(integerList.getList());
		
		
		System.out.println(
		        sumNumbers(integerList.getList())
		);
		
		
		
    }
	
	public static void printList(List<?> list) {

	    for (Object item : list) {
	        System.out.println(item);
	    }
	    
	    
	    
	}
	
	public static double sumNumbers(List<? extends Number> list) {

	    double sum = 0;

	    for (Number number : list) {
	        sum += number.doubleValue();
	    }

	    return sum;
	}
	

}
