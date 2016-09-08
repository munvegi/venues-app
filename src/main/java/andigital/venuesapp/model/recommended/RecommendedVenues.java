package andigital.venuesapp.model.recommended;

import andigital.venuesapp.model.Meta;

import java.io.Serializable;


public class RecommendedVenues implements Serializable {

    //Meta meta;

    Response response;

    public Response getResponse() {
        return response;
    }

    public void setResponse(Response response) {
        this.response = response;
    }
}
