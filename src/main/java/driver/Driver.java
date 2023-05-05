package driver;

import base.HomePage;
import base.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Driver {

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "E:\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        LoginPage loginPage = new LoginPage(driver);
        loginPage.clickLogin("Admin", "admin123");

        HomePage homePage = new HomePage(driver);
        homePage.addUser("Admin", "Odis", "Enabled",
                "odisAdalwin", "Xyz@12345");
        Thread.sleep(10000);
        driver.close();
    }


}
