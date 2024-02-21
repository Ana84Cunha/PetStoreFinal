package petStoreFinalBDD.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.After;
import org.openqa.selenium.WebDriver;
import petStoreFinalBDD.steps.UserRegistrationTest;
import Config.WebDriverConfig;
import Helpers.Helper;
import PetStorePOM.Registration;

public class UserRegistrationTest {

    private static WebDriver driver;
    private Registration registration;
    
    @Given("I am on the registration page using {string}")
    public void i_am_on_the_registration_page_using(String browser) {
        driver = WebDriverConfig.startBrowser(browser);
        registration = new Registration(driver);
        registration.navigateToRegistrationPage();
    }

    @When("the user is on the registration page")
    public void the_user_is_on_the_registration_page() {
        registration.navigateToRegistrationPage();
    }

    @And("the user enters valid registration details")
    public void the_user_enters_valid_registration_details() {
    	String randomUserID = Helper.generateRandomIDString(5);
        registration.userRegistrationForm(randomUserID, "testPassword123", "testPassword123", "John", "Doe", "test@example.com", "+123456789", "123 Street", "Apt 101", "City", "State", "12345", "Country");
    }

    @And("save account information")
    public void save_account_information() {
        registration.clickSaveAccount();
    }

    @Then("the user should be successfully registered and logged in")
    public void the_user_should_be_successfully_registered_and_logged_in() {
        registration.clickSignInButton();
        
        try {
            Thread.sleep(10000); // Wait for 10 seconds
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        registration.clickSecondSignInButton(); // Second sign-in
    }


    @After
    public void closeBrowser() {
        WebDriverConfig.closeBrowser(driver);
    }
}