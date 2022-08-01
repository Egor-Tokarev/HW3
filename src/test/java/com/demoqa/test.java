package com.demoqa;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class test {
    @BeforeAll
    static void config(){
        Configuration.holdBrowserOpen = true;
    }

    @Test
    void firstTest() {
      //  Assertions.assertTrue(3 > 2);

    }


}
