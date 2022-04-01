package com.example.heaven;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

// https://www.jetbrains.com/
public class MainPage {
    public SelenideElement first_name = $(new By.ByName("first-name"));
    public SelenideElement last_name = $(new By.ByName("last-name"));
    public SelenideElement email = $(new By.ByName("email"));
    public SelenideElement password = $(new By.ById("sign-up-password-input"));
    public SelenideElement confirm_password = $(new By.ById("sign-up-confirm-password-input"));
    public SelenideElement close_cookie = $(new By.ById("cookiescript_close"));
    public SelenideElement testHeard = $(new By.ByName("heard"));
    public SelenideElement sign_up = $(new By.ById(" qa_loader-button"));
    public SelenideElement sign_up_participation = $x("//div[contains(@class, 'w-100 d-flex flex-wrap flex-row justify-content-between')]");
    public SelenideElement email_error = $(new By.ById("sign-up-error-div"));
}
