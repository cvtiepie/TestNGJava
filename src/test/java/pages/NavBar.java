package pages;

import helpers.ExpectedConditionsHelper;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import java.util.Optional;

import static tests.BaseTest.driver;

public class NavBar {

    private final By SearchInput = By.xpath("//input[@aria-label = 'Search']");
    private final By NewMusicButton = By.xpath("//a[@class = 'header_item' and (contains(text(), 'new music'))]");

    private final By GenresButton = By.xpath("//a[@class = 'header_item' and (contains(text(), 'genres'))]");
    private final By ChartsButton = By.xpath("//a[contains(@class, 'header_item') and (contains(text(), 'charts'))]");
    private final By ListsButton = By.xpath("//a[@class = 'header_item' and (contains(text(), 'lists'))]");

    private final ExpectedConditionsHelper waitFor = new ExpectedConditionsHelper();

    @Step("Search for Item")
    public SearchPage searchItem(String itemName) {
        waitFor.waitForElementPresence(this.SearchInput, Optional.of(10));
        driver.findElement(SearchInput).sendKeys(itemName);
        driver.findElement(SearchInput).sendKeys(Keys.ENTER);
        return new SearchPage(driver);
    }

    @Step("Open New Music Page")
    public NewMusicPage openNewMusicPage() {
        waitFor.waitForElementPresence(this.NewMusicButton, Optional.of(10));
        driver.findElement(this.NewMusicButton).click();
        return new NewMusicPage(driver);
    }

    @Step("Open Genres Page")
    public GenresPage openGenresPage() {
        waitFor.waitForElementPresence(this.GenresButton, Optional.of(10));
        driver.findElement(this.GenresButton).click();
        return new GenresPage(driver);
    }

    @Step("Open Lists Page")
    public ListsPage openListsPage() {
        waitFor.waitForElementPresence(this.ListsButton, Optional.of(10));
        driver.findElement(this.ListsButton).click();
        return new ListsPage(driver);
    }

    @Step("Open Charts Page")
    public ChartsPage openChartsPage() {
        waitFor.waitForElementPresence(this.ChartsButton, Optional.of(10));
        driver.findElement(this.ChartsButton).click();
        return new ChartsPage(driver);
    }
}
