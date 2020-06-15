package com.infoshareacademy;

import com.infoshareacademy.events.EventRepository;
import com.infoshareacademy.navigation.Menu;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {

//        Menu.start();

        EventRepository asd = new EventRepository();

        asd.arrayToSet();
        asd.getEventSet();
//        System.out.println(asd.getEventSet().toString());

        asd.showAllEvents();
        
    }
}
