package andigital.venuesapp.model;

import java.io.Serializable;


public class VenueResponse implements Serializable {

    Meta meta;
    Response response;

    public Meta getMeta() {
        return meta;
    }

    public void setMeta(Meta meta) {
        this.meta = meta;
    }

    public Response getResponse() {
        return response;
    }

    public void setResponse(Response response) {
        this.response = response;
    }
}
