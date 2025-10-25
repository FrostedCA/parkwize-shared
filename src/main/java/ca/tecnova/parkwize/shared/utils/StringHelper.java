package ca.tecnova.parkwize.shared.utils;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Date;

public final class StringHelper {

    public static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS");

    public static String firstLetterToUpper(String text) {
        if(text == null || text.isEmpty()) {
            return "";
        }
        return text.substring(0, 1).toUpperCase() + text.substring(1).toLowerCase();
    }

    public static String getDoubleDigitsFormat(String text) {
        if(text.length() == 1) {
            text = "0" + text;
        }
        return text;
    }

    public static String getDoubleDigitsFormat(int number) {
        String parsed = String.valueOf(number);
        if(parsed.length() == 1) {
            parsed = "0" + parsed;
        }
        return parsed;
    }

    public static String getDateToString(Date date) {
        return sdf.format(date);
    }

    public static LocalDateTime parseUnixTimestamp(String unixTimestampStr) {
        double timestamp = Double.parseDouble(unixTimestampStr);
        long seconds = (long) timestamp;
        long nanos = (long) ((timestamp - seconds) * 1_000_000_000);

        return LocalDateTime.ofEpochSecond(seconds, (int) nanos, ZoneOffset.UTC);
    }

    public static Timestamp parseTimestamp(String dateString) {
        if (dateString == null || dateString.isEmpty()) {
            return null;
        }

        try {
            // For ISO 8601 format with or without milliseconds
            // Examples: "2023-04-15T14:30:45Z", "2023-04-15T14:30:45.123Z"
            Instant instant = Instant.parse(dateString);
            return Timestamp.from(instant);
        } catch (DateTimeParseException e) {
            try {
                // Try with the existing SimpleDateFormat that handles milliseconds
                Date parsedDate = sdf.parse(dateString);
                return new Timestamp(parsedDate.getTime());
            } catch (Exception e1) {
                // Try various millisecond precision formats
                String[] millisPatterns = {
                        "yyyy-MM-dd HH:mm:ss.S",    // .x (1 digit)
                        "yyyy-MM-dd HH:mm:ss.SS",   // .xx (2 digits)
                        "yyyy-MM-dd HH:mm:ss.SSS",  // .xxx (3 digits)
                        "yyyy-MM-dd'T'HH:mm:ss.S",  // ISO with .x
                        "yyyy-MM-dd'T'HH:mm:ss.SS", // ISO with .xx
                        "yyyy-MM-dd'T'HH:mm:ss.SSS" // ISO with .xxx
                };

                for (String pattern : millisPatterns) {
                    try {
                        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
                        LocalDateTime localDateTime = LocalDateTime.parse(dateString, formatter);
                        return Timestamp.valueOf(localDateTime);
                    } catch (DateTimeParseException ignored) {
                        // Try next pattern
                    }
                }

                // If all millisecond patterns fail, try without milliseconds
                try {
                    String[] basicPatterns = {
                            "yyyy-MM-dd HH:mm:ss",
                            "yyyy-MM-dd'T'HH:mm:ss"
                    };

                    for (String pattern : basicPatterns) {
                        try {
                            DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
                            LocalDateTime localDateTime = LocalDateTime.parse(dateString, formatter);
                            return Timestamp.valueOf(localDateTime);
                        } catch (DateTimeParseException ignored) {
                            // Try next pattern
                        }
                    }

                    // If we get here, all patterns failed
                    Logger.error("Error parsing timestamp: " + dateString + " - No matching pattern found");
                    return null;
                } catch (Exception e3) {
                    Logger.error("Error parsing timestamp: " + dateString + " - " + e3.getMessage());
                    return null;
                }
            }
        }
    }

    /**
     * Format duration in a human-readable format
     */
    public static String formatDuration(Duration duration) {
        long minutes = duration.toMinutes();
        long seconds = duration.minusMinutes(minutes).getSeconds();
        return String.format("%dm %ds", minutes, seconds);
    }

}
