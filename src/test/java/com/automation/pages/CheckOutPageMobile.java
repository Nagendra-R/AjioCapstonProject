package com.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class CheckOutPageMobile extends BasePageMobile {

    @FindBy(xpath = "//android.widget.TextView[@text='Add To Bag']")
    WebElement addToBagButton;

    @FindBy(xpath = "//android.widget.TextView[@text='ADD TO BAG']")
    WebElement againClickOnAddToBagButton;

    @FindBy(xpath = "//android.widget.TextView[@text='View Bag']")
    WebElement viewBagButton;

    @FindBy(xpath = "//android.widget.ImageButton[@resource-id='com.ril.ajio:id/add_to_closet']")
    WebElement wishListButtonPopUp;

    @FindBy(xpath = "//android.widget.TextView[@text='SIMILAR']")
    WebElement similarButtonPopUp;

    @FindBy(xpath = "//android.widget.TextView[@text='Select Size']")
    WebElement selectSizeText;

    @FindBy(xpath = "//android.widget.LinearLayout[@resource-id='com.ril.ajio:id/row_pdp_color']")
    List<WebElement> listOfColours;


    String loc = "//android.widget.TextView[@text='%s']";


    public boolean verifyAddToBagButtonIsDisplayed() {
        return isPresent(addToBagButton);
    }

    public void clickOnAddToBagButton() {
        clickOnElementIfPresent(addToBagButton);
    }

    public void clickOnSizeAndAddToBagButton(String size) {
        String xPath = String.format(loc,size);
        driver.findElement(By.xpath(xPath)).click();
        clickOnElementIfPresent(againClickOnAddToBagButton);
    }

    public boolean verifyViewBagIsDisplayed() {
        return isPresent(viewBagButton);
    }

    public void clickOnViewBagButton() {
        clickOnElementIfPresent(viewBagButton);
    }

    public void clickOnTheWishListAndSimilarButtonPopUp() {
        clickOnElementIfPresent(wishListButtonPopUp);
        clickOnElementIfPresent(similarButtonPopUp);
    }

    public void scrollTillTheSelectSize() {
        Dimension dimension = driver.manage().window().getSize();
        int width = dimension.getWidth();
        int height = dimension.getHeight();

        while(!isPresent(selectSizeText)){
            scrollOrSwipe(width/2,height/2,width/2,0);
        }
    }

    public boolean verifyItemHasMoreThanOneColourItem() {
        System.out.println(listOfColours.size());
        return listOfColours.size()>1;
    }



}
