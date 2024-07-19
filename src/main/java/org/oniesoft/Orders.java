package org.oniesoft;

import oniesoft.WebFramework.BrowserFunctions;
import oniesoft.web.actions.WaitForElement;
import org.openqa.selenium.By;

public class Orders extends BrowserFunctions {
    //Main Tab Xpath's
    private By pendingTab=By.xpath("//a[@id='home-tab1']");
    private By confirmTab=By.xpath("//a[@id='profile-tab20']");
    private By readyToDispatchTab=By.xpath("//a[@id='profile-tab21']");
    private By dispatchedTab=By.xpath("(//a[@id='profile-tab22'])[1]");

    private By deliveredTab=By.xpath("(//a[@id='profile-tab22'])[2]");
    private By canceledTab=By.xpath("(//a[@id='profile-tab22'])[3]");
    private By returnReqTab=By.xpath("(//a[@id='profile-tab22'])[4]");
    private By refundReq=By.xpath("(//a[@id='profile-tab22'])[5]");
    //Pending Tab Options
private By confirmBtn=By.xpath("(//button[contains(text(),'Confirm')])[1]");
private By cancelBtn=By.xpath("(//button[contains(text(),'Cancel')])[1]");
private By pendindTabStatus=By.xpath("(//span[@class='dtr-data'])[1]");
    private By popUpConfirmBtn=By.xpath("(//button[contains(text(),'Confirm')])[2]");
    private By popUpCancelBtn=By.xpath("//button[contains(text(),'Reject')]");
    private By notification=By.xpath("//div[contains(@class,'pc-notifications')]/p");
//Confirmed Tabs Options
    private By generateLabelBtn=By.xpath("//button[contains(text(),'Generate Label')]");
    //Delivered Tab Options
    private By deliveredBtn=By.xpath("//button[contains(text(),'Delivered')]");
    public void clickPendingTab(){
        click(pendingTab,"Click On Pending Tab");
    }
    public String clickCheckBox(String name) {
        return String.format("(//tr/td[contains(text(),'%s')])[2]/..//input[@class='checkedOrder']", name);
    }
public void clickPendingTabCheckBox(String name){
        click(By.xpath(clickCheckBox(name)),"Click On Pending Tab Check Box");
}
public void clickConfirmBtn(){
        click(confirmBtn,"Click On Confirm");
}
public void clickPopUpConfirm(){
        click(popUpConfirmBtn,"Click On PopUp Confirm");
}
    public void orderNotification() {
        waitForElement(notification,20,WaitForElement.visibility);
        String text=getText(notification,"Notification Text Get");
        verifyElementContainsText(notification,text,  "Notification");

    }
    public void clickOnConfirmTab(){
        click(confirmTab,"Click On Confirm Tab");
    }

public void clickGenerateLabel(){

        click(generateLabelBtn,"Click On Generate Laben Btn");
}
//delivered method
    public void clickDispatchedTab(){
        click(dispatchedTab,"ClickOn Dispatched Tab");
    }
    public void clickDeliveredBtn(){
        click(deliveredBtn,"Click On Delivered Btn");
    }
}
