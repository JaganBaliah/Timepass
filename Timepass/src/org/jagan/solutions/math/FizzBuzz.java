package org.jagan.solutions.math;

import java.util.ArrayList;
import java.util.List;

public class FizzBuzz {

	/*
	 * Write a program that outputs string representation of numbers from 1 to n.
	 * 
	 * But for multiples of three it should output “Fizz” instead of the number and
	 * for the multiples of five output “Buzz”. For numbers which are multiples of
	 * both three and five output “FizzBuzz”.
	 * 
	 * Example:
	 * 
	 * n = 15,
	 * 
	 * Return: [ "1", "2", "Fizz", "4", "Buzz", "Fizz", "7", "8", "Fizz", "Buzz",
	 * "11", "Fizz", "13", "14", "FizzBuzz" ]
	 * 
	 */
	public static void main(String[] args) {
		System.out.println("Output for n = 15 : " + fizzBuzz(15));

	}

	public static List<String> fizzBuzz(int n) {
		List<String> rtnVal = new ArrayList<String>();
		for(int i = 1; i <= n; i++) {
			if(i % 3 == 0 && i % 5 == 0) rtnVal.add("FizzBuzz");
			else if(i % 3 == 0) rtnVal.add("Fizz");
			else if(i % 5 == 0) rtnVal.add("Buzz");
			else rtnVal.add(i+"");			
		}
		return rtnVal;
	}
}
