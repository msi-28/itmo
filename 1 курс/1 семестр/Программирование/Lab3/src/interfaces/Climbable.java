package interfaces;

import models.places.Place;

public interface Climbable {
    public String climbTo(Place place);
    public String climbOut(Place place);
}
