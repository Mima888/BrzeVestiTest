package regions;

import framework.Configuration;
import framework.Page;
import java.io.IOException;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import pages.CategoriesPage;
import pages.DashboardPage;
import pages.LoginPage;
import pages.RegionsPage;

public class TestRegions extends DashboardPage {

    private static LoginPage loginPage;
    private static DashboardPage dashboardPage;
    private static CategoriesPage categoriesPage;
    private static RegionsPage regionsPage;

    @BeforeClass
    public static void setUpClass() throws IOException {
//        Configuration.init();
//        loginPage = new LoginPage();
//        dashboardPage = loginPage.login();
    }

    @AfterClass
    public static void tearDownClass() throws InterruptedException {

//        Thread.sleep(3000);
//        loginPage.quitDriver();

    }

    @Before
    public void setUp() {

        regionsPage = this.goToRegions();
    }

    @After
    public void tearDown() {

    }

    @Test
    public void createNewRegion() {

        regionsPage.addNewRegion();
    }

    @Test
    public void editRegion() {

        regionsPage.editFirstRegion();
//        regionsPage.editLastRegion();
//        regionsPage.editRandomRegion();

    }

    @Test
    public void deleteRegion() {

//        regionsPage.deleteFirstRegion();
//        regionsPage.deleteLastRegion();
        regionsPage.deleteRandomRegion();
    }

    @Test
    public void disableRegion() {

//        regionsPage.disableFirstRegion();
//        regionsPage.disableLastRegion();
//        regionsPage.disableRandomRegion();

    }

    @Test
    public void enableRegion() {

//        regionsPage.enableFirstRegion();
//        regionsPage.enableLastRegion();
    }
}
