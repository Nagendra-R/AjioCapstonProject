package com.automation.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CouponScreenPageMobile extends BasePage{

    @FindBy(xpath = "//android.widget.TextView[@text='Apply coupon']")
    WebElement applicableText;

    @FindBy(xpath = "(//android.widget.TextView[@resource-id='com.ril.ajio:id/applyCouponTv'])[2]")
    WebElement applyCouponButton;


    public boolean verifyUserOnCouponScreen() {
            return isPresent(applicableText);
    }

    public void clickOnFirstApplyCoupon() {
        clickOnElementIfPresent(applyCouponButton);
    }


}
