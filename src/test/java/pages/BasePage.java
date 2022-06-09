package pages;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public abstract class BasePage {

    protected WebDriver driver;

    public BasePage (WebDriver driver) {
        this.driver = driver;
    }

    public abstract BasePage goToPage();

    public void assertStrings(String actualResult, String expectedResult) {
        Assert.assertEquals(actualResult, expectedResult);
    }

    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }
}
