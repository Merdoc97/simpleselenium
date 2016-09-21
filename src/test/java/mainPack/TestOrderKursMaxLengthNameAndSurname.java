package mainPack;


import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.Arrays;
import java.util.Collection;


    @RunWith(value = Parameterized.class)
    public class TestOrderKursMaxLengthNameAndSurname {
        WebDriver driver = new FirefoxDriver();
        OrderPage orderPage = new OrderPage(driver);
        String textSurname;
        String textName;


        public TestOrderKursMaxLengthNameAndSurname(String textSurname, String textName) {
            this.textSurname = textSurname;
            this.textName = textName;
        }
        @Parameterized.Parameters
        public static Collection testData() {
            return Arrays.asList(new Object[][]{
                    {"Первыйтестфамилияяяя", "Первыйтестимяяяяяяяя"},
                    {"Второйтестфамилияяяя", "ИмяТест"},
                    {"фаМилия", "Третийтестимяяяяяяяя"}

            });
        }


    @Before
    public void setUp() {

    }

    @Test
    public void testOrderKursValid() {
        orderPage.openBrowserAndOpenPage();
        Assert.assertTrue("OrderPage was not Loaded", orderPage.isOrderPageLoad());
        orderPage.selectKursFromDropDown("PL/SQL");
        orderPage.inputTextIntoSurnameField(textSurname).inputTextIntoNameField(textName).inputTextIntoPhoneField("11111")
                .inputTextIntoEmailField("test@te.st").inputTextIntoSkypeField("test").inputTextIntoCommentField("test")
                .clickButtonBuy();
        Assert.assertTrue("Order was not sent", orderPage.isOrderSent());
    }

    @After
    public void tearDown() {
        orderPage.closeOrderPageAndBrowser();
    }
}


