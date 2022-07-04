package Learning.java11Training;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;

public class NumberFormattingExercise {
    public static void main(String[] args) {
        double value = 10_000_000.53;

        NumberFormat format = NumberFormat.getNumberInstance();

        System.out.println("Number: " + format.format(value));
        System.out.println(value);

        NumberFormat intF = NumberFormat.getIntegerInstance();
        System.out.println("Number: " + intF.format(value));

        intF.setGroupingUsed(false);
        System.out.println("Number: " + intF.format(value));

        Locale locale = new Locale("de", "DE");
        NumberFormat localeF = NumberFormat.getNumberInstance(locale);
        System.out.println("Number: " + localeF.format(value));

        NumberFormat currencyF = NumberFormat.getCurrencyInstance();
        System.out.println("Number: " + currencyF.format(value));

        NumberFormat decimalF = new DecimalFormat("$00.00");
        System.out.println(decimalF.format(1));

    }
}
