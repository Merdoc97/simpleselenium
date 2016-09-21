package mainPack;


import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.concurrent.TimeUnit;


public class OrderPage {
    private WebDriver driver;
    private Logger log;

    @FindBy(name = "menu-11")
    private WebElement ddMenuKurs;

    @FindBy(name = "your-name")
    private WebElement inputSurname;

    @FindBy(xpath = ".//*[@class='wpcf7-form-control-wrap text-68']/input")
    private WebElement inputName;

    @FindBy(xpath = ".//*[@class='wpcf7-form-control-wrap text-297']/input")
    private WebElement inputPhone;

    @FindBy(name = "your-email")
    private WebElement inputEmail;

    @FindBy(xpath = ".//*[@class='wpcf7-form-control-wrap text-71']/input")
    private WebElement inputSkype;

    @FindBy(id = "comment")
    private WebElement inputComment;

    @FindBy(xpath = ".//*[@type='submit']")
    private WebElement buttonBuy;

    @FindBy(xpath = ".//*[@value='Очистить']")
    private WebElement buttonClean;

    @FindBy(xpath = ".//*[contains(text(), 'Ваше сообщение было отправлено успешно')]")
    private WebElement messageSuccessSending;

    @FindBy(xpath = "count(.//span[contains(text(),'заполните обязательные поля')])")
    private WebElement qtyErrorMessages;

    public OrderPage(WebDriver driver) {
        this.driver = driver;
        log = Logger.getLogger(getClass());
        PageFactory.initElements(driver, this);
    }

    public void openBrowserAndOpenPage() {

        try {
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
            driver.get("http://old.qalight.com/zapisatsya-na-kurs/");
            log.info("Browser and OrderPage were opened");

        } catch (Exception e) {
            log.error("Can`t work with Browser or OrderPage");
            Assert.fail("Can`t work with Browser or OrderPage");
        }
    }

    public void selectKursFromDropDown(String textKurs) {
        try {
            Select valuesFromDD = new Select(ddMenuKurs);
            valuesFromDD.selectByVisibleText(textKurs);
            log.info(textKurs + " was selected from DropDown KursMenu");
        } catch (Exception e) {
            log.error("Can`t work with DropDown");
            Assert.fail("Can`t work with DropDown");
        }
    }

    public OrderPage inputTextIntoSurnameField(String textSurname) {
        inputSurname.clear();
        inputSurname.sendKeys(textSurname);
        log.info(textSurname + " was entered");
        return this;
    }

    public OrderPage inputTextIntoNameField(String textName) {
        inputName.clear();
        inputName.sendKeys(textName);
        log.info(textName + " was entered");
        return this;
    }

    public OrderPage inputTextIntoPhoneField(String textPhone) {
        inputPhone.clear();
        inputPhone.sendKeys(textPhone);
        log.info(textPhone + " was entered");
        return this;
    }

    public OrderPage inputTextIntoEmailField(String textEmail) {
        inputEmail.clear();
        inputEmail.sendKeys(textEmail);
        log.info(textEmail + " was entered");
        return this;
    }

    public OrderPage inputTextIntoSkypeField(String textSkype) {
        inputSkype.clear();
        inputSkype.sendKeys(textSkype);
        log.info(textSkype + " was entered");
        return this;
    }

    public OrderPage inputTextIntoCommentField(String textComment) {
        inputComment.clear();
        inputComment.sendKeys(textComment);
        log.info(textComment + " was entered");
        return this;
    }

    public void clickButtonBuy() {
        buttonBuy.click();
        log.info("Button Kupit` was clicked");
    }

    public void closeOrderPageAndBrowser() {
        driver.quit();
        log.info("Browser and OrderPage were closed");
    }

    public boolean isOrderPageLoad() {
        try {
            boolean isElementPresent = inputSurname.isDisplayed();
            return isElementPresent;
        } catch (NoSuchElementException e) {
            log.info("No such element");
            return false;
        }
    }

    public boolean isOrderSent() {
        try {
            boolean isElementPresent = messageSuccessSending.isDisplayed();
            return isElementPresent;
        } catch (NoSuchElementException e) {
            log.info("No such element");
            return false;
        }
    }

    public int quantityOfErrorMessages() {
        try {
            List<WebElement> elementList = driver.findElements(By.xpath(".//span[contains(text(), 'заполните обязательные поля' )]"));
            log.info("Quantity of errors is " + elementList.size());
            return elementList.size();
        } catch (Exception e) {
            log.info("Not all errors");
            return 0;
        }
    }
}