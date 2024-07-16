package pages;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import test.Base;


import java.time.Duration;
import java.util.List;

public class Checkout extends Base {
    public Checkout (WebDriver dv, ExtentTest test) {
        super(dv);
        Base.test = test;
    }
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
    By continuarBtn = By.id("button-guest");
    By acceptCond = By.xpath("//input[@name='agree']");
    By nextPayment = By.id("button-payment-method");
    By confirmOrder = By.id("button-confirm");

    public void clickonCheckout() throws InterruptedException {
        click(checkout);
        Thread.sleep(1000);
        test.log(Status.PASS, "Click en Chechout ");
    }
    public void clickonGuest() throws InterruptedException {
        click(guest);
        Thread.sleep(1000);
        test.log(Status.PASS, "Click en Guest ");
    }
    public void clickonContinuar() throws InterruptedException {
        click(next);
        Thread.sleep(3000);
        test.log(Status.PASS, "Click en Continuar ");
    }
    public void setName(String name) throws InterruptedException {
        type(name,nameKey);
        Thread.sleep(1000);
        test.log(Status.PASS, "Agregar Nombre ");
    }
    public void setLastName(String lastName) throws InterruptedException {
        type(lastName,lastNameGiven);
        Thread.sleep(1000);
        test.log(Status.PASS, "Agregar Nombre ");
    }
    public void setEmail(String email) throws InterruptedException {
        type(email,emailLocator);
        Thread.sleep(1000);
        test.log(Status.PASS, "Agregar email ");
    }
    public void setPhone(String phone) throws InterruptedException {
        type(phone,phoneLocator);
        Thread.sleep(1000);
        test.log(Status.PASS,"Agregar telefono ");
    }
    public void setAddress(String address) throws InterruptedException {
        type(address,addressLocator);
        Thread.sleep(1000);
        test.log(Status.PASS, "Agregar direccion ");
    }
    public void setCity(String city) throws InterruptedException {
        type(city,cityLocator);
        Thread.sleep(1000);
        test.log(Status.PASS, "Agregar ciudad ");
    }
    public void setPost(String postCode) throws InterruptedException {
        type(postCode,postLocator);
        Thread.sleep(1000);
        test.log(Status.PASS, "Agregar codigo postal");
    }
    public void setCountry() throws InterruptedException {
        click(clickCountry);
        Thread.sleep(1000);
        WebElement dropdownList = findElement(clickCountry);
        List<WebElement> listItems = dropdownList.findElements(By.tagName("option"));
        for (int i = 1; i < listItems.size(); i++) {
            WebElement item = listItems.get(i);
            String itemText = item.getText();
            System.out.println("This is the list "+ i +" Country: " + itemText);
        }
        click(selectAny);
        Thread.sleep(1000);
        test.log(Status.PASS, "Agregar pais");
    }

    public void setState() throws InterruptedException {
        click(clickZone);
        Thread.sleep(1000);
        click(selectZone);
        Thread.sleep(1000);
        test.log(Status.PASS, "Agregar estado");
    }

    public void clickonContinuarCheckout() throws InterruptedException {
        click(continuarBtn);
        Thread.sleep(1000);
        test.log(Status.PASS, "Click en Continuar");
    }

    public void acceptConditions() throws InterruptedException{
        click(acceptCond);
        Thread.sleep(1000);
        test.log(Status.PASS, "Click en Aceptar Condiciones");
    }

    public void clickonNextStepPayment() throws InterruptedException{
        click(nextPayment);
        Thread.sleep(1000);
        test.log(Status.PASS, "Click en Continuar siguiente");
    }

    public void confirmOrder() throws InterruptedException{
        click(confirmOrder);
        Thread.sleep(1000);
        test.log(Status.PASS, "Click en confirmar orden");
    }

    public void verify(String text) throws InterruptedException {
        By textLocator = By.xpath("//h1[normalize-space()='"+text+"']");
        wait(textLocator);
        Thread.sleep(1000);
        WebElement errorElement1 = findElement(textLocator);
        String textValue = errorElement1.getText();
        Assert.assertEquals(text,textValue);
        test.log(Status.PASS, "Verificar texto: "+text);
    }


}
