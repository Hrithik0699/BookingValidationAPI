package utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
//import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ReportManager {

    private static ExtentReports extent;
    private static ExtentHtmlReporter htmlReporter;

    public static void initializeReport() {
        String reportPath = System.getProperty("user.dir") + "/test-output/extent-report.html";
        htmlReporter = new ExtentHtmlReporter(reportPath);
        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);

        // Customize report settings
        htmlReporter.config().setDocumentTitle("API Test Automation Report");
        htmlReporter.config().setReportName("API Test Automation Report");
//        htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);
        htmlReporter.config().setTheme(Theme.STANDARD);
    }

    public static ExtentReports getExtentReport() {
        if (extent == null) {
            initializeReport();
        }
        return extent;
    }
}

