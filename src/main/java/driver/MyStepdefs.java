package driver;

import base.HomePage;
import base.LoginPage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java8.En;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;

import java.util.List;
import java.util.Map;

import static base.Base.driverContext;
import static base.ConfigProperties.*;

public class MyStepdefs implements En {

    LoginPage loginPage;
    HomePage homePage;

    private static final Logger logger = LogManager.getLogger(MyStepdefs.class.getName());

    public MyStepdefs() {

        Given("^I am on Orange HRM login page$", () -> {
            logger.info("Started launching URL");
            System.out.println("URL is: " + URL);
            driverContext.get(URL);
        });

        When("^I enter login credentials$", () -> {
            logger.info("Entering Credentials");
            loginPage = new LoginPage();
            System.out.println(loginPage.getTxtUsername().getText());
            loginPage.setTxtUsername(USERNAME);
            loginPage.setTxtPassword(PASSWORD);
            logger.info("Credentials Entered");
        });

        And("^I click on \"([^\"]*)\" button on \"([^\"]*)\" page$", (String buttonName, String pageName) -> {
            if ("Login".equals(pageName)) {
                switch (buttonName) {
                    case "Submit":
                        loginPage.clickSubmitButton();
                        break;
                    default:
                        throw new IllegalArgumentException("Button not available or supported");
                }
            } else if ("Home".equals(pageName)) {
                switch (buttonName) {
                    case "Admin":
                        homePage.clickAdmin();
                        break;
                    case "Add":
                        homePage.setBtnAddUser();
                        break;
                    default:
                        throw new IllegalArgumentException("Button not available or supported");
                }
            } else {
                throw new IllegalArgumentException("Page not supported");
            }
            logger.info("button..."+buttonName+"...visible on ...."+pageName+ " page");
        });


        And("^I enter user details as below$", (DataTable dataTable) -> {
            List<Map<String, String>> dataMap = dataTable.asMaps();
            homePage.addUser(dataMap.get(0).get("Role"), dataMap.get(0).get("Name"), dataMap.get(0).get("Status"),
                    dataMap.get(0).get("Username"), dataMap.get(0).get("Password"));
            logger.info("User details entered");
            Thread.sleep(10000);
        });

        Then("^I should see HomePage of Orange HRM$", () -> {
            homePage = new HomePage();
            Assert.assertEquals("Not on Home Page", homePage.getFuncAdmin().getText(), "Admin");
            logger.info("Home Page visible");
        });
    }

}
