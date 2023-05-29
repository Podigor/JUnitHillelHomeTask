package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import static pages.Utils.*;


public class HillelPage {
    static WebDriver driverInHillelPage;

    private final String coachNameSelector = "//*[@class='coach-card_name']";
    @FindBy (xpath = "//*[@class='course-descriptor']//*[contains(text(), 'Front-end Basic')]")
    private WebElement courseTitle;

    @FindBy (xpath = "//*[@class='course-rating_average']")
    private WebElement courseRate;

    @FindBy (xpath = "//*[@class='p-regular block-video-modal-trigger_descr']")
    private WebElement courseDescription;

    @FindBy (xpath = coachNameSelector)
    private WebElement coachName;

    @FindBy (id = "lazySectionCoaches")
    private WebElement coachesSection;

    @FindBy (id = "coachesShowAllButton")
    private WebElement showAllCoachesButton;

    public HillelPage(WebDriver driver) {
        driverInHillelPage = driver;
        PageFactory.initElements(driver, this);
    }

    public WebElement getCoachesSection() {
        return coachesSection;
    }

    public WebElement getShowAllCoachesButton() {
        return showAllCoachesButton;
    }

    public String getCourseRate() {
        return courseRate.getText();
    }

    public String getCourseDescription() {
        return courseDescription.getText();
    }

    public String getCourseTitle() {
        return courseTitle.getText();
    }

    public List<String> getListCoachesNames() { //This method gets sorted list of coaches names
        List<String> list = new ArrayList<>();
        scrollToTheElement(driverInHillelPage, getCoachesSection());
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        getShowAllCoachesButton().click();
        for (WebElement element : driverInHillelPage.findElements(By.xpath(coachNameSelector))) {
            list.add(element.getText());
        }
        Collections.sort(list);
        return list;
    }
}