package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class LoginPage extends TestBase {

	Actions action;

	@FindBy(name = "username")
	WebElement username;

	@FindBy(name = "password")
	WebElement password;

	@FindBy(xpath = "//input[@type='submit']")
	WebElement loginbtn;

	@FindBy(xpath = "//button[contains(text(),'Sign Up')]")
	WebElement Sign;

	@FindBy(xpath = "//img[contains(@class,'img-responsive')]")
	WebElement Logo;

	// Initializing the objects
	public LoginPage() {
		PageFactory.initElements(driver, this);
		action = new Actions(driver);
	}

	// Actions for the Web page
	public String pagetitle() {
		return driver.getTitle();
	}

	public boolean image() {
		
		return Logo.isDisplayed();
	}

	public HomePage login(String un, String pwd) {
		username.sendKeys(un);
		password.sendKeys(pwd);
		loginbtn.click();
//		action.moveToElement(loginbtn)
		return new HomePage();

	}
}