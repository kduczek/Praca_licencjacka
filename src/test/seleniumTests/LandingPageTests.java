import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LandingPageTests {
    private static WebDriver driver;
    private static BasePage page;

    @BeforeAll
    static void init() {
        driver = new ChromeDriver();
        driver.get(PathBuilder.createPath(""));
        page = new BasePage(driver);
    }

    @Test
    public void facultyLogoLinkTest() {
        page.clickFacultyLogo();
        Utils.waitUntilPageLoaded();

        Assertions.assertEquals("https://www.math.uni.lodz.pl/", driver.getCurrentUrl());
    }

    @Test
    public void universityLogoLinkTest() {
        page.clickUniversityLogo();
        Utils.waitUntilPageLoaded();

        Assertions.assertEquals("https://www.uni.lodz.pl/", driver.getCurrentUrl());

        Utils.previousPage(driver);
    }

    @Test
    public void facebookButtonLinkTest() {
        page.clickFacebookButton();
        Utils.waitUntilPageLoaded();

        Assertions.assertEquals("https://www.facebook.com/matematykaiinformatykaul/", driver.getCurrentUrl());

        Utils.previousPage(driver);
    }

    @Test
    public void emailButtonLinkTest() {
        page.clickPostButton();
        Utils.waitUntilPageLoaded();
        System.out.println(driver.getTitle());
        Assertions.assertEquals("Sign in to Outlook", driver.getTitle());

        Utils.previousPage(driver);
    }

    @Test
    public void usosButtonLinkTest() {
        page.clickUsosButton();
        Utils.waitUntilPageLoaded();

        Assertions.assertEquals("https://usosweb.uni.lodz.pl/kontroler.php?_action=actionx:news/default()", driver.getCurrentUrl());

        Utils.previousPage(driver);
    }

    @Test
    public void englishButtonLinkTest() {
        page.clickEnglishButton();
        Utils.waitUntilPageLoaded();

        Assertions.assertEquals("https://en.math.uni.lodz.pl/en/welcome/", driver.getCurrentUrl());

        Utils.previousPage(driver);
    }

    @Test
    public void switchToEnglishThenToPolishTest() {
        page.clickEnglishButton();
        Utils.waitUntilPageLoaded();

        Assertions.assertEquals("https://en.math.uni.lodz.pl/en/welcome/", driver.getCurrentUrl());

        page.clickPolishButton();

        Assertions.assertEquals("https://www.math.uni.lodz.pl/", driver.getCurrentUrl());
    }

    @Test
    public void facultyTabLinkTest() {
        page.clickFacultyTab();
        Utils.waitUntilPageLoaded();

        Assertions.assertEquals("https://www.math.uni.lodz.pl/strefa-wydzialu/", driver.getCurrentUrl());

        Utils.previousPage(driver);
    }

    @Test
    public void recruitmentTabLinkTest() {
        page.clickRecruitmentTab();
        Utils.waitUntilPageLoaded();

        Assertions.assertEquals("https://www.math.uni.lodz.pl/dziekanat/rekrutacja/", driver.getCurrentUrl());

        Utils.previousPage(driver);
    }

    @Test
    public void studyTabLinkTest() {
        page.clickStudyTab();
        Utils.waitUntilPageLoaded();

        Assertions.assertEquals("https://www.math.uni.lodz.pl/strefa-studenta/", driver.getCurrentUrl());

        Utils.previousPage(driver);
    }

    @Test
    public void researchTabLinkTest() {
        page.clickResearchTab();
        Utils.waitUntilPageLoaded();

        Assertions.assertEquals("https://www.math.uni.lodz.pl/strefa-nauki/", driver.getCurrentUrl());

        Utils.previousPage(driver);
    }

    @Test
    public void contactTabLinkTest() {
        page.clickContactTab();
        Utils.waitUntilPageLoaded();

        Assertions.assertEquals("https://www.math.uni.lodz.pl/kontakt/", driver.getCurrentUrl());

        Utils.previousPage(driver);
    }

    @Test
    public void englishTabLinkTest() {
        page.clickEnglishTab();
        Utils.waitUntilPageLoaded();

        Assertions.assertEquals("https://en.math.uni.lodz.pl/en/welcome/", driver.getCurrentUrl());

        Utils.previousPage(driver);
    }

    @Test
    public void peopleRadioButtonTest() {
        page.clickPeopleRadio();
        Assertions.assertTrue(page.checkIfPeopleRadioSelected());
    }

    @Test
    public void webRadioButtonTest() {
        page.clickWebRadio();
        Assertions.assertTrue(page.checkIfWebRadioSelected());
    }

    @Test
    public void basicSearchPersonTest() {
        String input = "Cybula";
        page.clickPeopleRadio();
        page.fillSearchInput(input);
        page.clickSearchButton();

        Assertions.assertEquals("https://www.math.uni.lodz.pl/?search_type=people&s=" + input, driver.getCurrentUrl());

        Utils.previousPage(driver);
    }

    @Test
    public void basicSearchWebTest() {
        String input = "Cybula";
        page.clickWebRadio();
        page.fillSearchInput(input);
        page.clickSearchButton();

        Assertions.assertEquals("Wynik wyszukania dla: " + input, page.getTextFromSearchResultTitle());

        Utils.previousPage(driver);
    }

    @Test
    public void footerTextTest() {
        Assertions.assertEquals("Copyright © 2021 Wydział Matematyki i Informatyki UŁ. All rights reserved.", page.getTextFromFooter());
    }

    @AfterAll
    static void closeBrowser() {
        driver.manage().deleteAllCookies();
        driver.close();
    }
}
