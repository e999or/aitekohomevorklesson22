package com.github.e999or.lesson22;

import org.openqa.selenium.By;
import org.testng.Assert;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.codeborne.selenide.Selenide.$;


public class ReviewButton {

    ReviewButton clikIdButton(){
        $ (By.id("bank-overview")).click();
        return this;
    }

    ReviewButton clikxPathButton(){
        $ (By.xpath("//small[@class='my-assets']")).click();
        return this;
    }

    ReviewButton inspectFild(){
        String text = $(By.id("can-spend")).getAttribute("innerText");
        Assert.assertTrue((text).contains("Финансовая свобода"));
        return this;
    }

    ReviewButton inspectPreReview(){
        Assert.assertEquals($("title").getAttribute("innerText"), "Старт -  Интернет банк - Банк Санкт-Петербург");
        return this;
    }

        ReviewButton inspectTipe(){
        String str = $(By.xpath("//small[@class='my-assets']")).getAttribute("innerText");
        String sy = String.valueOf(new StringBuffer(str).delete(0,14));
        Matcher matcher = (Pattern.compile("^[0-9]{1,3} [0-9]{3} [0-9]{3}[.]{1}[0-9]{2} [\u20BD]{1}$")).matcher(sy);
        Assert.assertTrue(matcher.find());
        return this;
    }
}
