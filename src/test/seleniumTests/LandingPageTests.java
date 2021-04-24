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
        for(int i = 0; i < 3; i++) {
            page.clickRightSliderArrow();
        }
    }

    @Test
    public void leftArrowTest() {
        for(int i = 0; i < 3; i++) {
            page.clickLeftSliderArrow();
        }
    }

    @Test
    public void sliderButtonTest() {
        Utils.waitForElementToBeClickable(driver, page.getSliderButton());
        String link = Utils.getLinkFromElement(page.getSliderButton());
        page.clickSliderButton();

        Assertions.assertEquals(link, driver.getCurrentUrl());

        Utils.previousPage(driver);
    }

//    @Test
//    public void mainPageMenuLinksTest() {
//        List<WebElement> mainPageMenu = page.getListOfMainMenuElements();
//        for(int i = 0; i < 9; i++) {
//            String[] hrefAndPageUrl = new String[2];
//            try {
//                hrefAndPageUrl[0] = mainPageMenu.get(i).getAttribute("href");
//                hrefAndPageUrl[0] = Utils.ifNotHttpsAddS(hrefAndPageUrl[0]);
//                mainPageMenu.get(i).click();
//            } catch (IndexOutOfBoundsException exception) {
//                WebElement openDrawer = driver.findElement(By.xpath("//body/div[@id='content']/div[1]/div[1]/nav[1]/ul[1]/li[3]/a[1]"));
////                WebElement openDrawer = driver.findElement(By.xpath("//ul[@class='nav bs-docs-sidenav']/li[" + i + "]/a[1]"));
//                openDrawer.click();
//                WebElement element = driver.findElement(By.xpath("//ul[@class='nav bs-docs-sidenav']/li[" + i + "]/ul[1]/li[1]"));
//                hrefAndPageUrl[0] = element.getAttribute("href");
//                hrefAndPageUrl[0] = Utils.ifNotHttpsAddS(hrefAndPageUrl[0]);
//                element.click();
//            }
//
//            Utils.waitUntilPageLoaded();
//            hrefAndPageUrl[1] = driver.getCurrentUrl();
//            Utils.makeStringsEqualLength(hrefAndPageUrl);
//
//            Assertions.assertEquals(hrefAndPageUrl[0], hrefAndPageUrl[1]);
//
//            Utils.previousPage(driver);
//            Utils.waitUntilPageLoaded();
//        }
//    }
//
//    @Test
//    public void test() throws InterruptedException {
//        WebElement openDrawer = driver.findElement(By.xpath("//body/div[@id='content']/div[1]/div[1]/nav[1]/ul[1]/li[3]/a[1]"));
//        openDrawer.click();
//
//        openDrawer = driver.findElement(By.xpath("//ul[@class='nav bs-docs-sidenav']/li[3]/ul[1]/li[1]"));
//        openDrawer.click();
//        Thread.sleep(3000);
//    }
    @AfterAll
    static void closeBrowser() {
        driver.manage().deleteAllCookies();
        driver.close();
    }
}
