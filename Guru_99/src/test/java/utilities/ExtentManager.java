package utilities;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentManager {

    private static ExtentReports extent;

    public static ExtentReports getInstance() {

        if (extent == null) {

            String timestamp =new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());

            String reportPath =System.getProperty("user.dir")+ "/reports/ExtentReport_"+ timestamp + ".html";

            ExtentSparkReporter spark =new ExtentSparkReporter(reportPath);

            spark.config().setDocumentTitle("Guru99 Banking Automation");

            spark.config().setReportName("Automation Execution Report");

            extent = new ExtentReports();

            extent.attachReporter(spark);

            extent.setSystemInfo("Project","Guru99 Banking");

            extent.setSystemInfo("Tester","DEV");

            extent.setSystemInfo("Environment","QA");
        }

        return extent;
    }
}