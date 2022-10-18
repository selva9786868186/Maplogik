package PageObject;

import Utilities.WebUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MarkImportPage {
    WebDriver driver;
    WebUtils webutils;
    public MarkImportPage(WebDriver driver) {
        this.driver=driver;
        webutils = new WebUtils();
        PageFactory.initElements(driver, this);
    }
    @FindBy(id="course_type")
    WebElement courseValue;
    @FindBy(id="course_name")
    WebElement courseName;
    @FindBy(xpath="//select[@name='semester']")
    WebElement semesterName;

    @FindBy(id="import_file")
    WebElement importMarks;
    @FindBy(xpath="//button[@type='submit']")
    WebElement submit;
    @FindBy(xpath="//span[text()='Log out']")
    WebElement logOut;
    @FindBy(xpath="//tbody/tr/td[text()='Anna University - college of Engineering']/../td/a[@title='Import Marks']")
    WebElement collegeImport;


public void naigationToAdmin(String url){
    webutils.waitThread();
    webutils.navigation(driver,url);

}
    public void openNewPage(String url){
        webutils.openInNewTab(driver,url);
        webutils.windowMax(driver);
    }
    public void marksImportForm (String type,int courseType,int semester) {

        webutils.scroll(driver);
        webutils.JavascriptExecutor(driver,collegeImport);
        webutils.selectDropdown(driver, courseValue, type);
        webutils.selectDropdown2(driver, courseName, courseType);
        webutils.selectDropdown2(driver, semesterName, semester);
    }
    public void markFile (String file){
        webutils.findElementEnterData(importMarks,file);
        webutils.JavascriptExecutor(driver,submit);
        webutils.findElementClick(logOut);
    }


}
