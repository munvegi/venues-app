package andigital.venuesapp.model;


import java.io.Serializable;

public class Stats implements Serializable {

  private Integer checkinsCount;
  private Integer usersCount;
  private Integer tipCount;

  public Integer getCheckinsCount() {
    return checkinsCount;
  }

  public Integer getUsersCount() {
    return usersCount;
  }

  public Integer getTipCount() {
    return tipCount;
  }
}
