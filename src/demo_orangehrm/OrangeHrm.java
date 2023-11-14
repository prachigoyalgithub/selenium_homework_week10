package demo_orangehrm;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class OrangeHrm {
    static String browser = "Chrome";
    static String baseUrl = "https://opensource-demo.orangehrmlive.com/";
    static WebDriver driver;

    public static void main(String[] args) {
        if (browser.equalsIgnoreCase("Chrome")){
            driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("Firefox")) {
            driver = new FirefoxDriver();

        } else if (browser.equalsIgnoreCase("Edge")) {
            driver = new EdgeDriver();

        }else {
            System.out.println("Wrong browser name");
        }
        driver.get(baseUrl);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        System.out.println(driver.getTitle());
        System.out.println(driver.getCurrentUrl());
        System.out.println(driver.getPageSource());

        WebElement forgorpasswordLink = driver.findElement(By.className("orangehrm-login-forgot"));
        forgorpasswordLink.click();


        String forgotPasswordUrl = "https://opensource-demo.orangehrmlive.com/web/index.php/auth/requestPasswordResetCode";
        driver.navigate().to(forgotPasswordUrl);
        System.out.println(" GET current URL" + driver.getCurrentUrl());

        String loginUrl = "https://opensource-demo.orangehrmlive.com";
        driver.navigate().back();
        System.out.println(" GET current URL" + driver.getCurrentUrl());

        driver.navigate().refresh();

        //Find Email field element and type the Email
        WebElement emailField = driver.findElement(By.name("username"));
        emailField.sendKeys("prime123@gmail.com");

        //find password field element and type password
        WebElement passwordField = driver.findElement(By.name("password"));
        passwordField.sendKeys("Prime123");

        //Find login link element and click on it
        WebElement loginLink = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[3]/button"));
        loginLink.click();


        driver.quit();
    }

}
