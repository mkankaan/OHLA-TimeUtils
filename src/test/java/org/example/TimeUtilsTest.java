package org.example;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.example.TimeUtils.secToTime;

class TimeUtilsTest {
    @ParameterizedTest(name="{0} sekuntia on ajassa {1}")
    @CsvSource({ "0, 0:00:00", "1, 0:00:00"})
    public void testSecToTime(int sekunnit, String tulos) {
        assertEquals(tulos, secToTime(sekunnit), "virhe");
    }
}