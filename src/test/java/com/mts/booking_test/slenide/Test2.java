package com.mts.booking_test.slenide;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.logevents.SelenideLogger;
import com.mts.booking_test.pages.MainPageSelenide;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.*;

public class Test2 {
    public MainPageSelenide mainPageSelenide;

    @BeforeEach
    public void setUp() {
        mainPageSelenide = new MainPageSelenide();
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide().screenshots(true).savePageSource(true));
    }

    @Test
    public void test2() {
        System.setProperty("webdriver.chrome.driver", "chromedriver131.exe"); //Chrome driver version 131

        open("https://www.booking.com");
        sleep(5000);
        Selenide.$("#\\:rh\\:").val("Марокко").pressEnter();
        sleep(5000);
        Selenide.$("#calendar-searchboxdatepicker > div > div.a10b0e2d13.c807ff2d48 > div > div:nth-child(1) > table > tbody > tr:nth-child(4) > td:nth-child(5) > span").click();
        Selenide.$("#bodyconstraint-inner > div:nth-child(8) > div > div.a6e267116d > div > form > div > div.e22b782521.d12ff5f5bf > button").click();
        sleep(5000);
        Selenide.$("#bodyconstraint-inner > div:nth-child(8) > div > div.af5895d4b2 > div.df7e6ba27d > div.b4b4b2787f > div.b546c9ed2b > div > div > div > div > button").click();
        sleep(5000);

        String name = Selenide.$("#b2searchresultsPage > div.map_full_overlay__wrapper.map-modal-full > div.map-modal-content > div > div.map_left_cards.map_left_cards--v2 > div > div > ul > li:nth-child(1) > a > div.dccc7e1586 > div.c624d7469d.f034cf5568.a937b09340.a3214e5942 > div.dc5041d860.c72df67c95 > div > h2").getText();
        String stars = Selenide.$("#b2searchresultsPage > div.map_full_overlay__wrapper.map-modal-full > div.map-modal-content > div > div.map_left_cards.map_left_cards--v2 > div > div > ul > li:nth-child(1) > a > div.dccc7e1586 > div.c624d7469d.f034cf5568.a937b09340.a3214e5942 > div.dc5041d860.c72df67c95 > div > span.a455730030.a30b0745db").getAttribute("aria-label");
        String rating = Selenide.$("#b2searchresultsPage > div.map_full_overlay__wrapper.map-modal-full > div.map-modal-content > div > div.map_left_cards.map_left_cards--v2 > div > div > ul > li:nth-child(1) > a > div.dccc7e1586 > div.c3deae0c07.afeaa8180f > div > div.a3b8729ab1.d86cee9b25").getText();
        String reviews = Selenide.$("#b2searchresultsPage > div.map_full_overlay__wrapper.map-modal-full > div.map-modal-content > div > div.map_left_cards.map_left_cards--v2 > div > div > ul > li:nth-child(1) > a > div.dccc7e1586 > div.c3deae0c07.afeaa8180f > div > div.dc5041d860.c72df67c95.a29749fd9f > div.abf093bdfe.f45d8e4c32.d935416c47").getText();
        String price = Selenide.$("#b2searchresultsPage > div.map_full_overlay__wrapper.map-modal-full > div.map-modal-content > div > div.map_left_cards.map_left_cards--v2 > div > div > ul > li:nth-child(1) > a > div.dccc7e1586 > div.b05883eda7 > div.c5ca594cb1.f19ed67e4b > span.f6431b446c.fbfd7c1165.e84eb96b1f").getText();

        ElementsCollection elements = $$x("//*[@data-testid='custom-price-marker']");

        for (SelenideElement element : elements) {
            if (element.getText().equals(price)){
                element.click();
                break;
            }
        }

        sleep(5000);

        boolean result = false;

        String name1 = Selenide.$("#hp_hotel_name > div > h2").getText();
        String rating1 = Selenide.$("#hp_hotel_name > span > div > div > span.f419a93f12.ebc0e717e3 > div > span").getText();
        String stars1 = Selenide.$("#hp_hotel_name > span > div > div > span.f419a93f12.ebc0e717e3 > div").getText();
        String reviews1 = Selenide.$("#js--hp-gallery-scorecard > a > div > div > div > div.dc5041d860.c72df67c95.a29749fd9f > div.abf093bdfe.f45d8e4c32.d935416c47").getText();
        String price1 = Selenide.$("#hprt-table > tbody > tr.js-rt-block-row.e2e-hprt-table-row.hprt-table-cheapest-block.hprt-table-cheapest-block-fix.js-hprt-table-cheapest-block.hprt-table-last-row > td.hp-price-left-align.hprt-table-cell.hprt-table-cell-price.droom_seperator > div > div.prco-wrapper.bui-price-display.prco-sr-default-assembly-wrapper > div:nth-child(1) > div:nth-child(2) > div > span.prco-valign-middle-helper").getText();

        if (name.equals(name1) && rating.equals(rating1) && reviews.equals(reviews1) && price.equals(price1) && stars.equals(stars1)) {
            result = true;
        }

        Assertions.assertEquals(true, result, "Тест не пройден!");
    }

    @AfterEach
    public void tearDown() {
        Selenide.closeWebDriver();
    }
}
