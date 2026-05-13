package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchPage {

    WebDriver driver;

    public SearchPage(WebDriver driver) {
        this.driver = driver;
    }

    By firstProduct = By.xpath("(//div[contains(@class,'KzDlHZ')])[1]");

    public void clickFirstProduct() {

        driver.findElement(firstProduct).click();
    }
}