package com.automation.steps;

import com.automation.pages.CartPage;
import com.automation.utils.ConfigReader;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;


public class CartPageSteps {

    CartPage cartPage = new CartPage();

    @Given("select a size for the product")
    public void select_a_size_for_the_product() {

        cartPage.tabSwitch();
        cartPage.sizeSelection(ConfigReader.getConfigValue("product.size"));

    }

    @When("user is on the cart page select a coupon and click apply")
    public void user_is_on_the_cart_page_select_a_coupon_and_click_apply() {

        cartPage.couponSelection();

    }
    @Then("verify the selected coupon is applied to the product")
    public void verify_the_selected_coupon_is_applied_to_the_product() throws InterruptedException {

        Assert.assertTrue(cartPage.verifyCouponIsApplied());

    }

//-----------------  Product delete button functionality  ---------------------------------


    @When("user is on the cart page click on the delete button")
    public void userIsOnTheCartPageClickOnTheDeleteButton() {
        cartPage.deleteBtnClick();
    }

    @Then("verify the product is removed from the cart")
    public void verifyTheProductIsRemovedFromTheCart() throws InterruptedException {

        Assert.assertTrue(cartPage.verifyProductIsRemoved());

    }


//------------------------------ quantity changing  -----------------------------------------

    @When("user is on the cart page change the quantity of the product")
    public void userIsOnTheCartPageChangeTheQuantityOfTheProduct() {

        cartPage.changeQuantityProcess();
    }

    @Then("verify the price is changed based on quantity")
    public void verifyThePriceIsChangedBasedOnQuantity() {

        Assert.assertTrue(cartPage.verifyQuantityChange());

    }

//----------------------------- product without a size ----------------------------------------



    @Then("verify product can't be added to cart without a size")
    public void verifyProductCanTBeAddedToCartWithoutASize() {
        Assert.assertEquals("Please select a size", cartPage.getTextFromCartPage());
    }

//-------------------------------------------------------------------------------------------

    @Then("verify the item is added to bag")
    public void verifyTheItemIsAddedToBag() {
        org.testng.Assert.assertTrue(cartPage.verifyItemAddedToBag());
    }

    @Then("verify cart is empty")
    public void verifyCartIsEmpty() {
        org.testng.Assert.assertEquals("Cart not found",cartPage.getTextFromCartPage());
    }

}
