package programming;

import java.util.List;

public class FP01Functional { 
	
	public static void main(String[] args) {
		List<Integer> numbers = List.of(12, 9, 13, 4, 6, 2, 4, 12, 15);
		System.out.println("Print all numbers");
		printAllNumbersInListFunctional(numbers);
		System.out.println("Print all even numbers");
		printEvenNumbersInListFunctional(numbers);
		System.out.println("Print squares of all even numbers");
		printSquaresOfEvenNumbersInListFunctional(numbers);
	}

	 private static void print(int number) {
		 System.out.println(number);
	 }

	// private static boolean isEven(int number) {
	// return number%2 == 0;
	// }

	private static void printAllNumbersInListFunctional(List<Integer> numbers) {
		// What to do?d
		System.out.println("Print using function defined in class");
		numbers.stream().forEach(FP01Functional::print);
		System.out.println("Print using straight System.opt::println");
		numbers.stream().forEach(System.out::println);// Method Reference

		System.out.println("Print using function defined in class without using stream");
		numbers.forEach(FP01Functional::print);
		System.out.println("Print using straight System.opt::println without using stream");
		numbers.forEach(System.out::println);// Method Reference

	}

	// number -> number%2 == 0
	private static void printEvenNumbersInListFunctional(List<Integer> numbers) {
		// What to do?

		numbers.stream() // Convert to Stream
				// .filter(FP01Functional::isEven)
				// Filter - Only Allow Even Numbers
				.filter(number -> number % 2 == 0) // Lamdba Expression
				.forEach(System.out::println);// Method Reference


	}
	
	private static void printSquaresOfEvenNumbersInListFunctional(List<Integer> numbers) {
		numbers.stream() // Convert to Stream
				.filter(number -> number % 2 == 0) // Lamdba Expression
				//mapping - x -> x * x
				.map(number -> number * number)
				.forEach(System.out::println);// Method Reference

		// .filter(FP01Functional::isEven)//Filter - Only Allow Even Numbers
	}

}
