package utils;

import java.util.Random;

public interface IBANgenerator {

    static String create(String countryIndicator){

        String IBAN = countryIndicator;

        for (int i = 0; i < 13; i++) {

            IBAN += String.valueOf(
                    new Random()
                            .ints(0, 9)
                            .findFirst()
                            .getAsInt()
            );
        }

        return IBAN;
    }
}
