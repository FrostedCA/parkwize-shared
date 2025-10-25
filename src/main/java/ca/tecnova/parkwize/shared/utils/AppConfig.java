package ca.tecnova.parkwize.shared.utils;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.github.cdimascio.dotenv.Dotenv;

import java.text.ParseException;
import java.util.Base64;

public class AppConfig {

    public static final ObjectMapper objectMapper = new ObjectMapper();

    public static final Dotenv dotenv = Dotenv.configure().directory("./").ignoreIfMissing().load();

    public static String getParkwizeApiKey() throws ParseException {

        String apiKey = dotenv.get("PARKWIZE_API_KEY", "");

        if (apiKey.isEmpty() || apiKey.isBlank()) {
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

    public static String getRedisHost() { return dotenv.get("REDIS_HOST"); }

    public static String getSasToken() { return dotenv.get("SAS_TOKEN"); }

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
