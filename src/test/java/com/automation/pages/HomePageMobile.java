package com.automation.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;


public class HomePageMobile extends BasePageMobile {

    @FindBy(xpath = "//android.widget.Button[@text='Allow']")
    WebElement allowBut;

    @FindBy(xpath = "//android.widget.ImageView[@resource-id='com.ril.ajio:id/fahIvMenu']")
    WebElement menuButton;




    @FindBy(xpath = "(//android.widget.ImageView[@resource-id='com.ril.ajio:id/tab_icon'])[5]")
    WebElement bagIcon;

    @FindBy(xpath = "//android.widget.TextView[@resource-id='com.ril.ajio:id/bagEmptyHeaderTv']")
    WebElement bagText;

    @FindBy(xpath = "//android.widget.TextView[@resource-id='com.ril.ajio:id/llpsTvSearch']")
    WebElement searchFieldInput;

    @FindBy(xpath = "//android.widget.EditText[@resource-id='com.ril.ajio:id/searchETV']")
    WebElement passInputText;

    @FindBy(xpath = "//android.widget.TextView[@resource-id='com.ril.ajio:id/toolbar_title_tv']")
    WebElement searchTextDisplay;

    @FindBy(xpath = "//android.widget.ImageView[@resource-id='com.ril.ajio:id/search_image']")
    WebElement searchButton;

    @FindBy(xpath = "//android.widget.TextView[@resource-id='com.ril.ajio:id/plp_row_prd_name_tv']")
    List<WebElement> listOfItems;

    @FindBy(xpath = "(//android.widget.ImageView[@resource-id='com.ril.ajio:id/tab_icon'])[3]")
    WebElement accountButton;







    public void userOpenApplication() {
        clickOnElementIfPresent(allowBut);
    }

    public boolean verifyUserOnHOmeScreen() {
        return isPresent(menuButton);
    }






    public void clickOnBag() {
        clickOnElementIfPresent(bagIcon);

    }

    public String getTheTextInsideTheBag() {
        return  bagText.getText();
    }

    public void searchWithItem(String item) {
        clickOnElementIfPresent(searchFieldInput);
        passInputText.sendKeys(item);
        clickOnElementIfPresent(searchButton);

//        System.out.println("after");
//        driver.pressKeyCode(AndroidKeyCode.KEYCODE_ENTER);
//        passInputText.sendKeys(Keys.ENTER);
//        JavascriptExecutor js = (JavascriptExecutor) driver;
//        js.executeScript("arguments[0].value=item",passInputText);

//        AndroidDriver<AndroidElement> androidDriver = (AndroidDriver<AndroidElement>) driver;
//
//// Simulate pressing Enter key
//        androidDriver.pressKeyCode(AndroidKeyCode.KEYCODE_ENTER);

//        passInputText.sendKeys("\n");
//        Actions action = new Actions(driver);
//        action.moveToElement(electronicsLink).pause(1000)
//                .keyDown(Keys.CONTROL).click(appleLink).keyUp(Keys.CONTROL)
//                .build().perform();
    }

    public boolean verifyEachItemWithText(String itemText) {
        for (WebElement element : listOfItems){
            if(!element.getText().contains(itemText)){
                return false;
            }
        }
        return true;
    }

    public void clickOnAccount() {
        clickOnElementIfPresent(accountButton);
    }
}
