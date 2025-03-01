package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignUpPage {
    private WebDriver driver;    

    @FindBy(xpath = "//div[@class='App']//div[1]//div[1]//input[1]")
    private WebElement emailField;
    
    @FindBy(xpath = "//div[@class='App']//div[1]//label[1]")
    private WebElement passwordField;
    
    @FindBy(xpath = "(//input[@id='outlined-basic'])[3]")
    private WebElement confirmPasswordField;
    
    @FindBy(xpath = "//button[normalize-space()='Sign Up']")
    private WebElement signUpButton;

    public SignUpPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void enterEmail(String email) {
        emailField.sendKeys(email);
    }

    public void enterPassword(String password) {
        passwordField.sendKeys(password);
    }

    public void enterConfirmPassword(String password) {
        confirmPasswordField.sendKeys(password);
    }

    public void clickSignUp() {
        signUpButton.click();
    }
}