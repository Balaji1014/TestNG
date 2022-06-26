package org.sample;

import org.testng.Assert;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import junit.framework.TestCase;

public class TestNG2 {
	
	
	
	
	@Test(priority = -2)
	private void testCase1() {
		System.out.println("T1");

	}


	@Test(priority = 2)
	private void testCase2() {
		System.out.println("T2");

	}
	@Ignore
	@Test
	private void testCase3() {
		System.out.println("T3");

	}
	
	@Test(priority = -1 , invocationCount = 2)
	private void testCase4() {
		System.out.println("T4");

	}
	
	
	
	
	
	
	
	
}
