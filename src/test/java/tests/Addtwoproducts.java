package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import base.BaseTest;

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
        checkoutpage.setName(firstName);
        checkoutpage.setLastName(lastName);
        checkoutpage.setEmail(email);
        checkoutpage.setPhone(phone);
        checkoutpage.setAddress(address);
        checkoutpage.setCity(city);
        checkoutpage.setPost(postCode);
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