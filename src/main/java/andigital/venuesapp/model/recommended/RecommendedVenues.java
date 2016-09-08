package andigital.venuesapp.model.recommended;

import java.io.Serializable;


public class RecommendedVenues implements Serializable {

    Response response;

    public Response getResponse() {
        return response;
    }

    public void setResponse(Response response) {
        this.response = response;
    }
}
