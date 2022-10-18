package Utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.OutputType;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;

public class WebUtils {
	public WebDriver setDriverProperty() {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") +"/src/main/java/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		return driver;
	}
	public WebDriver getBrowserDriver(String browserName) {
		WebDriver driver = null;
		if (browserName.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (browserName.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		} else if (browserName.equalsIgnoreCase("IE")) {
			WebDriverManager.iedriver().setup();
			driver = new InternetExplorerDriver();
		}
		return driver;
	}
	public void loadAppln(WebDriver driver, String url) {
		driver.get(url);
	}
	public void openInNewTab(WebDriver driver,String url){
		((JavascriptExecutor)driver).executeScript("window.open()");
		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs.get(1));
		driver.navigate().to(url);
	}
	public void navigation(WebDriver driver, String url) {
		driver.navigate().to(url);
	}
	public void windowMax(WebDriver driver) {
		driver.manage().window().maximize();
	}
	public void findElementEnterData(WebElement webElement, String data) {
		webElement.sendKeys(data);
	}
	public void scroll (WebDriver driver){
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy(0,1000)", "");
		}
	public String getTextValue(WebElement webElement){
		return webElement.getText();
	}
	public void getTextandStoreValue(WebDriver driver,WebElement webElement1,WebElement webElement2){
		WebDriverWait wait1 = new WebDriverWait(driver,Duration.ofSeconds(30));
		wait1.until(ExpectedConditions.elementToBeClickable(webElement1));
		String store1 = webElement1.getText();  // copy and get
		wait1.until(ExpectedConditions.elementToBeClickable(webElement2));
		webElement2.sendKeys(store1); // enter otp
	}
	public void assertion( String expected,String actual){
		Assert.assertEquals(expected,actual);
	}
	public void findElementClick(WebElement webElement) {

		webElement.click();
	}
	public void waitThread() {
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	public void browserClose(WebDriver driver){
		driver.close();
	}
	public void waitExplicit(WebDriver driver, WebElement webElement, int seconds) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
		wait.until(ExpectedConditions.elementToBeClickable(webElement));
	}
	public void alertHandling(WebDriver driver){
		Alert alert = driver.switchTo().alert();
		driver.switchTo().alert().accept();
	}

		public void selectDropdown(WebDriver driver,WebElement webElement,String string) {
			Select select = new Select(webElement);
			select.selectByValue(string);
		}
		public void selectDropdown2(WebDriver driver,WebElement webElement,int value) {
			Select select = new Select(webElement);
			select.selectByIndex(value);
		}
		public void JavascriptExecutor(WebDriver driver,WebElement webElement ) {
			JavascriptExecutor j = (JavascriptExecutor) driver;
			j.executeScript("arguments[0].click();", webElement);
			
		}
	public void robotClass (){
		Robot rob = null;
		try {
			rob = new Robot();
		} catch (AWTException e) {
			throw new RuntimeException(e);
		}
		rob.keyPress(KeyEvent.VK_CONTROL);
		rob.keyPress(KeyEvent.VK_MINUS);
		rob.keyRelease(KeyEvent.VK_MINUS);
		rob.keyRelease(KeyEvent.VK_CONTROL);
		}
   public File screenShot(WebDriver driver,String filePath)  {
	File SrcFile1 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);

	try {
		FileUtils.copyFile(SrcFile1, new File (filePath));
	} catch (IOException e) {
		throw new RuntimeException(e);
	}
	return SrcFile1;

}
}




