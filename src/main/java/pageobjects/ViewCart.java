package pageobjects;


import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import base.BasePage;

public class ViewCart extends BasePage {

    By cart = By.xpath("//span[@id='cart-total'][1]");
    By viewCart = By.xpath("//strong[normalize-space()='View Cart']");
    By subTotal = By.xpath("//table[@class='table table-bordered']//td[@class='text-right'][2]");

    public ViewCart(WebDriver dv, ExtentTest test) {
        //Constructor
        super(dv);
        BasePage.test = test;
    }
    public void clickItems() {
        click(cart);
        implicitWait(1);
        test.log(Status.PASS, "Click on first Item");
    }
    public void clickViewCart() {
        click(viewCart);
        implicitWait(1);
        test.log(Status.PASS, "Click on View Cart");
    }

    public String verifyValue(){
        String actualSubtotal = getText(subTotal);
        System.out.println("Looking for this value: "+actualSubtotal);
        return actualSubtotal;
    }
}
