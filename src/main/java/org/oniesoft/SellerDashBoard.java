package org.oniesoft;

import oniesoft.WebFramework.BrowserFunctions;
import org.openqa.selenium.By;

public class SellerDashBoard extends BrowserFunctions {
    private By productsBtn=By.xpath("(//span[@class='menu-text'])[2]");
    private By menuProductsBtn=By.xpath("(//span[@class='menu-text'])[3]");

    public void clickProductsBtn(){
        click(productsBtn,"Click On Products Main Menu");
    }
    public void clickProductsSubMenuBtn(){
        click(menuProductsBtn,"Click On Products Sub Menu");
    }
}
