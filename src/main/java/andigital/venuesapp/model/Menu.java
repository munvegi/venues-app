package andigital.venuesapp.model;

import java.io.Serializable;

public class Menu implements Serializable {
  
  private String type;
  private String label;
  private String anchor;
  private String url;
  private String mobileUrl;

  public String getType() {
    return type;
  }

  public String getLabel() {
    return label;
  }

  public String getAnchor() {
    return anchor;
  }

  public String getUrl() {
    return url;
  }

  public String getMobileUrl() {
    return mobileUrl;
  }
}
