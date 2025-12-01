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
        findingExceptionPageElements(driver);
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

    // Intro to using Selectors
    private static void findingPageElements(WebDriver driver){
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

        // XPath Locators
        WebElement usernameInputFieldXpath = driver.findElement(By.xpath("//input[@id='username']"));
        WebElement passwordInputFieldXpath = driver.findElement(By.xpath("//input[@name='password']"));
        WebElement submitBtnXpath = driver.findElement(By.xpath("//button[@id='submit']"));

        // CSS Selectors
        WebElement usernameInputFieldCss = driver.findElement(By.cssSelector("input[id='username']"));
        WebElement passwordInputFieldCss = driver.findElement(By.cssSelector("input[name='password']"));
        WebElement submitBtnCss = driver.findElement(By.cssSelector("button[id='submit']"));
    }

    private static void findingExceptionPageElements(WebDriver driver){
        driver.get("https://practicetestautomation.com/practice-test-exceptions/");
        WebElement linkTxt = driver.findElement(By.linkText("Selenium WebDriver with Java for beginners program"));
        WebElement partialLinkTxt = driver.findElement(By.partialLinkText("Selenium WebDriver"));

        WebElement inputFieldByTag = driver.findElement(By.tagName("input"));
        WebElement inputFieldByClassName = driver.findElement(By.className("input-field"));
        WebElement inputFieldByXpath = driver.findElement(By.xpath("//input[@value='Pizza']"));
        WebElement inputFieldByCSS = driver.findElement(By.cssSelector("input[type='text']"));

        List<WebElement> buttons = driver.findElements(By.tagName("button"));

        WebElement editBtnById = driver.findElement(By.id("edit_btn"));
        WebElement editBtnByName = driver.findElement(By.name("Edit"));
        WebElement editBtnByCss = driver.findElement(By.cssSelector("button[id='edit_btn']"));
        WebElement editBtnByXpath = driver.findElement(By.xpath("//button[@name='Edit']"));

        WebElement addBtnById = driver.findElement(By.id("add_btn"));
        WebElement addBtnByName = driver.findElement(By.name("Add"));
        WebElement addBtnByCss = driver.findElement(By.cssSelector("button[name='Add']"));
        WebElement addBtnByXpath = driver.findElement(By.xpath("//button[@id='add_btn']"));
    }
}