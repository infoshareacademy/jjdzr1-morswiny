package com.infoshareacademy.navigation;

import com.infoshareacademy.events.Event;
import com.infoshareacademy.events.EventRepository;
import com.infoshareacademy.favourites.Favourites;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.Scanner;

public class Menu {
    private static final Logger STDOUT = LoggerFactory.getLogger("CONSOLE_OUT");

    static EventRepository repository = new EventRepository();
    static Favourites favourites = new Favourites();

    public static EventRepository getRepository() {
        return repository;
    }

    public static void programStart() throws IOException {
        repository = new EventRepository();
        favourites = new Favourites();
        repository.arrayToSet();
        start();
    }

    public static void start() throws IOException {

        EventRepository.clearScreen();
        STDOUT.info("Welcome to our programme!\n");
        STDOUT.info("Press 1 to view all events\n");
        STDOUT.info("Press 2 to view favourites\n");
        STDOUT.info("Press 3 to exit\n\n");
        STDOUT.info("Please insert your choice:  ");


        Scanner scanner = new Scanner(System.in);
        Integer choice = scanner.nextInt();
            if (choice == 1)
                repository.showAllEvents();
            else if (choice == 2)
                favourites.showFavs();
            else if (choice == 3) {
                System.exit(0);
            } else {
                start();
            }
    }

    public static void menuAllEvents() throws IOException {

        EventRepository eventRepository = new EventRepository();
        STDOUT.info("\nPress 1 to go to detailed information for selected event\n");
        STDOUT.info("Press 2 to go back to main menu\n\n");
        STDOUT.info("Please insert your choice:  ");
        Scanner scanner = new Scanner(System.in);
        Integer choice = scanner.nextInt();

        while(true){
            if(choice==1){
                STDOUT.info("Please insert eventId to receive some more additional information about this particual event: ");
                Integer choiceSingleEvent = scanner.nextInt();
                repository.showSingleEvent(choiceSingleEvent);

            }else if(choice==2){
               start();
            }

        }

    }

    public static void menuSingleEvent(Event eventSent) throws IOException {
        if (!Favourites.getFavourites().contains(eventSent))
            STDOUT.info("\n\n*This event is not on your favourites list* \nPress 1 to add this event to FAVOURITES\n");
        if (Favourites.getFavourites().contains(eventSent))
            STDOUT.info("\n\n*This event is on your favourites list.* \nPress 5 to remove it from your favourites\n");
        STDOUT.info("Press 2 to reserve tickets for this event\n");
        STDOUT.info("Press 3 to go back to the list of all events\n");
        STDOUT.info("Press 4 to go back to main menu\n\n");
        STDOUT.info("Please insert your choice:  ");


        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
        while (true) {
            if (choice == 1) {
                favourites.addToFavs(eventSent);
                menuSingleEvent(eventSent);
            } else if (choice == 2) {
                STDOUT.info("Reservation system is in development. Please choose another option\n");
                choice = scanner.nextInt();
            } else if (choice == 3)
                repository.showAllEvents();
            else if (choice == 4)
                start();
            else if (choice == 5) {
                favourites.deleteFromFavs(eventSent);
                menuSingleEvent(eventSent);
            }
            else {
                STDOUT.info("Please enter valid number: ");
                choice = scanner.nextInt();
            }
        }
    }

    public static void menuSingleFav(Event eventSent) throws IOException {

        STDOUT.info("\n\nPress 1 to remove this event from Favourites\n");
        STDOUT.info("Press 2 to reserve tickets for this event\n");
        STDOUT.info("Press 3 to go to the list of favourite events\n");
        STDOUT.info("Press 4 to go back to main menu\n\n");
        STDOUT.info("Please insert your choice:  ");


        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
        while (true) {
            if (choice == 1) {
                favourites.deleteFromFavs(eventSent);
                favourites.showFavs();
            } else if (choice == 2) {
                STDOUT.info("Reservation system is in development. Please choose another option\n");
                choice = scanner.nextInt();
            } else if (choice == 3)
                favourites.showFavs();
            else if (choice == 4)
                start();
            else {
                STDOUT.info("Please enter a valid number: ");
                choice = scanner.nextInt();
            }
        }

    }
}
