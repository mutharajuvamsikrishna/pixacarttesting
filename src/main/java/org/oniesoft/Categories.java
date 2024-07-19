package org.oniesoft;

import oniesoft.WebFramework.BrowserFunctions;
import oniesoft.api.reporting.ExtentTestManager;
import oniesoft.web.actions.WaitForElement;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Categories extends BrowserFunctions {
    private By addNewCategoryBtn = By.id("addNewCateBtn");
    private By nameInput = By.xpath("//input[@name='cate_name']");
    private By imageInput = By.xpath("//div/input[@type='file']");
    private By closetBtn = By.xpath("(//button[contains(text(),'Close')])[1]");
    private By submitBtn = By.xpath("(//button[contains(text(),'Submit')])[1]");
    private By removeBtn = By.xpath("(//button/span)[1]");
    private By nootificetion=By.xpath("//div[contains(@class,'pc-notifications')]/p");
    private  By searchcatagry = By.xpath("//input[@type='search']");


    //SubCategory Xpath's
    private By addSubCategoryBtn= By.xpath("//a[@id='addNewSubCateBtn']");
    private By subCatInputName=By.xpath("//input[@id='cate_name']");
    private By mainCategoryDropdown=By.xpath(" //select[@id='main_cateid']");
    private By subCategoryImageInput=By.xpath("//div/input[@type='file']");
    private By subCategorySubmitBtn=By.xpath("(//button[contains(text(),'Submit')])[1]");

    public void clickAddNewCategoryBtn() {
        click(addNewCategoryBtn, "Click on AddNewCategory Button");
    }

    public void enterCategoryNameInput(String name) {
        click(nameInput, "Click On CategoryName Input Field");
        waitForElement(nameInput, 20, WaitForElement.visibility);
        enterText(nameInput, name, "Enter Category Name");
    }

    public void enterImageInput(String path) {
         getElement(imageInput, "Enter Image Path").sendKeys(path);

    }

    public void clickOnSubmitBtn() {
        click(submitBtn, "Click On Submit Button");
    }

    public void clickOnCloseBtn() {
        click(closetBtn, "Click On Close Button");
    }

    public void clickOnRemoveBtn() {
        click(removeBtn, "Click On Remove Button");
    }

    public String categoryName(String name) {
        return String.format("//td[normalize-space()='%s']/../td[4]//label", name);
    }

    public void clickStatusToggleBasedOnCategoryName(String name) {
        By ele = By.xpath(categoryName(name));
        click(ele, "Clock On Status ToggleFunction");

    }
    public void categoryAddedNotification() {
        waitForElement(nootificetion,20,WaitForElement.visibility);
        String text=getText(nootificetion,"Notificatin Text Get");
        verifyElementContainsText(nootificetion,text,  "Notification");
        if(text.contains("Yikes!")){
     clickOnCloseBtn();
        }

    }

    public void SearchCategory(String ctryname) throws InterruptedException {
        Thread.sleep(4000);
        enterText(searchcatagry,ctryname,"entered category name");
    }
    private By getCatagryname=By.xpath("(//td[@class=' cate_name'])[1]");
    public String getcatogeryname() throws InterruptedException {
        Thread.sleep(2000);
        waitForElement(getCatagryname,20,WaitForElement.visibility);
       String name= getText(getCatagryname,"category name");
       return name;
    }
    private By getSubCatagryname=By.xpath("(//td[@class=' subcate_name'])[1]");
    public String getSubcatogeryname() throws InterruptedException {
        Thread.sleep(2000);
        waitForElement(getSubCatagryname,20,WaitForElement.visibility);
        String name= getText(getSubCatagryname,"Sub category name");
        return name;
    }


    //Sub Category Methods
    public void clickAddNewSubCategoryBtn() {
        click(addSubCategoryBtn, "Click on AddNewCategory Button");
    }
    public void enterSubCategoryNameInput(String name) {
        click(subCatInputName, "Click On CategoryName Input Field");
        waitForElement(subCatInputName, 20, WaitForElement.visibility);
        enterText(subCatInputName, name, "Enter Category Name");
    }
    public void selectMainCategoryList(String name){

        click(mainCategoryDropdown,"Click on MainCategory in SubCategory");
        selectDropdown(mainCategoryDropdown,name,"Subcategory Element Name");
    }
    public void uploadSubCategoryImage(String path){
        getElement(subCategoryImageInput, "Enter Image Path For SubCategory").sendKeys(path);
        ExtentTestManager.setInfoMessageInReport("Enter Image Path For SubCategory");
    }
    public void clickOnSubCategorySubmitBtn() {
        click(subCategorySubmitBtn, "Click On Submit Button");
    }
    public void checkCategoryElementInList(String name){
      //  verifyElementContainsText();
    }
}
