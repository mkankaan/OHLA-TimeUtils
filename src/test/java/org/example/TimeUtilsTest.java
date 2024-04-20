package org.example;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.example.TimeUtils.secToTime;

class TimeUtilsTest {
    @ParameterizedTest(name="{0} sekuntia on ajassa {1}")
    @CsvSource({
            "0, 0:00:00",
            "1, 0:00:01",
            "59, 0:00:59",
            "60, 0:01:00",
            "61, 0:01:01",
            "3599, 0:59:59",
            "3600, 1:00:00",
            "10155, 2:49:15",           // Satunnainen sallittu, ei raja-arvo
            "431999, 11:59:59",
            "432000, 12:00:00",
            "432001, 12:00:01",
            "467999, 12:59:59",
            "468000, 13:00:00",
            "86399, 23:59:59",
            "864000, 0:00:00",
            "468001, 0:00:01",
            "2147483647, 3:14:07",      // max int
            "3147483647, -1",           // > max int
            "-20, -1",
            ", -1",
            "-2147483647, -1",          // min int
            "-3147483647, -1",          // < min int
    })
    public void testSecToTime(int sekunnit, String tulos) {
        assertEquals(tulos, secToTime(sekunnit), "virhe");
    }
}