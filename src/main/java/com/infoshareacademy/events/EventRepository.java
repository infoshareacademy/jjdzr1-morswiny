package com.infoshareacademy.events;

import java.util.*;

public class EventRepository implements EventRepositoryInterface {

    public Set<Event> eventSet;

    public void arrayToSet() {
        GsonEvents gsonEvents = new GsonEvents();
        Event[] event = gsonEvents.getJsonEventData("src/main/resources/db_events.json");
        Set<Event> eventSet1 = new HashSet<>(Arrays.asList(event));
        this.eventSet = eventSet1;
    }


    @Override
    public HashSet<Event> convertEvents(Event[] events) {
        return null;
    }

    @Override
    public void showAllEvents() {
        for(Event event:eventSet){
            System.out.println(event.toString());
        }


    }

    @Override
    public void showSingleEvent(Integer eventId) {
        for (Event event : eventSet) {
            if (event.getId().equals(eventId)) {
                System.out.println(event.toString());
            }

        }
    }

    @Override
    public List<Event> searchByString(String name) {
        List<Event> eventList = new ArrayList<>();
        for (Event event : eventSet) {
            String eventSpecification = event.toString();
            if (eventSpecification.contains(name)) {
                eventList.add(event);
            }
        }
        return eventList;
    }

    @Override
    public List<Event> searchByInteger(Integer name) {
        return null;
    }

    @Override
    public List<Event> filterEvents() {
        return null;
    }


    public Set<Event> getEventSet() {
        return eventSet;
    }
}
