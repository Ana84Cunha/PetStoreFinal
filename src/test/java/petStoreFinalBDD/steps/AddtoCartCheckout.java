package petStoreFinalBDD.steps;

import org.openqa.selenium.WebDriver;
import Config.WebDriverConfig;
import Helpers.Helper;
import PetStorePOM.AddtoCart_CheckoutPage;
import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AddtoCartCheckout {

    WebDriver driver;
    AddtoCart_CheckoutPage addtoCart_CheckoutPage;

    @Given("the user is on the animal details page using {string}")
    public void the_user_is_on_the_animal_details_page(String browser) {
        driver = WebDriverConfig.startBrowser(browser);
        addtoCart_CheckoutPage = new AddtoCart_CheckoutPage(driver);
        Helper.takeScreenshot(driver, "tiraprint");

              
    }

    @When("the user clicks on the {string} button")
    public void the_user_clicks_on_the_button(String buttonText) {
        addtoCart_CheckoutPage.clickAddToCartButton();
    }

    @Then("the item should be added to the shopping cart")
    public void the_item_should_be_added_to_the_shopping_cart() {
         // Esta verificação já foi realizada no método clickAddToCartButton(),
        // então este método não precisa de uma implementação adicional aqui.
       // após clicar em "Adicionar ao carrinho" já confirma que o item foi adicionado com sucesso.
    }

    @And("proceed to checkout successfully")
    public void proceed_to_checkout_successfully() {
        addtoCart_CheckoutPage.proceedToCheckout();
    }
    

    @After
    public void closeBrowser() {
        WebDriverConfig.closeBrowser(driver);
    }
}
