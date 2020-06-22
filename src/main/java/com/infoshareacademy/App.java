package com.infoshareacademy;

import com.infoshareacademy.events.EventRepository;
import com.infoshareacademy.navigation.Menu;
import java.io.IOException;


public class App 
{
    public static void main( String[] args ) throws IOException {

        //Menu.programStart();
        EventRepository eR = new EventRepository();
        Menu menu = new Menu();
        menu.menuSearchEvents(eR);
        
    }
}
