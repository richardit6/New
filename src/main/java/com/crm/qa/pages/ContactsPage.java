package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.crm.qa.base.TestBase;

public class ContactsPage extends TestBase {

	@FindBy(name = "title")
	WebElement Tit;

	@FindBy(id = "first_name")
	WebElement FName;

	@FindBy(id = "middle_initial")
	WebElement MName;

	@FindBy(id = "surname")
	WebElement SName;

	@FindBy(name = "client_lookup")
	WebElement CompEle;
	
	@FindBy(xpath = "//*[@id=\'contactForm\']/table/tbody/tr[1]/td/input[2]")
	WebElement sBtn;

	public ContactsPage() {
		PageFactory.initElements(driver, this);
	}

	public void createnewcontact(String Res, String Fame, String Mame, String Same, String ComEle) {
		Select select = new Select(Tit);
		select.selectByVisibleText(Res);
		FName.sendKeys(Fame);
		MName.sendKeys(Mame);
		SName.sendKeys(Same);
		CompEle.sendKeys(ComEle);
		sBtn.click();
	}

}
