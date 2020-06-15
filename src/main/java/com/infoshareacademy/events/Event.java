package com.infoshareacademy.events;

import java.util.Arrays;

public class Event {

    String id;
    Place place;
    String endDate;
    String name;
    EventURL urls;
    Attachment[] attachments;
    String descLong;
    String categoryId;
    String startDate;
    Organizer organizer;
    Integer active; //0 v 1

    @Override
    public String toString() {
        return "Event{" + '\n'+
                "id='" + id + '\n' +
                "place=" + place +
                "endDate='" + endDate + '\n' +
                "name='" + name + '\n' +
                "urls=" + urls +
                "attachments=" + Arrays.toString(attachments) + '\n' +
                "categoryId='" + categoryId + '\n' +
                "startDate='" + startDate + '\n' +
                "organizer=" + organizer + '\n' +
                "active=" + active + '\n' +
                "tickets=" + tickets + '\n' +
                '}';
    }

    Ticket tickets;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Place getPlace() {
        return place;
    }

    public void setPlace(Place place) {
        this.place = place;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public EventURL getUrls() {
        return urls;
    }

    public void setUrls(EventURL urls) {
        this.urls = urls;
    }

    public Attachment[] getAttachments() {
        return attachments;
    }

    public void setAttachments(Attachment[] attachments) {
        this.attachments = attachments;
    }

    public String getDescLong() {
        return descLong;
    }

    public void setDescLong(String descLong) {
        this.descLong = descLong;
    }

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public Organizer getOrganizer() {
        return organizer;
    }

    public void setOrganizer(Organizer organizer) {
        this.organizer = organizer;
    }

    public Integer getActive() {
        return active;
    }

    public void setActive(Integer active) {
        this.active = active;
    }

    public Ticket getTickets() {
        return tickets;
    }

    public void setTickets(Ticket tickets) {
        this.tickets = tickets;
    }
}
