package andigital.venuesapp.service;

import andigital.venuesapp.model.Venue;

import java.util.List;


public interface VenueService {

    List<Venue> getVenues(String location);
    List<Venue> getRecommendedVenues(String location);
}