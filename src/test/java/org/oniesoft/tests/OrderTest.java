package org.oniesoft.tests;

import oniesoft.WebFramework.Runner;
import oniesoft.api.reporting.ExtentTestManager;
import org.oniesoft.AdminDashBoard;
import org.oniesoft.Categories;
import org.oniesoft.Orders;
import org.oniesoft.SignInPage;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.Map;

public class OrderTest {
    private SignInPage signInPage;
    private AdminDashBoard adminDashBoard;
    private Orders orders;
    @BeforeClass
    public void init() {

        signInPage = new SignInPage();
        adminDashBoard=new AdminDashBoard();
        orders=new Orders();
    }
    @Test
    @Parameters({"strParams"})
    public void confirmPendingOrderWithValidData(String strParams){
        try {
            System.out.println("Test method execution started.");
            Map<String, String> data = Runner.getKeywordParameters(strParams);
            signInPage.fillEmail(data.get("email"));
            signInPage.fillPassword(data.get("password"));
            signInPage.clickRememberme();
            signInPage.clickLogin();
            signInPage.ValidCredentials();
            adminDashBoard.clickOrders();
            adminDashBoard.clickAll();
           orders.clickPendingTab();
           orders.clickPendingTabCheckBox(data.get("productName"));
           orders.clickConfirmBtn();
           orders.clickPopUpConfirm();
           orders.orderNotification();
        } catch (Exception e) {
            e.printStackTrace();
            ExtentTestManager.setFailMessageInReport("ERROR :"+e.getMessage());
        }
    }
    @Test
    @Parameters({"strParams"})
    public void confirmOrderWithValidData(String strParams){
        try {
            System.out.println("Test method execution started.");
            Map<String, String> data = Runner.getKeywordParameters(strParams);
            signInPage.fillEmail(data.get("email"));
            signInPage.fillPassword(data.get("password"));
            signInPage.clickRememberme();
            signInPage.clickLogin();
            signInPage.ValidCredentials();
            adminDashBoard.clickOrders();
            adminDashBoard.clickAll();
            orders.clickOnConfirmTab();
            orders.clickPendingTabCheckBox(data.get("productName"));
            orders.clickGenerateLabel();
            orders.clickPopUpConfirm();
            orders.orderNotification();
        } catch (Exception e) {
            e.printStackTrace();
            ExtentTestManager.setFailMessageInReport("ERROR :"+e.getMessage());
        }
    }
    @Test
    @Parameters({"strParams"})
    public void DeliveredOrderWithValidData(String strParams){
        try {
            System.out.println("Test method execution started.");
            Map<String, String> data = Runner.getKeywordParameters(strParams);
            signInPage.fillEmail(data.get("email"));
            signInPage.fillPassword(data.get("password"));
            signInPage.clickRememberme();
            signInPage.clickLogin();
            signInPage.ValidCredentials();
            adminDashBoard.clickOrders();
            adminDashBoard.clickAll();
            orders.clickDispatchedTab();
            orders.clickPendingTabCheckBox(data.get("productName"));
            orders.clickDeliveredBtn();
            orders.clickPopUpConfirm();
            orders.orderNotification();
        } catch (Exception e) {
            e.printStackTrace();
            ExtentTestManager.setFailMessageInReport("ERROR :"+e.getMessage());
        }
    }

}
