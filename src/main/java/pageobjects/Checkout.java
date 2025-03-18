package pageobjects;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import base.BasePage;


import java.util.List;

public class Checkout extends BasePage {

    By checkout = By.xpath("//a[@class='btn btn-primary']");
    By guest = By.xpath("//input[@value='guest']");
    By next = By.xpath("//input[@id='button-account']");
    By nameKey = By.id("input-payment-firstname");
    By lastNameGiven = By.id("input-payment-lastname");
    By emailLocator = By.id("input-payment-email");
    By phoneLocator = By.id("input-payment-telephone");
    By addressLocator = By.id("input-payment-address-1");
    By cityLocator = By.id("input-payment-city");
    By postLocator = By.id("input-payment-postcode");
    By clickCountry = By.id("input-payment-country");
    By selectAny = By.xpath("//option[@value='62']");
    By clickZone = By.id("input-payment-zone");
    By selectZone = By.xpath("//option[@value='997']");
    By nextBtn = By.id("button-guest");
    By acceptCond = By.xpath("//input[@name='agree']");
    By nextPayment = By.id("button-payment-method");
    By confirmOrder = By.id("button-confirm");

    public Checkout (WebDriver dv, ExtentTest test) {
        //Constructor
        super(dv);
        BasePage.test = test;
    }

    public void clickonCheckout() {
        click(checkout);
        implicitWait(1);
        test.log(Status.PASS, "Click en Chechout ");
    }
    public void clickonGuest() {
        click(guest);
        implicitWait(1);
        test.log(Status.PASS, "Click en Guest ");
    }
    public void clickonContinuar() {
        click(next);
        implicitWait(1);
        test.log(Status.PASS, "Click on Next ");
    }
    public void setName(String name) {
        type(name,nameKey);
        implicitWait(1);
        test.log(Status.PASS, "Add name ");
    }
    public void setLastName(String lastName) {
        type(lastName,lastNameGiven);
        implicitWait(1);
        test.log(Status.PASS, "Add lastname");
    }
    public void setEmail(String email) {
        type(email,emailLocator);
        implicitWait(1);
        test.log(Status.PASS, "Add email");
    }
    public void setPhone(String phone) {
        type(phone,phoneLocator);
        implicitWait(1);
        test.log(Status.PASS,"Add phone");
    }
    public void setAddress(String address) {
        type(address,addressLocator);
        implicitWait(1);
        test.log(Status.PASS, "Add address ");
    }
    public void setCity(String city) {
        type(city,cityLocator);
        implicitWait(1);
        test.log(Status.PASS, "Add city ");
    }
    public void setPost(String postCode) {
        type(postCode,postLocator);
        implicitWait(1);
        test.log(Status.PASS, "Add Zip Code");
    }
    public void setCountry() {
        click(clickCountry);
        implicitWait(1);
        WebElement dropdownList = findElement(clickCountry);
        List<WebElement> listItems = dropdownList.findElements(By.tagName("option"));
        for (int i = 1; i < listItems.size(); i++) {
            WebElement item = listItems.get(i);
            String itemText = item.getText();
            System.out.println("This is the list "+ i +" Country: " + itemText);
        }
        click(selectAny);
        implicitWait(1);
        test.log(Status.PASS, "Add country");
    }

    public void setState() {
        click(clickZone);
        implicitWait(1);
        click(selectZone);
        implicitWait(1);
        test.log(Status.PASS, "Add state");
    }

    public void clickonNextCheckout() {
        click(nextBtn);
        implicitWait(1);
        test.log(Status.PASS, "Click on Next");
    }

    public void acceptConditions() {
        wait(acceptCond);
        click(acceptCond);
        implicitWait(1);
        test.log(Status.PASS, "Click on Accept conditions");
    }

    public void clickonNextStepPayment() {
        click(nextPayment);
        implicitWait(1);
        test.log(Status.PASS, "Click on Next");
    }

    public void confirmOrder() {
        click(confirmOrder);
        implicitWait(1);
        test.log(Status.PASS, "Click on confirm order");
    }

    public void verify() {
        String expectedOrderText = "Your order has been placed!";
        By textLocator = By.xpath("//h1[normalize-space()='"+expectedOrderText+"']");
        wait(textLocator);
        WebElement errorElement1 = findElement(textLocator);
        String actualTextValue = errorElement1.getText();
        Assert.assertEquals(actualTextValue,expectedOrderText);
        test.log(Status.PASS, "Verify text: "+expectedOrderText);
    }
}
