package ca.tecnova.parkwize.shared.utils;

public enum LogType {

    NONE (LogColors.RESET),
    INFO (LogColors.GREEN),
    OK (LogColors.GREEN_BOLD),
    ERROR (LogColors.RED_BOLD),
    WARNING (LogColors.YELLOW_BOLD),
    CRON (LogColors.CYAN_BOLD)
    ;

    final String color;

    LogType(String color) {
        this.color = color;
    }

}
