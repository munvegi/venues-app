package andigital.venuesapp.service;

import andigital.venuesapp.model.Venue;
import andigital.venuesapp.model.recommended.RecommendedVenues;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.stream.Collectors;


@PropertySource("classpath:application.properties")
@Service
public class VenueServiceImpl implements VenueService {

    @Autowired
    Environment environment;

    @Autowired
    RestTemplate restTemplate;


    @Override
    public List<Venue> getRecommendedVenues(String location) {

        String baseURI = environment.getProperty("foursquare.recommended.venues.base.uri");
        String venuesURI = baseURI + "?client_id={clientId}&client_secret={clientSecret}&v={version}&near={location}";
        System.out.println("Making GET request to: " + venuesURI);

        RecommendedVenues recommendedVenues = restTemplate.getForObject(venuesURI, RecommendedVenues.class,
                environment.getProperty("foursquare.client.id"),
                environment.getProperty("foursquare.client.secret"),
                environment.getProperty("foursquare.version"),
                location);

        List<Venue> venues = recommendedVenues.getResponse().getGroups().get(0).getItems()
                .stream().map(item -> item.getVenue()).collect(Collectors.toList());

        return venues;
    }
}
