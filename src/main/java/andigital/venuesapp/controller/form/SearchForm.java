package andigital.venuesapp.controller.form;

public class SearchForm {

    private String location;
    private boolean recommended = true;

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public boolean isRecommended() {
        return recommended;
    }

    public void setRecommended(boolean recommended) {
        this.recommended = recommended;
    }


    @Override
    public boolean equals(Object o) {
        if (!(o instanceof SearchForm)) {
            return false;
        }
        SearchForm that = (SearchForm) o;
        return recommended == that.recommended && (location != null ? location.equals(that.location) : that.location == null);
    }

    @Override
    public int hashCode() {
        int result = location != null ? location.hashCode() : 0;
        result = 31 * result + (recommended ? 1 : 0);
        return result;
    }
}
