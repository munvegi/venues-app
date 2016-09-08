package andigital.venuesapp.service;

import andigital.venuesapp.model.Venue;

import java.util.List;


public interface VenueService {

    List<Venue> getRecommendedVenues(String location);
}