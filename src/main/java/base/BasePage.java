package base;

import com.aventstack.extentreports.ExtentTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class BasePage {
    private static final int DEFAULT_TIMEOUT = 10;
    protected static ExtentTest test;
    protected final WebDriver dv;

    public BasePage(WebDriver dv) {
        this.dv = dv;
    }

    public void visit(String url) {
        dv.get(url);
    }

    public WebElement findElement(By locator) {
        return dv.findElement(locator);
    }

    public void type(String inputText, By locator) {

        try {
            waitForElementVisible(locator).clear();
            waitForElementVisible(locator).sendKeys(inputText);
           
        } catch (Exception e) {
            test.fail("Failed to type text: " + e.getMessage());
            throw e;
        }
    }

    public void click(By locator) {

        try {
            waitForElementClickable(locator).click();
        } catch (Exception e) {
            test.info("Failed to click element: " + locator);
            test.fail("Failed to click element: " + e.getMessage());
            throw e;
        }
    }

    public void wait(By locator) {
        WebDriverWait wait = new WebDriverWait(dv, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    public boolean isDisplay(By locator) {
        return dv.findElement(locator).isDisplayed();
    }

    public List<WebElement> findElements(By locator) {
        return dv.findElements(locator);
    }

    public void implicitWait(int time) {
        dv.manage().timeouts().implicitlyWait(Duration.ofSeconds(time));
    }

    public String getText(By locator) {
        return dv.findElement(locator).getText();
    }

    public void waitForPageLoad() {
        new WebDriverWait(dv, Duration.ofSeconds(10)).until(ExpectedConditions.presenceOfElementLocated(By.tagName("body")));
    }

    public WebElement waitForElementVisible(By locator) {
        WebDriverWait wait = new WebDriverWait(dv, Duration.ofSeconds(DEFAULT_TIMEOUT));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public WebElement waitForElementClickable(By locator) {
        WebDriverWait wait = new WebDriverWait(dv, Duration.ofSeconds(DEFAULT_TIMEOUT));
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    //adding some comments

}