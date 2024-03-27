import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.Arrays;
import java.util.Locale;

public class DataTypes {
    public static void main(String[] args) {
        String name = "Tiago";
        System.out.println("Olá " + name);

        int num1 = 3;
        int num2 = 2;
        float div = (float) num1 / num2; // cast
        System.out.println("Div = " + div);

        LocalDate today = LocalDate.now();
        Locale brazilianLocale  = Locale.forLanguageTag("pt-BR");
        String dayWeek = today.getDayOfWeek().getDisplayName(TextStyle.FULL, brazilianLocale);
        System.out.println(dayWeek.toUpperCase());

//        int[] array = new int[5];
        int[] array = { 1, 2 , 3, 4 , 5 };
        System.out.println(Arrays.toString(array));

        Welcome(name);
    }
    public static void Welcome(String name) {
        System.out.printf("Welcome %s\n", name);
    }
}