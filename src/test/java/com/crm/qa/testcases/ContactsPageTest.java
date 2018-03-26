package com.crm.qa.testcases;

//import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.util;

public class ContactsPageTest extends TestBase {

	LoginPage loginPage;
	util testutil;
	HomePage homePage;
	ContactsPage contactPage;

	String sheetName = "contact";

	public ContactsPageTest() {
		super();
	}

	@BeforeMethod
	public void setup() {
		initialization();
		testutil = new util();
		contactPage = new ContactsPage();
		loginPage = new LoginPage();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		testutil.switchwindow();
		contactPage = homePage.clickContacts();
	}

	@DataProvider
	public Object[][] getCRMdata() {
		Object data[][] = util.getTestData(sheetName);
		return data;

	}

	@Test(dataProvider = "getCRMdata")
	public void validateCreateContact(String Title, String Firsname, String MidName, String SurName, String Company) {
		homePage.clickonNewContact();
		contactPage.createnewcontact(Title, Firsname, MidName, SurName, Company);
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
