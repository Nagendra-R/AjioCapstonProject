package com.automation.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ItemsListPageMobile extends BasePageMobile {

    @FindBy(xpath = "//android.widget.TextView[@text='Shirts']")
    WebElement itemTextDisplayed;

    @FindBy(xpath = "(//android.widget.TextView[@resource-id='com.ril.ajio:id/plp_row_prd_name_tv'])[2]")
    WebElement firstSearchedItem;

    @FindBy(xpath = "//android.widget.TextView[@text='SORT BY']")
    WebElement sortByText;

    @FindBy(xpath = "//android.widget.ImageView[@resource-id='com.ril.ajio:id/menu_cart_iv']")
    WebElement wishListButtonPopUp;

    public boolean verifyUserOnItemsScreen() {
        return isPresent(sortByText);
    }

    public void clickOnFirstItem() {
        clickOnElementIfPresent(firstSearchedItem);
    }

    public void clickOnTheWishList() {
        wishListButtonPopUp.click();
    }
}
