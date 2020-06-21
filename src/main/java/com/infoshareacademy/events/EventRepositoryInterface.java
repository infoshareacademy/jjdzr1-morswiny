package com.infoshareacademy.events;

import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public interface EventRepositoryInterface {

    //wyswietlanie
    //CRUD?
    //wez parametr z gson events i skonweruj na lioste eventow <--setter(par=gson events) return hashset;
    //1 metoda wyszukujaca ktora przyjmuje inne <<--

    // CRUD
    //create new event
    boolean createEvent(Event event);

    //delete existing event
    boolean deleteEvent(Integer eventId) throws IOException;

    //update event by id
    boolean updateEventById(Integer eventId);


    //Metoda konwertujaca evewnty na hash
    HashSet<Event> convertEvents(Event[] events);

    //zwroc all events  <--Mateusz
    void showAllEvents() throws IOException;

    //zwroc pojedyczny el.  <--Kuba
    void showSingleEvent(Integer eventId) throws IOException;

    //wyszukiwanie String
    List<Event> searchByString(String name);

    //wyszukiwanie int
    List<Event> searchByInteger(Integer name);

    //wyszukiwanie po dacie

    //wyszukiwanie po organizatorze
    List <Event> searchByOrganizer (String organizer);

    //wyszukiwanie po miejscu
    List<Event> searchByPlace (String place);

    //wyszukiwanie aktywnych/nieaktywnych eventow
    List<Event> searchActive (Integer active);

    //filtrowanie eventow po nazwie == sortowanie
    List<Event> filterEvents();



}
