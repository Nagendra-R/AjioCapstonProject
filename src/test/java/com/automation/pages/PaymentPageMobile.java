package com.automation.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PaymentPageMobile extends BasePageMobile {

    @FindBy(xpath = "//android.widget.TextView[@text='Proceed to Payment']")
    WebElement paymentProceedButton;

    @FindBy(xpath = "//android.widget.TextView[@resource-id='com.ril.ajio:id/row_cart_summary_tv_total']")
    WebElement amountPayable;

    @FindBy(xpath = "//android.widget.TextView[@text='Apply coupon']")
    WebElement applyCoupon;

    @FindBy(xpath = "//android.widget.ImageView[@resource-id='com.ril.ajio:id/close_dialog']")
    WebElement closeButtonAfterCouponApplied;

    @FindBy(xpath = "//android.widget.TextView[@resource-id='com.ril.ajio:id/row_cart_summary_tv_coupon_saving']")
    WebElement couponAmountText;

    @FindBy(xpath = "//android.widget.TextView[@resource-id='com.ril.ajio:id/fee_value_tv']")
    WebElement deliveryFeeElement;


    double amountBeforeCoupon= 0.0;
    double amountAfterCoupon= 0.0;
    double deliveryFee =0.0;


    public boolean verifyUserOnPaymentScreen() {
        return isPresent(paymentProceedButton);
    }

    public void storeAmountBeforeApplyingCoupon() {
         amountBeforeCoupon = Double.parseDouble(amountPayable.getText().replace(",","").substring(1));
        deliveryFee = Double.parseDouble(deliveryFeeElement.getText().replace(",","").substring(1));
    }

    public void clickOnApplyCoupon() {
        clickOnElementIfPresent(applyCoupon);
    }

    public void clickOnCancelButtonAfterCouponApplied() {
        clickOnElementIfPresent(closeButtonAfterCouponApplied);
    }

    public boolean checkBalanceBeforeAndAfterCouponApplied() {
        amountAfterCoupon = Double.parseDouble(amountPayable.getText().replace(",","").substring(1));
        double couponApplied =  Double.parseDouble(couponAmountText.getText().replace(",","").substring(2));
        System.out.println(amountBeforeCoupon +"  "+ couponApplied + "  "+ amountAfterCoupon);
        double finalAmount = amountBeforeCoupon - couponApplied - deliveryFee;
        return finalAmount == amountAfterCoupon;

    }
}
