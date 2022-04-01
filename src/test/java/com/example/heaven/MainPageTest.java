package com.example.heaven;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.conditions.webdriver.Url;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import javax.swing.*;

import static org.testng.Assert.*;

import static com.codeborne.selenide.Condition.attribute;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class MainPageTest {
    MainPage mainPage = new MainPage();

    @BeforeClass
    public static void setUpAll() {
        Configuration.browserSize = "1280x800";
    }

    @BeforeMethod
    public void setUp() {
        open("https://politrip.com/account/sign-up");
    }

    @Test
    public void validSignUpPart1(){
        sleep(10000);
        mainPage.close_cookie.click();
        mainPage.first_name.sendKeys("Dummy");
        mainPage.last_name.sendKeys("Test");
        mainPage.email.sendKeys("TestDummy@mail.com");
        mainPage.password.sendKeys("TestingIfOkay1");
        mainPage.confirm_password.sendKeys("TestingIfOkay1");
        mainPage.testHeard.selectOption(3);
        mainPage.sign_up.click();
        sleep(20000);
        String currentUrl = WebDriverRunner.getWebDriver().getCurrentUrl();


        assertEquals(currentUrl,"https://politrip.com/account/sign-up/type-select");

    }

    @Test
    public void validSignUpPart2(){
        sleep(10000);
        mainPage.close_cookie.click();
        mainPage.first_name.sendKeys("Dummy");
        mainPage.last_name.sendKeys("Test");
        mainPage.email.sendKeys("TestDummy@mail.com");
        mainPage.password.sendKeys("TestingIfOkay1");
        mainPage.confirm_password.sendKeys("TestingIfOkay1");
        mainPage.testHeard.selectOption(3);
        mainPage.sign_up.click();
        sleep(20000);
        mainPage.sign_up_participation.exists();
    }

    @Test
    public void emailTaken(){
        mainPage.close_cookie.click();
        mainPage.first_name.sendKeys("Dummy");
        mainPage.last_name.sendKeys("Test");
        mainPage.email.sendKeys("aa@t");
        mainPage.password.sendKeys("TestingIfOkay1");
        mainPage.confirm_password.sendKeys("TestingIfOkay1");
        mainPage.testHeard.selectOption(3);
        mainPage.sign_up.click();
        String error = mainPage.email_error.getText();
        assertEquals(error,"An user with this email is already registered");
    }

}
