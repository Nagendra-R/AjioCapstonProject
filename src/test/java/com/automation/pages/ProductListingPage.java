package com.automation.pages;

import com.automation.utils.ConfigReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Set;

public class ProductListingPage extends BasePageWeb {

    GridViewPage gridViewPage = new GridViewPage();

    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    Actions action = new Actions(driver);

    @FindBy(xpath = "//span[@aria-label='MEN']")
    WebElement menElementToHover;

    String clothTypeStr = "//a[@title='%s' and @href='/men-jackets-coats/c/830216010']";



    @FindBy(xpath = "//input[@id='Women - Jackets & Shrugs']/following-sibling::label")
    WebElement jacketsAndShrugs;

    @FindBy(xpath = "//div[contains(@aria-label, 'Found')]/strong")
    WebElement itemsFoundText;



    @FindBy(xpath = "//div[@id='0']//div[@class='_1gIWf']/p")
    List<WebElement> ratingsList;

    @FindBy(xpath = "//a[@title='HOME AND KITCHEN']")
    WebElement homeAndKitchenMenu;

    String ratingXpathString = "//input[@id='%d star & above'] ";

    @FindBy(xpath = "//span[contains(text(), 'rating')]")
    WebElement ratingMenu;



    @FindBy(xpath = "//a[text()='Brands']")
    WebElement brandElementToHover;

    String brandToSelect = "//a[text()='%s']";

    String productListingPageName = "//div[@aria-label='%s']";

    String individualBrandName = "//div[@aria-label='%s']";



    @FindBy(xpath = "//div[@aria-label='grid']/div/div[1]")
    WebElement singleProductSelection;



    @FindBy(xpath = "//span[@aria-label='BEAUTY']")
    WebElement beautyMenu;

    @FindBy(xpath = "//div[@id='0']//div[@class='nameCls']")
    List<WebElement> gridViewProductList;

    @FindBy(xpath = "//div[@aria-label='View grid 5']")
    WebElement gridViewButton;

    @FindBy(xpath = "//div[@aria-label='View grid 3']")
    WebElement threeGridViewButton;



    @FindBy(xpath = "//div[@class='header2']")
    WebElement searchText;

    @FindBy(xpath = "//select[@id='sortBy']/option")
    List<WebElement> listOfSortType;

    @FindBy(xpath = "//span[@class='price  ']/strong")
    List<WebElement> listOfPrices;

    @FindBy(xpath = "//div[@class='nameCls']")
    List<WebElement> listOfItemNames;

    @FindBy(xpath = "//div[@class='nameCls'][1]")
    WebElement firstItem;

    @FindBy(xpath = "//span[text() = 'ADD TO BAG']")
    WebElement addToBagButton;

    @FindBy(xpath = "//span[text() = 'L']")
    WebElement selectSize;

    @FindBy(xpath = "//span[text()='price']")
    WebElement priceButton;

    @FindBy(xpath = "//input[@name='minPrice']")
    WebElement minPriceField;

    @FindBy(xpath = "//input[@name='maxPrice']")
    WebElement maxPriceField;

    @FindBy(xpath = "//div[@class='facet-min-price-filter']/button")
    WebElement submitMinMaxButton;

    @FindBy(xpath = "//div[contains(text(), 'Sorry')]")
    WebElement meaninglessText;


//---------------- category number verification ------------------------



    public void hoverFunctionality(String clothType){
        action.moveToElement(menElementToHover).perform();

        String clothTypeXpath = String.format(clothTypeStr, clothType);
        driver.findElement(By.xpath(clothTypeXpath)).click();
    }

    public void categorySelection(){
        jacketsAndShrugs.click();

    }
    public String getTheNumber(){
        String jacketsStr = jacketsAndShrugs.getText();
        int startIndex = jacketsStr.indexOf('(');
        int endIndex = jacketsStr.indexOf(')');

        return jacketsStr.substring(startIndex+1, endIndex);
    }

    public boolean verifyNumberOfProducts() throws InterruptedException {
        Thread.sleep(4000);
        String itemsFoundStr = itemsFoundText.getText();
        System.out.println("Items found section: "+itemsFoundStr);
        System.out.println("Category selection:"+ getTheNumber());
        return itemsFoundStr.contains(getTheNumber());
    }


// ----After clicking on certain rating, make sure product with that rating is displayed------------


    public void menuFromTheHeaderClicks(){
        homeAndKitchenMenu.click();
    }

    public void ratingSelectionMethod(String rating) throws InterruptedException {
        ratingMenu.click();

        String ratingString = String.format(ratingXpathString, Integer.parseInt(rating));
        driver.findElement(By.xpath(ratingString)).click();
        Thread.sleep(4000);

    }
    boolean finalResult;
    public boolean verifyRatingOfProducts() throws InterruptedException {
        Thread.sleep(3000);
        int ratingValue = Integer.parseInt(ConfigReader.getConfigValue("rating.option"));
        for(WebElement rate : ratingsList){
            System.out.println("All the ratings:"+rate.getText());
            int value = Integer.parseInt(rate.getText());
            if(value >= ratingValue){
                finalResult = true;

            }
        }
        return finalResult;
    }

//-------------------      verifying selected brand only displayed      -------------------------


    public void headerSectionMenuHovering(){

        action.moveToElement(menElementToHover).perform();

    }

    public void brandMenuHovering(){
        action.moveToElement(brandElementToHover).perform();

    }

    public void brandSelection(String brand){

        String brandSelectXpathMake = String.format(brandToSelect, brand);
        driver.findElement(By.xpath(brandSelectXpathMake)).click();
    }

    public boolean productListingOfBrand() throws InterruptedException {
        Thread.sleep(3000);
        gridViewButton.click();
        Thread.sleep(3000);

        String productListingPageNameXpath = String.format(productListingPageName, ConfigReader.getConfigValue("brand").toUpperCase(Locale.ROOT));
        WebElement heading = driver.findElement(By.xpath(productListingPageNameXpath));
        return heading.isDisplayed();
    }

    boolean noRepetitionResult;
    public boolean verifyProductBrand() throws InterruptedException {
        Thread.sleep(3000);
        String brandName  = String.format(individualBrandName, ConfigReader.getConfigValue("brand").toUpperCase());
        List<WebElement> listOfNames = driver.findElements(By.xpath(brandName));
        int max = 10;
        if (listOfNames.size() > max) {
            listOfNames = listOfNames.subList(0, max);
        }
        for(WebElement element : listOfNames){
            if(element.getText().equals(ConfigReader.getConfigValue("brand").toUpperCase())){
                noRepetitionResult = true;
            }
        }
        return noRepetitionResult;
    }
//------------------------------- coupon verification -------------------------------------


    public void singleProductClick(){
        singleProductSelection.click();
    }
//------------------------------------- GRID VIEW PAGE --------------------------------------

    public void beautyMenuOptionClicks(){

        beautyMenu.click();
    }

    public void gridViewBtnClicks() {

        gridViewButton.click();
//        Thread.sleep(3000);

    }
    boolean finalResult2;

    public boolean verifyRowChanged(){
        threeGridViewButton.click();
        int beforeSize = gridViewProductList.size();
        gridViewButton.click();
        int afterSize = gridViewProductList.size();

        if((beforeSize != afterSize) && afterSize == 5 && beforeSize == 3){
            finalResult2 = true;
        }
        System.out.println("before Size:"+beforeSize);
        System.out.println("After Size:"+afterSize);
        return finalResult2;
    }

//-------------------------------------------------------------------------------------------
    public boolean verifyUserOnShirtsPage() {
        return searchText.isDisplayed();
    }

    public void selectTheHighestPrice(String sortType) {
        for (WebElement priceType : listOfSortType) {
            if (priceType.getText().equals(sortType)) {
                priceType.click();
            }
        }
        waitForListOfElementLocated(listOfPrices);

    }

    public boolean checkItemPricesInDescendingOrder() {
        List<Double> prices = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            String eachPrice = listOfPrices.get(i).getText();
            Double itemPrice = Double.parseDouble(eachPrice.substring(1).replace(",", ""));
            prices.add(itemPrice);
        }
        System.out.println(prices);
        for (int i = 1; i < prices.size(); i++) {
            if (prices.get(i) > prices.get(i - 1)) {
                return false;
            }
        }
        return true;
    }

    public boolean verifyItemsWithItemName(String itemName) {
        for (int i = 0; i < 10; i++) {
            System.out.println();
            if (!listOfItemNames.get(i).getText().contains(itemName)) {
                return false;
            }
        }
        return true;
    }

    public void clickOnFirstItem() {
        firstItem.click();
        Set<String> handles = driver.getWindowHandles();
        String[] handleArray = handles.toArray(new String[0]);
        // Switch to the new tab or window (usually the second handle in the list)
        driver.switchTo().window(handleArray[1]);

    }

    public boolean verifyAddToBagIsDisplayed() {
        return addToBagButton.isDisplayed();
    }

    public void clickOnAddToBag() {
        selectSize.click();
        addToBagButton.click();

    }


    public void fillTheMinAndMaxAmount(String min, String max) {
        priceButton.click();
        minPriceField.sendKeys(min);
        maxPriceField.sendKeys(max);
        submitMinMaxButton.click();
    }

    public boolean verifyThePriceBetweenMinAndMax() {
        waitForListOfElementLocated(listOfPrices);
        for (int i = 0; i < 10; i++) {
            String eachPrice = listOfPrices.get(i).getText();
            System.out.println("===>" + eachPrice);
            double itemPrice = Double.parseDouble(eachPrice.substring(1).replace(",", ""));
            if (!(itemPrice >= 600 && itemPrice <= 1200)) {
                return false;
            }
        }
        return true;
    }

    public boolean verifyItemsAreShown() {
        return meaninglessText.isDisplayed();
    }

}
