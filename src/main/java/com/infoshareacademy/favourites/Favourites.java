package com.infoshareacademy.favourites;

import com.infoshareacademy.events.Event;
import com.infoshareacademy.navigation.Menu;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Favourites {

    private static final Logger logger = LoggerFactory.getLogger("CONSOLE_OUT");
    private static List<Event> favList = new ArrayList<>();

    public static List<Event> getFavourites() {
        return favList;
    }

    public void deleteFromFavs(Event eventToDelete) {
        if(favList.contains(eventToDelete)){
            favList.remove(eventToDelete);
            logger.info("Event deleted!");
        } else {
            logger.info("This event was not on the list!");
        }
    }

    public void showFavs() {
        if (!favList.isEmpty()) {
            Integer i = 1;
            for (Event event : favList) {
                logger.info("------------" +    i   + "------------\n");
                logger.info("Event ID: " + event.getId() + "\n");
                logger.info(event.getName());
                logger.info(" @ " + event.getPlace().getName());
                logger.info("\nOrganiser: " + event.getOrganizer().getDesignation() + "\n");
                logger.info("Start Date: " + event.dateTimeFormatter(event.getStartDate()) + "\n");
                i += 1;
            }
        } else
            logger.info("\nThe list is empty!\n");


        if (!favList.isEmpty())
        logger.info("\n\nPress 1 to view event with all details\n");
        logger.info("Press 2 to go back to main menu\n");

        Scanner scanner = new Scanner(System.in);
        Integer choice = scanner.nextInt();
        while (true) {
            if (choice == 1) {
                logger.info("Please input ID of event you want to show\n");
                Integer inputId = scanner.nextInt();
                Menu.getRepository().showSingleEvent(inputId);
            } else if (choice == 2) {
                Menu.start();
            }
        }
    }

    public void addToFavs(Event eventToAdd) {
        if(!favList.contains(eventToAdd)){
           favList.add(eventToAdd);
            logger.info("Event added!");
        } else {
            logger.info("This event is already on the list!");
        }
    }

    }
