package de.neuefische.cgnjava222.guestlist;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Collections;
import java.util.List;

public class Guestlist {

    public static final Path PATH = Path.of("guests.txt");

    public List<String> getGuests() throws IOException {
        if (!Files.exists(PATH)) {
            return Collections.emptyList();
        }
        return Files.readAllLines(PATH);
    }

    public void setGuests(List<String> guests) throws IOException {
        String fileContent = String.join("\n", guests) + "\n";
        Files.writeString(PATH, fileContent);
    }
}
