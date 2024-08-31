package com.automation.steps;

import com.automation.pages.CartPage;
import com.automation.pages.SingleProductPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SingleProductSteps {

    SingleProductPage singleProductPage = new SingleProductPage();
    CartPage cartPage = new CartPage();

    @When("add to cart button is clicked")
    public void addToCartButtonIsClicked(){

        cartPage.tabSwitch();
        singleProductPage.addToCart();

    }

    @Then("add the product to the cart")
    public void add_the_product_to_the_cart() {

        singleProductPage.addToCart();

    }
    @Then("go to the cart page")
    public void go_to_the_cart_page() {

        singleProductPage.goToCart();

    }
}
