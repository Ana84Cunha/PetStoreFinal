package PetStorePOM;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class Registration {
    private final WebDriverWait wait;
    
    private final By elementUserIDInput = By.xpath("//input[@name='username']");
    private final By elementNewPassInput = By.xpath("//input[@name='password']");
    private final By elementRepeatPassInput = By.xpath("//input[@name='repeatedPassword']");
    private final By elementFirstNameInput = By.xpath("//input[@name='account.firstName']");
    private final By elementLastNameInput = By.xpath("//input[@name='account.lastName']");
    private final By elementEmailInput = By.xpath("//input[@name='account.email']");
    private final By elementPhoneInput = By.xpath("//input[@name='account.phone']");
    private final By elementAddress1Input = By.xpath("//input[@name='account.address1']");
    private final By elementAddress2Input = By.xpath("//input[@name='account.address2']");
    private final By elementCityInput = By.xpath("//input[@name='account.city']");
    private final By elementStateInput = By.xpath("//input[@name='account.state']");
    private final By elementZipInput = By.xpath("//input[@name='account.zip']");
    private final By elementCountryInput = By.xpath("//input[@name='account.country']");

    private final By elementButtonSaveAccount = By.xpath("//input[@name='newAccount']");
    private final By elementSignInButton = By.cssSelector("a[href='/actions/Account.action?signonForm=']");

	private WebDriver driver;
    
    public Registration(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(25));
    }
    
    public void navigateToRegistrationPage() {
        driver.get("https://petstore.octoperf.com/actions/Account.action?newAccountForm=");
    }
    public void userRegistrationForm(String username, String password, String repeatPassword,
                                     String firstName, String lastName, String email, String phone,
                                     String address1, String address2, String city, String state,
                                     String zip, String country) {
        insertUserInfo(username, password, repeatPassword);
        insertNames(firstName, lastName);
        insertContacts(email, phone);
        insertAddressLines(address1, address2);
        insertCityInfo(city, state, zip, country);
    }

    private void insertUserInfo(String username, String password, String repeatPassword) {
        WebElement waitRegister = wait.until(ExpectedConditions.elementToBeClickable(elementUserIDInput));
        waitRegister.clear();
        waitRegister.sendKeys(username);

        waitRegister = wait.until(ExpectedConditions.elementToBeClickable(elementNewPassInput));
        waitRegister.clear();
        waitRegister.sendKeys(password);

        waitRegister = wait.until(ExpectedConditions.elementToBeClickable(elementRepeatPassInput));
        waitRegister.clear();
        waitRegister.sendKeys(repeatPassword);
    }
    private void insertNames(String firstName, String lastName) {
        WebElement waitRegister = wait.until(ExpectedConditions.elementToBeClickable(elementFirstNameInput));
        waitRegister.clear();
        waitRegister.sendKeys(firstName);

        waitRegister = wait.until(ExpectedConditions.elementToBeClickable(elementLastNameInput));
        waitRegister.clear();
        waitRegister.sendKeys(lastName);
    }

    private void insertContacts(String email, String phone) {
        WebElement waitRegister = wait.until(ExpectedConditions.elementToBeClickable(elementEmailInput));
        waitRegister.clear();
        waitRegister.sendKeys(email);

        waitRegister = wait.until(ExpectedConditions.elementToBeClickable(elementPhoneInput));
        waitRegister.clear();
        waitRegister.sendKeys(phone);
    }

    private void insertAddressLines(String address1, String address2) {
        WebElement waitRegister = wait.until(ExpectedConditions.elementToBeClickable(elementAddress1Input));
        waitRegister.clear();
        waitRegister.sendKeys(address1);

        waitRegister = wait.until(ExpectedConditions.elementToBeClickable(elementAddress2Input));
        waitRegister.clear();
        waitRegister.sendKeys(address2);
    }

    private void insertCityInfo(String city, String state, String zip, String country) {
        WebElement waitRegister = wait.until(ExpectedConditions.elementToBeClickable(elementCityInput));
        waitRegister.clear();
        waitRegister.sendKeys(city);

        waitRegister = wait.until(ExpectedConditions.elementToBeClickable(elementStateInput));
        waitRegister.clear();
        waitRegister.sendKeys(state);

        waitRegister = wait.until(ExpectedConditions.elementToBeClickable(elementZipInput));
        waitRegister.clear();
        waitRegister.sendKeys(zip);

        waitRegister = wait.until(ExpectedConditions.elementToBeClickable(elementCountryInput));
        waitRegister.clear();
        waitRegister.sendKeys(country);
    }
    public void clickSaveAccount() {
        WebElement waitRegister = wait.until(ExpectedConditions.elementToBeClickable(elementButtonSaveAccount));
        waitRegister.click();
                
        wait.until(ExpectedConditions.urlContains("/actions/Catalog.action"));
    }
    
        public void clickSignInButton() {
        WebElement signInButton = wait.until(ExpectedConditions.elementToBeClickable(elementSignInButton));
        signInButton.click();
    }
        
       public void clickSecondSignInButton() {
            WebElement signInButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input[value='Login']")));
            signInButton.click();
        }

}
