package org.example;

public class TimeUtils {

    public static int timeToSec(String time) {
        String[] part = time.split(":");
        int hh = Integer.parseInt(part[0]);
        int mm = Integer.parseInt(part[1]);
        int ss = Integer.parseInt(part[2]);

        return 3600 * hh + 60 * mm + ss;
    }

    // Metodia muutettu alkamaan alusta 24 tunnin jälkeen
    public static String secToTime(int a) {
        int hh, mm, ss;
        int input_ss = a;

        if (input_ss < 0) {
            return "-1";
        }

        if (input_ss >= 86400) {
            int dd = input_ss / 86400;
            input_ss -= dd*86400;
        }

        hh = input_ss / 3600;
        input_ss -= (3600 * hh);
        mm = input_ss / 60;
        ss = input_ss - (60 * mm);

        String res = hh + ":";
        if (mm <= 10) {
            res = res + "0" + mm + ":";
        } else {
            res = res + mm + ":";
        }
        if (ss <= 10) {
            res = res + "0" + ss;
        } else {
            res = res + ss;
        }

        return res;
    }
}
