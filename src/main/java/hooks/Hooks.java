package hooks;

import base.HomePage;
import base.LoginPage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.util.Properties;

import static base.Base.driverContext;
import static base.ConfigProperties.*;

public class Hooks {

    @Before
    public void setup() throws IOException {
        System.out.println("In before");
        Properties properties = new Properties();
        FileInputStream fileInputStream = new FileInputStream("src/main/resources/testData.properties");
        properties.load(fileInputStream);
        fileInputStream.close();
        CHROMEDRIVER = properties.getProperty("chromedriver");
        URL = properties.getProperty("url");
        USERNAME = properties.getProperty("username");
        PASSWORD = properties.getProperty("password");
        System.out.println("Chrome Driver: "+ CHROMEDRIVER);

        System.setProperty("webdriver.chrome.driver", CHROMEDRIVER);
        driverContext = new ChromeDriver();
        driverContext.manage().window().maximize();
        driverContext.manage().timeouts().implicitlyWait(Duration.of(20, ChronoUnit.SECONDS));
    }

    @After
    public void tearDown() {
        driverContext.close();
    }

}
