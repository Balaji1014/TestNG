package org.pojo;

import java.sql.Driver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.sample.BaseClases;


public class FaceBookLoginPojo extends BaseClases{

	// Pom Task ; Question 1
	
	public FaceBookLoginPojo() {
		
		PageFactory.initElements(driver, this);
	}


	@FindBy(xpath = "//input[@class='inputtext _55r1 _6luy']")
	private WebElement email;
	
	@FindBy(xpath = "//input[@type='password']")
	private WebElement pass;

	@FindBy(xpath = "//button[text()='Log In']")
	private WebElement click;
	
	public WebElement getClick() {
		return click;
	}

	public WebElement getEmail() {
		return email;
	}

	public WebElement getPass() {
		return pass;
	}
	
	











}
