package Basics.Nullables;

import java.util.Locale;

public class SimpleNullPointer {
    public static void main(String[] args) {
        String name = null;
        int age = 34;
        boolean isMlae = true;
        char firstLetterOfSurname = 'Ç';

        Integer age2 = 34;

        name.toLowerCase(Locale.ROOT);
    }
}
