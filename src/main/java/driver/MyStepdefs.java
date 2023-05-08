package driver;

import static base.Base.driverContext;
import base.HomePage;
import base.LoginPage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java8.En;
import org.junit.Assert;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class MyStepdefs implements En {

    LoginPage loginPage;
    HomePage homePage;
    public MyStepdefs() {

        Given("^I am on Orange HRM login page$", () -> {
            driverContext.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        });

        When("^I enter username as (.+)$", (String username) -> {
            loginPage.setTxtUsername(username);
        });


        And("^I enter password as (.+)$", (String password) -> {
            loginPage.setTxtPassword(password);
        });


        And("^I click on Submit$", () -> {
            loginPage.clickSubmitButton();
        });

        When("^I click on Admin option$", () -> {
            homePage.clickAdmin();
        });


        And("^I click on Add button$", () -> {
            homePage.setBtnAddUser();
        });


        And("^I enter user details$", () -> {
            homePage.addUser("Admin", "Odis", "Enabled",
                    "odisAdalwin", "Xyz@12345");
        });

        Then("^I should see HomePage of Orange HRM$", () -> {
            Assert.assertEquals("Not on Home Page",homePage.getFuncAdmin().getText(),"Admin");
        });
    }

    @Before
    public void setup(){
        System.setProperty("webdriver.chrome.driver", "E:\\chromedriver_win32\\chromedriver.exe");
        driverContext  = new ChromeDriver();
        driverContext.manage().window().maximize();
        driverContext.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        loginPage = new LoginPage();
        homePage = new HomePage();
    }

    @After
    public void tearDown(){
        driverContext.close();
    }



}
