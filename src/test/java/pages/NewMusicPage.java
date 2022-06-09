package pages;

import data.Urls;
import org.openqa.selenium.WebDriver;

public class NewMusicPage extends BasePage {

    public NewMusicPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public BasePage goToPage() {
        driver.get(Urls.newMusicPage);
        return this;
    }
}
