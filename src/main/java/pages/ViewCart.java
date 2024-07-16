package pages;


import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import test.Base;
public class ViewCart extends Base {
    By cart = By.xpath("//span[@id='cart-total'][1]");
    By viewCart = By.xpath("//strong[normalize-space()='View Cart']");
    public ViewCart(WebDriver dv, ExtentTest test) {
        super(dv);
        Base.test = test;
    }
    public void clickItems() throws InterruptedException {
        click(cart);
        Thread.sleep(1000);
        test.log(Status.PASS, "Click on first Item");
    }
    public void clickViewCart() throws InterruptedException {
        click(viewCart);
        Thread.sleep(1000);
        test.log(Status.PASS, "Click on View Cart");
    }
}
