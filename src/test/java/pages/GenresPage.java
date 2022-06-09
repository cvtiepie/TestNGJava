package pages;

import data.Urls;
import org.openqa.selenium.WebDriver;

public class GenresPage extends BasePage {
    public GenresPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public GenresPage goToPage() {
        driver.get(Urls.genresPage);
        return this;
    }
}
