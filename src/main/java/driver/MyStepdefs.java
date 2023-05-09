package driver;

import static base.Base.driverContext;
import base.HomePage;
import base.LoginPage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java8.En;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class MyStepdefs implements En {

    LoginPage loginPage;
    HomePage homePage;

    private static final Logger logger = LogManager.getLogger(MyStepdefs.class.getName());
    public MyStepdefs() {

        Given("^I am on Orange HRM login page$", () -> {
            logger.info("Started launching URL");
            driverContext.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        });

        When("^I enter username as (.+)$", (String username) -> {
            logger.info("Entering Username");
            loginPage.setTxtUsername(username);
            logger.info("Username Entered");
        });


        And("^I enter password as (.+)$", (String password) -> {
            logger.info("Entering password");
            loginPage.setTxtPassword(password);
        });


        And("^I click on Submit$", () -> {
            loginPage.clickSubmitButton();
            logger.info("Clicked on Submit button ... on Login Page");
        });

        When("^I click on Admin option$", () -> {
            homePage.clickAdmin();
            logger.info("Clicking on Admin option");
        });


        And("^I click on Add button$", () -> {
            homePage.setBtnAddUser();
            logger.info("Clicking on Add button");
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
