package org.oniesoft.tests;

import oniesoft.WebFramework.Runner;
import oniesoft.api.reporting.ExtentTestManager;
import org.oniesoft.AdminDashBoard;
import org.oniesoft.Categories;
import org.oniesoft.Sellers;
import org.oniesoft.SignInPage;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.Map;

public class SellerTest {
    private SignInPage signInPage;
    private AdminDashBoard adminDashBoard;
    private Sellers sellers;
    @BeforeClass
    public void init() {

        signInPage = new SignInPage();
        adminDashBoard=new AdminDashBoard();
        sellers=new Sellers();
    }
    @Test
    @Parameters({"strParams"})
    public void verifySellerDetailsWithValidData(String strParams){
        try {
            System.out.println("Test method execution started.");
            Map<String, String> data = Runner.getKeywordParameters(strParams);
            signInPage.fillEmail(data.get("email"));
            signInPage.fillPassword(data.get("password"));
            signInPage.clickRememberme();
            signInPage.clickLogin();
            signInPage.ValidCredentials();
            adminDashBoard.clickSellers();
            adminDashBoard.clickListMenu();
            sellers.SearchName(data.get("sellerName"));
            Assert.assertTrue(sellers.getSellerName().equalsIgnoreCase(data.get("sellerName")));
        } catch (Exception e) {
            e.printStackTrace();
            ExtentTestManager.setFailMessageInReport("ERROR :"+e.getMessage());
        }
    }
}
