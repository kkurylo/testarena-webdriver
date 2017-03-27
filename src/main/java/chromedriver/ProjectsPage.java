package chromedriver;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProjectsPage {

    WebDriver driver;

    @FindBy(css="a[href='http://demo.testarena.pl/administration/add_project']")
    private WebElement addProjectButton;

    @FindBy(id="name")
    private WebElement nameOfProjectField;

    @FindBy(id="prefix")
    private WebElement prefixOfProjectField;

    @FindBy(id="description")
    private WebElement descriptionOfProjectField;

    @FindBy(id="save")
    private WebElement saveProjectButton;

    @FindBy(id="j_info_box")
//    @FindBy(xpath = "//*[@id=\"j_info_box\"]")
    private WebElement notificationBox;

    public void clickAddProjectButton() {
        addProjectButton.click();
    }

    public void setProjectName(String name) {
        nameOfProjectField.sendKeys(name);
    }

    public void setProjectPrefix(String prefix) {
        prefixOfProjectField.sendKeys(prefix);
    }

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
