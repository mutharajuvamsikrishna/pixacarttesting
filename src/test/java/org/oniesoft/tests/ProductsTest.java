package org.oniesoft.tests;

import oniesoft.WebFramework.Runner;
import oniesoft.api.reporting.ExtentTestManager;
import org.oniesoft.AdminDashBoard;
import org.oniesoft.Categories;
import org.oniesoft.Products;
import org.oniesoft.SignInPage;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.Map;

public class ProductsTest {
    private SignInPage signInPage;
    private AdminDashBoard adminDashBoard;
    private Products products;
    @BeforeClass
    public void init() {

        signInPage = new SignInPage();
        adminDashBoard=new AdminDashBoard();
        products=new Products();
    }
    @Test
    @Parameters({"strParams"})
    public void addAttributeInProductsWithValidDate(String strParams){
        try {
            System.out.println("Test method execution started.");
            Map<String, String> data = Runner.getKeywordParameters(strParams);
            signInPage.fillEmail(data.get("email"));
            signInPage.fillPassword(data.get("password"));
            signInPage.clickRememberme();
            signInPage.clickLogin();
            signInPage.ValidCredentials();
            adminDashBoard.clickProducts();
            adminDashBoard.clickAttributes();
           products.clickOnAddNewAttributeBtn();
           products.enterAttributeName(data.get("attributeName"));
         // products.enterAttributeValueText(data.get("attributeValue"));
           products.selectCategoryDropDown(data.get("categoryName"));
            products.clickOnSubmitBtn();
            products.attributeAddedNotification();
            products.searchProducts(data.get("attributeName"));
            Assert.assertTrue(products.getAttributeName().equalsIgnoreCase(data.get("attributeName")));
            ExtentTestManager.setInfoMessageInReport(products.getAttributeName()+" is Displayed Success Fully");
        } catch (Exception e) {
            e.printStackTrace();
            ExtentTestManager.setFailMessageInReport("ERROR :"+e.getMessage());
        }
    }
    @Test
    @Parameters({"strParams"})
    public void addBrandsInProductsWithValidDate(String strParams){
        try {
            System.out.println("Test method execution started.");
            Map<String, String> data = Runner.getKeywordParameters(strParams);
            signInPage.fillEmail(data.get("email"));
            signInPage.fillPassword(data.get("password"));
            signInPage.clickRememberme();
            signInPage.clickLogin();
            signInPage.ValidCredentials();
            adminDashBoard.clickProducts();
            adminDashBoard.clickBrands();
            products.clickAddNewBrandBtn();
            products.enterBrandTxt(data.get("brandName"));
          products.uploadBrandImage(data.get("path"));
            products.clickOnSubmitBtn();
            products.attributeAddedNotification();
            products.searchProducts(data.get("brandName"));

            Assert.assertTrue(products.getBrandName().equalsIgnoreCase(data.get("brandName")));
            ExtentTestManager.setInfoMessageInReport(products.getBrandName()+" is Displayed Success Fully");
        } catch (Exception e) {
            e.printStackTrace();
            ExtentTestManager.setFailMessageInReport("ERROR :"+e.getMessage());
        }
    }
    @Test
    @Parameters({"strParams"})
    public void searchProductInProductsWithValidDate(String strParams){
        try {
            System.out.println("Test method execution started.");
            Map<String, String> data = Runner.getKeywordParameters(strParams);
            signInPage.fillEmail(data.get("email"));
            signInPage.fillPassword(data.get("password"));
            signInPage.clickRememberme();
            signInPage.clickLogin();
            signInPage.ValidCredentials();
            adminDashBoard.clickProducts();
            adminDashBoard.clickSubProducts();
            products.searchProducts(data.get("productName"));
         //   Assert.assertTrue(products.getProductName().equalsIgnoreCase(data.get("productName")));
            ExtentTestManager.setInfoMessageInReport(products.getProductName()+" is Displayed Success Fully");
        } catch (Exception e) {
            e.printStackTrace();
            ExtentTestManager.setFailMessageInReport("ERROR :"+e.getMessage());
        }
    }

}
