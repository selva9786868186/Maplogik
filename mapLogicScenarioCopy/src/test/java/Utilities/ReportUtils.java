package Utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import java.util.HashMap;
import java.util.Map;


public class ReportUtils {
    ExtentSparkReporter extentSparkReporter;
    public static final ExtentReports extent = new ExtentReports();
    public ExtentTest test;
    public String reportFilePath;
    static Map<Integer, ExtentTest> extentTestMap = new HashMap<>();
    static ExtentReports  extentreports = createExtentReports();
    public void extentReport(){


    }
    public void extentConfig() {

        extent.attachReporter(extentSparkReporter);
    }

    public void ReportName(String reportName){
        extentSparkReporter.config().setReportName(reportName);
    }
    public void DocumentTitle(String title){

        extent.attachReporter(extentSparkReporter);
    }

    public void flushReport(){

        extent.flush();
    }
    public synchronized static ExtentReports createExtentReports() {
        ExtentSparkReporter reporter = new ExtentSparkReporter(System.getProperty("user.dir") +"/src/main/java/test.xml");
        reporter.config().setReportName("TestNGproject");
        reporter.config().setDocumentTitle("MapLogicScenario1");
        reporter.config().setEncoding("utf-8");
        reporter.config().setTimeStampFormat("EEEE, MMMM dd, yyyy, hh:mm a '('zzz')'");
        extent.attachReporter(reporter);
        extent.setSystemInfo("Author", "Selva Mani");
        extent.setSystemInfo("OS", System.getProperty("os.name"));
        extent.setSystemInfo("USER", System.getProperty("user.name"));
        return extent;
    }
    public static synchronized ExtentTest getTest() {
        return extentTestMap.get((int) Thread.currentThread().getId());
    }
    public static synchronized ExtentTest startTest(String testName, String desc) {
        ExtentTest test = extentreports.createTest(testName, desc);
        extentTestMap.put((int) Thread.currentThread().getId(), test);
        return test;
    }
}
