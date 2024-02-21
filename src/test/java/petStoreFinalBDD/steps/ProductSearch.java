package petStoreFinalBDD.steps;

import org.openqa.selenium.WebDriver;


import Config.WebDriverConfig;
import Helpers.Helper;
import PetStorePOM.ProductPage;
import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ProductSearch {
	WebDriver driver;
	ProductPage productPage;

	@Given("the user is logged in using {string}")
	public void the_user_is_logged_in(String browser) {
		driver = WebDriverConfig.startBrowser(browser);
		productPage = new ProductPage(driver);
		Helper.takeScreenshot(driver, "tiraprint");

		
	}

	@When("the user searches for an animal")
	public void the_user_searches_for_an_animal() {
		productPage.enterSearchKeyword("dog");
		productPage.clickSearchButton();

	}

	@And("selects a product from the search results")
	public void selects_a_product_from_the_search_results() {
		productPage.selectProduct();

	}

	@And("choose an animal")
	public void choose_an_animal() {
		productPage.clickOnProduct();

	}

	@Then("the user should be able to view the animal details")
	public void the_user_should_be_able_to_view_the_animal_details() {
		String expectedProductName = "Female Puppy Bulldog";
		productPage.confirmAnimalDetails(expectedProductName);

		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@After
	public void closeBrowser() {
		WebDriverConfig.closeBrowser(driver);
	}
}
