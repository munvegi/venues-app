package andigital.venuesapp.service;

import andigital.venuesapp.model.Venue;
import andigital.venuesapp.model.VenueResponse;
import andigital.venuesapp.model.recommended.RecommendedVenues;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.stream.Collectors;

// This is a good example of how a Service layer can decouple the presentation layers from the particularities of lower
// level layers. In this case, the Foursquare API returns quite different responses when we make queries for getVenues
// or getRecommendedVenues. Since we just need a list of venues, the service returns a list of venues (List<Venue>) in
// both cases, so the presentation layers and views above don't need to change.

@PropertySource("classpath:application.properties")
@Service
public class VenueServiceImpl implements VenueService {

    @Autowired
    Environment environment;

    @Autowired
    RestTemplate restTemplate;


    @Override
    public List<Venue> getVenues(String location) {

        String baseURI = environment.getProperty("foursquare.search.venues.base.uri");
        String venuesURI = baseURI + "?client_id={clientId}&client_secret={clientSecret}&v={version}&near={location}";
        System.out.println("Making GET request to: " + venuesURI);

        VenueResponse venueResponse = restTemplate.getForObject(venuesURI, VenueResponse.class,
                environment.getProperty("foursquare.client.id"),
                environment.getProperty("foursquare.client.secret"),
                environment.getProperty("foursquare.version"),
                location);

        //Map<String, Object> venuesMap = restTemplate.getForObject(requestURI, LinkedHashMap.class);
        return venueResponse.getResponse().getVenues();
    }

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
