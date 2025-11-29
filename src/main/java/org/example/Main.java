package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.locators.RelativeLocator;

import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://practicetestautomation.com/practice-test-login/");
        // WebElement locators - id, name, className
        WebElement usernameInputField = driver.findElement(By.id("username"));
        WebElement passwordInputField = driver.findElement(By.name("password"));
        WebElement submitBtn = driver.findElement(By.className("btn"));

        // Finding all input fields on the page
        List<WebElement> inputFields = driver.findElements(By.tagName("input"));

        // // WebElement locators - linkText, partialLinkText
        WebElement linkTextLocator = driver.findElement(By.linkText("Practice Test Automation."));
        WebElement partialLinkTextLocator = driver.findElement(By.partialLinkText("Test Automation"));

        // Practicing Relative Locators
        WebElement passwordFieldBelowUserName = driver.findElement(RelativeLocator.with(By.tagName("input")).below(By.id("username")));
        WebElement privacyPolicyLink = driver.findElement(RelativeLocator.with(By.tagName("a")).toRightOf(By.linkText("Practice Test Automation.")));
        driver.quit();
    }

    private static String chromeTest(String url){
        WebDriver driver = new ChromeDriver();
        driver.get(url);
        String title = driver.getTitle();
        driver.quit();
        return title;
    }

    private static String firefoxTest(String url){
        System.setProperty("webdriver.gecko.driver", "src/main/resources/geckodriver");
        WebDriver driver = new FirefoxDriver();
        driver.get(url);
        String title = driver.getTitle();
        driver.quit();
        return title;
    }
}