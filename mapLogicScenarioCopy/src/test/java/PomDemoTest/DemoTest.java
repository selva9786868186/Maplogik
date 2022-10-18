package PomDemoTest;

import PageObject.*;
import Utilities.ExcelUtils;
import Utilities.PropUtils;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import resourses.BaseClass;

import java.lang.reflect.Method;

import static Utilities.ReportUtils.startTest;


public class DemoTest extends BaseClass {
	PropUtils prop = null;

	WebDriver driver;

	LoginPage loginPage;
	HomePage homePage;
	CollegeInfoPage collegeInfoPage;
	CollegeListPage collegeListPage;
	MarkImportPage markImportPage;
	StudentLoginPage studentLoginPage;
	StudentHomePage studentHomePage;
	ExcelUtils excelUtils;
	DemoTest demoTest;

	public DemoTest() {
		prop = new PropUtils("/src/test/java/resourses/data.properties");
		String browserName = prop.getValue("Browser");
		driver = driverDetails(browserName);
		excelUtils = new ExcelUtils(System.getProperty("user.dir") + "/src/main/java/Login.xlsx",System.getProperty("user.dir") + "/src/main/java/OTP2.xlsx");
		loginPage = new LoginPage(driver);
		homePage = new HomePage(driver);
		collegeInfoPage = new CollegeInfoPage(driver);
		collegeListPage = new CollegeListPage(driver);
		markImportPage = new MarkImportPage(driver);
		studentLoginPage = new StudentLoginPage(driver);
		studentHomePage = new StudentHomePage(driver);
	}
	@Test(groups={"scenario 1"},priority = 1)
	public void login(Method method) {
		loginPage.loadApplication(prop.getValue("url"));
		loginPage.enterCredentials();
		startTest(method.getName(), "Entering username and password");
	}
	@Test(groups={"scenario 1"},priority = 2)
	public void newCollege(Method method) {
		homePage.collegeActivationTab();
		homePage.newCollegeTab();
		startTest(method.getName(), "Adding new college");
	}
	@Test(groups={"scenario 1"},priority = 3)
	public void CollegeDetails(Method method) {
		collegeInfoPage.collegeInfoForm(prop.getValue("coursename"),(System.getProperty("user.dir") + prop.getValue("logoImage")), prop.getValue("addressLocation"));
		collegeInfoPage.dropDownSelection(prop.getValue("district"), prop.getValue("affiliation"), prop.getValue("affiliatedTo"), prop.getValue("collegeType"));
		collegeInfoPage.courseDropDownSelection(prop.getValues2("course"), prop.getValues2("course1"), prop.getValues2("course2"));
		collegeInfoPage.contactInfo(prop.getValue("contactName"), prop.getValue("contactNumber"), prop.getValue("contactEmail"));
		collegeInfoPage.placementInfo(prop.getValue("placementContact"), prop.getValue("placementContactNum"), prop.getValue("placementContactEmail"));
		collegeInfoPage.submitForm();
		startTest(method.getName(), "Getting college Details");
	}
	@Test(groups={"scenario 1"},priority = 4)
	public void CollegeValidation(Method method) {
		collegeListPage.collegeDeleteIcon(prop.getValue("coursename"));
		collegeListPage.collegeDeleteIcon2(prop.getValue("addressLocation"));
		collegeListPage.delete();
		startTest(method.getName(), "validating the college");
	}
	@Test(groups={"scenario 2"},priority = 5)
	public void StudentMarkBeforeUImport(Method method) {
		studentLoginPage.studentPageNavigation(prop.getValue("studentUrl"));
		studentLoginPage.studentLoginForm(0,0);
		studentHomePage.studentMarks((System.getProperty("user.dir") +prop.getValue("screenShot")));
		startTest(method.getName(), "Taking screen shot in student academic info page before importing the marks");
	}
	@Test(groups={"scenario 2"},priority = 6)
	public void studentMarks(Method method) {
		markImportPage.naigationToAdmin(prop.getValue("url"));
		loginPage.enterCredentials();
		homePage.collegeActivationTab();
		markImportPage.marksImportForm(prop.getValue("type"), prop.getValues2("courseType"), prop.getValues2("semester"));
		markImportPage.markFile((System.getProperty("user.dir") +prop.getValue("studentMarkExcel")));
		studentLoginPage.studentPageNavigation(prop.getValue("studentUrl"));
		studentLoginPage.studentLoginForm(1,1);
		studentHomePage.studentMarks((System.getProperty("user.dir") +prop.getValue("screenShotAfterUpdation")));
		startTest(method.getName(), "Taking screen shot in student academic info page after importing the marks");
	}
}
