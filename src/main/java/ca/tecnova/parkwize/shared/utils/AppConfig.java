package ca.tecnova.parkwize.shared.utils;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.github.cdimascio.dotenv.Dotenv;

import java.text.ParseException;
import java.util.Base64;

public class AppConfig {

    public static final ObjectMapper objectMapper = new ObjectMapper();

    public static final Dotenv dotenv = loadDotenv();

    private static Dotenv loadDotenv() {
        String[] possiblePaths = {
                "./",           // Spring Boot + some environments
                ".",            // Plain Java/Maven
                "../",          // Sometimes needed for packaged JARs
                ""              // Current directory (no path)
        };

        for (String path : possiblePaths) {
            try {
                return Dotenv.configure()
                        .directory(path)
                        .ignoreIfMissing()
                        .load();
            } catch (Exception e) {
                // Try next path
            }
        }

        // If all fails, try without directory specification (uses system env vars)
        return Dotenv.configure()
                .ignoreIfMissing()
                .load();
    }

    public static String getParkwizeApiKey() throws ParseException {
        String apiKey = dotenv.get("PARKWIZE_API_KEY", "");
        if (apiKey.isBlank()) {
            throw new ParseException("No API key found. Dot event either missing or 'PARKWIZE_API_KEY' is not defined.", 0);
        }
        return apiKey;
    }

    // Use for Global API works
    public static String getParkwizeV1Url() {
        return dotenv.get("PARKWIZE_API_BASE_URL", "https://www.parkwizeinc.com/api/v1");
    }

    // Use for Global Payments (Maybe)
    public static String getParkwizeV2Url() {
        return dotenv.get("PARKWIZE_V2_URL", "https://www.parkwizeinc.com/api/v2");
    }

    public static String getRedisHost() {
        if (isDev()) {
            return dotenv.get("REDIS_DEV_HOST");
        }
        return dotenv.get("REDIS_HOST");
    }

    public static String getJavaEnv() { return dotenv.get("JAVA_ENV", "DEV"); }

    public static String getAmqSig() {
        if (getJavaEnv().equals("DEV")) {
            return dotenv.get("AMQ_DEV_SIG");
        }
        return dotenv.get("AMQ_SIG");
    }

    public static String getAmqHost() {
        if (getJavaEnv().equals("DEV")) {
            return dotenv.get("AMQ_DEV_HOST");
        }
        return dotenv.get("AMQ_HOST");
    }

    public static String getAmqName() {
        if (getJavaEnv().equals("DEV")) {
            return dotenv.get("AMQ_DEV_NAME");
        }
        return dotenv.get("AMQ_NAME");
    }

    public static String getRmqHost() {
        if (getJavaEnv().equals("DEV")) {
            return dotenv.get("RMQ_DEV_HOST");
        }
        return dotenv.get("RMQ_HOST");
    }

    public static Integer getRmqPort() {
        if (getJavaEnv().equals("DEV")) {
            return Integer.parseInt(dotenv.get("RMQ_DEV_PORT"));
        }
        return Integer.parseInt(dotenv.get("RMQ_PORT"));
    }

    public static String getRmqUser() {
        if (getJavaEnv().equals("DEV")) {
            return dotenv.get("RMQ_DEV_USER");
        }
        return dotenv.get("RMQ_USER");
    }

    public static String getRmqPassword() {
        if (getJavaEnv().equals("DEV")) {
            return dotenv.get("RMQ_DEV_PASS");
        }
        return dotenv.get("RMQ_PASS");
    }

    public static Boolean isProd() {
        return getJavaEnv().equals("PROD");
    }

    public static Boolean isDev() {
        return getJavaEnv().equals("DEV");
    }

    public static String decodeBase64Message(String encodedMessage) {
        try {
            byte[] decodedBytes = Base64.getDecoder().decode(encodedMessage);
            return new String(decodedBytes);
        } catch (IllegalArgumentException e) {
            System.out.println("Error decoding message: " + e.getMessage());
            return encodedMessage; // Return original if not Base64
        }
    }

}
