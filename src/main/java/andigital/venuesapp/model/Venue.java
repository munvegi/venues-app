package andigital.venuesapp.model;

import java.io.Serializable;
import java.util.List;


public class Venue implements Serializable {

  private String id;
  private String name;
  private Contact contact;
  private Location location;
  private List<Category> categories;
  private Boolean verified;
  private Stats stats;
  private String url;
  private String rating;

  public String getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public Contact getContact() {
    return contact;
  }

  public Location getLocation() {
    return location;
  }

  public List<Category> getCategories() {
    return categories;
  }

  public Boolean getVerified() {
    return verified;
  }

  public Stats getStats() {
    return stats;
  }

  public String getUrl() {
    return url;
  }

  public String getRating() {
    return rating;
  }
}
