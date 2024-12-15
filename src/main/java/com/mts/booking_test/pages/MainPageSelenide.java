package com.mts.booking_test.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$$x;

public class MainPageSelenide {
    public ElementsCollection elements = $$x("//*[contains(@aria-label, 'из 5')]");

    public boolean searchForStars() {
        for (SelenideElement element : elements) {
            if (!element.getAttribute("aria-label").equals("5 из 5")) {
                return false;
            }
        }
        return true;
    }
}
