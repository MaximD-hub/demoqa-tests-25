package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class TestBoxTests {

    @BeforeAll
    static void beforeAll()
    {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.pageLoadStrategy = "eager";
        Configuration.holdBrowserOpen = true;
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
        $x("//*[@id=\"submit\"]").click();

        $x("//*[@id=\"name\"]").shouldHave(text(name));
        $x("//*[@id=\"email\"]").shouldHave(text(email));
        $x("/html/body/div[2]/div/div/div/div[2]/div[2]/form/div[6]/div/p[3]").shouldHave(text(currentAddress));
        $x("/html/body/div[2]/div/div/div/div[2]/div[2]/form/div[6]/div/p[4]").shouldHave(text(permanentAddress));

    }
}
