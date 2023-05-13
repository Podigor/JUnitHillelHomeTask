package hillelTest;

import configuration.BaseClass;
import org.junit.BeforeClass;
import org.junit.Test;
import pages.MainPage;

public class TestGetCoaches extends BaseClass {
    static MainPage mainPage;
    @BeforeClass
    public static void startSite() {
        driver.get("https://ithillel.ua/");
        mainPage = new MainPage(driver);
    }
    @Test
    public void printFrontEndBasicsCoaches() throws InterruptedException {
        System.out.println(mainPage.getListCoaches());
    }
}
