package chromedriver;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdminPanelPage {

    WebDriver driver;

    @FindBy(css="a[href='http://demo.testarena.pl/administration/add_project']")
    private WebElement addProjectButton;

    @FindBy(id="name")
    private WebElement nameOfProjectField;

    @FindBy(id="prefix")
    private WebElement prefixOfProjectField;

//    @FindBy(id="openStatusColor")
//    private WebElement openStatusColorButton;

    @FindBy(id="description")
    private WebElement descriptionOfProjectField;

    @FindBy(id="save")
    private WebElement saveProjectButton;

    @FindBy(id="j_info_box")
    private WebElement notificationBox;

    JavascriptExecutor js = (JavascriptExecutor) driver;

    public AdminPanelPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public AdminPanelPage clickAddProjectButton() {
        addProjectButton.click();
        return new AdminPanelPage(driver);
    }

    public AdminPanelPage setProjectName(String name) {
        nameOfProjectField.sendKeys(name);
        return new AdminPanelPage(driver);
    }

    public AdminPanelPage setProjectPrefix(String prefix) {
        prefixOfProjectField.sendKeys(prefix);
        return new AdminPanelPage(driver);
    }

//    public void setColorOfOpenStatusProject() {
//        js.executeScript("driver.getElementById('openStatusColor').value='#ffffff'");
//    }

    public AdminPanelPage setProjectDescription(String description) {
        descriptionOfProjectField.sendKeys(description);
        return new AdminPanelPage(driver);
    }

    public void clickSaveProjectButton() {
        saveProjectButton.click();
    }

    public boolean findNotificationAddedNewProject() {
        return notificationBox.isDisplayed();
    }

}
