package chromedriver;

import org.junit.Assert;
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
    AdminPanelPage adminPanelPage = PageFactory.initElements(driver, AdminPanelPage.class);
    ProjectsPage projectsPage = PageFactory.initElements(driver, ProjectsPage.class);

    @BeforeMethod
    public void getUp() {
        loginPage.openPage();
        loginPage.logInAsAdmin("administrator@testarena.pl", "sumXQQ72$L");
        kokpitPage.goToAdminPanel();
        adminPanelPage.clickAddProjectButton();
        adminPanelPage.setProjectName("niechpowstanie");
        adminPanelPage.setProjectPrefix("26");
        adminPanelPage.setProjectDescription("niema");
        adminPanelPage.clickSaveProjectButton();
    }

    @Test
    public void shouldFindMyProject() {
        projectsPage.goToProjectsSection();
        projectsPage.setSearchingProject("niechpowstanie");
        projectsPage.searchProject();

        Assert.assertTrue(projectsPage.tellIfProjectIsFounded());
    }

    @AfterMethod
    public void chillOut() {
        driver.quit();
    }
}
