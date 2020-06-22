package com.infoshareacademy.favourites;

import com.infoshareacademy.events.Event;
import com.infoshareacademy.navigation.Menu;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Favourites {

    private static final Logger logger = LoggerFactory.getLogger("CONSOLE_OUT");
    private static final List<Event> favList = new ArrayList<>();

    public static List<Event> getFavourites() {
        return favList;
    }

    public void deleteFromFavs(Event eventToDelete) {
        if(favList.contains(eventToDelete)){
            favList.remove(eventToDelete);
            logger.info("Event deleted!\n");
        } else {
            logger.info("This event was not on the list!\n");
        }
    }

    public void showFavs() throws IOException {
        if (!favList.isEmpty()) {
            int i = 1;
            for (Event event : favList) {
                logger.info("------------" +    i   + "------------\n");
                logger.info("Event ID: " + event.getId() + "\n");
                logger.info(event.getName());
                logger.info(" @ " + event.getPlace().getName());
                logger.info("\nOrganiser: " + event.getOrganizer().getDesignation() + "\n");
                logger.info("Start Date: " + event.dateTimeFormatter(event.getStartDate()) + "\n");
                i += 1;
            }
            logger.info("-------------------------");
        } else {
            logger.info("\nThe list is empty!\n");
            logger.info("Press 1 to go to main menu\n");
            logger.info("Press 2 to see all events\n");
            Scanner scanner = new Scanner(System.in);
            int choice = scanner.nextInt();
            if (choice == 1)
                Menu.start();
            else if (choice == 2)
                Menu.getRepository().showAllEvents();
            else {
                logger.info("\nYou entered wrong number. Going back to menu");
                Menu.start();
            }
        }
        if (!favList.isEmpty()) {
                logger.info("\nPress 1 to see details about favourite event\n");
                logger.info("Press 2 to go back to main menu\n");
                Scanner scanner = new Scanner(System.in);
                int choice = scanner.nextInt();
                while (true) {
                    if (choice == 1) {
                        logger.info("Please input ID of event you want to show\n");
                        Integer inputId = scanner.nextInt();
                        boolean eventFound = false;
                        for (Event favEvent : favList){
                            if (favEvent.getId().equals(inputId)) {
                                eventFound = true;
                                Menu.getRepository().singleEventData(favEvent);
                                Menu.menuSingleFav(favEvent);
                            }
                        }
                        if (!eventFound) {
                            logger.info("Event not found!");
                            showFavs();
                        }
                    } else if (choice == 2) {
                        Menu.start();
                    } else {
                        logger.info("Please enter valid number: ");
                        choice = scanner.nextInt();
                    }
                }
            }
        }

    public void addToFavs(Event eventToAdd) {
        if(!favList.contains(eventToAdd)){
           favList.add(eventToAdd);
            logger.info("Event added!\n");
        } else {
            logger.info("This event is already on the list!\n");
        }
    }
}
