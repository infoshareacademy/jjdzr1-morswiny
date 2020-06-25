package com.infoshareacademy.events;

import com.infoshareacademy.navigation.Menu;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class EventRepository implements EventRepositoryInterface {

    private static final Logger STDOUT = LoggerFactory.getLogger("CONSOLE_OUT");
    private Set<Event> eventSet;

    public void arrayToSet() {
        GsonEvents gsonEvents = new GsonEvents();
        Event[] event = gsonEvents.getJsonEventData("src/main/resources/events.json");
        Set<Event> eventSet1 = new HashSet<>(Arrays.asList(event));
        this.eventSet = eventSet1;
    }

    private boolean eventExist(Event event) {
        return Objects.nonNull(event) && eventSet.contains(event);
    }

    @Override
    public boolean createEvent(Event event) {
        if (!eventExist(event)) {
            eventSet.add(event);
            STDOUT.info("New event has been created successfully! \n" + event);
            return true;
        } else {
            STDOUT.info("Event already existing or not defined!");
        }
        return false;
    }

    public Event putEventData() throws Exception{
        Event event = new Event();
        STDOUT.info("Enter ID\n");
        Scanner scanner = new Scanner(System.in);
        String id = scanner.nextLine();
        event.setId(Integer.valueOf(id));
        STDOUT.info("Enter name\n");
        if (scanner.hasNextLine()){
            String name = scanner.nextLine();
            event.setName(name);
            STDOUT.info("Enter start date\n");
        }
        if (scanner.hasNextLine()){
            String startDate = scanner.nextLine();
            event.setStartDate(startDate);
            STDOUT.info("Enter end date\n");
        }
        if (scanner.hasNextLine()){
            String endDate = scanner.nextLine();
            event.setEndDate(endDate);
            STDOUT.info("Enter place\n");
        }
        if (scanner.hasNextLine()){
            try {
                String placeName = scanner.nextLine();
                Place place = new Place();
                place.setName(placeName);
                place.setSubname(placeName);
                event.setPlace(place);
            } catch (NullPointerException e) {
            }
            STDOUT.info("Enter category ID\n");
        }
        if (scanner.hasNextLine()){
            String categoryId = scanner.nextLine();
            event.setCategoryId(categoryId);
            STDOUT.info("Enter organizer\n");
        }
        if (scanner.hasNextLine()){
            try {
                String organizerDest = scanner.nextLine();
                Organizer organizer = new Organizer();
                organizer.setDesignation(organizerDest);
                event.setOrganizer(organizer);
            } catch (NullPointerException e) {
            }
            STDOUT.info("Enter url address\n");
        }
        if (scanner.hasNextLine()){
            try {
                String url = scanner.nextLine();
                EventURL www = new EventURL();
                www.setWww(url);
                event.setUrls(www);
            } catch (NullPointerException e) {
            }
            STDOUT.info("Enter attachment\n");
        }
        if (scanner.hasNextLine()){
            try {
                String attach = scanner.nextLine();
                Attachment[] attachment = event.getAttachments();
                attachment[0].setFileName(attach);
                event.setAttachments(attachment);
            } catch (NullPointerException e) {
            }
            STDOUT.info("Enter 1 if event is active, 0 if inactive\n");
        }
        if (scanner.hasNextLine()) {
            Integer number = scanner.nextInt();
            event.setActive(number);
        }
        return event;
    }


    @Override
    public boolean deleteEvent(Integer eventId) {
        for (Event event : eventSet) {
            if (eventId.equals(event.getId())) {
                eventSet.remove(event);
                STDOUT.info("Event has been deleted");
                return true;
            }
        }
        STDOUT.info("\nFailed! Please try again");
        return false;
    }


    @Override
    public boolean updateEventById(Integer eventId) {
        for (Event event : eventSet) {
            if ((event.getId().equals(eventId))) {
                STDOUT.info("Please enter new name. To go next hit Enter ");
                Scanner scanName = new Scanner(System.in);
                String name = scanName.nextLine();
                if (!name.equals("")) {
                    event.setName(name);
                } else {
                    event.getName();
                }
                STDOUT.info("Please enter new place name. To go next hit Enter ");
                Scanner scanPlace = new Scanner(System.in);
                String placeName = scanPlace.nextLine();
                if (!placeName.equals("")) {
                    Place place = event.getPlace();
                    place.setName(placeName);
                } else {
                    event.getPlace().getName();
                }
                STDOUT.info("Please enter new  place subname. To go next hit Enter ");
                Scanner scanSubname = new Scanner(System.in);
                String subname = scanSubname.nextLine();
                if (!subname.equals("")) {
                    Place place = event.getPlace();
                    place.setSubname(subname);
                } else {
                    event.getPlace().getSubname();
                }
                STDOUT.info("Please enter new start date. To go next hit Enter ");
                Scanner scanStartDate = new Scanner(System.in);
                String startDate = scanStartDate.nextLine();
                if (!startDate.equals("")) {
                    event.setStartDate(startDate);
                } else {
                    event.dateTimeFormatter(event.getStartDate());
                }
                STDOUT.info("Please enter new end date. To go next hit Enter ");
                Scanner scanEndDate = new Scanner(System.in);
                String endDate = scanEndDate.nextLine();
                if (!endDate.equals("")) {
                    event.setEndDate(endDate);
                } else {
                    event.dateTimeFormatter(event.getEndDate());
                }
                STDOUT.info("Please enter new organizer designation. To go next hit Enter ");
                Scanner scanOrganizer = new Scanner(System.in);
                String organizer = scanOrganizer.nextLine();
                if (!organizer.equals("")) {
                    Organizer org = event.getOrganizer();
                    org.setDesignation(organizer);
                } else {
                    event.getOrganizer().getDesignation();
                }
                STDOUT.info("Please enter new event URL. To go next hit Enter ");
                Scanner scanUrlWww = new Scanner(System.in);
                String urlW = scanUrlWww.nextLine();
                if (!urlW.equals("")) {
                    EventURL eventURL = event.getUrls();
                    eventURL.setWww(urlW);
                } else {
                    event.getUrls().getWww();
                }
                STDOUT.info("Please enter new event URL for tickets. To go next hit Enter ");
                Scanner scanUrlTicket = new Scanner(System.in);
                String urlT = scanUrlTicket.nextLine();
                if (!urlT.equals("")) {
                    EventURL eventURL = event.getUrls();
                    eventURL.setTickets(urlT);
                } else {
                    event.getUrls().getTickets();
                }
                STDOUT.info("Please enter new category ID. To go next hit Enter ");
                Scanner scanCat = new Scanner(System.in);
                String cat = scanCat.nextLine();
                if (!cat.equals("")) {
                    event.setCategoryId(cat);
                } else {
                    event.getCategoryId();
                }
                STDOUT.info("Please enter 'yes' if event is active. To go next hit Enter ");
                Scanner scanActive = new Scanner(System.in);
                String active = scanActive.nextLine();
                if (active.equals("yes")) {
                    event.setActive(1);
                } else {
                    event.setActive(0);
                }
                STDOUT.info("Please enter new ticket type. To go next hit Enter ");
                Scanner scanTicketType = new Scanner(System.in);
                String ticketType = scanCat.nextLine();
                if (!ticketType.equals("")) {
                    Ticket ticket = event.getTickets();
                    ticket.setType(ticketType);
                } else {
                    event.getTickets().getType();
                }
                STDOUT.info("Please enter new start ticket. To go next hit Enter ");
                Scanner scanStartT = new Scanner(System.in);
                String startTicket = scanCat.nextLine();
                if (!startTicket.equals("")) {
                    Ticket ticket = event.getTickets();
                    ticket.setStartTicket(startTicket);
                } else {
                    event.getTickets().getStartTicket();
                }
                STDOUT.info("Please enter new end ticket. To go next hit Enter ");
                Scanner scanEndT = new Scanner(System.in);
                String endTicket = scanCat.nextLine();
                if (!endTicket.equals("")) {
                    Ticket ticket = event.getTickets();
                    ticket.setEndTicket(endTicket);
                } else {
                    event.getTickets().getEndTicket();
                }
                STDOUT.info("Please enter new attachment. To go next hit Enter ");
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
                STDOUT.info("Event has been updated \n" + event.toString());
            }

        }
        return false;
    }

    @Override
    public HashSet<Event> convertEvents(Event[] events) {
        return null;
    }

    @Override
    public void showAllEvents() throws IOException {
        clearScreen();
        String isActive;
        for (Event event : eventSet) {
            if (event.getActive().equals(1)) {
                isActive = "Active";
            } else {
                isActive = "Inactive";
            }
            STDOUT.info("Event ID: " + event.getId() + "\n");
            STDOUT.info("This Event is: " + isActive + "\n");
            STDOUT.info("Description: " + event.getName() + "\n");
            if (event.getPlace().getSubname() != null) {
                STDOUT.info("Place: " + event.getPlace().getSubname()+"\n");
            } else {
                STDOUT.info("Place: " + event.getPlace().getName()+"\n");
            }
            STDOUT.info("Organiser: " + event.getOrganizer().getDesignation() + "\n");
            STDOUT.info("Start Date: " + event.dateTimeFormatter(event.getStartDate()) + "\n");
            STDOUT.info("End Date: " + event.dateTimeFormatter(event.getEndDate()) + "\n\n");

        }
        Menu.menuAllEvents();
    }

    @Override
    public void showSingleEvent(Integer eventId) throws IOException {
        clearScreen();
        boolean eventFound = false;
        for (Event event : eventSet) {
            if (event.getId().equals(eventId)) {
                eventFound = true;
                singleEventData(event);
                Menu.menuSingleEvent(event);
                break;
            }
        }
        if (!eventFound) {
            STDOUT.info("Event not found! Try again or press 1 to go back to main menu\n");
            Scanner scanner = new Scanner(System.in);
            int choice = 0;
            try {
                choice = scanner.nextInt();
                if (choice != 1) {
                    showSingleEvent(choice);
                } else {
                    Menu.start();
                }
            } catch (Exception e) {
                STDOUT.info("Please enter valid number");
            }
        }
    }

    public void singleEventData(Event event) {
        String isActive;
        if (event.getActive().equals(0)) {
            isActive = "inactive.";
        } else isActive = "active.";

        STDOUT.info("\n---------------*---------------");
        STDOUT.info("\nEvent ID: " + event.getId() + ". This event is " + isActive + "\n");
        STDOUT.info("Start: " + event.dateTimeFormatter(event.getStartDate()) + "\n");
        STDOUT.info("End: " + event.dateTimeFormatter(event.getEndDate()) + "\n\n");
        STDOUT.info(event.getName() + " @ " + event.getPlace().getName() + "\n");
        STDOUT.info(event.trimDescription(event.getDescLong()));

        if (event.getPlace().getSubname() != null) {
            STDOUT.info("\n\nPlace: " + event.getPlace().getName() + ", " + event.getPlace().getSubname());
        } else {
            STDOUT.info("\n\nPlace: " + event.getPlace().getName());
        }
        STDOUT.info("\nOrganiser:" + event.getOrganizer().getDesignation());
        if (event.getTickets().getStartTicket() != null) {
            STDOUT.info(("\n\nTickets from " + event.getTickets().getStartTicket() + " to " + event.getTickets().getEndTicket()));
        }
        if (event.getTickets().getEndTicket() != null) {
            STDOUT.info("\nGet tickets on " + event.getUrls().getTickets());
        }
        STDOUT.info("\n\nEvent URL: " + event.getUrls().getWww());
        if (event.getAttachments().length != 0) {
            STDOUT.info("\nAttachments: ");
            for (Attachment attachment1 : event.getAttachments())
                STDOUT.info("\n" + attachment1.getFileName());
        }
        STDOUT.info("\n---------------*---------------");
    }

    public void showListOfEvents (List <Event> list){
        for (Event event : list) {
            singleEventData(event);
        }
    }


    @Override
    public List<Event> searchByString(String userInput) {
        List<Event> list = new ArrayList<>();
        String eventSpecification;
        for (Event event : eventSet) {
            eventSpecification = event.returnEventParams();
            if (eventSpecification.toLowerCase()
                    .contains
                            (userInput.toLowerCase())) {
                list.add(event);
            }
        }
        return list;
    }

    @Override
    public List<Event> searchByOrganizer(String organizer) {
        List<Event> list = new ArrayList<>();
        for (Event event : eventSet) {
            if (event.getOrganizer().getDesignation().toLowerCase()
                    .contains
                            (organizer.toLowerCase())) {
                list.add(event);
            }
        }
        return list;
    }

    @Override
    public List<Event> searchByPlace(String place) {
        List<Event> list = new ArrayList<>();
        for (Event event : eventSet) {
            String nameAndSubname = event.getPlace().getName() + event.getPlace().getSubname();
            if (nameAndSubname.toLowerCase()
                    .contains(
                            place.toLowerCase())) {
                list.add(event);
            }
        }
        return list;
    }

    @Override
    // 1 if active, 0 if inactive
    public List<Event> searchActive(Integer active) {
        List<Event> list = new ArrayList<>();
        for (Event event : eventSet) {
            if (event.getActive().equals(active)) {
                list.add(event);
            }
        }
        return list;
    }

    @Override
    public List<Event> searchByName(String name) {
        List<Event> list = new ArrayList<>();
        for (Event event : eventSet) {
            if (event.getName().toLowerCase()
                    .contains(
                            name.toLowerCase())) {
                list.add(event);
            }
        }
        return list;
    }

    public LocalDate stringToLocalDate (String date){
        Properties prop = Event.readPropertiesFile();
        String[] dateArray = date.split("T");
        LocalDate eventDate = LocalDate.parse(dateArray[0]);
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern(prop.getProperty("date.format"));
        String eventDate1 = eventDate.format(dtf);
        return LocalDate.parse(eventDate1, dtf);
    }

    // method to search for event dates
    public List<Event> searchByExactDate(String date) {
        LocalDate queryDate = stringToLocalDate(date);

        List<Event> list = new ArrayList<>();
        for (Event event : eventSet) {
            LocalDate eventStart = stringToLocalDate(event.getStartDate());
            LocalDate eventEnd = stringToLocalDate(event.getEndDate());
            if (eventStart.isBefore(queryDate) && eventEnd.isAfter(queryDate)) {
                list.add(event);
            }
        }
        return list;
    }

    // method to search for event dates
    public List<Event> searchByMonth (String date) {
        LocalDate queryDate = stringToLocalDate(date);
        int queryMonth = queryDate.getMonth().getValue();
        List<Event> list = new ArrayList<>();
        for (Event event : eventSet) {
            LocalDate eventStart = stringToLocalDate(event.getStartDate());
            LocalDate eventEnd = stringToLocalDate(event.getEndDate());
            int startMonth = eventStart.getMonth().getValue();
            int endMonth = eventEnd.getMonth().getValue();
            if (startMonth < queryMonth
                    &&
                    endMonth >= queryMonth) {
                list.add(event);
            }
        }
        return list;
    }


    // method to get random String from user for random user's query (at least 3 characters)
    public String getUserQuery() {
        Scanner scanner = new Scanner(System.in);
        String userInput;
        while (true) {
            STDOUT.info(" Please provide at least 3 characters in your query:\n");
            userInput = scanner.nextLine();
            if (userInput.length() >= 3) {
                return userInput;
            } else {
                STDOUT.info("\nNot enough characters provided.");
            }
        }
    }


    public String getInputForName() {
        STDOUT.info("\nProvide name of the event you search for.");
        return getUserQuery();
    }

    public String getInputForPlace() {
        STDOUT.info("\nProvide name of the place to search for events happening there.");
        return getUserQuery();
    }

    public Integer getInputForActive() {
        Scanner scanner = new Scanner(System.in);
        Integer userInput;
        while (true) {
            STDOUT.info("\nSelect 1 if you want to search for active events, select 0 for inactive events.\n\n");
           STDOUT.info("Please insert your choice: ");
            userInput = scanner.nextInt();
            if (userInput.equals(1) || userInput.equals(0)) {
                return userInput;
            } else {
                STDOUT.info("\nIncorrect value provided.");
            }
        }
    }

    public String getInputForOrganizer() {
        STDOUT.info("\nProvide name of organizer to see all events hosted by them: \n");
        String userInput = getUserQuery();
        return userInput;
    }

    public String getRandomInput() {
        STDOUT.info("\nProvide your random query.");
        String userInput = getUserQuery();
        return userInput;
    }

    public Set<Event> getEventSet() {
        return eventSet;
    }

    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}