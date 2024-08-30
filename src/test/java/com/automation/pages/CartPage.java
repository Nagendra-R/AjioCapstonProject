package com.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.ArrayList;
import java.util.List;

public class CartPage extends BasePage {

    @FindBy(xpath = "//div[@class='ic-cart ']")
    WebElement cartIconButton;

    List<String> windowHandles = new ArrayList<>(driver.getWindowHandles());


    String sizeXpath = "//div[@tabindex='0']/span[text()='%s']";

    @FindBy(xpath = "//div[@role='button' and @class='btn-gold']")
    WebElement addToCartBtn;

    @FindBy(xpath = "//section[@id='orderTotal']/span[@class='price-value bold-font']")
    WebElement totalPrice;

    @FindBy(xpath = "//ul/li[1]//p[@aria-label='Savings']//span")
    WebElement couponPrice;

    @FindBy(xpath = "//ul/li[1]//div[@class='detail-info']")
    WebElement couponSelect;

    @FindBy(xpath = "//button[@aria-label='Apply']")
    WebElement couponApplyBtn;


    public void tabSwitch() {
        driver.switchTo().window(windowHandles.getLast());
    }


    @FindBy(xpath = "//button[text()='Proceed to shipping']")
    WebElement proceedToShippingButton;
    public void sizeSelection(String size) {
        String sizeStr = String.format(sizeXpath, size);
        driver.findElement(By.xpath(sizeStr)).click();
    }

    @FindBy(id = "error-tooltip")
    WebElement textInEmptyCartPage;

    @FindBy(xpath = "//span[text()='GO TO BAG']")
    WebElement goToCartBtn;

    public void addToCart() {
        addToCartBtn.click();
    }

    public boolean verifyItemAddedToBag() {
        clickElementByJS(cartIconButton);
        return proceedToShippingButton.isDisplayed();
    }
    public void goToCart() {
        waitForElementToBeClickable(goToCartBtn);
//        WebElement goToCartBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='GO TO BAG']")));
        goToCartBtn.click();
    }

    public void couponSelection() {
        couponSelect.click();
        couponApplyBtn.click();
    }

    public boolean verifyCouponIsApplied() throws InterruptedException {
        String originalPriceStr = totalPrice.getText().substring(1).replace(",", "");
        System.out.println("original price str:" + originalPriceStr);
        String couponPriceStr = couponPrice.getText().substring(1);
        System.out.println("coupon price str:" + couponPriceStr);


        float finalPrice = Float.parseFloat(originalPriceStr) - Float.parseFloat(couponPriceStr);
        System.out.println("final Price:" + finalPrice);
        Thread.sleep(3000);
        WebElement priceAfterCouponApplied = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//section[@id='orderTotal']/span[@class='price-value bold-font']")));
        System.out.println("price after coupon is applied" + priceAfterCouponApplied.getText().replace(",", ""));

        return priceAfterCouponApplied.getText().replace(",", "").contains(Float.toString(finalPrice));
    }

    public String getTextFromCartPage() {
        return textInEmptyCartPage.getText();
    }

//------------------  product deletion functionality  ----------------------------------------

    @FindBy(xpath = "//div[@aria-label='Delete']")
    WebElement deleteBtn;

    @FindBy(xpath = "//div[@class='card-delete-button']/div[2]")
    WebElement deleteBtnInPopUp;

//    @FindBy(xpath = "//div[@class='mybag-section']/span[2]")
//    WebElement cartItemsCount;

    @FindBy(xpath = "//div[@class=' empty-cart']/p")
    WebElement emptyCartText;


    public void deleteBtnClick() {

        deleteBtn.click();
        deleteBtnInPopUp.click();

    }

    boolean cartVerify;

    public boolean verifyProductIsRemoved() throws InterruptedException {

        return cartVerify = emptyCartText.isDisplayed();

    }


//------------------ quantity changing --------------------------------------------------

    @FindBy(xpath = "//div[@class='cartqty']")
    WebElement quantityChangeBtn;

    @FindBy(xpath = "//button[@class='increment button']")
    WebElement incrementBtn;

    @FindBy(id = "updateQuantity")
    WebElement quantityUpdateBtn;

    @FindBy(className = "counter")
    WebElement quantityValue;

    @FindBy(xpath = "//span[@aria-label='items']")
    WebElement myBagsItemsQuantity;

    private String updatedText;
    public void changeQuantityProcess(){
        quantityChangeBtn.click();
        incrementBtn.click();
        updatedText = quantityValue.getText();
        quantityUpdateBtn.click();
    }

    public String updatedTextReturn(){
        return updatedText;
    }

    public boolean verifyQuantityChange(){
        String myBagsQuantityStr = myBagsItemsQuantity.getText();
        System.out.println("Value inside parantheses : " + myBagsQuantityStr);
        System.out.println("after quantity incremented value:"+updatedText);
        return myBagsQuantityStr.contains(updatedTextReturn());
    }

    public void scrollToElement(){
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", addToCartBtn);
    }

}
