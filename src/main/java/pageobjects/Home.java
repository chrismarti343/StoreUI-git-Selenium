package pageobjects;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import base.BasePage;

import java.util.List;


public class Home extends BasePage {

    private static final String HOME_URL = "https://opencart.abstracta.us/index.php?route=common/home";

    By addCart = By.xpath("//span[contains(text(),'Add to Cart')][1]");
    By macImage = By.xpath("//img[@title='MacBook']");
    By title = By.xpath("//a[normalize-space()='Laptops & Notebooks']");
    By cartItem = By.xpath("//button[@class='btn btn-inverse btn-block btn-lg dropdown-toggle']");

    public Home (WebDriver dv, ExtentTest test) {
        //Constructor
        super(dv);
        BasePage.test = test;
    }
    public void gotoHome() {
        visit(HOME_URL);
        waitForPageLoad();
        test.log(Status.PASS, "Ir a Home page");
    }
    public void clickFirstProduct() {
        scrollToBottom();
        wait(addCart);
        click(addCart);
        waitForPageLoad();
        test.log(Status.PASS, "Click on the first product: Macbook ");
    }

    public void macIsDisplay() {
        wait(macImage);
        isDisplay(macImage);
        test.log(Status.PASS, "Wait till Mac image is display");
    }

    public void verifyTitle() {
        String actualTitle = dv.getTitle();
        String expectedTitle = "Your Store";
        Assert.assertEquals(actualTitle,expectedTitle);
        implicitWait(1);
        test.log(Status.PASS, "Verify title page is present");
    }
    public void printOut() {
        // Find elements in a list
        click(title);
        WebElement listLaptop = findElement(title);
        List<WebElement> listItems = listLaptop.findElements(By.tagName("li"));

        for (WebElement item : listItems) {
            String itemText = item.getText();
            System.out.println("List of countries: "+itemText);
        }
    }

    public void checkCartItem(){

        boolean isDisplayed = isDisplay(cartItem);

        if (!isDisplayed) {
            System.out.println("Cart Item is not displayed ");
        }else {
            System.out.println("Cart Item is displayed ");
        }
    }

    public void scrollToElement() {
        WebElement element = findElement(macImage);
        implicitWait(5);
        ((JavascriptExecutor) dv).executeScript("arguments[0].scrollIntoView()", element);
    }

    private void scrollToBottom() {
        ((JavascriptExecutor) dv).executeScript("window.scrollTo(0, document.body.scrollHeight)");
    }
}