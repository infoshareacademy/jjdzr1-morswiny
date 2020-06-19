package com.infoshareacademy.events;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Properties;

public class Event {
    private Integer id;
    private Place place;
    private String endDate;
    private String name;
    private EventURL urls;
    private Attachment[] attachments;
    private String descLong;
    private String categoryId;
    private String startDate;
    private Organizer organizer;
    private Integer  active;
    private Ticket tickets;

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
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    public String dateTimeFormatter(String date) {
        Properties prop = readPropertiesFile("credentials.properties");
        String[] dateArray = date.split("T");
        LocalDate eventDate = LocalDate.parse(dateArray[0]);
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern(prop.getProperty("date.format"));
        String eventDate1 = eventDate.format(dtf);
        String eventDateTime = eventDate1 + ", time: " + dateArray[1].substring(0,5);
        return eventDateTime;
    }

    public static Properties readPropertiesFile(String fileName) {
        FileInputStream property = null;
        Properties prop = null;
        try {
            property = new FileInputStream("src/main/resources/config.properties");
            prop = new Properties();
            prop.load(property);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            assert property != null;
            try {
                property.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return prop;
    }
    public String trimDescription(String description){
        String trimmedDesc = description.replace("\r", "");
        trimmedDesc = trimmedDesc.replace("<p>", "");
        trimmedDesc = trimmedDesc.replace("</p>", "");
        trimmedDesc = trimmedDesc.replace("<p1>", "");
        trimmedDesc = trimmedDesc.replace("</p1>", "");
        trimmedDesc = trimmedDesc.replace("<h>", "");
        trimmedDesc = trimmedDesc.replace("</h>", "");
        trimmedDesc = trimmedDesc.replace("<h1>", "");
        trimmedDesc = trimmedDesc.replace("</h1>", "");
        trimmedDesc = trimmedDesc.replace("<h2>", "");
        trimmedDesc = trimmedDesc.replace("</h2>", "");
        trimmedDesc = trimmedDesc.replace("<b>", "");
        trimmedDesc = trimmedDesc.replace("</b>", "");
        trimmedDesc = trimmedDesc.replace("<br>", " ");
        trimmedDesc = trimmedDesc.replace("</br>", "");
        trimmedDesc = trimmedDesc.trim();
        return trimmedDesc;
    }
}
