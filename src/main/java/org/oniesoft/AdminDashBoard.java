package org.oniesoft;

import oniesoft.WebFramework.BrowserFunctions;
import org.openqa.selenium.By;

public class AdminDashBoard extends BrowserFunctions {
    //    NavBar Xpath's
    private By logoSymbol=By.xpath("//span[@class='pc-auth-logo-text']");
    private By dashBoard = By.xpath("//ul/li/a/span[contains(text(),'Dashboard')]");

    //categories
    private By categoriesBtn = By.xpath("//ul/li/a/span[contains(text(),'Categories')]");
    private By CategoryMenu = By.xpath("(//ul/li/a/span[contains(text(),'Category')])[1]");
    private By subCategoryMenu = By.xpath("//ul/li/a/span[contains(text(),'Sub Category')]");

    //products
    private By products = By.xpath("(//ul/li/a/span[contains(text(),'Products')])[1]");
    private By attributesMenu = By.xpath("//ul/li/a/span[contains(text(),'Attributes')]");
    private By brandsMenu = By.xpath("//ul/li/a/span[contains(text(),'Brands')]");
    private By productsMenu = By.xpath("(//ul/li/a/span[contains(text(),'Products')])[2]");
    private By orders = By.xpath("//ul/li/a/span[contains(text(),'Orders')]");
    private By allMenu = By.xpath("//ul/li/a/span[contains(text(),'All')]");
    private By sellers = By.xpath("//ul/li/a/span[contains(text(),'Sellers')]");
    private By listMenu = By.xpath("//ul/li/a/span[contains(text(),'List')]");
    private By withdrawRequestMenu = By.xpath("//ul/li/a/span[contains(text(),'Withdraw Request')]");
    private By customers = By.xpath("//ul/li/a/span[contains(text(),'Customers')]");
    private By businessSectionMenu = By.xpath("//ul/li/a/span[contains(text(),'Business Section')]");
    private By promotionalBannetrMenu = By.xpath("//ul/li/a/span[contains(text(),'Promotional Banner')]");
    private By customerReviewsMenu = By.xpath("//ul/li/a/span[contains(text(),'Customer Reviews')]");
    private By productsInWishListManu = By.xpath("//ul/li/a/span[contains(text(),'Products In Wish List')]");
    private By pageSetUp = By.xpath("//ul/li/a/span[contains(text(),'Page Setup')]");
    private By termsAndConditionsMenu = By.xpath("//ul/li/a/span[contains(text(),'Terms And Conditions')]");
    private By privacyPolicyMenu = By.xpath("//ul/li/a/span[contains(text(),'Privacy Policy')]");
    private By aboutUsMenu = By.xpath("//ul/li/a/span[contains(text(),'About Us')]");
    private By fAQMenu = By.xpath("//ul/li/a/span[contains(text(),'FAQ')]");
    private By businessSettings = By.xpath("//ul/li/a/span[contains(text(),'Business Settings')]");
    private By paymentMethodMenu = By.xpath("//ul/li/a/span[contains(text(),'Payment Method')]");
    private By CurrenciesMenu = By.xpath("//ul/li/a/span[contains(text(),'Currencies')]");
    private By support = By.xpath("//ul/li/a/span[contains(text(),'Support')]");
    private By supportCategoryMenu = By.xpath("//ul/li/a/span[contains(text(),'Support Category')]");
    private By webAndAppSettings = By.xpath("//ul/li/a/span[contains(text(),'Web & App Settings')]");
    private By webConfigMenu = By.xpath("//ul/li/a/span[contains(text(),'Web Config')]");
    private By mailConfigMenu = By.xpath("//ul/li/a/span[contains(text(),'Mail Config')]");
    private By smsConfigMenu = By.xpath("//ul/li/a/span[contains(text(),'Sms Config)]");
    private By notificationConfigMenu = By.xpath("//ul/li/a/span[contains(text(),' Notification Config')]");

    //Bell Symbol Xpath
    private By bellSymbol=By.xpath("//a[@id='notiBell']");

    // Profile
    private By userInfoSymbol=By.xpath("//a[@class='user-info']");
    private By editSymbolMenu=By.xpath("//a/i[@class='far fa-edit']");
    private By settingsSymbolMenu=By.xpath("//a/i[@class='fas fa-cog']");
    private By logoutSymbolMenu=By.xpath("//a/i[@class='fas fa-sign-out-alt']");
    public void clickCategories(){
        click(categoriesBtn,"Click On Categories");
    }
    public void clickCategory(){
        click(CategoryMenu,"Click On Category");
    }
    public void clickSubCategory(){
        click(subCategoryMenu,"Click On SubCategory");
    }
    public void  clickProducts(){
        click(products,"Click On Products");
    }
    public void clickAttributes(){
        click(attributesMenu,"Click On Attributes Menu");
    }
    public void clickBrands(){
        click(brandsMenu,"Click On Brands");
    }
    public void  clickSubProducts(){
        click(productsMenu,"Click On Products");
    }
    public void clickOrders(){
        click(orders,"Click On Orders");
    }
    public void clickAll(){
        click(allMenu,"Click On All");
    }
    public void clickSellers(){
        click(sellers,"Click On Sellers");
    }
    public void clickListMenu(){
        click(listMenu,"Click On List Menu");
    }

}
