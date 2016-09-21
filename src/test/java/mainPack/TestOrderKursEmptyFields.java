package mainPack;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestOrderKursEmptyFields {
    WebDriver driver = new FirefoxDriver();
    OrderPage orderPage = new OrderPage(driver);


    @Before
    public void setUp() {

    }

    @Test
    public void testOrderKursValid() {
        orderPage.openBrowserAndOpenPage();
        Assert.assertTrue("OrderPage was not Loaded", orderPage.isOrderPageLoad());
        orderPage.inputTextIntoSurnameField("").inputTextIntoNameField("").inputTextIntoPhoneField("")
                .inputTextIntoEmailField("").inputTextIntoSkypeField("").inputTextIntoCommentField("")
                .clickButtonBuy();
        orderPage.quantityOfErrorMessages();
        // нужен ассерт, чтобы тест падал, если кол-во ошибок меньше ожидаемого
    }

    @After
    public void tearDown() {

        orderPage.closeOrderPageAndBrowser();
    }
}


