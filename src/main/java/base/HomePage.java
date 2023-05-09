package base;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.List;

public class HomePage extends BasePage{

    public HomePage() {
        super();
    }

    @FindBy(how = How.XPATH, using = "//span[text()='Admin']")
    private WebElement funcAdmin;

    @FindBy(how = How.XPATH, using = "//button[text()=' Add ']")
    private WebElement btnAddUser;

    @FindBy(how = How.XPATH, using = "//label[text()='User Role']/parent::div/following-sibling::div/descendant::i")
    private WebElement selectUserRole;

    @FindBy(how = How.XPATH, using = "//div[@role='listbox']/div")
    private List<WebElement> selectFromDropdown;

    @FindBy(how = How.XPATH, using = "//input[@placeholder='Type for hints...']")
    private WebElement txtEmployeeName;

    @FindBy(how = How.XPATH, using = "//label[text()='Status']/parent::div/following-sibling::div/descendant::i")
    private WebElement selectStatus;

    @FindBy(how = How.XPATH, using = "//label[text()='Username']/parent::div/following-sibling::div/input")
    private WebElement txtCreateUsername;

    @FindBy(how = How.XPATH, using = "//label[text()='Password']/parent::div/following-sibling::div/input")
    private WebElement txtCreatePassword;

    @FindBy(how = How.XPATH, using = "//label[text()='Confirm Password']/parent::div/following-sibling::div/input")
    private WebElement txtConfirmPassword;

    @FindBy(how = How.XPATH, using = "//button[text()=' Save ']")
    private WebElement btnSave;

    @FindBy(how = How.XPATH, using = "//div[contains(text(),'employ')]/following-sibling::div")
    private List<WebElement> employeeNames;

    public WebElement getFuncAdmin() {
        return funcAdmin;
    }

    public void clickAdmin() {
        funcAdmin.click();
    }

    public WebElement getBtnAddUser() {
        return btnAddUser;
    }

    public void setBtnAddUser() {
        btnAddUser.click();
    }

    ////div[contains(text(),'employ')]/following-sibling::div

    public void addUser(String inputRole, String employeeName, String inputStatus,
                        String createUserName, String password) throws InterruptedException {
        selectUserRole.click();
        getFromDropdown(selectFromDropdown, inputRole);
        txtEmployeeName.sendKeys(employeeName);
        Thread.sleep(5000);
        getFromDropdown(selectFromDropdown, employeeName);
        selectStatus.click();
        getFromDropdown(selectFromDropdown, inputStatus);
        txtCreateUsername.sendKeys(createUserName);
        txtCreatePassword.sendKeys(password);
        txtConfirmPassword.sendKeys(password);
        btnSave.submit();
    }

    public void getFromDropdown(List<WebElement> elementList, String input) {
        for (WebElement element : elementList) {
            if (element.getText().trim().contains(input)) {
                element.click();
                break;
            }
        }
    }


}
