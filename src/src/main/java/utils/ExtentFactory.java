package utils;


import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.maven.surefire.shared.io.FileUtils;
import org.openqa.selenium.OutputType;
import java.io.File;import java.io.IOException;

public class ExtentFactory {

    public static ExtentSparkReporter getInstance() {

        String projectPath = System.getProperty("user.dir");
        String path = projectPath + "/report/report.html";

        return new ExtentSparkReporter(path);
    }

    public static String getScreenshot(WebDriver dv) throws IOException, IOException {
        String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
        TakesScreenshot ts = (TakesScreenshot) dv;
        File source = ts.getScreenshotAs(OutputType.FILE);
        String destination = dateName + ".png";
        String destination2 = "./report/" + dateName + ".png";
        File finalDestination = new File(destination2);
        FileUtils.copyFile(source, finalDestination);
        return destination;
    }
}
