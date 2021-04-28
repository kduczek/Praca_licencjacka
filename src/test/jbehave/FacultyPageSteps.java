import org.jbehave.core.annotations.*;
import org.jbehave.core.steps.Steps;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FacultyPageSteps extends Steps {
    private static WebDriver driver;
    private static LandingPage page;
    private static RecruitmentPage recruitmentPage;
    private static String chosenPage = "";

    @BeforeStories
    public void setPreferencesAndOpenBrowser() {
        HashMap<String,Object> chromePrefs = new HashMap<String, Object>();
        chromePrefs.put("plugins.always_open_pdf_externally", true);

        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("prefs", chromePrefs);

        driver = new ChromeDriver(options);
    }

    @Given("a landing page of Faculty")
    public void goToSubpage() {
        driver.get(PathBuilder.createPath(""));
        page = new LandingPage(driver);
        recruitmentPage = new RecruitmentPage(driver);
    }

    @When("user clicks $tabName tab")
    public void openTab(String tabName) {
        switch (tabName) {
            case "Wydział":
                page.clickFacultyTab();
                chosenPage = "https://www.math.uni.lodz.pl/strefa-wydzialu/";
                break;
            case "Rekrutacja":
                page.clickRecruitmentTab();
                chosenPage = "https://www.math.uni.lodz.pl/dziekanat/rekrutacja/";
                break;
            case "Studia":
                page.clickStudyTab();
                chosenPage = "https://www.math.uni.lodz.pl/strefa-studenta/";
                break;
            case "Badania i nauka":
                page.clickResearchTab();
                chosenPage = "https://www.math.uni.lodz.pl/strefa-nauki/";
                break;
            case "Kontakt":
                page.clickContactTab();
                chosenPage = "https://www.math.uni.lodz.pl/kontakt/";
                break;
            case "English":
                page.clickEnglishTab();
                chosenPage = "https://en.math.uni.lodz.pl/en/welcome/";
                break;
        }
    }

    @Then("page is loaded")
    public void loadPage() {
        Utils.waitUntilPageLoaded();
        Assert.assertEquals(chosenPage, driver.getCurrentUrl());
    }


    @When("user clicks for first study plan to download")
    public void downloadFirstStudyPlan() {
        recruitmentPage.clickGeneralITNewestStudyPlan();
    }

    @Then("file $fileName is downloaded")
    public void checkIfFileDownloaded(String fileName) {
        Utils.waitForFileToDownload(driver, fileName);
        Assert.assertTrue(Utils.isFileDownloaded(fileName));
    }

    @When("user populate Search field with phrase $Cybula and clicks People radio button")
    public void fillSearchFieldWithPhrase(String phrase) {
        page.clickPeopleRadio();
        page.fillSearchInput(phrase);
    }

    @When("clicks Search button")
    public void clickSearch() {
        page.clickSearchButton();
    }

    @Then("user gets searching results for given phrase $Cybula")
    public void compareResults(String phrase) {
        Utils.waitUntilPageLoaded();
        Assert.assertEquals("https://www.math.uni.lodz.pl/?search_type=people&s=" + phrase, driver.getCurrentUrl());
    }

    @Then("user gets email of searched person")
    public void checkIfEmailBelongsToFaculty() {
        String email = page.getSearchedEmail();
        Pattern pattern = Pattern.compile("^[a-z]*(.)[a-z]*(@wmii.uni.lodz.pl)");
        Matcher matcher = pattern.matcher(email);
        Assert.assertTrue(matcher.find());
    }

    @When("user clicks Kalendarz from main menu")
    public void openCalendarSubpage() {
        page.clickCalendarFromMenu();
        chosenPage = "https://www.math.uni.lodz.pl/kalendarz/";
    }

    @When("user clicks for first schedule of academic year to download")
    public void downloadFirstScheduleOfAcademicYear() {
        page.clickFirstSchedule();
    }

    @When("user clicks $menuItem in recruitment page")
    public void clickItemInMenu(String menuItem) {
        switch (menuItem) {
            case "Serwis Rekrutacyjny UŁ":
                recruitmentPage.clickRecruitmentServiceTab();
                break;
            case "Studia I stopnia":
                recruitmentPage.clickFirstDegreeStudiesTab();
                break;
            case "Studia II stopnia":
                recruitmentPage.clickSecondDegreeStudiesTab();
                break;
            case "Studia doktoranckie":
                recruitmentPage.clickDoctoralStudiesTab();
                break;
            case "Studia podyplomowe":
                recruitmentPage.clickPostgraduateStudiesTab();
                break;
            case "Informator":
                recruitmentPage.clickInformationTab();
                break;
        }
        Utils.waitUntilPageLoaded();
    }

    @Then("user is on recruitment website")
    public void checkIfCurrentPageIsRecruitmentService() {
        Assert.assertEquals("https://rekrutacja.uni.lodz.pl/index.php", driver.getCurrentUrl());
    }

    @AfterStories
    public void closeBrowser() {
        driver.close();
    }
}
