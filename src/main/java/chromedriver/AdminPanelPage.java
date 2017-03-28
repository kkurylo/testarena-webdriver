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

    public void clickAddProjectButton() {
        addProjectButton.click();
    }

    public void setProjectName(String name) {
        nameOfProjectField.sendKeys(name);
    }

    public void setProjectPrefix(String prefix) {
        prefixOfProjectField.sendKeys(prefix);
    }

//    public void setColorOfOpenStatusProject() {
//        js.executeScript("driver.getElementById('openStatusColor').value='#ffffff'");
//    }

    public void setProjectDescription(String description) {
        descriptionOfProjectField.sendKeys(description);
    }

    public void clickSaveProjectButton() {
        saveProjectButton.click();
    }

    public boolean findNotificationAddedNewProject() {
        return notificationBox.isDisplayed();
    }

}
