package cl.evilgenius.myschedule.data;

import java.util.ArrayList;
import java.util.List;

import cl.evilgenius.myschedule.models.Event;

public class Queries {

    public List<Event> eventList() {

        List<Event> eventList = new ArrayList<>();
        List<Event> eventAll = Event.find(Event.class, "done = 0");

        if (eventAll != null && eventAll.size() > 0) {
            eventList.addAll(eventAll);
        }

        return eventList;
    }

}
