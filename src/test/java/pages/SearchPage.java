package pages;

import data.Urls;
import helpers.ExpectedConditionsHelper;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.Optional;

public class SearchPage extends BasePage {

    public SearchPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public SearchPage goToPage() {
        driver.get(Urls.mainPage);
        return this;
    }

    private final By firstItemInSearch = By.xpath("(//tr[@class = 'infobox'])[1]//a[@class = 'searchpage']");

    @Step("Check First Item In Search")
    public void checkFirstItemInSearch(String expectedItemName) {
        ExpectedConditionsHelper waitFor = new ExpectedConditionsHelper();
        waitFor.waitForElementPresence(this.firstItemInSearch, Optional.of(10));
        String actualName = driver.findElement(this.firstItemInSearch).getText();
        this.assertStrings(actualName, expectedItemName);
    }
}
