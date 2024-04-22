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
            "43199, 11:59:59",
            "43200, 12:00:00",
            "43201, 12:00:01",
            "46799, 12:59:59",
            "46800, 13:00:00",
            "46801, 13:00:01",
            "86399, 23:59:59",
            "86400, 0:00:00",
            "86401, 0:00:01",
            "2147483647, 3:14:07",      // max int
            "-1, -1",
            "-20, -1",
            "-2147483647, -1",          // min int
    })
    public void testSecToTime(int sekunnit, String tulos) {
        assertEquals(tulos, secToTime(sekunnit));
    }
}