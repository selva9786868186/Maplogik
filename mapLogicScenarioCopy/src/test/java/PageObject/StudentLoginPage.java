package PageObject;

import Utilities.ExcelUtils;
import Utilities.WebUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class StudentLoginPage {
    WebDriver driver;
    WebUtils webutils;
    ExcelUtils excelUtils;
    public StudentLoginPage(WebDriver driver) {
        this.driver=driver;
        webutils = new WebUtils();
         excelUtils = new  ExcelUtils (System.getProperty("user.dir") + "/src/main/java/Login.xlsx", System.getProperty("user.dir") + "/src/main/java/OTP2.xlsx");
        PageFactory.initElements(driver, this);
    }

    @FindBy(id="login-student-id")
    WebElement studentId;
    @FindBy(xpath="(//input[@type='text'])[2]")
    WebElement password;

    @FindBy(xpath="(//*[text()='Log in'])")
    WebElement logIn;
    @FindBy(id="test_otp")
    WebElement otpValue;
    @FindBy(id="login-otp")
    WebElement otpBox;
    @FindBy(xpath="(//*[text()='Submit'])")
    WebElement submit;


public void studentPageNavigation(String url){
    webutils.navigation(driver,url);
    webutils.windowMax(driver);
}
    public void studentLoginForm(int rowsNum,int colsnNum){

        excelUtils.getExcelSheet(0);
        String username1 = excelUtils.getExcelCellValue(1,0);
        webutils.findElementEnterData(studentId,username1);
        String pass1 = excelUtils.getExcelCellNumericValue(1,1);
        webutils.findElementEnterData(password, pass1);
        webutils.findElementClick(logIn);

        webutils.waitExplicit(driver,otpValue,10);
        webutils.getTextandStoreValue(driver,otpValue,otpBox);
        excelUtils.cellCreationAndWrite(rowsNum,colsnNum,otpValue);
        excelUtils.fileCreation(System.getProperty("user.dir") + "/src/main/java/OTP2.xlsx");
        webutils.findElementClick(submit);
        webutils.waitThread();
    }

}
