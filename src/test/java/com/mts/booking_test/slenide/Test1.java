package com.mts.booking_test.slenide;


import com.codeborne.selenide.Selenide;
import com.mts.booking_test.pages.MainPageSelenide;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.test.context.event.annotation.BeforeTestMethod;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.sleep;

public class Test1 {
    private MainPageSelenide mainPageSelenide;

    @BeforeEach
    public void setUp() {
        mainPageSelenide = new MainPageSelenide();
    }

    @Test
    public void test1() {
        System.setProperty("webdriver.chrome.driver", "chromedriver131.exe");
        open("https://www.booking.com/searchresults.ru.html?ss=Анталья&ssne=Анталья&ssne_untouched=Анталья&efdco=1&label=gen173nr-1BCAEoggI46AdIM1gEaMIBiAEBmAEhuAEXyAEV2AEB6AEBiAIBqAIDuAK42uu6BsACAdICJGVkYmUyNjJhLTA2MjUtNGYyMi04NjU5LWY4OTg5OGQ5NTIwZdgCBeACAQ&sid=2c43ea7c87750b4fe6a929eb2e151c44&aid=304142&lang=ru&sb=1&src_elem=sb&src=searchresults&dest_id=-735347&dest_type=city&group_adults=2&no_rooms=1&group_children=0");
        sleep(10000);
        Selenide.$("#\\:r29\\:").click();
        //Selenide.$("#ss").val("Анталья").pressEnter();
        boolean result = mainPageSelenide.searchForStars();
        Assertions.assertEquals(true, result, "Тест не пройден!");
    }
}
