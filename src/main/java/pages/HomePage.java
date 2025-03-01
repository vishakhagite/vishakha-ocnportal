package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
    private WebDriver driver;

    @FindBy(xpath = "//button[contains(text(),'Get Started')]")
    private WebElement getStartedButton;
    
    @FindBy(xpath = "//a[contains(text(),'Sign In')]")
    private WebElement signInButton;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickGetStarted() {
        getStartedButton.click();
    }

    public void clickSignIn() {
        signInButton.click();
    }
}