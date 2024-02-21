package PetStorePOM;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ProductPage {
    private WebDriver driver;
    private WebElement searchFields;
    private WebElement searchButton;
    private WebElement selectProduct;
    private WebElement itemProduct;
    private WebElement productNameElement;

    private final By searchIdElement = By.xpath("//input[@name='keyword']");
    private final By searchButtonElement = By.name("searchProducts");
    private final By selectIdProduct = By.xpath("//a[normalize-space()='Friendly dog from England']");
    private final By itemIdProduct = By.xpath("//a[normalize-space()='EST-7']");
    private final By productName = By.xpath("//font[contains(text(),'Female Puppy')]");
  
    

    public ProductPage(WebDriver driver) {
        this.driver = driver;
        driver.get("https://petstore.octoperf.com/actions/Catalog.action");
    }

    public void enterSearchKeyword(String keyword) {
        searchFields = new WebDriverWait(driver, Duration.ofSeconds(20))
                .until(ExpectedConditions.elementToBeClickable(searchIdElement));
        searchFields.clear();
        searchFields.sendKeys(keyword);
    }

    public void clickSearchButton() {
        searchButton = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(searchButtonElement));
        searchButton.click();
    }

    public void selectProduct() {
        selectProduct = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(selectIdProduct));
        selectProduct.click();
    }

    public void clickOnProduct() {
        itemProduct = new WebDriverWait(driver, Duration.ofSeconds(20))
                .until(ExpectedConditions.elementToBeClickable(itemIdProduct));
        itemProduct.click();
    }
    
    public void confirmAnimalDetails(String expectedProductName) {
    	productNameElement = driver.findElement(productName);
        String productName = productNameElement.getText();
        Assert.assertTrue("Product name contains 'Female Puppy'", productName.contains(expectedProductName));
    
    }
}
        