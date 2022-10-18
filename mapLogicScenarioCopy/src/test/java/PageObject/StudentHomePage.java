package PageObject;

import Utilities.WebUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class StudentHomePage {
    WebDriver driver;
    WebUtils webutils;
    public StudentHomePage(WebDriver driver) {
        this.driver=driver;
        webutils = new WebUtils();
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath="//span[text()='Academic Info']")
    WebElement academic;
    @FindBy(xpath="//span[text()='Log out']")
    WebElement logingOut;
    public void studentMarks(String filePath){
        webutils.robotClass();
        webutils.JavascriptExecutor(driver,academic);
        webutils.scroll(driver);
        webutils.screenShot(driver,filePath);
        webutils.findElementClick(logingOut);
    }

}
