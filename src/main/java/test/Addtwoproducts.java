package test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.ExtentFactory;
import pageobjects.*;

import java.io.IOException;

public class Addtwoproducts {

    WebDriver dv;

    String nameTest = "Testing";
    String description = "Testing description";
    Home homepage;
    Checkout checkoutpage;
    ViewCart viewCart;
    String firstName = "Guest";
    String lastName = "Checkout";
    String email = "testing@gmail.com";
    String phone = "0923456783";
    String address = "Simon Bolivar #4";
    String city = "Quito";
    String postCode = "189503";

    public static ExtentTest test;
    static ExtentReports extent = new ExtentReports();

    @BeforeMethod
    public void beforeMethod() {

        extent.attachReporter(ExtentFactory.getInstance());
        test = extent.createTest(nameTest,description);

        ChromeOptions options = new ChromeOptions();
		options.addArguments("--headless=new");
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

    @Test
    public void testAddTwoProducts() throws Exception {

        homepage.gotoHome();

        homepage.verifyTitle();
        homepage.checkCartItem();
        homepage.macIsDisplay();
//        homepage.clickFirstProduct();
        homepage.verifyTitle();
        homepage.printOut();

        viewCart.clickItems();
        viewCart.clickViewCart();

        checkoutpage.clickonCheckout();
        checkoutpage.clickonGuest();
        checkoutpage.clickonContinuar();
        checkoutpage.setName(firstName);
        checkoutpage.setLastName(lastName);
        checkoutpage.setEmail(email);
        checkoutpage.setPhone(phone);
        checkoutpage.setAddress(address);
        checkoutpage.setCity(city);
        checkoutpage.setPost(postCode);
        checkoutpage.setCountry();
        checkoutpage.setState();
        checkoutpage.clickonContinuarCheckout();
        checkoutpage.acceptConditions();
        checkoutpage.clickonNextStepPayment();
        checkoutpage.confirmOrder();
        checkoutpage.verify();
    }

}