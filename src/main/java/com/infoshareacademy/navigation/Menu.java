package com.infoshareacademy.navigation;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Scanner;

public class Menu {
    private static final Logger STDOUT = LoggerFactory.getLogger("CONSOLE_OUT");

    public static void start(){

        STDOUT.info("Press 1 to view all events\n");
        STDOUT.info("Press 2 to view favourites\n");
        STDOUT.info("Press 3 to exit\n");

        Scanner scanner = new Scanner(System.in);
        Integer choice = scanner.nextInt();
        if (choice == 1)
            STDOUT.info("metoda 1");
        else if (choice == 2)
            STDOUT.info("metoda 2");
        else if (choice == 3)
            System.exit(0);
        scanner.close();

    }

}
