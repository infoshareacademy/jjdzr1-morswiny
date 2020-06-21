package com.infoshareacademy.events;

public class EventURL {
    private String www;
    private String tickets;

    public EventURL(String www, String tickets) {
        this.www = www;
        this.tickets = tickets;
    }

    @Override
    public String toString() {
        return "EventURL " +
                "www = " + www +
                ", tickets = " + tickets;
    }

    public String getWww() {
        return www;
    }

    public void setWww(String www) {
        this.www = www;
    }

    public String getTickets() {
        return tickets;
    }

    public void setTickets(String tickets) {
        this.tickets = tickets;
    }
}
