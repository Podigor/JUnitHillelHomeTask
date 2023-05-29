package hillelTest;

import configuration.BaseClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.support.PageFactory;
import pages.HillelPage;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import static org.junit.Assert.*;

public class TestFrontEndBasic extends BaseClass {

    private static final String expectedCourseTitle = "Front-end Basic";
    private static final String expectedCourseRate = "5";
    private static final String expectedCourseDescription =
            "У цьому огляді ми розглянемо, що таке Front-end," +
                    " що робить Front-end розробник і чому вчаться студенти на курсі Front-end Basic.";
    private static final ArrayList<String> expectedCoachesNames = new ArrayList<>(
            Arrays.asList("Євген Волинець", "Роман Резніков", "Андрій Нежид", "Михайло Волков",
            "Олександр Плахотенко", "Дмитро Крулькевич", "Сергій Никифоров", "Володимир Шайтан", "Валерій Тернавський",
            "Олександр Дятлов", "Володимир Зіняк", "Іван Король", "Ігор Колєчкін", "Марія Падалко", "Ростислав Яшкін",
            "Сергій Скорінов", "Олексій Кайдалов", "Антон Лисенко", "Олександра Микитенко", "Артур Тарасов", "Олексій Єфанов",
            "Петро Павлюк", "Ольга Смирнова", "Анна Короткова", "Павло Зубак", "Олександр Гуць", "Костянтин Кулаксиз",
            "Сергій Ярчук", "Сергій Бірський", "Леонід Дулгер", "Олександра Коваленко", "Віктор Жиляєв", "Катерина Шиповська",
            "Костянтин Абрамкін", "Олександра Донцова", "Владислав Тамащук", "Дмитро Соколовський", "Іван Самойлов",
            "Андрій Онищук", "Марія Хазяєнко", "Олексій Толстоног", "Юрій Панченко", "Максим Попович", "Богдан Продан",
            "Юлія Котенко", "Дмитро Горобець", "Роман Яремій", "Ігор Муковоз", "Владислав Солонько", "Сергій Скубида",
            "Олександр Казначєєв", "Віталій Малинка", "Максим Гричина", "Роман Нищий", "Андрій Фоменко", "Михайло Корольков",
            "Микола Шаршов", "Андрій Кривцов", "Богдан Марченко", "Владислав Повелиця", "Юлія Остапенко", "Валерій Хомченко",
            "Олексій Ан", "Сергій Лямцев", "Сурен Мнацаканов", "Ольга Мурашко", "Юрій Мартинюк", "Владислав Єрмолаєв",
            "Єгор Якименко", "Всеволод Бобровский", "Сергій Мірошник", "Олександр Кравец", "Артем Рижов", "Ольга Маслова",
            "Павло Панаітов", "Віктор Кущенко", "Назар Малець", "Олексій Пузіч", "Єгор Мухладі"));

    static HillelPage hillelPage = null;
    @BeforeClass
    public static void startSite() {
        driver.get("https://dnipro.ithillel.ua/courses/front-end-basic");
        hillelPage = PageFactory.initElements(driver,HillelPage.class);
    }

    @Test
    public void checkCourseTitle() {
        assertEquals(expectedCourseTitle, hillelPage.getCourseTitle());
    }

    @Test
    public void checkCourseRate() {
        assertEquals(expectedCourseRate, hillelPage.getCourseRate());
    }

    @Test
    public void checkCourseDescription() {
        assertEquals(expectedCourseDescription, hillelPage.getCourseDescription());
    }

    @Test
    public void checkCourseCoachesNames() {
        Collections.sort(expectedCoachesNames);
        assertEquals(expectedCoachesNames, hillelPage.getListCoachesNames());
    }
}
