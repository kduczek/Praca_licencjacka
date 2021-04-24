import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.time.Duration;
import java.util.Objects;

public class Utils {
    public static final String PATH_TO_DOWNLOAD_FOLDER = "/Users/krystian/Downloads";

    public static void waitUntilPageLoaded() {
        ExpectedCondition<Boolean> expectation = driver -> ((JavascriptExecutor) driver).executeScript("return document.readyState").toString().equals("complete");
    }

    public static void previousPage(WebDriver driver) {
        driver.navigate().back();
    }

    public static boolean isFileDownloaded(String fileName) {
        File dir = new File(PATH_TO_DOWNLOAD_FOLDER);
        File[] dirContents = dir.listFiles();

        for (int i = 0; i < Objects.requireNonNull(dirContents).length; i++) {
            if (dirContents[i].getName().equals(fileName)) {
                // File has been found, it can now be deleted:
                dirContents[i].delete();
                return true;
            }
        }
        return false;
    }

    private static File createFile(String fileName) {
        return new File(PATH_TO_DOWNLOAD_FOLDER, fileName);
    }

    public static void waitForFileToDownload(WebDriver driver, String fileName) {
        FluentWait wait = new FluentWait(driver)
                .withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofSeconds(1));
        File file = Utils.createFile(fileName);
        wait.until((webDriver) -> file.exists());
    }

    public static void waitForElementToBeClickable(WebDriver driver, WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public static String getLinkFromElement(WebElement element) {
        return element.getAttribute("href");
    }

    public static String ifNotHttpsAddS(String link) {
        if (!link.startsWith("https")) {
            return link.substring(0, 4) + "s" + link.substring(4);
        }
        return link;
    }

    public static String makeStringsLengthEqual(String expected, String actual) {
        int expectedLength = expected.length();
        int actualLength = actual.length();
        int diff = actualLength - expectedLength;

        if(diff < 0) {
            diff = expectedLength - actualLength;
        }

        System.out.println(diff);
        if(actualLength > expectedLength) {
            return expected.substring(0, expectedLength - diff);
        } else {
            return actual.substring(0, actualLength - diff);
        }
    }

    public static String[] makeStringsEqualLength(String[] strings) {
        int length = strings[0].length();

        for(String str : strings) {
            if(str.length() < length) {
                length = str.length();
            }
        }

        for(int i = 0; i < strings.length; i++) {
            if (strings[i].length() > length) {
                strings[i] = strings[i].substring(0, length);
            }
        }

        return strings;
    }

}
