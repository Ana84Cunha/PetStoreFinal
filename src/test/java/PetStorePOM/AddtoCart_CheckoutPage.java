package PetStorePOM;

import java.time.Duration;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddtoCart_CheckoutPage {

    private WebDriver driver;

    private final By pageTitleElementLocator = By.xpath("//font[contains(text(),'Female Puppy')]");
    private final By addTocartButtonLocator = By.className("Button");
    private final By proceedToCheckoutLocator = By.xpath("//a[normalize-space()='Proceed to Checkout']");
    private final By quantityInputLocator = By.cssSelector("input[value='1']");

    public AddtoCart_CheckoutPage(WebDriver driver) {
        this.driver = driver;
        driver.get("https://petstore.octoperf.com/actions/Catalog.action?viewItem=&itemId=EST-7");
    }

    public void confirmDetailsPage() {
        WebElement pageTitleElement = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(pageTitleElementLocator));
        Assert.assertTrue("Página de detalhes do animal está correta",
                pageTitleElement.getText().contains("Female Puppy"));
    }

    public void clickAddToCartButton() {
        WebElement addTocartButton = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(addTocartButtonLocator));
        addTocartButton.click();
        
        WebElement quantityInput = new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfElementLocated(quantityInputLocator));
        Assert.assertEquals("1", quantityInput.getAttribute("value"));
    }

    public void proceedToCheckout() {
        WebElement proceedToCheckout = new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(proceedToCheckoutLocator));
        proceedToCheckout.click();
    }
}
