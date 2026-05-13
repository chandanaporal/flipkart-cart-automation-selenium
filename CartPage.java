package pages;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage {

    WebDriver driver;

    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

    By addToCartButton = By.xpath("//button[contains(text(),'Add to cart')]");

    public void switchWindow() {

        String parent = driver.getWindowHandle();

        Set<String> allWindows = driver.getWindowHandles();

        for(String window : allWindows) {

            if(!window.equals(parent)) {
                driver.switchTo().window(window);
            }
        }
    }

    public void addToCart() {

        driver.findElement(addToCartButton).click();
    }
}
