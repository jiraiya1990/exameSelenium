package Examen.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DocusingLandingPage {

    public WebDriver driver;

    public DocusingLandingPage(WebDriver remoteDriver) {
        driver = remoteDriver;
    }

    public String getTitle() {
        return driver.getTitle();
    }

    public void clickLogin() {
        driver.findElement(By.xpath("//*[@href='/login']")).click();
    }

    public WebElement fcbkBtn() {
        return  driver.findElement(By.xpath("//*[@for='bxid_rememberMe_true']"));
    }






}
