package com.infoshareacademy.events;

import com.infoshareacademy.navigation.Menu;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.io.IOException;
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
    public boolean createEvent(Event event) {
        if (event != null) {
            eventSet.add(event);
            logger.info("New event has been created successfully! \n" + eventSet.toString());
            return true;
        }
        else{
            logger.info("Event already existing! \n");
            logger.info("Failed! Please try again");
            return false;
        }

    }

    @Override
    public boolean deleteEvent(Integer eventId) {
        logger.info("Event to be deleted: \n");
        showSingleEvent(eventId);
        for (Event event : eventSet) {
            if (eventId.equals(event.getId())) {
                eventSet.remove(event);
                logger.info("\n\nActual list of events: \n" + eventSet.toString());
                return true;
            }
        }
        logger.info("\nFailed! Please try again");
        return false;
    }


    @Override
    public boolean updateEventById(Integer eventId) {
        for (Event event : eventSet) {
            if ((event.getId().equals(eventId))) {
                logger.info("Please enter new name. To go next hit Enter ");
                Scanner scanName = new Scanner(System.in);
                String name = scanName.nextLine();
                if (!name.equals("")) {
                    event.setName(name);
                } else {
                    event.getName();
                }
                logger.info("Please enter new place name. To go next hit Enter ");
                Scanner scanPlace = new Scanner(System.in);
                String placeName = scanPlace.nextLine();
                if (!placeName.equals("")) {
                    Place place = event.getPlace();
                    place.setName(placeName);
                } else {
                    event.getPlace().getName();
                }
                logger.info("Please enter new  place subname. To go next hit Enter ");
                Scanner scanSubname = new Scanner(System.in);
                String subname = scanSubname.nextLine();
                if (!subname.equals("")) {
                    Place place = event.getPlace();
                    place.setSubname(subname);
                } else {
                    event.getPlace().getSubname();
                }
                logger.info("Please enter new start date. To go next hit Enter ");
                Scanner scanStartDate = new Scanner(System.in);
                String startDate = scanStartDate.nextLine();
                if (!startDate.equals("")) {
                    event.setStartDate(startDate);
                } else {
                    event.dateTimeFormatter(event.getStartDate());
                }
                logger.info("Please enter new end date. To go next hit Enter ");
                Scanner scanEndDate = new Scanner(System.in);
                String endDate = scanEndDate.nextLine();
                if (!endDate.equals("")) {
                    event.setEndDate(endDate);
                } else {
                    event.dateTimeFormatter(event.getEndDate());
                }
                logger.info("Please enter new organizer designation. To go next hit Enter ");
                Scanner scanOrganizer = new Scanner(System.in);
                String organizer = scanOrganizer.nextLine();
                if (!organizer.equals("")) {
                    Organizer org = event.getOrganizer();
                    org.setDesignation(organizer);
                } else {
                    event.getOrganizer().getDesignation();
                }
                logger.info("Please enter new event URL. To go next hit Enter ");
                Scanner scanUrlWww = new Scanner(System.in);
                String urlW = scanUrlWww.nextLine();
                if (!urlW.equals("")) {
                    EventURL eventURL = event.getUrls();
                    eventURL.setWww(urlW);
                } else {
                    event.getUrls().getWww();
                }
                logger.info("Please enter new event URL for tickets. To go next hit Enter ");
                Scanner scanUrlTicket = new Scanner(System.in);
                String urlT = scanUrlTicket.nextLine();
                if (!urlT.equals("")) {
                    EventURL eventURL = event.getUrls();
                    eventURL.setTickets(urlT);
                } else {
                    event.getUrls().getTickets();
                }
                logger.info("Please enter new category ID. To go next hit Enter ");
                Scanner scanCat = new Scanner(System.in);
                String cat = scanCat.nextLine();
                if (!cat.equals("")) {
                    event.setCategoryId(cat);
                } else {
                    event.getCategoryId();
                }
                logger.info("Please enter 'yes' if event is active. To go next hit Enter ");
                Scanner scanActive = new Scanner(System.in);
                String active = scanActive.nextLine();
                if (active.equals("yes")) {
                    event.setActive(1);
                } else {
                    event.setActive(0);
                }
                logger.info("Please enter new ticket type. To go next hit Enter ");
                Scanner scanTicketType = new Scanner(System.in);
                String ticketType = scanCat.nextLine();
                if (!ticketType.equals("")) {
                    Ticket ticket = event.getTickets();
                    ticket.setType(ticketType);
                } else {
                    event.getTickets().getType();
                }
                logger.info("Please enter new start ticket. To go next hit Enter ");
                Scanner scanStartT = new Scanner(System.in);
                String startTicket = scanCat.nextLine();
                if (!startTicket.equals("")) {
                    Ticket ticket = event.getTickets();
                    ticket.setStartTicket(startTicket);
                } else {
                    event.getTickets().getStartTicket();
                }
                logger.info("Please enter new end ticket. To go next hit Enter ");
                Scanner scanEndT = new Scanner(System.in);
                String endTicket = scanCat.nextLine();
                if (!endTicket.equals("")) {
                    Ticket ticket = event.getTickets();
                    ticket.setEndTicket(endTicket);
                } else {
                    event.getTickets().getEndTicket();
                }
                logger.info("Please enter new attachment. To go next hit Enter ");
                Scanner scanAttachment = new Scanner(System.in);
                String attach = scanAttachment.nextLine();
                if (!attach.equals("")) {
                    for (Attachment attachment : event.getAttachments()) {
                        attachment.setFileName(attach);
                    }
                } else {
                    for (Attachment attachment : event.getAttachments()) {
                        attachment.getFileName();
                    }
                }
                logger.info(event.toString());
            }

        }
        return false;
    }

    @Override
    public HashSet<Event> convertEvents(Event[] events) {
        return null;
    }

    @Override
    public void showAllEvents() {
        clearScreen();
        String isActive;
        for (Event event : eventSet) {
            if (event.getActive().equals(1)) {
                isActive = "Active";
            } else {
                isActive = "Inactive";
            }
            logger.info("Event ID: " + event.getId() + "\n");
            logger.info("This Event is: " + isActive + "\n");
            logger.info("Description: " + event.getName() + "\n");
            logger.info("Place: " + event.getPlace().getSubname() + "\n");
            logger.info("Organiser: " + event.getOrganizer().getDesignation() + "\n");
            logger.info("Start Date: " + event.dateTimeFormatter(event.getStartDate()) + "\n");
            logger.info("End Date: " + event.dateTimeFormatter(event.getEndDate()) + "\n\n");

            Menu.menuAllEvents();
            //break;

        }
    }


    @Override
    public void showSingleEvent(Integer eventId) {
        clearScreen();
        boolean eventFound = false;
        String isActive;
        for (Event event : eventSet) {
            if (event.getId().equals(eventId)) {
                eventFound = true;

                    if (event.getActive().equals(0)) isActive = "inactive.";
                    else isActive = "active.";
                    logger.info("Event ID: " + event.getId() + ". This event is " + isActive + "\n");
                    logger.info("Start: " + event.dateTimeFormatter(event.getStartDate()) + "\n");
                    logger.info("End: " + event.dateTimeFormatter(event.getEndDate()) + "\n\n");
                    logger.info(event.getName() + " @ " + event.getPlace().getName() + "\n");
                    logger.info(event.trimDescription(event.getDescLong()));
                    if (event.getPlace().getSubname() != null)
                        logger.info("\n\nPlace: " + event.getPlace().getName() + ", " + event.getPlace().getSubname());
                    else
                        logger.info("\n\nPlace: " + event.getPlace().getName());
                    logger.info("\nOrganiser:" + event.getOrganizer().getDesignation());
                    if (event.getTickets().getStartTicket() != null)
                        logger.info(("\n\nTickets from " + event.getTickets().getStartTicket() + " to " + event.getTickets().getEndTicket()));
                    if (event.getTickets().getEndTicket() != null)
                        logger.info("\nGet tickets on " + event.getUrls().getTickets());
                    logger.info("\n\nEvent URL: " + event.getUrls().getWww());
                    if (event.getAttachments().length != 0) logger.info("\nAttachments: ");
                    for (Attachment attachment1 : event.getAttachments())
                        logger.info("/n" + attachment1.getFileName());
                Menu.menuSingleEvent();
                break;
            }
        }
        if (!eventFound) {
            logger.info("Event not found! Going back to list of all events in: \n");
            Integer i = 5;
            while (i > 0) {
                logger.info(i.toString() + "... \n");
                try {
                    i--;
                    Thread.sleep(1000L);    // 1000L = 1000ms = 1 second
                } catch (InterruptedException e) {
                    logger.info(e.getMessage());
                    showAllEvents();
                }
            }
            showAllEvents();
        }
    }

    }

    public String getUserQuery() {
        Scanner scanner = new Scanner(System.in);
        String userInput;
        while (true) {
            logger.info("\nPlease provide at least 3 characters in your query:\n");
            userInput = scanner.nextLine();
            if (userInput.length() >= 3) {
                return userInput;
            } else {
                logger.info("\nNot enough characters provided.");
            }
        }
    }

    @Override
    public List<Event> searchByString(String userInput) {
        List<Event> eventList = new ArrayList<>();
        String eventSpecification;
        for (Event event : eventSet) {
            eventSpecification = event.returnEventParams();
            if (eventSpecification.toLowerCase()
                    .contains
                            (userInput.toLowerCase())) {
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

    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}