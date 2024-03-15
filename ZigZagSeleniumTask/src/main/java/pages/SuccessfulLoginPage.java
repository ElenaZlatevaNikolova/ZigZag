package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class SuccessfulLoginPage extends BasePage {

    WebElement greetingMessageElement;
    WebElement logoutButton;

    public SuccessfulLoginPage(WebDriver driver) {
        super(driver);
    }

    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }

    public String getGreetingMessageText() {
        greetingMessageElement = driver.findElement(By.xpath("//strong[contains(text(),'student')]"));
        return greetingMessageElement.getText();
    }

    public boolean isLogoutButtonDisplayed() {
        logoutButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(normalize-space(), 'Log out')]")));
        boolean isLogoutButtonDisplayed = logoutButton.isDisplayed();
        return isLogoutButtonDisplayed;
    }

}
