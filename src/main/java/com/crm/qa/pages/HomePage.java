package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class HomePage extends TestBase {

	@FindBy(xpath = "//td[contains(text(),'User: Naveen K')]")
	WebElement username;

	@FindBy(xpath = "//a[@title='Contacts']")
	WebElement contacts;

	@FindBy(xpath = "//a[@title='Deals']")
	WebElement deals;

	@FindBy(xpath = "//a[@title='Tasks']")
	WebElement tasks;

	@FindBy(xpath = "//a[contains(text(), 'New Contact')]")
	WebElement NewContact;

	public HomePage() {
		PageFactory.initElements(driver, this);
	}

	public String verifyHomeTitle() {
		return driver.getTitle();
	}

	public boolean verifyUsername() {
		return username.isDisplayed();
	}

	public ContactsPage clickContacts() {
		 contacts.click();
		return new ContactsPage();
	}

	public DealsPage clickDeals() {
		deals.click();
		return new DealsPage();
	}

	public TasksPage clickTasks() {
		tasks.click();
		return new TasksPage();
	}

	public void clickonNewContact() {
		Actions action = new Actions(driver);
		action.moveToElement(contacts).build().perform();
		NewContact.click();

	}

}
