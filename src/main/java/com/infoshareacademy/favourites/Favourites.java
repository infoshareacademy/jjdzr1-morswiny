package com.infoshareacademy.favourites;

import com.infoshareacademy.events.Event;
import com.infoshareacademy.navigation.Menu;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class Favourites {

    private static final Logger logger = LoggerFactory.getLogger("CONSOLE_OUT");
    private static List<Event> favList = new ArrayList<>();

    public static List<Event> getFavourites() {
        return favList;
    }

    public void deleteFromFavs(Event eventToDelete) {
        if(!Favourites.getFavourites().contains(eventToDelete)){
            Favourites.getFavourites().remove(eventToDelete);
            logger.info("Event deleted!");
        } else {
            logger.info("This event was not on the list!");
        }
    }

    public void showFavs() {
        if (!favList.isEmpty()) {
            for (Event event : favList) {
                logger.info("Event ID: " + event.getId() + "\n");
                logger.info(event.getName());
                logger.info(" @ " + event.getPlace());
                logger.info("Organiser: " + event.getOrganizer().getDesignation() + "\n");
                logger.info("Start Date: " + event.dateTimeFormatter(event.getStartDate()) + "\n");
            }
        } else
            logger.info("\nThe list is empty!\n");



    }
    public void addToFavs(Event eventToAdd) {
        if(!Favourites.getFavourites().contains(eventToAdd)){
            Favourites.getFavourites().add(eventToAdd);
            logger.info("Event added!");
        } else {
            logger.info("This event is already on the list!");
        }
    }

    }
