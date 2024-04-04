import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;


public class GoogleMessagesForWeb {

    WebDriver driver;

@BeforeMethod
public void setUp(){


    System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
    driver = new ChromeDriver();
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
}
@AfterMethod
public void tearDown(){
    driver.quit();

}


   @Test
   public void sendMessages(){
    String[] numbers = {"0692107200","0692107200","0692107200","0692107200"};
    driver.get("https://messages.google.com/web/authentication");

    for(int i =0; i< numbers.length; i++) {
        driver.findElement(By.xpath("//div[contains(text(), 'Start chat')]/../..")).click();
        driver.findElement(By.xpath("//input[@placeholder='Type a name, phone number, or email']")).sendKeys(numbers[i]);
        driver.findElement(By.xpath("//input[@placeholder='Type a name, phone number, or email']")).sendKeys(Keys.ENTER);
        driver.findElement(By.xpath("//textarea")).sendKeys("Cao");
        driver.findElement(By.xpath("//textarea")).sendKeys(Keys.ENTER);
    }


   }



}
