import org.openqa.selenium.By;  
import org.openqa.selenium.WebDriver;  
import org.openqa.selenium.chrome.ChromeDriver;  
import org.testng.Assert;  
import org.testng.annotations.Test;  

public class LoginTest {  
    WebDriver driver;  

    @Test  
    public void validLogin() {  
        driver = new ChromeDriver();  
        driver.get("https://example.com/login");  
        driver.findElement(By.id("username")).sendKeys("valid_user");  
        driver.findElement(By.id("password")).sendKeys("Pass123!");  
        driver.findElement(By.id("submit")).click();  
        Assert.assertEquals(driver.getCurrentUrl(), "https://example.com/dashboard");  
        driver.quit();  
    }  

    @Test  
    public void invalidLogin() {  
        driver = new ChromeDriver();  
        driver.get("https://example.com/login");  
        driver.findElement(By.id("username")).sendKeys("invalid_user");  
        driver.findElement(By.id("password")).sendKeys("WrongPass");  
        driver.findElement(By.id("submit")).click();  
        String error = driver.findElement(By.className("error-msg")).getText();  
        Assert.assertTrue(error.contains("Invalid credentials"));  
        driver.quit();  
    }  
}  