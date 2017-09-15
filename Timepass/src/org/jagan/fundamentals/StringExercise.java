package org.jagan.fundamentals;

public class StringExercise {

	public static void main(String args[]) {
		String str1 = "abc";
		String str2 = "abc";
		System.out.println("Is str1 = \"abc\" and \"abc\" equal? " + (str1 == "abc"));
		System.out.println("Is str1 = \"abc\" and str2 = \"abc\" equal? " + (str1 == str2));
		String str3 = new String("abc");
		System.out.println("Is str1 = \"abc\" and str3 = new String(\"abc\") equal? " + (str1 == str3));
		System.out.println("Is str2 = \"abc\" and str3 = new String(\"abc\") equal? " + (str2 == str3));
		System.out.println("Is str1 = \"abc\" and str3 = new String(\"abc\") equal in content? " + (str1.equals(str3)));
		System.out.println("Is str2 = \"abc\" and str3 = new String(\"abc\") equal in content? " + (str2.equals(str3)));
	}
}
