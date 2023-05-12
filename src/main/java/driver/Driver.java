package driver;

import base.Base;
import base.HomePage;
import base.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;
import static base.Base.driverContext;

public class Driver {

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "E:\\chromedriver_win32\\chromedriver.exe");
        driverContext  = new ChromeDriver();

        driverContext.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        driverContext.manage().window().maximize();
        driverContext.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        LoginPage loginPage = new LoginPage();
        loginPage.performLogin("Admin", "admin123");

        HomePage homePage = new HomePage();
        homePage.addUser("Admin", "Odis", "Enabled",
                "odisAdalwin", "Xyz@12345");
        Thread.sleep(10000);
        driverContext.close();
    }


}
