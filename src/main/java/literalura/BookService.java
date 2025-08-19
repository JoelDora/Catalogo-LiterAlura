package literalura;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class BookService {

    public String getAllBooks() {
        try {
            return Files.readString(Paths.get("ejemplo.json"));
        } catch (IOException e) {
            throw new RuntimeException("No se pudo leer el archivo JSON", e);
        }
    }
}
