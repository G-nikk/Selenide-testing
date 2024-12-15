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
        open("https://www.booking.com/searchresults.ru.html?ss=%D0%90%D0%BD%D1%82%D0%B0%D0%BB%D1%8C%D1%8F&label=gog235jc-1DCAEoggI46AdIIVgDaMIBiAEBmAEhuAEXyAEM2AED6AEB-AECiAIBqAIDuALTzvq6BsACAdICJGUyZjU4NjFkLTVjNjYtNDI4Yy05YWI2LWIzNTgyOWJlNWEzOdgCBOACAQ&aid=397594&lang=ru&sb=1&src_elem=sb&src=index&dest_id=-735347&dest_type=city&place_id=city%2F-735347&ac_position=0&ac_click_type=b&ac_langcode=ru&ac_suggestion_list_length=5&search_selected=true&search_pageview_id=3e4645a98a9f059d&ac_meta=GhBhOTllNDVhYzdlZWYwMmViIAAoATICcnU6DNCQ0L3RgtCw0LvRjEAASgBQAA%3D%3D&group_adults=2&no_rooms=1&group_children=0");
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
