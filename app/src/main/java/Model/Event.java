package Model;

import com.google.android.gms.maps.model.LatLng;

public class Event {

    private String nameOfEvent;
    private LatLng latLng;

    public Event(String nameOfEvent, double latitude, double longitide) {
        this.nameOfEvent = nameOfEvent;
        this.latLng = new LatLng(latitude, longitide);
    }

    public String getNameOfEvent() {
        return nameOfEvent;
    }

    public void setNameOfEvent(String nameOfEvent) {
        this.nameOfEvent = nameOfEvent;
    }

    public double getLatitude() {
        return this.latLng.latitude;
    }

    public double getLongitude() {
        return this.latLng.longitude;
    }
    
}
