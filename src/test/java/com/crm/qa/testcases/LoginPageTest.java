package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

public class LoginPageTest extends TestBase {

	LoginPage loginpage;
	HomePage homepage;

	public LoginPageTest() {
		super();
	}

	@BeforeMethod
	public void setup() {
		initialization();
		loginpage = new LoginPage();
	}

	 @Test(priority = 1)
	public void title() {
		String tit = loginpage.pagetitle();
		Assert.assertEquals(tit, "#1 Free CRM for Any Business: Online Customer Relationship Software");
	}

	 @Test(priority = 2)
	public void Logo() {
		boolean flag = loginpage.image();
		Assert.assertTrue(flag);
	}

	@Test(priority = 3)
	public void data() {
		// System.out.println("tes:" +prop.getProperty("username"));
		homepage = loginpage.login(prop.getProperty("username"), prop.getProperty("password"));

	}
	 @AfterMethod
	public void moodu() {
		driver.quit();

	}
}