package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class SignUpPage {
    private WebDriver driver;
    private WebDriverWait wait;

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
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        PageFactory.initElements(driver, this);
    }

    public void enterEmail(String email) {
        WebElement element = wait.until(ExpectedConditions.visibilityOf(emailField));
        element.clear();
        element.sendKeys(email);
    }

    public void enterPassword(String password) {
        WebElement element = wait.until(ExpectedConditions.visibilityOf(passwordField));
        element.clear();
        element.sendKeys(password);
    }

    public void enterConfirmPassword(String password) {
        WebElement element = wait.until(ExpectedConditions.visibilityOf(confirmPasswordField));
        element.clear();
        element.sendKeys(password);
    }

    public void clickSignUp() {
        wait.until(ExpectedConditions.elementToBeClickable(signUpButton)).click();
    }

    public boolean isSignUpButtonEnabled() {
        return wait.until(ExpectedConditions.visibilityOf(signUpButton)).isEnabled();
    }
    
    public String getEmailError() {
        WebElement errorElement = wait.until(ExpectedConditions.visibilityOfElementLocated(
            By.xpath("//label[text()='Email']/following-sibling::div[contains(@class,'error')]")
        ));
        return errorElement.getText();
    }
}