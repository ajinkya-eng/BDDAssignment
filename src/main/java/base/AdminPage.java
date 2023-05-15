package base;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.List;

public class AdminPage extends BasePage{
    public String correspondingDeleteXpath = "//div[@class='oxd-table-body']/div/div/div[2]/div[text()='xyz']/parent::div/parent::div/div[6]/div/button[1]";

    public String correspondingCheckboxXpath  = "//div[@class='oxd-table-body']/div/div/div[2]/div[text()='xyz']/parent::div/parent::div/div[1]/div";

    public AdminPage() {
        super();
    }

    @FindBy(how = How.XPATH, using = "//div[@class='oxd-table-body']/div/div/div[2]/div")
    private List<WebElement> usernameList;

    @FindBy(how = How.XPATH, using = "//div[@class='oxd-table-body']/div/div/div[3]/div")
    private List<WebElement> userRoleList;

    @FindBy(how = How.XPATH, using = "//div[@class='oxd-table-body']/div/div/div[4]/div")
    private List<WebElement> employeeNameList;

    @FindBy(how = How.XPATH, using = "//div[@class='oxd-table-body']/div/div/div[5]/div")
    private List<WebElement> statusList;

    @FindBy(how = How.XPATH, using = "//div[@class='oxd-table-body']/div/div/div[2]/div/parent::div/parent::div/descendant::div[@class='oxd-table-cell-actions']/button[1]")
    private List<WebElement> deleteButtonList;

    @FindBy(how = How.XPATH, using = "//button[@class='oxd-button oxd-button--medium oxd-button--label-danger orangehrm-button-margin']")
    private WebElement confirmDelete;

    public WebElement getConfirmDelete() {
        return confirmDelete;
    }

    public void setConfirmDelete(WebElement confirmDelete) {
        this.confirmDelete = confirmDelete;
    }

    public List<WebElement> getUsernameList() {
        return usernameList;
    }

    public void setUsernameList(List<WebElement> usernameList) {
        this.usernameList = usernameList;
    }

    public List<WebElement> getUserRoleList() {
        return userRoleList;
    }

    public void setUserRoleList(List<WebElement> userRoleList) {
        this.userRoleList = userRoleList;
    }

    public List<WebElement> getEmployeeNameList() {
        return employeeNameList;
    }

    public void setEmployeeNameList(List<WebElement> employeeNameList) {
        this.employeeNameList = employeeNameList;
    }

    public List<WebElement> getStatusList() {
        return statusList;
    }

    public void setStatusList(List<WebElement> statusList) {
        this.statusList = statusList;
    }

    public List<WebElement> getDeleteButtonList() {
        return deleteButtonList;
    }

    public void setDeleteButtonList(List<WebElement> deleteButtonList) {
        this.deleteButtonList = deleteButtonList;
    }
}
