package chromedriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdminPanelPage {

    private WebDriver driver;

    @FindBy(css = "a[href='http://demo.testarena.pl/administration/add_project']")
    private WebElement addProjectButton;

    @FindBy(id = "name")
    private WebElement nameOfProjectField;

    @FindBy(id = "prefix")
    private WebElement prefixOfProjectField;

    @FindBy(css = "#content>article>form>div:nth-child(4)>span>div>div.sp-dd")
    private WebElement openStatusColorButton;

    @FindBy(xpath = "/html/body/div[2]/div[1]/div[2]/button")
    private WebElement moreColorsForOpenStatusButton;

    @FindBy(xpath = "/html/body/div[2]/div[2]/div[1]/div[2]/div[2]")
    private WebElement clearColorForOpenStatusButton;

    @FindBy(xpath ="/html/body/div[2]/div[2]/div[2]/input")
    private WebElement colorForOpenStatusField;

    @FindBy(xpath = "/html/body/div[2]/div[2]/div[4]/button")
    private WebElement saveColorForOpenStatusButton;

    @FindBy(css = "#content > article > form > div:nth-child(5) > span > div > div.sp-dd")
    private WebElement inProgressStatusColorButton;

    @FindBy(xpath = "/html/body/div[3]/div[1]/div[2]/button")
    private WebElement moreColorsForInProgressStatusButton;

    @FindBy(xpath = "/html/body/div[3]/div[2]/div[1]/div[2]/div[2]")
    private WebElement clearColorForInProgressStatusButton;

    @FindBy(xpath = "/html/body/div[3]/div[2]/div[2]/input")
    private WebElement colorForInProgressField;

    @FindBy(xpath = "/html/body/div[3]/div[2]/div[4]/button")
    private WebElement saveColorForInProgressStatusButton;

    @FindBy(id = "description")
    private WebElement descriptionOfProjectField;

    @FindBy(id = "save")
    private WebElement saveProjectButton;

    @FindBy(id = "j_info_box")
    private WebElement notificationBox;

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

    public AdminPanelPage setColorForOpenStatus(String colorInHex) {
        openStatusColorButton.click();
        moreColorsForOpenStatusButton.click();
        clearColorForOpenStatusButton.click();
        colorForOpenStatusField.sendKeys(colorInHex);
        saveColorForOpenStatusButton.click();
        return new AdminPanelPage(driver);
    }

    public AdminPanelPage setColorForInProgressStatus(String colorInHex) {
        inProgressStatusColorButton.click();
        moreColorsForInProgressStatusButton.click();
        clearColorForInProgressStatusButton.click();
        colorForInProgressField.sendKeys(colorInHex);
        saveColorForInProgressStatusButton.click();
        return new AdminPanelPage(driver);
    }

    public AdminPanelPage setProjectPrefix(String prefix) {
        prefixOfProjectField.sendKeys(prefix);
        return new AdminPanelPage(driver);
    }

    public AdminPanelPage setProjectDescription(String description) {
        descriptionOfProjectField.sendKeys(description);
        return new AdminPanelPage(driver);
    }

    public void clickSaveProjectButton() {
        saveProjectButton.click();
    }

    public boolean tellIfNotificationBoxAddedNewProjectIsFounded() {
        return notificationBox.isDisplayed();
    }

}
