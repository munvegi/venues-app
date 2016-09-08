package andigital.venuesapp.model;

import java.io.Serializable;

public class Price implements Serializable {
  
  private Integer tier;
  private String message;

  public Integer getTier() {
    return tier;
  }

  public String getMessage() {
    return message;
  }
}
