package andigital.venuesapp.controller;

import andigital.venuesapp.model.SearchForm;
import andigital.venuesapp.model.Venue;
import andigital.venuesapp.service.VenueService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.ui.ModelMap;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;


@RunWith(MockitoJUnitRunner.class)
public class VenueControllerTest {

    @Mock
    VenueService venueService;

    @InjectMocks
    VenueController venueController;


    @Test
    public void searchForm() throws Exception {

        // Given
        ModelMap model = Mockito.mock(ModelMap.class);

        // When
        String actual = venueController.searchForm(model);

        // Then
        Mockito.verify(model).addAttribute("searchForm", new SearchForm());
        assertThat(actual, is("searchVenues"));
    }


    @Test
    public void doSearch_recommendedVenues() throws Exception {

        // Given
        SearchForm searchForm = new SearchForm();
        searchForm.setLocation("London");
        searchForm.setRecommended(true);
        ModelMap model = Mockito.mock(ModelMap.class);
        List<Venue> venues = Mockito.mock(List.class);
        Mockito.when(venueService.getRecommendedVenues(searchForm.getLocation())).thenReturn(venues);

        // When
        String actual = venueController.doSearch(searchForm, null, model);

        // Then
        Mockito.verify(venueService).getRecommendedVenues(searchForm.getLocation());
        Mockito.verify(model).addAttribute("searchForm", searchForm);
        Mockito.verify(model).addAttribute("venues", venues);
        assertThat(actual, is("searchVenues"));
    }

    @Test
    public void doSearch_allVenues() throws Exception {

        // Given
        SearchForm searchForm = new SearchForm();
        searchForm.setLocation("London");
        searchForm.setRecommended(false);
        ModelMap model = Mockito.mock(ModelMap.class);
        List<Venue> venues = Mockito.mock(List.class);
        Mockito.when(venueService.getVenues(searchForm.getLocation())).thenReturn(venues);

        // When
        String actual = venueController.doSearch(searchForm, null, model);

        // Then
        Mockito.verify(venueService).getVenues(searchForm.getLocation());
        Mockito.verify(model).addAttribute("searchForm", searchForm);
        Mockito.verify(model).addAttribute("venues", venues);
        assertThat(actual, is("searchVenues"));
    }
}