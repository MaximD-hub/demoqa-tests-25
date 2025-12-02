package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TestBoxTests {

    @BeforeAll
    static void beforeAll()
    {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
    }

    String name = "Max Dedyura";
    String email = "max@mail.com";
    String currentAddress = "Almaty";
    String permanentAddress = "Almaty, Kazakhstan";

    @Test
    void fillFormTest() {
        open("/text-box");
        $("#userName").setValue(name);
        $("#userEmail").setValue(email);
        $("#currentAddress").setValue(currentAddress);
        $("#permanentAddress").setValue(permanentAddress);
        $("#submit").click();

        $("#output #userName").shouldHave(text("Name:"+name));
        $("#output #userEmail").shouldHave(text("Email:"+email));
        $("#output #currentAddressl").shouldHave(text("Сurrent Address :"+currentAddress));
        $("#output #permanentAddress").shouldHave(text("Permanent Address :"+permanentAddress));

    }
}
