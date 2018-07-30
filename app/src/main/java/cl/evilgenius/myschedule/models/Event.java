package cl.evilgenius.myschedule.models;

import com.orm.SugarRecord;

public class Event extends SugarRecord {
    public Event() {
    }

    String name, date, hour, place, description;
    boolean done;



    public Event(String name, String date, String hour, String place, String description, boolean done) {
        this.name = name;
        this.date = date;
        this.hour = hour;
        this.place = place;
        this.description = description;
        this.done = done;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getHour() {
        return hour;
    }

    public void setHour(String hour) {
        this.hour = hour;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }
}
