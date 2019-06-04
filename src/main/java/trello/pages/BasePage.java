package trello.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static trello.core.BrowserFactory.driver;

public class BasePage {
    protected By homeBy = By.xpath("//a[@href='/']");

    protected void typeText(By by, String text) {
        waitForElementPresent(by);
        driver.findElement(by).clear();
        driver.findElement(by).sendKeys(text);
    }

    protected void click(By by) {
        waitForElementPresent(by);
        driver.findElement(by).click();
    }

    protected boolean isElementPresent(By by) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, 10);
            wait.until(ExpectedConditions.presenceOfElementLocated(by));
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    public void waitForElementPresent(By by) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.presenceOfElementLocated(by));
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }
}
