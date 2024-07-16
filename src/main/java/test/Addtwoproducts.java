package test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.ExtentFactory;
import pages.*;

public class Addtwoproducts {

   private WebDriver dv;
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

    static ExtentReports report;
    public static ExtentTest test;
    static ExtentReports extent = new ExtentReports();

    @BeforeMethod
    public void beforeMethod() {

        extent.attachReporter(ExtentFactory.getInstance());
        test = extent.createTest(nameTest,description);

        ChromeOptions options = new ChromeOptions();
//		options.addArguments("--headless=new");
        options.addArguments("ignore-certificate-errors");
        options.addArguments("--remote-allow-origins=*");
        dv = new ChromeDriver(options);
        homepage = new Home(dv,test);
        viewCart = new ViewCart(dv,test);
        checkoutpage = new Checkout(dv, test);
//        dv = homepage.chromeDriverConnecction();
        dv.manage().window().maximize();

    }

    @Test
    public void testAddTwoProducts() throws Exception {
        homepage.gotoHome();
        JavascriptExecutor js = (JavascriptExecutor) dv;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        homepage.macIsDisplay();
        homepage.clickFirstProduct();
        homepage.clickTitle();
        homepage.printOut();
//        JavascriptExecutor js2 = (JavascriptExecutor) dv;
//        js2.executeScript("window.scrollTo(0, document.body.scrollHeight)");
//        homepage.clickSecondProduct();
//        JavascriptExecutor js1 = (JavascriptExecutor) dv;
//        js1.executeScript("window.scrollTo(0, 0)");

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
        String verifyOrderText= "Your order has been placed!";
        checkoutpage.verify(verifyOrderText);
    }

    @AfterMethod
    public void tearDown(ITestResult result)  {

        if(ITestResult.FAILURE==result.getStatus())
        {
            test.log(Status.FAIL, nameTest);
            System.out.println("Error in: " + result.getMethod().getMethodName());

        } else {
            System.out.println("Successful: " + result.getMethod().getMethodName());
        }
        dv.quit();
        extent.flush();
    }
}