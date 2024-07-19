package org.oniesoft.tests;

import oniesoft.WebFramework.Runner;
import oniesoft.api.reporting.ExtentTestManager;
import org.oniesoft.*;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.Map;

public class ProductTest {
    private SignInPage signInPage;
    private SellerDashBoard sellerDashBoard;
    private SellerProduct sellerProduct;
    @BeforeClass
    public void init() {

        signInPage = new SignInPage();
        sellerDashBoard=new SellerDashBoard();
       sellerProduct =new SellerProduct();
    }
    @Test
    @Parameters({"strParams"})
    public void AddProductWithValidData(String strParams){
        try {
            System.out.println("Test method execution started.");
            Map<String, String> data = Runner.getKeywordParameters(strParams);
            signInPage.fillEmail(data.get("email"));
            signInPage.fillPassword(data.get("password"));
            signInPage.clickRememberme();
            signInPage.clickLogin();
            signInPage.ValidCredentials();
        sellerDashBoard.clickProductsBtn();
        sellerDashBoard.clickProductsSubMenuBtn();
        sellerProduct.clickAddNewProductBtnInProd();
        sellerProduct.enterProdName(data.get("prod_name"));
        sellerProduct.enterProdDescription(data.get("prod_desc"));
        sellerProduct.selectProdCat(data.get("prod_cat"));
       sellerProduct.selectSubCat(data.get("prod_subCat"));
       sellerProduct.selectBrand(data.get("prod_brand"));
       sellerProduct.selectUnit(data.get("prod_unit"));
       sellerProduct.clickOnSubmit();
       sellerProduct.productAddedNotification();
        } catch (Exception e) {
            e.printStackTrace();
            ExtentTestManager.setFailMessageInReport("ERROR :"+e.getMessage());
        }
    }
}
