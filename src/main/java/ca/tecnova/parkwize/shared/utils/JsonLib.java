package ca.tecnova.parkwize.shared.utils;

import com.fasterxml.jackson.core.type.TypeReference;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

public class JsonLib {

    /**
     * Parse a JSON file into a list of objects of the specified type
     * @param filePath Path to the JSON file
     * @param typeReference TypeReference for the target object type
     * @return List of parsed objects
     * @throws IOException If there's an error reading or parsing the file
     */
    public static <T> List<T> parseJsonFile(String filePath, TypeReference<List<T>> typeReference) throws IOException {
        File file = new File(filePath);
        String content = new String(Files.readAllBytes(file.toPath()));
        return AppConfig.objectMapper.readValue(content, typeReference);
    }

}
