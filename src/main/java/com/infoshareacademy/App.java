package com.infoshareacademy;

import com.infoshareacademy.events.Event;
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

        //Menu.start();


        EventRepository asd = new EventRepository();
        //Event event = new Event();
        //event.dateTimeFormatter("2020-06-16T23:00:00+0200");
       asd.arrayToSet();
       //asd.showAllEvents();
        // asd.showSingleEvent(71890);


//        System.out.println(asd.getEventSet().toString());


        
    }
}
