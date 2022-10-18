package PageObject;

import Utilities.WebUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	WebDriver driver;
	WebUtils webutils; 
	public HomePage(WebDriver driver) {
		webutils = new WebUtils();
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
@FindBy(xpath="(//span[@class='menu-title text-truncate'])[3]")
WebElement collegeActivation;
@FindBy(xpath="//span[text()='Add New']")
WebElement newCollege;

public void collegeActivationTab() {
	webutils.findElementClick(collegeActivation);
}
public void newCollegeTab() {
	webutils.findElementClick(newCollege);
}
}