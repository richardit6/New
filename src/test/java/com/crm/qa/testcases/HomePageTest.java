package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.util;

public class HomePageTest extends TestBase {
	LoginPage loginpage;
	HomePage homepage;
	util testutil;

	public HomePageTest() {
		super();
	}

	@BeforeMethod
	public void setup() {
		initialization();
		loginpage = new LoginPage();
		homepage = loginpage.login(prop.getProperty("username"), prop.getProperty("password"));

	}

	@Test(priority=1)
	public void usernameTest() {
		testutil.switchwindow();
		Assert.assertTrue(homepage.verifyUsername());
	}

	@Test(priority=2)
	public void verifyHomeTitleTest() {
		String tit = homepage.verifyHomeTitle();
		Assert.assertEquals(tit, "CRMPRO", "Title is not matched");
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
