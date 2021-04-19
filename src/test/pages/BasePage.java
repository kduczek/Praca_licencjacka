import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BasePage extends Page{

    @FindBy(xpath = "//img[@alt='Wydział Matematyki i Informatyki UŁ']")
    private WebElement facultyLogo;

    @FindBy(xpath = "//img[@alt='Uniwersytet Łódzki']")
    private WebElement universityLogo;

    @FindBy(xpath = "//img[@alt='Wydział Matematyki i Informatyki, profil oficjalny']")
    private WebElement facebookButton;

    @FindBy(xpath = "//a[@href='https://outlook.office.com/']")
    private WebElement postButton;

    @FindBy(xpath = "//a[@href='http://usosweb.uni.lodz.pl/']")
    private WebElement usosButton;

    @FindBy(xpath = "//a[@lang='en-US']")
    private WebElement changeToEnglish;

    @FindBy(xpath = "//a[@hreflang='pl']")
    private WebElement changeToPolish;

    @FindBy(id = "search-web")
    private WebElement searchWebRadio;

    @FindBy(id = "search-people")
    private WebElement searchPeopleRadio;

    @FindBy(xpath = "//input[@title='Szukaj:']")
    private WebElement searchInput;

    @FindBy(className = "glyphicon-search")
    private WebElement searchButton;

    @FindBy(xpath = "//a[@title='Wydział']")
    private WebElement facultyTab;

    @FindBy(xpath = "//a[@title='Rekrutacja']")
    private WebElement recruitmentTab;

    @FindBy(xpath = "//a[@title='Studia']")
    private WebElement studyTab;

    @FindBy(xpath = "//a[@title='Badania i nauka']")
    private WebElement researchTab;

    @FindBy(xpath = "//a[@title='Kontakt']")
    private WebElement contactTab;

    @FindBy(xpath = "//a[@title='English']")
    private WebElement englishTab;

    @FindBy(className = "page-title")
    private WebElement searchResultPageTitle;

    @FindBy(className = "copy")
    private WebElement copyrightsFooter;

    public void clickFacultyLogo() {
        facultyLogo.click();
    }

    public void clickUniversityLogo() {
        universityLogo.click();
    }

    public void clickFacebookButton() {
        facebookButton.click();
    }

    public void clickPostButton() {
        postButton.click();
    }

    public void clickUsosButton() {
        usosButton.click();
    }

    public void clickEnglishButton() {
        changeToEnglish.click();
    }

    public void clickPolishButton() {
        changeToPolish.click();
    }

    public void clickWebRadio() {
        searchWebRadio.click();
    }

    public boolean checkIfWebRadioSelected() {
        return searchWebRadio.isSelected();
    }

    public void clickPeopleRadio() {
        searchPeopleRadio.click();
    }

    public boolean checkIfPeopleRadioSelected() {
        return searchPeopleRadio.isSelected();
    }

    public void fillSearchInput(String input) {
        searchInput.clear();
        searchInput.sendKeys(input);
    }

    public void clickSearchButton() {
        searchButton.click();
    }

    public void clickFacultyTab() {
        facultyTab.click();
    }

    public void clickRecruitmentTab() {
        recruitmentTab.click();
    }

    public void clickStudyTab() {
        studyTab.click();
    }

    public void clickResearchTab() {
        researchTab.click();
    }

    public void clickContactTab() {
        contactTab.click();
    }

    public void clickEnglishTab() {
        englishTab.click();
    }

    public String getTextFromSearchResultTitle() {
        return searchResultPageTitle.getText();
    }

    public String getTextFromFooter() {
        return copyrightsFooter.getText();
    }



    public BasePage(WebDriver driver) {
        super(driver);
    }
}
