package seleniumtests;

import org.junit.Assert;
import org.junit.Test;
import pages.LoginPage;
import pages.SuccessfulLoginPage;

public class LoginTests extends BaseTest {

    LoginPage loginPage = new LoginPage(driver);
    SuccessfulLoginPage successfulLoginPage = new SuccessfulLoginPage(driver);

    @Test
    public void successfulLogin_when_validCredentialsProvided() {
        loginPage.navigateToLoginPage();
        loginPage.successfulLogin();
        Assert.assertTrue(successfulLoginPage.getCurrentUrl().contains("https://practicetestautomation.com/logged-in-successfully/"));
        Assert.assertTrue(successfulLoginPage.getGreetingMessageText().contains("Congratulations") || successfulLoginPage.getGreetingMessageText().contains("successfully logged in"));
        Assert.assertTrue(successfulLoginPage.isLogoutButtonDisplayed());
    }

    @Test
    public void unsuccessfulLogin_when_invalidUsernameProvided() {
        loginPage.navigateToLoginPage();
        loginPage.unsuccessfulLoginWithInvalidUsername();
        Assert.assertTrue(loginPage.isErrorMessageDisplayed());
        Assert.assertEquals("Your username is invalid!", loginPage.getErrorMessage().getText());
    }

    @Test
    public void unsuccessfulLogin_when_invalidPasswordProvided() {
        loginPage.navigateToLoginPage();
        loginPage.unsuccessfulLoginWithInvalidPassword();
        Assert.assertTrue(loginPage.isErrorMessageDisplayed());
        Assert.assertEquals("Your password is invalid!", loginPage.getErrorMessage().getText());
    }
}
