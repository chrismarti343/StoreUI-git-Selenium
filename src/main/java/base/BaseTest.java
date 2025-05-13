package base;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeMethod;
import pageobjects.Checkout;
import pageobjects.Home;
import pageobjects.ViewCart;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import utils.ExtentFactory;

import java.io.IOException;

public class BaseTest {

    WebDriver dv;
    protected static Home homepage;
    protected static Checkout checkoutpage;
    protected static ViewCart viewCart;
    public static ExtentTest test;
    static ExtentReports extent = new ExtentReports();
    String nameTest = "Testing";
    String description = "Testing description";

    @BeforeMethod
    public void beforeMethod() {

        extent.attachReporter(ExtentFactory.getInstance());
        test = extent.createTest(nameTest,description);

        ChromeOptions options = new ChromeOptions();
//        options.addArguments("--headless=new");
        options.addArguments("ignore-certificate-errors");
        options.addArguments("--remote-allow-origins=*");
        dv = new ChromeDriver(options);
        homepage = new Home(dv,test);
        viewCart = new ViewCart(dv,test);
        checkoutpage = new Checkout(dv, test);
        dv.manage().window().maximize();

    }

    @AfterMethod
    public void tearDown(ITestResult result) throws IOException {

        if(ITestResult.FAILURE==result.getStatus())
        {
            test.log(Status.FAIL,result.getMethod().getMethodName());
            String temp = ExtentFactory.getScreenshot(dv);
            System.out.println("Image Path: "+temp);
            test.log(Status.INFO,result.getThrowable().getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(temp).build());
            System.out.println("Error in: " + result.getMethod().getMethodName());

        } else {
            System.out.println("Successful: " + result.getMethod().getMethodName());
        }
        dv.quit();
        extent.flush();
    }
}
