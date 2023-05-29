package all;


import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;

import all.services.EmployeeService;

public class App {

    public static void main(String[] args) {
        LocalDate d04 = LocalDate.parse("2023-07-23");
        LocalDateTime d05 = LocalDateTime.parse("2023-07-23T01:30:26");
        Instant d06 = Instant.parse("2023-07-23T01:30:26Z");

        LocalDate pastWeekLocalDate = d04.minusWeeks(0);

        

        System.out.println("D04 = " + d04);
        System.out.println("D04 = " + pastWeekLocalDate);
    }
  
}
