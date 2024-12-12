package pageobjects;


import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.Base;
public class ViewCart extends Base {

    By cart = By.xpath("//span[@id='cart-total'][1]");
    By viewCart = By.xpath("//strong[normalize-space()='View Cart']");

    public ViewCart(WebDriver dv, ExtentTest test) {
        //Constructor
        super(dv);
        Base.test = test;
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
}
