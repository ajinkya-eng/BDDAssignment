package base;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LoginPage extends BasePage {

    public LoginPage() {
        super();
    }

    @FindBy(how = How.NAME, using = "username")
    private WebElement txtUsername;

    @FindBy(how = How.NAME, using = "password")
    private WebElement txtPassword;

    @FindBy(how = How.XPATH, using = "//button[@type='submit']")
    private WebElement btnSubmit;


    public WebElement getTxtUsername() {
        return txtUsername;
    }

    public void setTxtUsername(String username) {
        txtUsername.sendKeys(username);
    }

    public WebElement getTxtPassword() {
        return txtPassword;
    }

    public void setTxtPassword(String password) {
        txtPassword.sendKeys(password);
    }

    public WebElement getBtnSubmit() {
        return btnSubmit;
    }

    public void clickSubmitButton() {
        btnSubmit.click();
    }

    public void performLogin(String username, String password) {
        txtUsername.sendKeys(username);
        txtPassword.sendKeys(password);
        btnSubmit.submit();
    }

}
