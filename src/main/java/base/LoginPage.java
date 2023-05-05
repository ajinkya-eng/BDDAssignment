package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    public LoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(how = How.NAME, using = "username")
    private WebElement txtUsername;

    @FindBy(how = How.NAME, using = "password")
    private WebElement txtPassword;

    @FindBy(how = How.XPATH, using = "//button[@type='submit']")
    private WebElement btnSubmit;

    public void clickLogin(String username, String password){
        txtUsername.sendKeys(username);
        txtPassword.sendKeys(password);
        btnSubmit.submit();
    }

}
