package chromedriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class KokpitPage {

    WebDriver driver;

    @FindBy(css="a[href='http://demo.testarena.pl/administration']")
    private WebElement rightAdministrationButton;

    public KokpitPage(WebDriver driver) {
        this.driver = driver;
    }

    public void goToAdminPanel() {
        rightAdministrationButton.click();
    }
}
