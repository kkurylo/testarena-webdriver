package chromedriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProjectsPage {

    WebDriver driver;

    @FindBy(id="search")
    private WebElement searchField;

    @FindBy(css="a[href='http://demo.testarena.pl/administration/projects']")
    private WebElement leftProjectsSectionButton;

    @FindBy(id="j_searchButton")
    private WebElement searchButton;

    @FindBy(id="action_icon")
    private WebElement actionButton;

    public ProjectsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void goToProjectsSection() {
        leftProjectsSectionButton.click();
    }

    public void setSearchingProject(String name) {
        searchField.sendKeys(name);
    }

    public void searchProject() {
        searchButton.click();
    }

    public boolean tellIfProjectIsFounded() {
        return actionButton.isDisplayed();
    }




}
