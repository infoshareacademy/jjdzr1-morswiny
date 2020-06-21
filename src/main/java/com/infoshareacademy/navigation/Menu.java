package com.infoshareacademy.navigation;

import com.infoshareacademy.events.EventRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Scanner;

public class Menu {
    private static final Logger STDOUT = LoggerFactory.getLogger("CONSOLE_OUT");

    public static void start(){
        EventRepository repository = new EventRepository();
        repository.arrayToSet();
        EventRepository.clearScreen();
        STDOUT.info("Press 1 to view all events\n");
        STDOUT.info("Press 2 to view favourites\n");
        STDOUT.info("Press 3 to exit\n");

        Scanner scanner = new Scanner(System.in);
        Integer choice = scanner.nextInt();
        if (choice == 1)
            repository.showAllEvents();
        else if (choice == 2)
            STDOUT.info("metoda 2");
        else if (choice == 3)
            System.exit(0);
        scanner.close();

    }

    public static void menuAllEvents(){

        EventRepository eventRepository = new EventRepository();
        STDOUT.info("\n\nPress 1 to go to detailed information about Event\n");
        STDOUT.info("Press 2 to go back to Main Menu\n");

        Scanner scanner = new Scanner(System.in);
        Integer choice = scanner.nextInt();

        while(true){
            if(choice==1){
                STDOUT.info("show single event\n"); //wstepnie
                STDOUT.info("Please insert eventId to receive some more additional information about this particual event: ");
                Integer choiceSingleEvent = scanner.nextInt();
                eventRepository.showSingleEvent(choiceSingleEvent);

            }else if(choice==2){
                start();
            }

        }

    }



    public static void menuSingleEvent() {

        EventRepository repository = new EventRepository();
        STDOUT.info("\n\nPress 1 to add this event to FAVOURITES\n");
        STDOUT.info("Press 2 to reserve tickets for this event\n");
        STDOUT.info("Press 3 to go back to the list of all events\n");
        STDOUT.info("Press 4 to go back to main menu\n");

        Scanner scanner = new Scanner(System.in);
        Integer choice = scanner.nextInt();
            while (true) {
                if (choice == 1){
                    STDOUT.info("add to favourites");
                    break;
                }
                else if (choice == 2) {
                    STDOUT.info("Reservation system is in development. Please choose another option\n");
                    choice = scanner.nextInt();
                } else if (choice == 3)
                    repository.showAllEvents();
                else if (choice == 4)
                    start();
            }
        }


    }
