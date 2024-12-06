package pages;
//import com.relevantcodes.extentreports.ExtentTest;
//import com.relevantcodes.extentreports.LogStatus;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import test.Base;

import java.util.List;


public class Home extends Base {
    By addCart = By.xpath("//span[contains(text(),'Add to Cart')][1]");
    By macImage = By.xpath("//img[@title='MacBook']");
    By title = By.xpath("//a[normalize-space()='Laptops & Notebooks']");

    public Home (WebDriver dv, ExtentTest test) {
        super(dv);
        Base.test = test;
    }
    public void gotoHome()  throws InterruptedException {
        visit("https://opencart.abstracta.us/index.php?route=common/home");
        Thread.sleep(1000);
        test.log(Status.PASS, "Ir a Home page");
    }
    public void clickFirstProduct()  throws InterruptedException {
        wait(addCart);
        click(addCart);
        Thread.sleep(1000);
        test.log(Status.PASS, "Click en primer producto ");
    }

    public void macIsDisplay() {
        wait(macImage);
        isDisplay(macImage);
    }

    public void clickTitle() throws InterruptedException {

        Thread.sleep(1000);

    }
    public void printOut() {
        // Find the UL element (replace with your actual locator)
        click(title);
        WebElement listLaptop = findElement(title);
        List<WebElement> listItems = listLaptop.findElements(By.tagName("li"));
        for (WebElement item : listItems) {
            String itemText = item.getText();
            System.out.println("This is what is found: "+itemText);
        }
    }

}

//    public void clickSecondProduct()  throws InterruptedException {
//        WebDriverWait wait = new WebDriverWait(dv, Duration.ofSeconds(20));
//        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[@type='button'][10]")));
//        dv.findElement(By.xpath("//button[@type='button'][10]")).click();
//        Thread.sleep(1000);
////        test.log(LogStatus.INFO, "Click en primer producto ");
//        //body//div[@id='common-home']//div[@class='row']//div[@class='row']//div[2]//div[1]//div[3]//button[1]//span[1]
//    }
