package testcases;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import base.BaseTest;
import pages.SignUpPage;

public class SignUpTest extends BaseTest {
    
    @Test(priority = 1, description = "Successful sign-up with valid credentials")
    public void testSuccessfulSignUp() {
        SignUpPage signUpPage = new SignUpPage(driver);
        
        signUpPage.enterEmail("valid@example.com");
        signUpPage.enterPassword("ValidPass@123");
        signUpPage.enterConfirmPassword("ValidPass@123");
        
        Assert.assertTrue(signUpPage.isSignUpButtonEnabled(), 
            "Sign Up button should be enabled with valid inputs");
        
        signUpPage.clickSignUp();
        
    }

    @Test(priority = 2, dataProvider = "invalidEmails")
    public void testEmailValidations(String email, String expectedError) {
        SignUpPage signUpPage = new SignUpPage(driver);
        
        signUpPage.enterEmail(email);
        signUpPage.enterPassword("ValidPass@123");
        signUpPage.enterConfirmPassword("ValidPass@123");
        
        Assert.assertFalse(signUpPage.isSignUpButtonEnabled(), 
            "Sign Up button should be disabled with invalid email: " + email);
        
        Assert.assertEquals(signUpPage.getEmailError(), expectedError, 
            "Unexpected error message for email: " + email);
    }

    @DataProvider(name = "invalidEmails")
    public Object[][] emailData() {
        return new Object[][] {
            {"invalidemail", "Invalid email format"},
            {"user@domain", "Invalid email format"},
            {"", "Email is required"}
        };
    }
}