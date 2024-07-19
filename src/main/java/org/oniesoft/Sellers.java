package org.oniesoft;

import oniesoft.WebFramework.BrowserFunctions;
import oniesoft.web.actions.WaitForElement;
import org.openqa.selenium.By;

public class Sellers extends BrowserFunctions {
    private By closetBtn = By.xpath("(//button[contains(text(),'Close')])[1]");
    private By submitBtn = By.xpath("(//button[contains(text(),'Submit')])[1]");
    private By removeBtn = By.xpath("(//button/span)[1]");
    private By notification=By.xpath("//div[contains(@class,'pc-notifications')]/p");
    private  By search = By.xpath("//input[@type='search']");
    public void clickOnSubmitBtn() {
        click(submitBtn, "Click On Submit Button");
    }

    public void clickOnCloseBtn() {
        click(closetBtn, "Click On Close Button");
    }

    public void clickOnRemoveBtn() {
        click(removeBtn, "Click On Remove Button");
    }

    public String sellerName(String name) {
        return String.format("//td[normalize-space()='%s']/../td[4]//label", name);
    }


    public void SearchName(String ctryname) throws InterruptedException {
        Thread.sleep(4000);
        enterText(search,ctryname,"entered category name");
    }
    private By getSellerName=By.xpath("(//td[@class=' userName'])[1]");
    public String getSellerName() throws InterruptedException {
        Thread.sleep(2000);
        waitForElement(getSellerName,20, WaitForElement.visibility);
        String name= getText(getSellerName,"User name");
        return name;
    }
}
