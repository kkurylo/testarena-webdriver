package chromedriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class KokpitPage {

    WebDriver driver;

    @FindBy(css="a[href='http://demo.testarena.pl/administration']")
    private WebElement rightAdminPanelButton;

    public KokpitPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void goToAdminPanel() {
        rightAdminPanelButton.click();
    }
}
