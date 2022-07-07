package de.neuefische.cgnjava222.guestlist;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Collections;
import java.util.List;

public class GuestlistTest {

    @Test
    void shouldBeEmptyInitially() {
        Guestlist guestlist = new Guestlist();
        List<String> actual = guestlist.getGuests();
        Assertions.assertEquals(Collections.emptyList(), actual);
    }

    @Test
    void shouldReadSameGuestsAsWrittenBefore() throws IOException {
        Guestlist guestlist = new Guestlist();
        guestlist.setGuests(List.of("Karl", "Ute"));
        List<String> actual = guestlist.getGuests();
        Assertions.assertEquals(List.of("Karl", "Ute"), actual);
    }

    @Test
    void shouldWriteToFileSystem() throws IOException {
        // given
        Guestlist guestlist = new Guestlist();

        // when
        guestlist.setGuests(List.of("Theodor", "Anette"));

        // then
        String actual = Files.readString(Path.of("guests.txt"));
        Assertions.assertEquals(
                """
                        Theodor
                        Anette
                        """, actual);
    }
}
