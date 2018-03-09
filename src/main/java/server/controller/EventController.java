package server.controller;

import server.dbmanager.DbManager;
import server.models.Event;
import server.models.Quiz;

public class EventController {

    public EventController() {

    }

    public Event createEvent(Event event) {
        DbManager dbManager = new DbManager();
        Event createdEvent = dbManager.createEvent(event);
        if (createdEvent != null) {
            return createdEvent;
        } else {
            return null;
        }
    }




}
