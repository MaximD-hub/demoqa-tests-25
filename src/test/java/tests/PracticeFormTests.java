package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class PracticeFormTests {

    @BeforeAll
    static void beforeAll(){
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.pageLoadStrategy = "eager";
        Configuration.holdBrowserOpen = true;
    }

    String firstName = "Max";
    String lastName = "Dedyura";
    String email = "max@mail.com";
    int mobile = 1234567890;
    int dayBirth = 25;
    String monthBirth = "May";
    int yearBirth = 1992;
    String subject = "History";
    String currentAdress = "Almaty, Kazakhstan";

    @Test
    void fillFormTest() {
        open("/automation-practice-form");

        $("#firstName").setValue(firstName);
        $("[placeholder='Last Name']").setValue(lastName);
        $("[placeholder='name@example.com']").setValue(email);
        $("[for='gender-radio-1']").click(); //Выбор пола, клик по самому "Male"
        $("[placeholder='Mobile Number']").setValue(String.valueOf(mobile)); //setValue() - принимает только строковые значения, String.valueOf() - преобразует любой тип данных

        // Выпадающий текст
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption(String.valueOf(monthBirth));
        $(".react-datepicker__year-select").selectOption(String.valueOf(yearBirth));
        $$(".react-datepicker__day").find(text(String.valueOf(dayBirth))).click();

        $("#subjectsInput").setValue(subject).pressEnter();
        $("[for='hobbies-checkbox-3']").click();

        // Загрузка файла с компьютера
        $("#uploadPicture").uploadFile(new File("/Users/kaspi/Desktop/gnunvna-dpyr8dzj9gwsh-xinlm.jpeg"));

        $("[placeholder='Current Address'").setValue(currentAdress);

        // Выбор значения из выпадающего списка #1
        $x("//*[@id=\"state\"]").click();
        $$(".css-26l3qy-menu div")
                .findBy(exactText("Haryana")) // exactText ищет ровно "Haryana", без лишних пробелов и других символов
                .click();

        // Выбор значения из выпадающего списка #2
        $x("//*[@id=\"city\"]/div/div[1]/div[1]").click();
        $$(".css-26l3qy-menu div")
                .findBy(exactText("Karnal"))
                .click();

        $("#submit").click();

        $x("//table//tr[td[text()='Student Name']]/td[2]").shouldHave(text(firstName+" "+lastName));
        $x("//table//tr[td[text()='Student Email']]/td[2]").shouldHave(text(email));
        $x("//table//tr[td[text()='Gender']]/td[2]").shouldHave(text("Male"));
        $x("//table//tr[td[text()='Mobile']]/td[2]").shouldHave(text(String.valueOf(mobile)));
        $x("//table//tr[td[text()='Date of Birth']]/td[2]").shouldHave(text(dayBirth+" "+monthBirth+","+yearBirth));
        $x("//table//tr[td[text()='Subjects']]/td[2]").shouldHave(text(subject));
        $x("//table//tr[td[text()='Hobbies']]/td[2]").shouldHave(text("Music"));
        $x("//table//tr[td[text()='Picture']]/td[2]").shouldHave(text("gnunvna-dpyr8dzj9gwsh-xinlm.jpeg"));
        $x("//table//tr[td[text()='Address']]/td[2]").shouldHave(text(currentAdress));
        $x("//table//tr[td[text()='State and City']]/td[2]").shouldHave(text("Haryana Karnal"));

        $("#closeLargeModal").click();



    }
}

