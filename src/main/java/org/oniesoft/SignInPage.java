package org.oniesoft;

import oniesoft.WebFramework.BrowserFunctions;
import oniesoft.web.actions.WaitForElement;
import org.openqa.selenium.By;

public class SignInPage extends BrowserFunctions {
    private By txtEmail = By.name("uemail");

    private By txtPassword = By.name("pwd");
    private By checkBoxRememberMe=By.xpath("//div/form/div[2]/div/label");
    private By forgetPasswordLink=By.xpath("//a[contains(text(),'Forgot')]");
    private By LoginBtn=By.xpath("//a[contains(text(),'Login')]");
   private By sellerBtn=By.xpath("//a[contains(text(),'Click')]");
private By notification=By.xpath("//div/p");

    public void fillEmail(String email) {
        enterText(txtEmail, email, "Email");
    }

    public void fillPassword(String password) {
        enterText(txtPassword, password, "Password");
    }
    public void  clickRememberme(){
        click(checkBoxRememberMe,"Click on Remember me");
    }
    public void clickForgetPassword(){
        click(forgetPasswordLink,"Click on Forget Password");
    }
    public void clickLogin() {
        click(LoginBtn, "Login");

    }
public void clickSellerAccount(){
        click(sellerBtn,"Click on Seller Account");
}
public void inValidCredentials() {
    waitForElement(notification,20,WaitForElement.visibility);
    String text=getText(notification,"Notificatin Text Get");
    System.out.println(text);
    verifyElementContainsText(notification,text,  "Invalid Credentials Notification");
}
    public void ValidCredentials() {
        waitForElement(notification,20,WaitForElement.visibility);
        verifyElementContainsText(notification, "Congratulations!","valid Credentials Notification");
    }
}
