package org.oniesoft.tests;

import oniesoft.WebFramework.Runner;
import oniesoft.api.reporting.ExtentTestManager;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.oniesoft.SignInPage;

import java.util.Map;

public class LoginTest {

    /*
    launch the browser
    Navigate to URL
    Click on login link in home page
    Enter Email Address
    Enter Password
    Click on Login button
     */

    private SignInPage signInPage;
    @BeforeClass
    public void init() {

            signInPage = new SignInPage();
    }

    @Test
    @Parameters({"strParams"})
    public void testLoginWithValidCreds(String strParams){
        try {
            System.out.println("Test method execution started.");
            Map<String, String> data = Runner.getKeywordParameters(strParams);

            signInPage.fillEmail(data.get("email"));
            signInPage.fillPassword(data.get("password"));
            signInPage.clickRememberme();
            signInPage.clickLogin();
            signInPage.ValidCredentials();
        } catch (Exception e) {
            e.printStackTrace();
            ExtentTestManager.setFailMessageInReport("Failed to login with valid credentials: " + e.getMessage());
        }
    }
    @Test
    @Parameters({"strParams"})
    public void testLoginWithNullCreds(String strParams){
        try {
            System.out.println("Test method execution started.");
            Map<String, String> data = Runner.getKeywordParameters(strParams);
            signInPage.clickRememberme();
            signInPage.clickLogin();
            signInPage.inValidCredentials();
        } catch (Exception e) {
            e.printStackTrace();
            ExtentTestManager.setFailMessageInReport("Failed to login with valid credentials: " + e.getMessage());
        }
    }
    @Test
    @Parameters({"strParams"})
    public void testLoginWithInvalidCreds(String strParams){
        try {
            System.out.println("Test method execution started.");
            Map<String, String> data = Runner.getKeywordParameters(strParams);
            signInPage.fillEmail(data.get("email"));
            signInPage.fillPassword(data.get("password"));
            signInPage.clickRememberme();
            signInPage.clickLogin();
            signInPage.inValidCredentials();

        } catch (Exception e) {
            e.printStackTrace();
            ExtentTestManager.setFailMessageInReport("Failed to login with valid credentials: " + e.getMessage());
        }
    }
}
