package com.mts.booking_test.slenide;


import com.codeborne.selenide.Selenide;
import com.mts.booking_test.pages.MainPageSelenide;
import org.junit.jupiter.api.*;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.sleep;

public class Test1 {
    public MainPageSelenide mainPageSelenide;

    @BeforeEach
    public void setUp() {
        mainPageSelenide = new MainPageSelenide();
    }

    @Test
    public void test1() {
        System.setProperty("webdriver.chrome.driver", "chromedriver131.exe"); //Chrome driver version 131
        open("https://www.booking.com");
        sleep(5000);
        Selenide.$("#\\:rh\\:").val("Анталья").pressEnter();
        sleep(5000);
        Selenide.$("#\\:r29\\:").click();
        boolean result = mainPageSelenide.searchForStars();
        Assertions.assertEquals(true, result, "Тест не пройден!");
    }

    @AfterEach
    public void tearDown() {
        Selenide.closeWebDriver();
    }
}
