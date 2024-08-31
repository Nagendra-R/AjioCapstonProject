package com.automation.steps;

import com.automation.pages.ProductListingPage;
import com.automation.utils.ConfigReader;
import com.automation.utils.ReportManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class ProductListingSteps {

    ProductListingPage productListingPage = new ProductListingPage();

    @Then("hover over men section and click on a type {string}")
    public void hover_over_men_section_and_click_on_a_type(String type) {

        productListingPage.hoverFunctionality(ConfigReader.getConfigValue(type));

    }

    @When("product list page is displayed select a category")
    public void productListPageIsDisplayedSelectACategory() {

        productListingPage.categorySelection();

    }

    @Then("verify the number along the category is same as total products")
    public void verify_the_number_along_the_category_is_same_as_total_products() throws InterruptedException {

        Assert.assertTrue(productListingPage.verifyNumberOfProducts());

    }


//----------------------------RATING VERIFICATION-------------------------------------------

    @And("clicks on the home and kitchen menu from the header")
    public void clicksOnTheHomeAndKitchenMenuFromTheHeader() {
        productListingPage.menuFromTheHeaderClicks();

    }


    @When("user is on home and kitchen page, click on a rating {string}")
    public void userIsOnHomeAndKitchenPageClickOnARating(String rating) throws InterruptedException {

        productListingPage.ratingSelectionMethod(ConfigReader.getConfigValue(rating));

    }

    @Then("verify the products have the selected rating only")
    public void verifyTheProductsHaveTheSelectedRatingOnly() throws InterruptedException {

        Assert.assertTrue(productListingPage.verifyRatingOfProducts());

    }

//------------------------BRAND SELECTION VERIFICATION-----------------------------------------

    @And("user hovers above a menu in the header section")
    public void userHoversAboveAMenuInTheHeaderSection() {

        productListingPage.headerSectionMenuHovering();
    }


    @Then("hover over the brand menu option")
    public void hoverOverTheBrandMenuOption() {

        productListingPage.brandMenuHovering();
    }

    @And("select a particular brand {string}")
    public void selectAParticularBrand(String brand) {

        productListingPage.brandSelection(ConfigReader.getConfigValue(brand));
    }

    @When("user is on the product listing page")
    public void userIsOnTheProductListingPage() throws InterruptedException {

        Assert.assertTrue(productListingPage.productListingOfBrand());
    }

    @Then("verify every product is of the selected brand only")
    public void verifyEveryProductIsOfTheSelectedBrandOnly() throws InterruptedException {

        Assert.assertTrue(productListingPage.verifyProductBrand());
    }

//----------------------------COUPON VERIFICATION------------------------------------------

    @Then("click on a product")
    public void clickOnAProduct() {
        productListingPage.singleProductClick();
    }

//---------------------------------GRID VIEW PAGE---------------------------------------

    @And("user clicks on the beauty menu from the homepage")
    public void userClicksOnTheBeautyMenuFromTheHomepage() {

        productListingPage.beautyMenuOptionClicks();

    }

    @When("user is on the beauty page and clicks grid button")
    public void userIsOnTheBeautyPageAndClicksGridButton() throws InterruptedException {

        productListingPage.gridViewBtnClicks();
    }

    @Then("verify number of products displayed in a single row changed")
    public void verifyNumberOfProductsDisplayedInASingleRowChanged() {

        Assert.assertTrue(productListingPage.verifyRowChanged());
    }

//-----------------------------------------------------------------------------------------------
    @Then("verify user on shirts item page")
    public void verifyUserOnShirtsItemPage() {
        org.testng.Assert.assertTrue(productListingPage.verifyUserOnShirtsPage());
    }

    @When("select price {string}")
    public void selectPrice(String highestPrice) {
        productListingPage.selectTheHighestPrice(highestPrice);
    }

    @Then("verify the price in desc order")
    public void verifyThePriceInDescOrder() {
        org.testng.Assert.assertTrue(productListingPage.checkItemPricesInDescendingOrder());
    }

    @Then("user check the each item result with the {string}")
    public void userCheckTheEachItemResultWithThe(String itemName) {
        org.testng.Assert.assertTrue(productListingPage.verifyItemsWithItemName(itemName));
    }

    @When("click on first item")
    public void clickOnFirstItem() {
        productListingPage.clickOnFirstItem();
    }

    @Then("verify user on add to bag page")
    public void verifyUserOnAddToBagPage() {
        org.testng.Assert.assertTrue(productListingPage.verifyAddToBagIsDisplayed());
    }

    @When("click on the add to bag button")
    public void clickOnTheAddToBagButton() {
        productListingPage.clickOnAddToBag();
    }


    @When("fill the min {string} and max {string} amount")
    public void fillTheMinAndMaxAmount(String min, String max) {
        productListingPage.fillTheMinAndMaxAmount(min,max);
    }

    @Then("validate the price is between min and max")
    public void validateThePriceIsBetweenMinAndMax() {
        org.testng.Assert.assertTrue(productListingPage.verifyThePriceBetweenMinAndMax());
    }

    @Then("verify the items are shown")
    public void verifyTheItemsAreShown() {
        if(!productListingPage.verifyItemsAreShown()){
            System.out.println("Its valid word only");
        }else{
            System.out.println("Meaning less word");
            ReportManager.log("Meaningless word search!!.. Search with meaningful text");
            ReportManager.attachScreenshot();
        }
    }

}
