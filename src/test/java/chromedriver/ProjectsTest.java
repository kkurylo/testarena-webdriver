package chromedriver;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ProjectsTest {

    WebDriver driver = new ChromeDriver();
    LoginPage loginPage = new LoginPage(driver);
    KokpitPage kokpitPage = new KokpitPage(driver);
    AdminPanelPage adminPanelPage = new AdminPanelPage(driver);
    ProjectsPage projectsPage = new ProjectsPage(driver);

    @BeforeMethod
    public void setUp() {
        loginPage.openPage();
        loginPage.logInAsAdmin("administrator@testarena.pl", "sumXQQ72$L");
        kokpitPage.goToAdminPanel();
        adminPanelPage.clickAddProjectButton();
        adminPanelPage.setProjectName("mojnowyprojekt0");
        adminPanelPage.setProjectPrefix("22a0");
        adminPanelPage.setProjectDescription("niema");
        adminPanelPage.clickSaveProjectButton();
    }

    @Test
    public void shouldFindMyProject() {
        projectsPage.goToProjectsSection();
        projectsPage.setSearchingProject("mojnowyprojekt0");
        projectsPage.searchProject();

        Assert.assertTrue(projectsPage.tellIfProjectIsFounded());
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
