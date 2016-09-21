package mainPack;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestOrderKursEmptyFields {
    private WebDriver driver;
    private OrderPage orderPage;


    @Before
    public void setUp() {
        driver = new FirefoxDriver();
        orderPage = new OrderPage(driver);
    }

    @After
    public void tearDown() {
        orderPage.closeOrderPageAndBrowser();
    }

    @Test
    public void testOrderKursValid() {
        orderPage.openBrowserAndOpenPage();
        Assert.assertTrue("OrderPage was not Loaded", orderPage.isOrderPageLoad());
        orderPage.inputTextIntoSurnameField("").inputTextIntoNameField("").inputTextIntoPhoneField("")
                .inputTextIntoEmailField("").inputTextIntoSkypeField("").inputTextIntoCommentField("")
                .clickButtonBuy();
        Assert.assertEquals("checks how many errors on the page", 6, orderPage.quantityOfErrorMessages());
        //Todo маркер используется вместо простого маркера, тогда перед каждым коммитом будет видно что необходимо сделать.
        // нужен ассерт, чтобы тест падал, если кол-во ошибок меньше ожидаемого
    }

}


