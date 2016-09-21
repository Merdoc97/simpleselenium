package mainPack;


import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestOrderKursValid {
    WebDriver driver = new FirefoxDriver();
    OrderPage orderPage = new OrderPage(driver);


    @Before
    public void setUp() {

    }

    @Test
    public void testOrderKursValid() {
        orderPage.openBrowserAndOpenPage();
        Assert.assertTrue("OrderPage was not Loaded", orderPage.isOrderPageLoad());
        orderPage.selectKursFromDropDown("PL/SQL");
        orderPage.inputTextIntoSurnameField("qa-test").inputTextIntoNameField("qa-test").inputTextIntoPhoneField("11111")
                .inputTextIntoEmailField("test@te.st").inputTextIntoSkypeField("test").inputTextIntoCommentField("test")
                .clickButtonBuy();
        Assert.assertTrue("Order was not sent", orderPage.isOrderSent());
    }

    @After
    public void tearDown() {
        orderPage.closeOrderPageAndBrowser();
    }
}


