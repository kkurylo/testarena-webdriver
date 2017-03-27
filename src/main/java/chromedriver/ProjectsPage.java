package chromedriver;

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

    public void clickAddProjectButton() {
        addProjectButton.click();
    }

    public void setProjectName(String name) {
        nameOfProjectField.sendKeys(name);
    }

    public void setPojectPrefix(String prefix) {
        prefixOfProjectField.sendKeys(prefix);
    }

    public void setProjectDescription(String description) {
        descriptionOfProjectField.sendKeys(description);
    }

    public void clickSaveProjectButton() {
        saveProjectButton.click();
    }
}
