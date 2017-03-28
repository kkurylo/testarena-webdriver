package chromedriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    WebDriver driver;

    @FindBy(id="email")
    private WebElement emailField;

    @FindBy(id="password")
    private WebElement passwordField;

    @FindBy(id="login")
    private WebElement loginButton;

    @FindBy(css="a[href='http://demo.testarena.pl/wyloguj']")
    private WebElement logoutButton;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void openPage() {
        driver.get("http://demo.testarena.pl/zaloguj");
    }

    public void logInAsAdmin(String email, String password) {
        emailField.sendKeys(email);
        passwordField.sendKeys(password);
        loginButton.click();
    }

    public boolean tellIfICanLogOut() {
        return logoutButton.isDisplayed();
    }
}
