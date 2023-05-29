package utilities;

import base.Base;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.time.temporal.ChronoUnit;

public class SeleniumUtilities extends Base {

    public SeleniumUtilities() {
        PageFactory.initElements(driverContext, this);
    }

    private WebDriverWait webDriverWait;

    public void waitTillElementVisible(WebElement element, int seconds) {
        webDriverWait = new WebDriverWait(driverContext, Duration.of(seconds, ChronoUnit.SECONDS));
        webDriverWait.until(ExpectedConditions.visibilityOf(element));
    }

}
