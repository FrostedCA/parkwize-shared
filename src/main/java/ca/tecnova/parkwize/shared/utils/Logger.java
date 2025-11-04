package ca.tecnova.parkwize.shared.utils;

public class Logger {

    private static void print(String text) { System.out.println(text); }

    private static void log(LogType type, String text) {
        if(type == LogType.NONE) {
            print(text);
            return;
        }
        text = "[" + type.color + type.name() + LogColors.RESET + "]: " + text;
        print(text);
    }

    public static void log(String text) { log(LogType.NONE, text); }

    public static void ok(String text) { log(LogType.OK, LogType.OK.color + text + LogColors.RESET); }

    public static void info(String text) { log(LogType.INFO, LogType.INFO.color + text + LogColors.RESET); }

    public static void error(String text) { log(LogType.ERROR, LogType.ERROR.color + text + LogColors.RESET); }

    public static void warning(String text) { log(LogType.WARNING, LogType.WARNING.color + text + LogColors.RESET); }

    public static void cron(String text) { log(LogType.CRON, LogType.CRON.color + text + LogColors.RESET); }

    public static void pricing(String text) { log(LogType.PRICING, LogType.PRICING.color + text + LogColors.RESET); }

}
