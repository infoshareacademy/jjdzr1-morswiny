package com.infoshareacademy.favourites;

import com.infoshareacademy.events.Event;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class Favourites {

    private static final Logger logger = LoggerFactory.getLogger("CONSOLE_OUT");
    static List<Event> favList = new ArrayList<>();

    public static List<Event> getFavourites() {
        return favList;
    }



}
