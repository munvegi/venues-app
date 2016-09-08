package andigital.venuesapp.model;

import java.io.Serializable;
import java.util.List;


public class Response implements Serializable {

    List<Venue> venues;

    public List<Venue> getVenues() {
        return venues;
    }

    public void setVenues(List<Venue> venues) {
        this.venues = venues;
    }
}
