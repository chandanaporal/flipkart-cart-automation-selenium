package tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.CartPage;
import pages.HomePage;
import pages.SearchPage;
import utils.TestListener;

@Listeners(TestListener.class)
public class FlipkartTest extends BaseTest {

    @DataProvider(name = "productData")
    public Object[][] getData() {

        return new Object[][] {
            {"iPhone 15"},
            {"Samsung Mobile"}
        };
    }

    @Test(dataProvider = "productData")
    public void addProductToCart(String productName) throws InterruptedException {

        HomePage home = new HomePage(driver);
        home.searchProduct(productName);

        Thread.sleep(3000);

        SearchPage search = new SearchPage(driver);
        search.clickFirstProduct();

        CartPage cart = new CartPage(driver);
        cart.switchWindow();

        Thread.sleep(3000);

        cart.addToCart();

        Thread.sleep(3000);

        String currentURL = driver.getCurrentUrl();

        Assert.assertTrue(currentURL.contains("cart"));
    }
}