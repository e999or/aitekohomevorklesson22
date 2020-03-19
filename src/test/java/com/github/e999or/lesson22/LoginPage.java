package com.github.e999or.lesson22;

import com.codeborne.selenide.Selenide;
import org.openqa.selenium.By;
import org.testng.Assert;

import static com.codeborne.selenide.Selenide.$;

public class LoginPage {

    LoginPage open() {
        Selenide.open("https://idemo.bspb.ru");
        return this;
    }

    LoginPage clickLoginButton(){
        $(By.id("login-button")).click();
        return this;
    }

    LoginPage inspectCodePhone(){
        String phone = $(By.xpath("//div[@id='otp-code-text']/b")).getAttribute("innerText");
        Assert.assertTrue(phone.equals("*1111"));
        return this;
    }

    LoginPage sendKeyskOtpCode(String keys){
        $(By.id("otp-code")).sendKeys(keys);
        return this;
    }

    LoginPage clikOtpCode(){
        $(By.id("login-otp-button")).click();
        return this;
    }
}
