package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends BasePage {

    private WebElement usernameField;
    private WebElement passwordField;
    private WebElement submitButton;
    private WebElement errorMessage;
    private String validUsername;
    private String validPassword;
    private String invalidUsername;
    private String invalidPassword;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void navigateToLoginPage() {
        navigateToPage("https://practicetestautomation.com/practice-test-login/");
    }

    public void setUsername(String username) {
        usernameField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("username")));
        usernameField.sendKeys(username);
    }

    public void setPassword(String password) {
        passwordField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("password")));
        passwordField.sendKeys(password);
    }

    public void clickSubmitButton() {
        submitButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("submit")));
        submitButton.click();
    }

    public void getValidUsername() {
        validUsername = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ul[1]/li[2]/b[1]"))).getText();
    }

    public void getValidPassword() {
        validPassword = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ul[1]/li[2]/b[2]"))).getText();
    }

    public void getInvalidUsername() {
        invalidUsername = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ol[2]/li[2]/b"))).getText();
    }

    public void getInvalidPassword() {
        invalidPassword = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ol[3]/li[3]/b"))).getText();
    }

    public void successfulLogin() {
        getValidUsername();
        getValidPassword();
        setUsername(validUsername);
        setPassword(validPassword);
        clickSubmitButton();
    }

    public void unsuccessfulLoginWithInvalidUsername() {
        getInvalidUsername();
        getValidPassword();
        setUsername(invalidUsername);
        setPassword(validPassword);
        clickSubmitButton();
    }

    public void unsuccessfulLoginWithInvalidPassword() {
        getValidUsername();
        getInvalidPassword();
        setUsername(validUsername);
        setPassword(invalidPassword);
        clickSubmitButton();
    }

    public WebElement getErrorMessage() {
        errorMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("error")));
        return errorMessage;
    }

    public boolean isErrorMessageDisplayed() {
        getErrorMessage();
        return errorMessage.isDisplayed();
    }


}
