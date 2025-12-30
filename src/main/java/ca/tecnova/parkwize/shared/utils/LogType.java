package ca.tecnova.parkwize.shared.utils;

public enum LogType {

    NONE (LogColors.RESET),
    INFO (LogColors.RESET),
    OK (LogColors.GREEN_BOLD),
    ERROR (LogColors.RED_BOLD),
    WARNING (LogColors.YELLOW_BOLD),
    CRON (LogColors.CYAN),
    PRICING (LogColors.PURPLE)
    ;

    public final String color;

    LogType(String color) {
        this.color = color;
    }

}
