package test.Page;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import test.Models.Attribute;
import test.Base.BasePage;
import java.util.ArrayList;
import java.util.List;

public class LazadaPage extends BasePage {

        @FindBy(xpath="//button[@class='search-box__button--1oH7']")
        private WebElement buttonSearchPath;

        @FindBy(xpath="//*[@id=\"q\"]")
        private WebElement txtboxSearchPath;

        @FindBy(xpath="//div[@data-tracking='product-card']")
        private WebElement productPath;

        @FindBy(xpath="//div[@data-tracking='product-card']//a[@title]")
        private List<WebElement> urlPath;

        @FindBy(xpath="//div[@data-tracking='product-card']//a[@title]")
        private List<WebElement> nameProductPath;

        @FindBy(xpath="//div[@data-tracking='product-card']//a[@title]/../following-sibling::div[1]")
        private List<WebElement> pricePath;

        private WebDriver driver;
        public LazadaPage(WebDriver _driver){
            super(_driver);
            driver = _driver;
            PageFactory.initElements(driver, this);
        }

        @Step("Search product")
        public void searchProductOfLazada(){
            driver.get("https://www.lazada.vn/");
            visibility(txtboxSearchPath,driver);
            sendKey( txtboxSearchPath, "Iphone 11");
            elementToBeClickable(buttonSearchPath,driver);
            click( buttonSearchPath);
        }

        @Step("Get title of website")
        public String getTitleOfLazada(){
            String title2=driver.getTitle().substring(57,61);
            return title2;
        }

        @Step("Get information of products")
        public List<Attribute> getProductOfLazada(){
            List<Attribute> atributeList2=new ArrayList<Attribute>();
            for (int i=0;i<20;i++){
                String pri2=pricePath.get(i).getText().substring(1).replace(",","");
                Attribute atribute2=new Attribute(getTitleOfLazada(),nameProductPath.get(i).getText(),pri2.trim(),urlPath.get(i).getAttribute("href") );
                atributeList2.add(atribute2);
            }
            return atributeList2;
        }
}

