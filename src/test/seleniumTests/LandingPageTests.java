import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LandingPageTests {
    private static WebDriver driver;
    private static BasePage hp;
    @BeforeAll
    static void init() {
        driver = new ChromeDriver();
        driver.get(PathBuilder.createPath(""));
        hp = new BasePage(driver);
    }

    @Test
    public void checkIfPageWorks() {
//        hp.clickFacultyLogo();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @AfterAll
    static void closeBrowser() {
        driver.manage().deleteAllCookies();
        driver.close();
    }
}
