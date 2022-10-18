package resourses;
import Utilities.WebUtils;
import org.openqa.selenium.WebDriver;

public class BaseClass {

	WebUtils webutils;
	public BaseClass () {

		webutils = new WebUtils();
	}
	public WebDriver driverDetails(String browserName) {
		return webutils.setDriverProperty();
}
}