package com.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPageMobile extends BasePageMobile {

    @FindBy(xpath = "//android.widget.TextView[@text='Login or Signup']")
    WebElement loginOrSignUpText;

    @FindBy(xpath = "//android.widget.Button[@text='Sign in / Join']")
    WebElement loginSignUpButton;

    @FindBy(xpath = "//android.widget.TextView[@resource-id='com.ril.ajio:id/user_name']")
    WebElement usernameText;

    @FindBy(xpath = "//android.widget.TextView[@text='Logout']")
    WebElement logoutButton;

    @FindBy(xpath = "//android.widget.EditText[@text='Enter Mobile Number']")
    WebElement mobileText;

    @FindBy(xpath = "//android.widget.TextView[@text='Continue']")
    WebElement continueButton;

    @FindBy(xpath = "//android.widget.TextView[@text='Verify Details']")
    WebElement otpScreenView;

    @FindBy(xpath = "//android.widget.TextView[@resource-id='com.ril.ajio:id/error_tv']")
    WebElement wrongMessage;

    String loc = "//android.widget.EditText[@resource-id='com.ril.ajio:id/otp_et%s']";



    public void fillTheOtpManually() {

    }

    public boolean verifyUserOnLoginScreen() {
        return isPresent(loginOrSignUpText);
    }

    public boolean verifyUserOnSignUpLoginScreen() {
        return isPresent(loginSignUpButton);
    }

    public void clickOnTheLoginSignUpButton() {
        clickOnElementIfPresent(loginSignUpButton);
    }

    public void fillThePhoneNumber(String phoneNumber) {
        mobileText.sendKeys(phoneNumber);
    }

    public void clickOnContinueButton() {
        continueButton.click();
    }

    public boolean verifyUserOnOtpScreen() {
        return isPresent(otpScreenView);
    }

    public void fillTheRandomOtp() {

        for(int i=1;i<5;i++){
            String xpath = String.format(loc,i);
            System.out.println(xpath);
            String ans = getRandomInteger();
            driver.findElement(By.xpath(xpath)).sendKeys(ans);
        }

        System.out.println("finish ");
    }

    public String getTheWrongMessage() {
        return wrongMessage.getText();
    }

    public boolean verifyUserSuccessfullyLogin() {
        return isPresent(usernameText);
    }

    public void scrollTillTheLogoutButton() {
        Dimension dimension = driver.manage().window().getSize();
        int width = dimension.getWidth();
        int height = dimension.getHeight();

        while(!isPresent(logoutButton)){
            scrollOrSwipe(width/2,height/2,width/2,0);
        }
    }

    public void clickOnLogoutButton() {
        clickOnElementIfPresent(logoutButton);
    }
}
