package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import base.BaseTest;
import org.openqa.selenium.By;

public class Addtwoproducts extends BaseTest {
    String firstName = "Guest";
    String lastName = "Checkout";
    String email = "testing@gmail.com";
    String phone = "0923456783";
    String address = "Simon Bolivar #4";
    String city = "Quito";
    String postCode = "189503";

    @Test
    public void testAddTwoProducts() throws Exception {

        homepage.gotoHome();
        homepage.verifyTitle();
        homepage.checkCartItem();
        homepage.macIsDisplay();
        homepage.clickFirstProduct();
        homepage.verifyTitle();
        homepage.printOut();
        homepage.scrollToElement();
        viewCart.clickItems();
        String actualSubtotal = viewCart.verifyValue();
        Assert.assertEquals(actualSubtotal,"$500.00");
        viewCart.clickViewCart();
        checkoutpage.clickonCheckout();
        checkoutpage.clickonGuest();
        checkoutpage.clickonContinuar();

        String[] personalInfo = {firstName, lastName, email, phone, address, city, postCode};
        By[] personalInfoFields = {checkoutpage.nameKey, checkoutpage.lastNameGiven, checkoutpage.emailLocator, checkoutpage.phoneLocator, checkoutpage.addressLocator, checkoutpage.cityLocator, checkoutpage.postLocator};

        for (int i = 0; i < personalInfo.length; i++) {
            checkoutpage.setInfo(personalInfoFields[i], personalInfo[i]);
        }

        checkoutpage.setCountry();
        checkoutpage.setState();
        checkoutpage.clickonNextCheckout();
        Thread.sleep(2000);
        checkoutpage.acceptConditions();
        checkoutpage.clickonNextStepPayment();
        checkoutpage.confirmOrder();
        checkoutpage.verify();
    }

}