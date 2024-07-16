package utils;


import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentFactory {

    static ExtentReports extent = new ExtentReports();
    public static ExtentSparkReporter getInstance() {

        String projectPath = System.getProperty("user.dir");
        String path = projectPath + "/reporte/reporte.html";

        return new ExtentSparkReporter(path);
    }
}
