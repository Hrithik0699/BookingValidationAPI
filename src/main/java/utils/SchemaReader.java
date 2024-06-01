package utils;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.Files;
import java.io.IOException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class SchemaReader {
    private static final Logger LOG = LogManager.getLogger(SchemaReader.class);

    public static String readSchema(String schemaFileName) {
        String schemaFilePath = Paths.get("resources/schemas", schemaFileName).toString();

        final Path path = Paths.get(schemaFilePath);

        if (!Files.exists(path)) {
            LOG.error("Schema file not found: " + schemaFileName);
            throw new IllegalArgumentException("Schema to use cannot be null");
        }

        try {
            return new String(Files.readAllBytes(path));
        } catch (IOException e) {
            LOG.error("Error reading schema file: " + schemaFileName, e);
            throw new RuntimeException("Error reading schema file", e);
        }
    }
}
