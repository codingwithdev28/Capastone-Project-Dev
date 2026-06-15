package listeners;

import java.util.concurrent.TimeUnit;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentTest;

import utilities.ExtentManager;
import utilities.ExtentTestManager;
import utilities.ScreenshotUtil;

public class TestListener implements ITestListener {

    private int passed = 0;
    private int failed = 0;
    private int skipped = 0;

    private long startTime;
    
    private static final Logger logger =
            LogManager.getLogger(TestListener.class);


    @Override
    public void onStart(ITestContext context) {

        startTime = System.currentTimeMillis();

        System.out.println("\n================================================");
        System.out.println("     GURU99 BANK AUTOMATION FRAMEWORK");
        System.out.println("================================================");

        ExtentManager.getInstance();
        logger.info("Execution Started");
    }

    @Override
    public void onTestStart(ITestResult result) {

        String testName =result.getMethod().getMethodName();

        System.out.println("\nExecuting : " + testName);

        ExtentTest test =ExtentManager.getInstance().createTest(testName);

        ExtentTestManager.setTest(test);

        ExtentTestManager.getTest().info("Test Started");
    }

    @Override
    public void onTestSuccess(ITestResult result) {

        passed++;

        System.out.println("PASS : "+ result.getMethod().getMethodName());

        ExtentTestManager.getTest().pass("Test Passed Successfully");
        logger.info("Test Passed : "+ result.getMethod().getMethodName());
    }

    @Override
    public void onTestFailure(ITestResult result) {

        failed++;

        String testName =result.getMethod().getMethodName();

        System.out.println("FAIL : " + testName);

        if (result.getThrowable() != null) {

            System.out.println(result.getThrowable().getMessage());

            ExtentTestManager.getTest().fail(result.getThrowable());
        }

        try {

            String screenshotPath =ScreenshotUtil.captureScreenshot(testName);

            ExtentTestManager.getTest().addScreenCaptureFromPath(screenshotPath);

        } catch (Exception e) {

            System.out.println("Screenshot Capture Failed : "+ e.getMessage());
        }
        logger.error("Test Failed : "+ result.getMethod().getMethodName());

        logger.error(result.getThrowable());
    }

    @Override
    public void onTestSkipped(ITestResult result) {

        skipped++;

        System.out.println("SKIPPED : "+ result.getMethod().getMethodName());

        ExtentTestManager.getTest().skip("Test Skipped");
        logger.warn("Test Skipped : "+ result.getMethod().getMethodName());
    }

    @Override
    public void onFinish(ITestContext context) {

        long endTime =System.currentTimeMillis();

        long duration =endTime - startTime;

        long minutes =TimeUnit.MILLISECONDS.toMinutes(duration);

        long seconds =TimeUnit.MILLISECONDS.toSeconds(duration) % 60;

        System.out.println("\n================================================");
        System.out.println("FINAL EXECUTION SUMMARY");
        System.out.println("================================================");

        System.out.println("Total Tests : "+ (passed + failed + skipped));

        System.out.println("Passed      : "+ passed);

        System.out.println("Failed      : "+ failed);

        System.out.println("Skipped     : "+ skipped);

        System.out.println("Execution Time : "+ minutes + "m "+ seconds + "s");

        System.out.println("================================================");

        ExtentManager.getInstance().flush();
        logger.info("Execution Completed");
    }
}