package com.infoshareacademy.navigation;

import com.infoshareacademy.events.Event;
import com.infoshareacademy.events.EventRepository;
import com.infoshareacademy.favourites.Favourites;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Scanner;

public class Menu {
    private static final Logger STDOUT = LoggerFactory.getLogger("CONSOLE_OUT");

    static EventRepository repository = new EventRepository();
    static Favourites favourites = new Favourites();

    public static EventRepository getRepository() {
        return repository;
    }

    public static void start() {

        repository.arrayToSet();
        EventRepository.clearScreen();
        STDOUT.info("Welcome to our programme!\n");
        STDOUT.info("Press 1 to view all events\n");
        STDOUT.info("Press 2 to view favourites\n");
        STDOUT.info("Press 3 to exit\n");

        Scanner scanner = new Scanner(System.in);
        Integer choice = scanner.nextInt();
        if (choice == 1)
            repository.showAllEvents();
        else if (choice == 2)
            favourites.showFavs();
        else if (choice == 3)
            System.exit(0);
        scanner.close();

    }

    public static void menuSingleEvent(Event eventSent) {
        if (!Favourites.getFavourites().contains(eventSent))
            STDOUT.info("\n\nThis event is not on your favourites list. Press 1 to add this event to FAVOURITES\n");
        if (Favourites.getFavourites().contains(eventSent))
            STDOUT.info("\n\nThis event is on your favourites list. Press 5 to remove it from your favourites\n");
        STDOUT.info("Press 2 to reserve tickets for this event\n");
        STDOUT.info("Press 3 to go back to the list of all events\n");
        STDOUT.info("Press 4 to go back to main menu\n");

        Scanner scanner = new Scanner(System.in);
        Integer choice = scanner.nextInt();
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
        }
    }

    public static void menuSingleFav(Event eventSent) {

        STDOUT.info("\n\nPress 1 to remove this event from FAVOURITES\n");
        STDOUT.info("Press 2 to reserve tickets for this event\n");
        STDOUT.info("Press 3 to go to the list of all events\n");
        STDOUT.info("Press 4 to go back to main menu\n");

        Scanner scanner = new Scanner(System.in);
        Integer choice = scanner.nextInt();
        while (true) {
            if (choice == 1) {
                favourites.deleteFromFavs(eventSent);
                menuSingleEvent(eventSent);
            } else if (choice == 2) {
                STDOUT.info("Reservation system is in development. Please choose another option\n");
                choice = scanner.nextInt();
            } else if (choice == 3)
                repository.showAllEvents();
            else if (choice == 4)
                start();
        }
    }

    public static void menuAllEvents(Integer eventId) {

        STDOUT.info("\nPress 1 to view event and all details\n");
        STDOUT.info("Press 2 to go back to main menu\n");

        Scanner scanner = new Scanner(System.in);
        Integer choice = scanner.nextInt();
        while (true) {
            if (choice == 1) {
                STDOUT.info("Please input ID of event you want to show\n");
                Integer inputId = scanner.nextInt();
                repository.showSingleEvent(inputId);
            } else if (choice == 2) {
                repository.showAllEvents();
            }
        }
    }
}
