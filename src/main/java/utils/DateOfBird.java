package utils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public interface DateOfBird {

    static LocalDate add(String date){

        return LocalDate.parse("10-12-2020", DateTimeFormatter.ofPattern("dd-MM-yyyy"));
    }
}
