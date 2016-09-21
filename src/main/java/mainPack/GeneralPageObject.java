package mainPack;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.concurrent.TimeUnit;


public abstract class GeneralPageObject {
    protected final WebDriver driver;
    protected Logger log;

    protected GeneralPageObject(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        log = Logger.getLogger(getClass());
    }

    protected void openBrowserAndOpenPage() {
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
    //general web elements
    @FindBy(xpath = ".//span[contains(text(), 'заполните обязательные поля' )]")
    protected List<WebElement> quantityOfErrorMessages;

}
