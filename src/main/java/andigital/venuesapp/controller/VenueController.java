package andigital.venuesapp.controller;

import andigital.venuesapp.controller.form.SearchForm;
import andigital.venuesapp.model.Venue;
import andigital.venuesapp.service.VenueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;


@Controller
@RequestMapping("/")
public class VenueController {

	@Autowired
	VenueService venueService;

	/**
	 * This method will return the main view.
	 */
	@RequestMapping(value = { "/"}, method = RequestMethod.GET)
	public String searchForm(ModelMap model) {
		model.addAttribute("searchForm", new SearchForm());
		return "searchVenues";
	}

	/**
	 * Performs a venue search
 	 */
	@RequestMapping(value = { "/" }, method = RequestMethod.POST)
	public String doSearch(SearchForm searchForm, ModelMap model) {

		List<Venue> venues;

		if (searchForm.isRecommended()) {
			venues = venueService.getRecommendedVenues(searchForm.getLocation());
		} else {
			venues = venueService.getVenues(searchForm.getLocation());
		}

		model.addAttribute("searchForm", searchForm);
		model.addAttribute("venues", venues);

		return "searchVenues";
	}
}
