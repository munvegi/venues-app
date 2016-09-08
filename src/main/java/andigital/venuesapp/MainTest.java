package andigital.venuesapp;

import andigital.venuesapp.configuration.RestTemplateConfiguration;
import andigital.venuesapp.model.Venue;
import andigital.venuesapp.service.VenueService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class MainTest {

    public static void main(String args[]) {

        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(RestTemplateConfiguration.class);
        VenueService venueService = applicationContext.getBean(VenueService.class);

        List<Venue> venues = venueService.getRecommendedVenues("Barnet");

        System.out.println(venues);
    }
}
