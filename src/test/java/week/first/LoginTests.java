package week.first;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.openqa.selenium.WebDriver.*;

public class LoginTests {
    @Test
    public void positiveLoginTest(){
        //List<String> usernames = Arrays.asList("standard_user", "locked_out_user", "problem_user", "performance_glitch_user", "error_user", "visual_user");
        String username = "standard_user";
        String password = "secret_sauce";


        FirefoxOptions options = new FirefoxOptions().setBinary("/usr/sbin/firefox");
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver(options);

        driver.get("https://www.saucedemo.com/");



        WebElement usernameFieldCSS = driver.findElement(By.cssSelector("input[id='user-name']"));

        WebElement passwordFieldCSS = driver.findElement(By.cssSelector("input[type='password']"));

        //usernameFieldCSS.sendKeys("secret_sauce");

        WebElement logInButtonCSS = driver.findElement(By.cssSelector("input[value='Login']"));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));


        usernameFieldCSS.sendKeys(username);
        passwordFieldCSS.sendKeys(password);

        logInButtonCSS.click();

        wait.until(ExpectedConditions.titleIs("Swag Labs"));

        WebElement menu = driver.findElement((By.id("react-burger-menu-btn")));
        menu.click();

        WebElement logOutButton = driver.findElement(By.id("logout_sidebar_link"));
        logOutButton.click();

        driver.close();
    }

    @Test
    public void negativeLoginTest(){
        //List<String> usernames = Arrays.asList("standard_user", "locked_out_user", "problem_user", "performance_glitch_user", "error_user", "visual_user");
        String username = "standard_user";
        String password = "ragu_sauce";


        FirefoxOptions options = new FirefoxOptions().setBinary("/usr/sbin/firefox");
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver(options);

        driver.get("https://www.saucedemo.com/");



        WebElement usernameFieldCSS = driver.findElement(By.cssSelector("input[id='user-name']"));

        WebElement passwordFieldCSS = driver.findElement(By.cssSelector("input[type='password']"));

        //usernameFieldCSS.sendKeys("secret_sauce");

        WebElement logInButtonCSS = driver.findElement(By.cssSelector("input[value='Login']"));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));


        usernameFieldCSS.sendKeys(username);
        passwordFieldCSS.sendKeys(password);

        logInButtonCSS.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("error-message-container")));

        driver.close();
    }
}
