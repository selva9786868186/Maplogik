package resourses;

import Utilities.PropUtils;
import Utilities.ReportUtils;
import com.aventstack.extentreports.Status;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import static Utilities.ReportUtils.getTest;


public  class Listeners implements ITestListener {
    PropUtils prop = null;
    public  ReportUtils reportUtils;

    public Listeners() {
        prop = new PropUtils(System.getProperty("user.dir") + "/src/test/java/resourses/data.properties");
        reportUtils = new ReportUtils();
    }


    @Override
    public void onTestStart(ITestResult result) {

    }

    @Override
    public void onTestSuccess(ITestResult result) {

    }

    @Override
    public void onTestFailure(ITestResult result) {

    }

    @Override
    public void onTestSkipped(ITestResult result) {

    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

    }

    @Override
    public void onStart(ITestContext context) {
    }

    @Override
    public void onFinish(ITestContext context) {
        ReportUtils.extent.flush();

    }
}
