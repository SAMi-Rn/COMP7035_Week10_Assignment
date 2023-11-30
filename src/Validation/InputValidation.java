package Validation;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.regex.Pattern;

public class InputValidation {
    public static boolean isValidArgumentCount(String[] arguments) {
        if (arguments.length < 1) {
            System.out.println("Error: too less arguments" + arguments.length);
            return true;
        } else if (arguments.length > 2) {
            System.out.println("Error: too many arguments" + arguments.length);
            return true;
        }
        return false;
    }

    public static boolean isInteger(String date) {
        if (!Pattern.matches("^[0-9]{8}_[0-9]{6}$", date)) {
            System.out.println("Error: Argument should follow the yyyyMMdd_HHmmss Format: " + date);
            return false;
        }
        return true;
    }

    public static boolean isValidDate(String[] arguments) {
        String startDate = arguments[0];
        String endDate = arguments[1];

        return true;
    }

    public static String getFormattedCurrentDateTime() {
        LocalDateTime currentDateTime = LocalDateTime.now();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss");

        return currentDateTime.format(formatter);
    }

    public static boolean checkInvalidDateValues(String startDate, String endDate) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss");

        try {
            LocalDateTime start_date_time = LocalDateTime.parse(startDate, formatter);
            LocalDateTime end_date_time = LocalDateTime.parse(endDate, formatter);

            LocalDateTime valid_start_date = LocalDateTime.parse("19700101_000000", formatter);
            LocalDateTime valid_end_date = LocalDateTime.parse(getFormattedCurrentDateTime(), formatter);

            boolean out_of_range = start_date_time.isBefore(valid_start_date) || start_date_time.isAfter(valid_end_date) ||
                    end_date_time.isBefore(valid_start_date) || end_date_time.isAfter(valid_end_date);
            if (out_of_range) {
                System.out.println("Error: The provided date values are outside of the acceptable range.");
                return false;
            }

            if (start_date_time.isAfter(end_date_time)) {
                System.out.println("Error: The start date exceeds the end date.");
                return false;
            }

            return end_date_time.isAfter(start_date_time);

        } catch (Exception e) {
            System.out.println("Error: The provided date range is not valid.");
            System.out.println(e.getMessage());
            return false;
        }
    }
}