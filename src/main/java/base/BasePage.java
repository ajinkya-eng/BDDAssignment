package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class BasePage extends Base {

    public BasePage() {
        PageFactory.initElements(driverContext, this);
    }

}
