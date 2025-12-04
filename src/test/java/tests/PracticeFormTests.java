package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class PracticeFormTests {

    @BeforeAll
    static void beforeAll(){
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.pageLoadStrategy = "eager";
        Configuration.holdBrowserOpen = true;
    }

    String firstName = "Max";
    String lastName = "Dedyura";
    String email = "max@mail.com";
    int mobile = 1234567890;

    @Test
    void fillFormTest() {
        open("/automation-practice-form");

        $("#firstName").setValue(firstName);
        $("[placeholder='Last Name']").setValue(lastName);
        $("[placeholder='name@example.com']").setValue(email);
        $("[for='gender-radio-1']").click(); //Выбор пола, клик по самому "Male"
        $("[placeholder='Mobile Number']").setValue(String.valueOf(mobile)); //setValue() - принимает только строковые значения, String.valueOf() - преобразует любой тип данных


    }
}

