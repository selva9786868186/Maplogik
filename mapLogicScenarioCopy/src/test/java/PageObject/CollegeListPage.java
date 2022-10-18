package PageObject;

import Utilities.WebUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CollegeListPage {
    WebDriver driver;
    WebUtils webutils;
    public CollegeListPage(WebDriver driver) {
        this.driver=driver;
        webutils = new WebUtils();
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath="//a[@class='item-edit dlt-college']")
    WebElement collegeDelete;
    @FindBy(xpath="(//table[@id='datatable']/tbody/tr/td)[2]")
    WebElement collegeTitleText;
    @FindBy(xpath="(//table[@id='datatable']/tbody/tr/td)[3]")
    WebElement collegeLocationText;
    @FindBy(xpath="//span[text()='Log out']")
    WebElement adminLogOut;

    public void collegeDeleteIcon (String expected) {
        webutils.assertion(expected, webutils.getTextValue(collegeTitleText));
    }
    public void collegeDeleteIcon2 (String expected){

        webutils.assertion(expected,webutils.getTextValue(collegeLocationText));
    }
    public void delete(){
        webutils.findElementClick(collegeDelete);
        webutils.alertHandling(driver);
        webutils.findElementClick(adminLogOut);
    }

}
