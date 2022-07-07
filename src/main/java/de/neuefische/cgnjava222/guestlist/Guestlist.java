package de.neuefische.cgnjava222.guestlist;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Guestlist {

    private List<String> guests = Collections.emptyList();

    public List<String> getGuests() {
        return guests;
    }

    public void setGuests(List<String> guests) throws IOException {
        this.guests = guests;
        String fileContent = String.join("\n", guests) + "\n";
        Files.writeString(Paths.get("guests.txt"), fileContent);
    }
}
