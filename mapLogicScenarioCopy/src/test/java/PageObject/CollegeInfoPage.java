package PageObject;

import Utilities.WebUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CollegeInfoPage {
	WebDriver driver;
	WebUtils webutils;
	public CollegeInfoPage(WebDriver driver) {
		this.driver=driver;
		webutils = new WebUtils();
	       PageFactory.initElements(driver, this);
	}

	@FindBy(id="course_name")
	WebElement courseName;

	@FindBy(id="logo")
	WebElement logo;

	@FindBy(id="address")
	WebElement address;

	@FindBy(xpath="(//select[@class='form-control'])[1]")
	WebElement collegeDistrict;

	@FindBy(xpath="(//select[@class='form-control'])[2]")
	WebElement collegeAffiliation;

	@FindBy(xpath="(//select[@class='form-control'])[3]")
	WebElement collegeAffiliatedTo;
	
	@FindBy(xpath="(//select[@class='form-control'])[4]")
	WebElement typeOfCollege;

	@FindBy(id="bootstrap-duallistbox-nonselected-list_course[]")
	WebElement courseSelection;

	@FindBy(id="cnt_name")
	WebElement contactPerson;

	@FindBy(id="cnt_number")
	WebElement contactPersonNumber;

	@FindBy(id="cnt_email")
	WebElement contactPersonEmail;

	@FindBy(id="cnt_name_plc")
	WebElement contactPersonPlacement;

	@FindBy(id="cnt_number_plc")
	WebElement contactPersonPlacementNumber;

	@FindBy(id="course_email_plc")
	WebElement contactPersonPlacementEmail;
	@FindBy(xpath="//button[@type='submit']")
	WebElement submit;
	
	public void collegeInfoForm(String coursename,String logoImage,String addressLocation) {
		webutils.findElementEnterData(courseName, coursename);
		webutils.findElementEnterData(logo, logoImage);
		webutils.findElementEnterData(address, addressLocation);
		webutils.waitThread();
		webutils.scroll(driver);
	}
	public void dropDownSelection(String district,String affiliation,String affiliatedTo,String collegeType) {
		webutils.selectDropdown(driver, collegeDistrict, district);
		webutils.selectDropdown(driver, collegeAffiliation, affiliation);
		webutils.selectDropdown(driver, collegeAffiliatedTo, affiliatedTo);
		webutils.selectDropdown(driver, typeOfCollege, collegeType);
	}
	public void courseDropDownSelection(int course,int course1,int course2) {
		webutils.selectDropdown2(driver, courseSelection, course);
		webutils.selectDropdown2(driver, courseSelection, course1);
		webutils.selectDropdown2(driver, courseSelection, course2);
	}
	public void contactInfo (String contactName,String contactNumber,String contactEmail) {
		webutils.findElementEnterData(contactPerson, contactName);
		webutils.findElementEnterData(contactPersonNumber, contactNumber);
		webutils.findElementEnterData(contactPersonEmail, contactEmail);
	}

	public void placementInfo (String placementContact,String placementContactNum,String placementContactEmail) {
		webutils.findElementEnterData(contactPersonPlacement, placementContact);
		webutils.findElementEnterData(contactPersonPlacementNumber, placementContactNum);
		webutils.findElementEnterData(contactPersonPlacementEmail, placementContactEmail);
	}
	public void submitForm()
	{
		webutils.JavascriptExecutor(driver, submit);
	}
}
