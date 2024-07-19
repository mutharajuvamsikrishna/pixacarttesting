package org.oniesoft;

import oniesoft.WebFramework.BrowserFunctions;
import oniesoft.api.reporting.ExtentTestManager;
import oniesoft.web.actions.WaitForElement;
import org.openqa.selenium.By;

import java.util.concurrent.BrokenBarrierException;

public class Products extends BrowserFunctions {
    private By addNewAttributeBtn=By.xpath("//a[@id='addNewAttributeBtn']");
    private By attributeNameText=By.xpath("//input[@id='attribute_name']");
 private By attributeValueText=By.xpath("//input[@class='type-zone']");
private By attributeCategoryDropDown=By.xpath("//select[@id='attributes_cate']");
    private By submitBtn = By.xpath("(//button[contains(text(),'Submit')])[1]");
private By closeBtn=By.xpath("(//button[contains(text(),'Close')])[1]");
    private By removeBtn = By.xpath("(//button/span)[1]");
    private By notification=By.xpath("//div[contains(@class,'pc-notifications')]/p");
    private  By searchAttributes = By.xpath("//input[@type='search']");
    public void clickOnAddNewAttributeBtn(){
        click(addNewAttributeBtn,"Click On Add New Attribute");
    }

    //Add New Brands Path
    private By addNewBrandBtn=By.xpath("//a[@id='addNewBrandBtn']");
    private By brandNameInputText=By.xpath("//input[@id='brand_name']");
    private By brandInptImage=By.xpath("//input[@type='file']");
    //View Products
  public void enterAttributeName(String attributeName){
        click(attributeNameText,"Click On Attribute Name");
        enterText(attributeNameText,attributeName,"Enter Text in AttributeName");
  }
  public void enterAttributeValueText(String attributeValue){
        click(attributeValueText,"Click On Attribute Value");
        enterText(attributeValueText,attributeValue,"Enter Attribute Value");
  }
  public void selectCategoryDropDown(String categoryName){
        click(attributeCategoryDropDown,"Click On AttributeCategoryDropDown");
        selectDropdown(attributeCategoryDropDown,categoryName,"Select an Option In Category DropDown");
  }
    public void clickOnSubmitBtn() {
        click(submitBtn, "Click On Submit Button");
    }

    public void clickOnCloseBtn() {
        click(closeBtn, "Click On Close Button");
    }

    public void clickOnRemoveBtn() {
        click(removeBtn, "Click On Remove Button");
    }

    public void attributeAddedNotification() {
        waitForElement(notification,20, WaitForElement.visibility);
        String text=getText(notification,"Notificatin Text Get");
        verifyElementContainsText(notification,text,  "Notification");
        if(text.contains("Yikes!")){
            clickOnCloseBtn();
        }

    }

    public void searchProducts(String attributeName) throws InterruptedException {
        Thread.sleep(4000);
        enterText(searchAttributes,attributeName,"entered category name");
    }

    private By getAttributeName=By.xpath("(//td[@class=' attribute_name'])[1]");

    public String getAttributeName() throws InterruptedException {
        Thread.sleep(2000);
        waitForElement(getAttributeName,20,WaitForElement.visibility);
        String name= getText(getAttributeName,"category name");
        return name;
    }
    //Add New Brand
    public void clickAddNewBrandBtn(){
        click(addNewBrandBtn,"Click On Add New Brand");
    }
    public void enterBrandTxt(String brandName){
        click(brandNameInputText,"Click On Brand Name");
        enterText(brandNameInputText,brandName,"Entered Brand Name");
    }
    public void uploadBrandImage(String path){
        getElement(brandInptImage, "Enter Image Path For Brands").sendKeys(path);
        ExtentTestManager.setInfoMessageInReport("Enter Image Path For Brands");
    }
    private By getBrandName=By.xpath("//td[@class=' brand_name']");

    public String getBrandName() throws InterruptedException {
        Thread.sleep(2000);
        waitForElement(getBrandName,20,WaitForElement.visibility);
        String name= getText(getBrandName,"Brand name");
        System.out.println(name);
        return name;
    }
    //products

    private By getProductName=By.xpath("//td[@class=' p_name']");
public void print(){
    System.out.println(getProductName);
}
    public String getProductName() throws InterruptedException {
        Thread.sleep(2000);
        waitForElement(getProductName, 20, WaitForElement.visibility);
        String name = getText(getProductName, "Product Name");
        System.out.println(name);
        return name;
    }
}
