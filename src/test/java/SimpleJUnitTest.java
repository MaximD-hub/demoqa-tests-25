import org.junit.jupiter.api.*;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class SimpleJUnitTest {

    int result;

    @BeforeAll
    static void beforeAll() {
        System.out.println("\n### Before All");
    }

    @BeforeEach
    void beforeEach() {
        System.out.println("### beforeEach");
        result = getResult();
    }

    @AfterEach
    void afterEach() {
        System.out.println("### afterEach\n");
    }

    @AfterAll
    static void afterAll() {
        System.out.println("\n### afterAll");
    }

    @Test // аннотация, метка, показывать, откуда начинается тест, чтобы появилась зеленая кнопка
    void firstTest() {
        System.out.println("###   firstTest");
        Assertions.assertTrue(result > 2);
    }

    @Test // аннотация, метка, показывать, откуда начинается тест, чтобы появилась зеленая кнопка
    void secondTest() {
        System.out.println("###   secondTest");
        Assertions.assertTrue(result > 2);
    }

    @Test // аннотация, метка, показывать, откуда начинается тест, чтобы появилась зеленая кнопка
    void thirdTest() {
        System.out.println("###   thirdTest");
        Assertions.assertTrue(result > 2);
    }

    private int getResult() {
        return 3;
    }
}
