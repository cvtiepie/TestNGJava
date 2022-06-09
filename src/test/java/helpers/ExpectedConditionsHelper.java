package helpers;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Optional;

import static tests.BaseTest.driver;

public class ExpectedConditionsHelper {

    public void waitForElementPresence(By element, Optional<Integer> optionalTimeout) {
        int timeout = optionalTimeout.orElse(10);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
        wait.until(ExpectedConditions.presenceOfElementLocated(element));
    }

    public void waitForElementVisibility(By element, Optional<Integer> optionalTimeout) {
        int timeout = optionalTimeout.orElse(10);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
        wait.until(ExpectedConditions.visibilityOfElementLocated(element));
    }


}
