package org.jagan.fundamentals;

import junit.framework.TestCase;

public class EqualsTest extends TestCase {

	public void test() {
		assert "ab" == "a" + "b";

		Integer i = 1;
		Integer j = i;
		assert i == j;
		
		String ab = "ab";
		String apb = "a" + "b";
	
		System.out.println(ab == apb);
		System.out.println(i == j);
		
		String abn = new String("ab");
		System.out.println(ab == abn);
	}

	public void test1() {
		assert new String("a") != new String("a");
		String str1 = new String("a");
		String str2 = new String("a");
		assert str1 != str2;
		Integer i = 128;
		Integer j = 128;
		assert i != j;
		assert i.equals(j);
		System.out.println(i.equals(j));
	}
	
	public void test2() {
		String a = "abcxyz";
		String b = "abcxyz";
		assert a == b;
	}
	
	public void test3() {
		String abc = "Hello WorldHello WorldHello WorldHello WorldHello WorldHello WorldHello WorldHello WorldHello World";
		String xyz = "Hello WorldHello WorldHello WorldHello WorldHello WorldHello WorldHello WorldHello WorldHello World";

		if(abc == xyz)
		    System.out.println("Refers to same string");
		else
		    System.out.println("Refers to different strings");

		if(abc.equals(xyz))
		     System.out.println("Contents of both strings are same");
		else
		     System.out.println("Contents of strings are different");
	}
}
