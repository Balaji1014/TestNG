package org.sample;

import org.pojo.FaceBookLoginPojo;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


public class TestNG1 extends BaseClases{
	
	@BeforeClass
	private void before() {
		
		browserConfigure();
		getUrl("https://www.facebook.com/");
		
	}
	@Parameters({"user" , "pass"})
	@Test
	private void testCase1(String user , String pass) {
		
		FaceBookLoginPojo f = new FaceBookLoginPojo();
	
		sendKeys(f.getEmail(), user);
		
		sendKeys(f.getPass(), pass);
	}	

	@AfterClass
	private void after() {
		
		close();

	}
}