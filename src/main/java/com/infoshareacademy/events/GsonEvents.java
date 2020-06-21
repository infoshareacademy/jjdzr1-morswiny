package com.infoshareacademy.events;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileReader;

public class GsonEvents {
    private static final Logger STDOUT = LoggerFactory.getLogger("CONSOLE_OUT");

    Event[] eventArray;

    public Event[] getJsonEventData(String filePath) {

        Gson gson = new Gson();
        JsonReader jsonReader = null;
        try {
            jsonReader = new JsonReader(new FileReader(filePath));
        } catch (Exception e) {
            STDOUT.error("Plik nie moze byc znaleziony lub nie jest w formacie JSON. Upewnij sie, ze podales wlasciwe dane.");
        }
        Event[] gsonEvents = gson.fromJson(jsonReader, Event[].class);
        return gsonEvents;
    }

}
