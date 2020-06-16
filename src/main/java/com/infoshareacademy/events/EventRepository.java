package com.infoshareacademy.events;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.*;

public class EventRepository implements EventRepositoryInterface {

    private static final Logger logger = LoggerFactory.getLogger("CONSOLE_OUT");
    private Set<Event> eventSet;

    public void arrayToSet() {
        GsonEvents gsonEvents = new GsonEvents();
        Event[] event = gsonEvents.getJsonEventData("src/main/resources/events.json");
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
            System.out.println(event.getId());
            //System.out.println(event.toString());
        }


    }

    @Override
    public void showSingleEvent(Integer eventId) {
        boolean eventFound = false;
        String isActive;
        for (Event event : eventSet) {
            if (event.getId().equals(eventId)){
                eventFound = true;

                    if (event.getActive().equals(0)) isActive = "inactive.";
                    else isActive = "active.";
                    logger.info("Event ID: " + event.getId() + ". This event is " + isActive + "\n");
                    logger.info("Start: " + event.dateTimeFormatter(event.getStartDate()) + "\n");
                    logger.info("End: " + event.dateTimeFormatter(event.getEndDate()) + "\n\n");
                    logger.info(event.getName() + " @ " + event.getPlace().getName() + "\n");
                    logger.info(event.trimDescription(event.getDescLong()));
                    logger.info("\n\nPlace: " + event.getPlace().getName() + ", " + event.getPlace().getSubname());
                    logger.info("\nOrganiser:" + event.getOrganizer().getDesignation());
                    if (event.getTickets().getStartTicket() != null)
                        logger.info(("\n\nTickets from " + event.getTickets().getStartTicket() + " to " + event.getTickets().getEndTicket()));
                    if (event.getTickets().getEndTicket() != null)
                        logger.info("\nGet tickets on " + event.getUrls().getTickets());
                    logger.info("\n\nEvent URL: " + event.getUrls().getWww());
                    if (event.getAttachments().length != 0) logger.info("\nAttachments: ");
                    for (Attachment attachment1 : event.getAttachments())
                        logger.info("/n" + attachment1.getFileName());
                    break;

            }

        }
        if (!eventFound) {logger.info("Nie znalazles eventu");}

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
