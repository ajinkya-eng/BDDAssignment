package driver;

import base.AdminPage;
import base.HomePage;
import base.LoginPage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java8.En;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static base.Base.driverContext;
import static base.ConfigProperties.*;

public class MyStepdefs implements En {

    LoginPage loginPage;
    HomePage homePage;

    AdminPage adminPage;

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
            logger.info("button..." + buttonName + "...visible on ...." + pageName + " page");
        });


        And("^I enter user details as below$", (DataTable dataTable) -> {
            List<Map<String, String>> dataMap = dataTable.asMaps();
            homePage.addUser(dataMap.get(0).get("Role"), dataMap.get(0).get("Name"), dataMap.get(0).get("Status"),
                    dataMap.get(0).get("Username"), dataMap.get(0).get("Password"));
            logger.info("User details entered");
            Thread.sleep(15000);
        });

        Then("^I should see HomePage of Orange HRM$", () -> {
            homePage = new HomePage();
            Assert.assertEquals("Not on Home Page", homePage.getFuncAdmin().getText(), "Admin");
            logger.info("Home Page visible");
        });

        And("^I select checkbox to Delete User \"([^\"]*)\"$", (String user) -> {
            String checkboxXpath = adminPage.correspondingCheckboxXpath.replace("xyz",user);
            logger.info("Effective xpath..."+checkboxXpath);
            driverContext.findElement(By.xpath(checkboxXpath)).click();
        });

        And("^I click on Delete button for User \"([^\"]*)\"$", (String user) -> {
            String deleteXpath = adminPage.correspondingDeleteXpath.replace("xyz",user);
            logger.info("Effective xpath..."+deleteXpath);
            WebElement deleteButton = driverContext.findElement(By.xpath(deleteXpath));
            WebDriverWait wait = new WebDriverWait(driverContext, Duration.of(10, ChronoUnit.SECONDS));
            wait.until(ExpectedConditions.visibilityOf(deleteButton));
            deleteButton.click();
            WebDriverWait wait1 = new WebDriverWait(driverContext, Duration.of(10, ChronoUnit.SECONDS));
            wait1.until(ExpectedConditions.visibilityOf(adminPage.getConfirmDelete()));
            adminPage.getConfirmDelete().click();
        });

        Then("^I should see User \"([^\"]*)\" details in Records Found List$", (String user) -> {
            adminPage = new AdminPage();
            List<WebElement> usernames = adminPage.getUsernameList();
            for (WebElement username : usernames) {
                if (username.getText().equals(user)) {
                    logger.info("Username found in username list");
                    Assert.assertEquals("Username not found", username.getText(), user);
                    break;
                }
            }
        });

        Then("^I should not see User \"([^\"]*)\" details in Records found List$", (String user) -> {
            List<WebElement> usernames = adminPage.getUsernameList();
            List<String> usernameNames = usernames.stream().map(WebElement::getText).collect(Collectors.toList());
            Assert.assertTrue("Username found", !usernameNames.contains(user));
        });
    }

}
