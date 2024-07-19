package org.oniesoft;

import oniesoft.WebFramework.BrowserFunctions;
import oniesoft.api.reporting.ExtentTestManager;
import oniesoft.web.actions.WaitForElement;
import org.openqa.selenium.By;

import java.io.Externalizable;

public class SellerProduct extends BrowserFunctions {
    private By clickAddNewProductBtn= By.xpath("//a[@id='addNewCateBtn']");
    private By prodName=By.xpath("//input[@id='pro_name']");
    private By prodDescription=By.xpath("//textarea[@id='pro_desc']");
    private By prodCat=By.xpath("//select[@id='pro_cate']");
    private By prodSubCat=By.xpath("//select[@id='pro_subcate']");
    private By prodBrand=By.xpath("//select[@id='pro_brand']");
    private By prodUnit=By.xpath("//select[@id='pro_unit']");
    private By prodSubmit=By.xpath("//button[@id='addProduct']");
    private By notification=By.xpath("//div[contains(@class,'pc-notifications')]/p");
public void clickAddNewProductBtnInProd(){
    click(clickAddNewProductBtn,"Click On Add New Product Btn");
}
public void enterProdName(String prod_name){
    click(prodName,"Click On ProdName");
    enterText(prodName,prod_name,"Enter Text In Prod_Name");
}
public void enterProdDescription(String prod_Desc){
    click(prodDescription,"Click On Prod_Description");
    enterText(prodDescription,prod_Desc,"Enter Text In Prod_description");
}
public void selectProdCat(String prod_Cat){
    click(prodCat,"Click On Prod_Cat");
  selectDropdown(prodCat,prod_Cat,"Select an Element in Prod_Cat");
}
public void  selectSubCat(String prod_subCat){
    click(prodSubCat,"Click On Prod_Cat");
    selectDropdown(prodSubCat,prod_subCat,"Select an Element in Prod_SubCat");
}
    public void  selectBrand(String prod_brand){
        click(prodBrand,"Click On Prod_Cat");
        selectDropdown(prodBrand,prod_brand,"Select an Element in Prod_SubCat");
    }
    public void  selectUnit(String prod_unit){
        click(prodUnit,"Click On Prod_Cat");
        selectDropdown(prodUnit,prod_unit,"Select an Element in Prod_SubCat");
    }
    public void  clickOnSubmit(){
    click(prodSubmit,"Click On ProductSubmit Btn");
    }
    public void productAddedNotification() {
        waitForElement(notification,20, WaitForElement.visibility);
        String text=getText(notification,"Notificatin Text Get");
        verifyElementContainsText(notification,text,  "Notification");
        if(text.contains("Yikes!")){
            ExtentTestManager.setInfoMessageInReport("Error While Adding The Product");
        }

    }
}
