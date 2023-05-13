package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.ArrayList;
import java.util.List;

public class MainPage {
    WebDriver driver;

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    By courseDropdownButton = By.xpath("//button[@data-dropdown-trigger='coursesMenu']"),
       programmingCourseButton = By.xpath("//button[@data-category='programming']"),
       frontEndBasicCourseItem = By.xpath("//li[@id='block-202987']//a[@href='https://ithillel.ua/courses/front-end-basic']"),
       coachesSection = By.id("lazySectionCoaches"),
       showAllCoachesButton = By.id("coachesShowAllButton"),
       coachName = By.className("coach-card_name");


    public void scrollToTheElement(By elementLocator) {
       WebElement element = driver.findElement(elementLocator);
       ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
    }

    public List<String> getListCoaches() throws InterruptedException {
        List<String> list = new ArrayList<>();
        driver.findElement(courseDropdownButton).click();
        driver.findElement(programmingCourseButton).click();
        Thread.sleep(3000);
        driver.findElement(frontEndBasicCourseItem).click();
        Thread.sleep(3000);
        scrollToTheElement(coachesSection);
        Thread.sleep(3000);
        driver.findElement(showAllCoachesButton).click();
        for (WebElement element : driver.findElements(coachName)) {
             list.add(element.getText());
        }
        return list;
    }
}