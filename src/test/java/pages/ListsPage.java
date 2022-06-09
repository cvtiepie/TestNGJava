package pages;

import data.Urls;
import org.openqa.selenium.WebDriver;

public class ListsPage extends BasePage {
    public ListsPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public ListsPage goToPage() {
        driver.get(Urls.genresPage);
        return this;
    }
}
