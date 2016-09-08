package andigital.venuesapp.model.recommended;

import andigital.venuesapp.model.Venue;

import java.io.Serializable;

public class Item implements Serializable {

    Venue venue;

    public Venue getVenue() {
        return venue;
    }

    public void setVenue(Venue venue) {
        this.venue = venue;
    }
}
