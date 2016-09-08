package andigital.venuesapp.model.recommended;

import java.io.Serializable;
import java.util.List;

public class Group implements Serializable {

    List<Item> items;

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }
}
