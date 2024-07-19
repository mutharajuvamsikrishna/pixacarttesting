package org.oniesoft.tests;

import oniesoft.WebFramework.Runner;
import oniesoft.api.reporting.ExtentTestManager;
import org.oniesoft.AdminDashBoard;
import org.oniesoft.Categories;
import org.oniesoft.SignInPage;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.Map;

public class CategoriesTest {
    private SignInPage signInPage;
    private AdminDashBoard adminDashBoard;
    private Categories categories;
    @BeforeClass
    public void init() {

        signInPage = new SignInPage();
        adminDashBoard=new AdminDashBoard();
        categories=new Categories();
    }
    @Test
    @Parameters({"strParams"})
    public void addItemsInCategoryWithValidDate(String strParams){
        try {
            System.out.println("Test method execution started.");
            Map<String, String> data = Runner.getKeywordParameters(strParams);
            signInPage.fillEmail(data.get("email"));
            signInPage.fillPassword(data.get("password"));
            signInPage.clickRememberme();
            signInPage.clickLogin();
            signInPage.ValidCredentials();
            adminDashBoard.clickCategories();
            adminDashBoard.clickCategory();
            categories.clickAddNewCategoryBtn();
            categories.enterCategoryNameInput(data.get("categoryName"));
            categories.enterImageInput(data.get("path"));
            categories.clickOnSubmitBtn();
             categories.categoryAddedNotification();
            categories.SearchCategory(data.get("categoryName"));
            Assert.assertTrue(categories.getcatogeryname().equalsIgnoreCase(data.get("categoryName")));
        } catch (Exception e) {
            e.printStackTrace();
            ExtentTestManager.setFailMessageInReport("ERROR :"+e.getMessage());
        }
    }
    //SubCategoryAdd
    @Test
    @Parameters({"strParams"})
    public void addItemsInSubCategoryWithValidDate(String strParams){
        try {
            System.out.println("Test method execution started.");
            Map<String, String> data = Runner.getKeywordParameters(strParams);
            signInPage.fillEmail(data.get("email"));
            signInPage.fillPassword(data.get("password"));
            signInPage.clickRememberme();
            signInPage.clickLogin();
            signInPage.ValidCredentials();
            adminDashBoard.clickCategories();
            adminDashBoard.clickSubCategory();
            categories.clickAddNewSubCategoryBtn();
            categories.enterSubCategoryNameInput(data.get("subCategoryName"));
            categories.selectMainCategoryList(data.get("mainCategory"));
            categories.uploadSubCategoryImage(data.get("subPath"));
            categories.clickOnSubCategorySubmitBtn();
            categories.categoryAddedNotification();
            categories.SearchCategory(data.get("subCategoryName"));
           Assert.assertTrue(categories.getSubcatogeryname().equalsIgnoreCase(data.get("subCategoryName")));

        } catch (Exception e) {
            e.printStackTrace();
            ExtentTestManager.setFailMessageInReport("ERROR :"+e.getMessage());
        }
    }


}
