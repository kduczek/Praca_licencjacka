import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RecruitmentPage extends Page{

    @FindBy(xpath = "//a[contains(text(),'Serwis Rekrutacyjny UŁ')]")
    private WebElement recruitmentServiceTab;

    @FindBy(xpath = "//a[contains(text(),'Studia I stopnia')]")
    private WebElement firstDegreeStudiesTab;

    @FindBy(xpath = "//a[contains(text(),'Studia II stopnia')]")
    private WebElement secondDegreeStudiesTab;

    @FindBy(xpath = "//a[contains(text(),'Studia doktoranckie')]")
    private WebElement doctoralStudiesTab;

    @FindBy(xpath = "//a[contains(text(),'Studia podyplomowe')]")
    private WebElement postgraduateStudiesTab;

    @FindBy(xpath = "//a[contains(text(),'Informator')]")
    private WebElement informationTab;

    @FindBy(xpath = "//div[@class='entry']/ul[1]/li[1]/a[1]")
    private WebElement generalITNewestStudyPlan;


    public void clickRecruitmentServiceTab() {
        recruitmentServiceTab.click();
    }

    public void clickFirstDegreeStudiesTab() {
        firstDegreeStudiesTab.click();
    }

    public void clickSecondDegreeStudiesTab() {
        secondDegreeStudiesTab.click();
    }

    public void clickDoctoralStudiesTab() {
        doctoralStudiesTab.click();
    }

    public void clickPostgraduateStudiesTab() {
        postgraduateStudiesTab.click();
    }

    public void clickInformationTab() {
        informationTab.click();
    }

    public void clickGeneralITNewestStudyPlan() {
        generalITNewestStudyPlan.click();
    }

    public RecruitmentPage(WebDriver driver) {
        super(driver);
    }
}
