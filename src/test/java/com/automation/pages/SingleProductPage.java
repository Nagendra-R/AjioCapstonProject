package com.automation.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SingleProductPage extends BasePageWeb {

    @FindBy(xpath = "//div[@role='button' and @class='btn-gold']")
    WebElement addToCartBtn;

    @FindBy(xpath = "//span[text()='GO TO BAG']")
    WebElement goToCartBtn;

    public void goToCart() {
        waitForElementToBeClickable(goToCartBtn);
//        WebElement goToCartBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='GO TO BAG']")));
        goToCartBtn.click();
    }

    public void addToCart() {
        addToCartBtn.click();
    }
}
