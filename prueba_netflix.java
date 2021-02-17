package Examen;

import Examen.pageObjects.DataProvidergenerator;
import Examen.pageObjects.DocusingLandingPage;
import com.github.javafaker.Faker;
import jdk.nashorn.internal.objects.annotations.Property;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class prueba_netflix {

    public WebDriver driver;

    @BeforeTest
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.netflix.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

    }



    @Test(priority = 0)
    public void validarTituloTest() {
        DocusingLandingPage docusingLandingPage = new DocusingLandingPage(driver);

        Assert.assertEquals(docusingLandingPage.getTitle(), "Netflix Uruguay: Ve series online, ve películas online");

        docusingLandingPage.clickLogin();
        Assert.assertEquals(docusingLandingPage.getTitle(), "Netflix");

        List<WebElement> h1s = driver.findElements(By.tagName("h1"));

        //Assert.assertEquals();

        boolean encontrar = false;


        for (WebElement elemento : h1s) {
            System.out.println(elemento.getText());
            if (elemento.getText().contains("Inicia Sesión")) {
                encontrar = true;
            }
        }
        Assert.assertTrue(encontrar);

        WebElement fcbkText = driver.findElement(By.xpath("//*[@class='fbBtnText']"));

        Assert.assertEquals(fcbkText.getText(), "Iniciar sesión con Facebook");




        driver.findElement(By.id("id_userLoginId")).sendKeys("XXX");
        driver.findElement(By.id("id_password")).sendKeys("holamundo");

        WebElement remembermeBtn = docusingLandingPage.fcbkBtn();

        if (remembermeBtn.isDisplayed() == true) {
            remembermeBtn.click();
        }

        Assert.assertTrue(remembermeBtn.isSelected());

        driver.findElement(By.xpath("(//*[@type='submit'])[1]")).click();


    }

    @Test(priority = 1)
    public void fakeEmailTest() throws InterruptedException {

        Faker faker = new Faker();

        String email = faker.name().firstName();
        driver.findElement(By.id("id_email_hero_fuji")).sendKeys(email + "@gmail.com");
        driver.findElement(By.xpath("(//*[@type='submit'])[1]")).click();

        Thread.sleep(3000);

        String currenUrl = driver.getCurrentUrl();

        Assert.assertTrue(currenUrl.contains("signup"));



    }

    @Test(priority = 2,dataProvider = "emails",dataProviderClass = DataProvidergenerator.class)
    public void dataProviderEmailTest(String email){
        driver.findElement(By.id("id_email_hero_fuji")).sendKeys(email);
        driver.findElement(By.xpath("(//*[@type='submit'])[1]")).click();




    }

    @Test(priority = 3)
    @Parameters({"tagname"})
    public void printTagsTest(String tagname){
        driver.findElement(By.tagName(tagname));


    }










    @AfterTest
    public void close() throws InterruptedException {
        Thread.sleep(3000);
        driver.close();
    }


}
