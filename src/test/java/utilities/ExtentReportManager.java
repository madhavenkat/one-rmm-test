package utilities;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportManager implements ITestListener {
    private static ExtentReports extent;
    private static ThreadLocal<ExtentTest> testThread = new ThreadLocal<>();

    // Initializes ExtentReports (Singleton)
    private static void initReports() {
        if (extent == null) {
            extent = new ExtentReports();
            ExtentSparkReporter spark = new ExtentSparkReporter(System.getProperty("user.dir") + "/test-output/reports/ExtentReport.html");
            extent.attachReporter(spark);
        }
    }

    public static ExtentTest getTest() {
        return testThread.get();
    }

    @Override
    public void onStart(ITestContext context) {
        initReports();
    }

    @Override
    public void onTestStart(ITestResult result) {
        ExtentTest test = extent.createTest(result.getMethod().getMethodName());
        testThread.set(test);
        test.info("Test Started: " + result.getMethod().getMethodName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        getTest().pass("Test Passed: " + result.getMethod().getMethodName());
    }

    @Override
    public void onTestFailure(ITestResult result) {
        getTest().fail("Test Failed: " + result.getMethod().getMethodName());
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        getTest().skip("Test Skipped: " + result.getMethod().getMethodName());
    }

    @Override
    public void onFinish(ITestContext context) {
        if (extent != null) {
            extent.flush();
        }
    }
}
