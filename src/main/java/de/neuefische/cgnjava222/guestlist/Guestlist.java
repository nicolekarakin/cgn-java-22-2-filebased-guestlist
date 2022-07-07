package de.neuefische.cgnjava222.guestlist;

import java.util.Collections;
import java.util.List;

public class Guestlist {

    private List<String> guests = Collections.emptyList();

    public List<String> getGuests() {
        return guests;
    }

    public void setGuests(List<String> guests) {
        this.guests = guests;
    }
}
