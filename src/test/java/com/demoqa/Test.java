package com.demoqa;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class Test {
    @BeforeAll
    static void config(){
        Configuration.holdBrowserOpen = true;
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "400x1680"; // костыль на обход рекламы
    }
    @AfterAll
    static void closing(){
     // закрываем модалку после проверки
       $("#closeLargeModal").scrollIntoView(true).click(); // ура зароботоло
    }

    @org.junit.jupiter.api.Test
    void firstTest() {
        //открываем страничку:
        open("/automation-practice-form");
        //заполнение данных:
        $("#firstName").setValue("Egor");
        $("#lastName").setValue("Tokarev");
        $("#userEmail").setValue("egor@test.ru");
        $("[for = gender-radio-2]").click();
        $("#userNumber").setValue("89990009988");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__day--006").click();
        $("#subjectsInput").setValue("H").pressEnter();// ?
        $("[for = hobbies-checkbox-2]").scrollTo().click();
        // аплоад
        $("#uploadPicture").uploadFile(new File("src/test/java/resources/ccc.png"));
        // заполняем дальше
        $("#currentAddress").setValue("Поисковая, 1");
        $("#state").click();
        $(byText("Haryana")).click();
        $("#city").click();
        $(byText("Karnal")).click();
        $("#submit").click();
        //проверка заполненной модалки :
        $(".modal-body").shouldHave(text("Egor Tokarev"));
        $(".modal-body").shouldHave(text("egor@test.ru"));
        $(".modal-body").shouldHave(text("Female"));
        $(".modal-body").shouldHave(text("06 August,2022"));
        $(".modal-body").shouldHave(text("Hindi"));
        $(".modal-body").shouldHave(text("Reading"));
        $(".modal-body").shouldHave(text("8999000998"));
        $(".modal-body").shouldHave(text("Поисковая, 1"));
        $(".modal-body").shouldHave(text("Haryana Karnal"));
        $(".modal-body").shouldHave(text("ccc.png"));
    }
}
