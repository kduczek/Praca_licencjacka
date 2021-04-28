import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class LandingPageTests {
    private static WebDriver driver;
    private static LandingPage page;

    @BeforeAll
    static void init() {
        driver = new ChromeDriver();
        driver.get(PathBuilder.createPath(""));
        driver.manage().window().maximize();
        page = new LandingPage(driver);
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
    public void emptyStringSearchPersonTest() {
        String input = "";
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
    public void emptyStringSearchWebTest() {
        String input = "";
        page.clickWebRadio();
        page.fillSearchInput(input);
        page.clickSearchButton();

        Assertions.assertEquals("Wynik wyszukania dla:" + input, page.getTextFromSearchResultTitle());

        Utils.previousPage(driver);
    }

    @Test
    public void footerTextTest() {
        Assertions.assertEquals("Copyright © 2021 Wydział Matematyki i Informatyki UŁ. All rights reserved.", page.getTextFromFooter());
    }

    @Test
    public void sliderTest() {
        page.goThroughAllSlides();
    }

    @Test
    public void rightArrowTest() {
        for (int i = 0; i < 3; i++) {
            page.clickRightSliderArrow();
        }
    }

    @Test
    public void leftArrowTest() {
        for (int i = 0; i < 3; i++) {
            page.clickLeftSliderArrow();
        }
    }

    @Test
    @Order(1)
    public void sliderButtonTest() {
        Utils.waitForElementToBeClickable(driver, page.getSliderButton());
        String link = Utils.getLinkFromElement(page.getSliderButton());
        page.clickSliderButton();

        Assertions.assertEquals(link, driver.getCurrentUrl());

        Utils.previousPage(driver);
    }

    @Test
    public void mainPageMenuLinksWithoutSubmenusTest() {
        List<WebElement> mainPageMenu = page.getListOfMainMenuElements();

        for (int i = 0; i < mainPageMenu.size(); i++) {
            String[] hrefAndPageUrl = new String[2];
            if (i != 2 && i != 5) {
                hrefAndPageUrl[0] = mainPageMenu.get(i).getAttribute("href");
                hrefAndPageUrl[0] = Utils.ifNotHttpsAddS(hrefAndPageUrl[0]);
                mainPageMenu.get(i).click();

                Utils.waitUntilPageLoaded();
                hrefAndPageUrl[1] = driver.getCurrentUrl();
                Utils.makeStringsEqualLength(hrefAndPageUrl);

                Assertions.assertEquals(hrefAndPageUrl[0], hrefAndPageUrl[1]);

                Utils.previousPage(driver);
                Utils.waitUntilPageLoaded();
            }
        }
    }

    @Test
    @Order(2)
    public void elearningSubmenuLinksTest() {
        int positionInMainMenu = 3;
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        for(int i = 0; i < page.returnSizeOfSubmenu(positionInMainMenu); i++) {
            String[] hrefAndPageUrl = new String[2];
            page.openNestedMenu(positionInMainMenu);
            hrefAndPageUrl[0] = page.returnElementFromSubmenu(positionInMainMenu, i + 1).getAttribute("href");
            hrefAndPageUrl[0] = Utils.ifNotHttpsAddS(hrefAndPageUrl[0]);
            page.returnElementFromSubmenu(positionInMainMenu, i + 1).click();

            Utils.waitUntilPageLoaded();
            hrefAndPageUrl[1] = driver.getCurrentUrl();
            Utils.makeStringsEqualLength(hrefAndPageUrl);

            Assertions.assertEquals(hrefAndPageUrl[0], hrefAndPageUrl[1]);

            Utils.previousPage(driver);
            Utils.waitUntilPageLoaded();
        }
    }

    @Test
    @Order(3)
    public void businessAdviceSubmenuLinksTest() {
        int positionInMainMenu = 6;
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        for(int i = 0; i < page.returnSizeOfSubmenu(positionInMainMenu); i++) {
            String[] hrefAndPageUrl = new String[2];
            page.openNestedMenu(positionInMainMenu);
            hrefAndPageUrl[0] = page.returnElementFromSubmenu(positionInMainMenu, i + 1).getAttribute("href");
            hrefAndPageUrl[0] = Utils.ifNotHttpsAddS(hrefAndPageUrl[0]);
            page.returnElementFromSubmenu(positionInMainMenu, i + 1).click();

            Utils.waitUntilPageLoaded();
            hrefAndPageUrl[1] = driver.getCurrentUrl();
            Utils.makeStringsEqualLength(hrefAndPageUrl);

            Assertions.assertEquals(hrefAndPageUrl[0], hrefAndPageUrl[1]);

            Utils.previousPage(driver);
            Utils.waitUntilPageLoaded();
        }
    }

    @Test
    public void clickAllReadMoreButtons() {
        List<WebElement> buttons = page.returnReadMoreButtonsList();

        for(int i = 0; i < buttons.size(); i++) {
            String[] hrefAndPageUrl = new String[2];
            hrefAndPageUrl[0] = buttons.get(i).getAttribute("href");
            hrefAndPageUrl[0] = Utils.ifNotHttpsAddS(hrefAndPageUrl[0]);
            buttons.get(i).click();

            Utils.waitUntilPageLoaded();
            hrefAndPageUrl[1] = driver.getCurrentUrl();
            Utils.makeStringsEqualLength(hrefAndPageUrl);

            Assertions.assertEquals(hrefAndPageUrl[0], hrefAndPageUrl[1]);

            Utils.previousPage(driver);
            Utils.waitUntilPageLoaded();
        }
    }

    @Test
    public void newsLabelTextTest() {
        Assertions.assertEquals("Aktualności", page.returnNewsLabelText());
    }


    @AfterAll
    static void closeBrowser() {
        driver.manage().deleteAllCookies();
        driver.close();
    }
}
