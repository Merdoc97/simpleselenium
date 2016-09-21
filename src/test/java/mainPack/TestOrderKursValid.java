package mainPack;


import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestOrderKursValid {

    private OrderPage orderPage;

    @Before
    public void setUp() {
        orderPage = new OrderPage(new FirefoxDriver());
        orderPage.openBrowserAndOpenPage();
    }

    @After
    public void tearDown() {
        orderPage.closeOrderPageAndBrowser();
    }

    @Test
    public void testOrderKursValid() {
        Assert.assertTrue("OrderPage was not Loaded", orderPage.isOrderPageLoad());
        orderPage.selectKursFromDropDown("PL/SQL");
        orderPage.inputTextIntoSurnameField("qa-test").inputTextIntoNameField("qa-test").inputTextIntoPhoneField("11111")
                .inputTextIntoEmailField("test@te.st").inputTextIntoSkypeField("test").inputTextIntoCommentField("test")
                .clickButtonBuy();
        Assert.assertTrue("Order was not sent", orderPage.isOrderSent());
    }

}


