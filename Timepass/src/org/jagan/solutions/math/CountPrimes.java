package org.jagan.solutions.math;

public class CountPrimes {

	/*
	 * 
	 * Count the number of prime numbers less than a non-negative number, n.
	 * 
	 * Example:
	 * 
	 * Input: 10 Output: 4 
	 * Explanation: There are 4 prime numbers less than 10, they are 2, 3, 5, 7.
	 * 
	 */
	public static void main(String[] args) {
		System.out.println("Count of primes less than n = 10 is " + countPrimes(10));
	}
	
	public static int countPrimes(int n) {
        int count = 0;
        boolean[] notPrime = new boolean[n];
        notPrime[0] = true;
        notPrime[1] = true;
        int i = 2;
		for (;i <= (int)Math.sqrt(n); i++) {
			if (!notPrime[i]) {
				count++;
				for (int j = 2; (j * i) < n; j++) {
					notPrime[j * i] = true;
				}
			}
		}
		while(i < n) if(!notPrime[i++]) count++;
        return count;
    }

}
