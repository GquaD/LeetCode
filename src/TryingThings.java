import LeetCode.LeetCodeUtils;

import java.util.*;

public class TryingThings {
    public static void main(String[] args) {
        String s = "2022 Январь \"EPAM SYSTEMS\" MCHJ 24 874 868 1 865 615 0 2022 Февраль \"EPAM SYSTEMS\" MCHJ 24 978 000 1 873 350 0 2022 Март \"EPAM SYSTEMS\" MCHJ 30 210 557 2 265 792 0 2022 Апрель \"EPAM SYSTEMS\" MCHJ 25 810 301 1 935 773 0 2022 Май \"EPAM SYSTEMS\" MCHJ 28 823 444 2 161 758 0 2022 Июнь \"EPAM SYSTEMS\" MCHJ 24 894 096 1 867 057 0 2022 Июль \"EPAM SYSTEMS\" MCHJ 21 694 004 1 627 050 0 2022 Август \"EPAM SYSTEMS\" MCHJ 26 495 956 1 987 197 0 2022 Сентябрь \"EPAM SYSTEMS\" MCHJ 27 620 700 2 071 553 0 2022 Октябрь \"EPAM SYSTEMS\" MCHJ 27 928 325 2 094 624 0 2022 Ноябрь \"EPAM SYSTEMS\" MCHJ 28 115 275 2 108 646 0 2022 Декабрь \"EPAM SYSTEMS\" MCHJ 28 015 275 2 101 146 0";
        List<String> months = new ArrayList<>();
        String[] split = s.split("MCHJ");
        for (String str : split) {
            months.add(str.substring(0, 11));
        }
        months.remove(0);
        int sum = 0;
        for (String str : months) {
            System.out.println(str);
            sum += Integer.parseInt(str.replace(" ", ""));
        }
        System.out.println("sum = " + sum);
    }
}
