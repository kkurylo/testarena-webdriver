package chromedriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ProjectsTest {

    WebDriver driver = new ChromeDriver();
    LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
    KokpitPage kokpitPage = PageFactory.initElements(driver, KokpitPage.class);
    ProjectsPage projectsPage = PageFactory.initElements(driver, ProjectsPage.class);

    @BeforeMethod
    public void setUp() {
        loginPage.openPage();
        loginPage.logInAsAdmin("administrator@testarena.pl", "sumXQQ72$L");

    }

    @Test
    public void shouldAddNewProject() {
        kokpitPage.goToAdminPanel();
        projectsPage.clickAddProjectButton();
        projectsPage.setProjectName("Project158");
        projectsPage.setPojectPrefix("58");
        projectsPage.setProjectDescription("This is the best project ever");
        projectsPage.clickSaveProjectButton();
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
