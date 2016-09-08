package andigital.venuesapp.service;

import andigital.venuesapp.model.Venue;
import andigital.venuesapp.model.VenueResponse;
import andigital.venuesapp.model.recommended.Group;
import andigital.venuesapp.model.recommended.Item;
import andigital.venuesapp.model.recommended.RecommendedVenues;
import andigital.venuesapp.model.recommended.Response;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.core.env.Environment;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class VenueServiceImplTest {

    @InjectMocks
    private VenueServiceImpl venueService;

    @Mock
    RestTemplate restTemplate;

    @Mock
    Environment environment;

    @Test
    public void getVenues() throws Exception {

        // Given
        String location = "London";
        String baseURI = "baseURI";
        String clientId = "clientId";
        String clientSecret = "clientSecret";
        String version = "version";

        Mockito.when(environment.getProperty("foursquare.search.venues.base.uri")).thenReturn(baseURI);
        Mockito.when(environment.getProperty("foursquare.client.id")).thenReturn(clientId);
        Mockito.when(environment.getProperty("foursquare.client.secret")).thenReturn(clientSecret);
        Mockito.when(environment.getProperty("foursquare.version")).thenReturn(version);

        String venuesURI = baseURI + "?client_id={clientId}&client_secret={clientSecret}&v={version}&near={location}";

        VenueResponse venueResponse = new VenueResponse();
        andigital.venuesapp.model.Response response = new andigital.venuesapp.model.Response();
        venueResponse.setResponse(response);
        List<Venue> expectedVenues = Arrays.asList(new Venue());
        response.setVenues(expectedVenues);

        Mockito.when(restTemplate.getForObject(venuesURI, VenueResponse.class,
                clientId,
                clientSecret,
                version,
                location)).thenReturn(venueResponse);

        // When
        List<Venue> actual = venueService.getVenues("London");

        // Then
        Mockito.verify(restTemplate).getForObject(venuesURI, VenueResponse.class, clientId, clientSecret, version, location);
        assertThat(actual, is(expectedVenues));
    }

    @Test
    public void getRecommendedVenues() throws Exception {

        // Given
        String location = "London";
        String baseURI = "baseURI";
        String clientId = "clientId";
        String clientSecret = "clientSecret";
        String version = "version";

        Mockito.when(environment.getProperty("foursquare.recommended.venues.base.uri")).thenReturn(baseURI);
        Mockito.when(environment.getProperty("foursquare.client.id")).thenReturn(clientId);
        Mockito.when(environment.getProperty("foursquare.client.secret")).thenReturn(clientSecret);
        Mockito.when(environment.getProperty("foursquare.version")).thenReturn(version);

        String venuesURI = baseURI + "?client_id={clientId}&client_secret={clientSecret}&v={version}&near={location}";

        RecommendedVenues recommendedVenues = new RecommendedVenues();
        Response response = new Response();
        recommendedVenues.setResponse(response);
        Group group = new Group();
        List<Group> groups = Arrays.asList(group);
        response.setGroups(groups);
        Item item = new Item();
        List<Item> items = Arrays.asList(item);
        group.setItems(items);
        item.setVenue(new Venue());
        List<Venue> expectedVenues = recommendedVenues.getResponse().getGroups().get(0).getItems()
                .stream().map(anItem -> anItem.getVenue()).collect(Collectors.toList());

        Mockito.when(restTemplate.getForObject(venuesURI, RecommendedVenues.class,
                clientId,
                clientSecret,
                version,
                location)).thenReturn(recommendedVenues);

        // When
        List<Venue> actual = venueService.getRecommendedVenues("London");

        // Then
        Mockito.verify(restTemplate).getForObject(venuesURI, RecommendedVenues.class, clientId, clientSecret, version, location);
        assertThat(actual, is(expectedVenues));
    }
}