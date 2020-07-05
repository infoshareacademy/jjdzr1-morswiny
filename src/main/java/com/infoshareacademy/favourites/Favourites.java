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

    private static final Logger STDOUT = LoggerFactory.getLogger("CONSOLE_OUT");
    private static final List<Event> favList = new ArrayList<>();

    public static List<Event> getFavourites() {
        return favList;
    }

    public void deleteFromFavs(Event eventToDelete) {
        if(favList.contains(eventToDelete)){
            favList.remove(eventToDelete);
            STDOUT.info("Event deleted!\n");
        } else {
            STDOUT.info("This event was not on the list!\n");
        }
    }

    public void showFavs() throws IOException {
        if (!favList.isEmpty()) {
            int i = 1;
            for (Event event : favList) {
                STDOUT.info("------------" +    i   + "------------\n");
                STDOUT.info("Event ID: " + event.getId() + "\n");
                STDOUT.info(event.getName());
                STDOUT.info(" @ " + event.getPlace().getName());
                STDOUT.info("\nOrganiser: " + event.getOrganizer().getDesignation() + "\n");
                STDOUT.info("Start Date: " + event.dateTimeFormatter(event.getStartDate()) + "\n");
                i += 1;
            }
            STDOUT.info("-------------------------");
        } else {

            STDOUT.info("\nThe list is empty!\n");
            STDOUT.info("Press 1 to go to main menu\n");
            STDOUT.info("Press 2 to see all events\n");
            Scanner scanner = new Scanner(System.in);
            int choice = scanner.nextInt();
            if (choice == 1)
                Menu.start();
            else if (choice == 2)
                Menu.getRepository().showAllEvents();
            else {
                STDOUT.info("\nYou entered wrong number. Going back to menu");
                Menu.start();
            }
        }
        if (!favList.isEmpty()) {
                STDOUT.info("\nPress 1 to see details about favourite event\n");
                STDOUT.info("Press 2 to go back to main menu\n");
                Scanner scanner = new Scanner(System.in);
                int choice = scanner.nextInt();
                while (true) {
                    if (choice == 1) {
                        STDOUT.info("Please input ID of event you want to show\n");
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
                            STDOUT.info("Event not found!");
                            showFavs();
                        }
                    } else if (choice == 2) {
                        Menu.start();
                    } else {
                        STDOUT.info("Please enter valid number: ");
                        choice = scanner.nextInt();
                    }
                }
            }
        }

    public void addToFavs(Event eventToAdd) {
        if(!favList.contains(eventToAdd)){
           favList.add(eventToAdd);
            STDOUT.info("Event added!\n");
        } else {
            STDOUT.info("This event is already on the list!\n");
        }
    }
}
