package testcases; // Fixed package

import base.BaseTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.SignUpPage;
import pages.HomePage;

public class SignUpTest extends BaseTest { // Fixed class name
    
    @Test(priority = 1, description = "TC_005: Successful sign-up with valid credentials")
    public void testSuccessfulSignUp() {
        HomePage homePage = new HomePage(driver);
        SignUpPage signUpPage = new SignUpPage(driver);
        
        homePage.clickGetStarted();
        signUpPage.enterEmail("valid@example.com");
        signUpPage.enterPassword("ValidPass@123");
        signUpPage.enterConfirmPassword("ValidPass@123");
        signUpPage.clickSignUp();
    }

    @Test(priority = 2, dataProvider = "invalidEmails")
    public void testEmailValidations(String email, String expectedError) {
        HomePage homePage = new HomePage(driver);
        SignUpPage signUpPage = new SignUpPage(driver);
        
        homePage.clickGetStarted();
        signUpPage.enterEmail(email);
        signUpPage.clickSignUp();
    }

    @DataProvider(name = "invalidEmails")
    public Object[][] emailData() {
        return new Object[][] {
            {"userdomain.com", "Invalid email format"},
            {"user@.com", "Invalid email format"},
            {"", "Email is required"}
        };
    }
}