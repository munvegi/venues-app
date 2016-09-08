package andigital.venuesapp.model.recommended;


import java.io.Serializable;
import java.util.List;

public class Response implements Serializable {

    Integer totalResults;
    List<Group> groups;

    public Integer getTotalResults() {
        return totalResults;
    }

    public List<Group> getGroups() {
        return groups;
    }

    public void setTotalResults(Integer totalResults) {
        this.totalResults = totalResults;
    }

    public void setGroups(List<Group> groups) {
        this.groups = groups;
    }
}
