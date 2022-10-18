package PageObject;

import Utilities.ExcelUtils;
import Utilities.WebUtils;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	WebDriver driver;
	WebUtils webutils;

	 ExcelUtils excelUtils;
	ExtentSparkReporter extentSparkReporter;

	
	@FindBy(id="login-email")
	WebElement login;
	@FindBy(id="login-password")
	WebElement password;
	@FindBy(xpath="//button[@class='btn btn-primary w-100 waves-effect waves-float waves-light']")
	WebElement submit;
	public LoginPage(WebDriver driver) {
		this.driver=driver;
		webutils = new WebUtils();
		excelUtils = new ExcelUtils(System.getProperty("user.dir") + "/src/main/java/Login.xlsx",System.getProperty("user.dir") + "/src/main/java/OTP2.xlsx");
		PageFactory.initElements(driver, this);
	}
	public void loadApplication(String url) {
		webutils.loadAppln(driver, url);
		webutils.windowMax(driver);
		webutils.waitThread();

	}
	public void enterCredentials() {

		excelUtils.getExcelSheet(0);
		String username = excelUtils.getExcelCellValue(0,0);
		webutils.findElementEnterData(login,username);
		String pass = excelUtils.getExcelCellValue(0,1);
		webutils.findElementEnterData(password, pass);
		webutils.findElementClick(submit);
	}
	public WebDriver reOpenBrowser(){
		return  webutils.setDriverProperty();
	}
}

