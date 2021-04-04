package com.example.leaguessoccer.database.entity;

import java.io.Serializable;
import java.util.List;

public class ResponseEvents implements Serializable {
    private List<Event> events = null;

    public List<Event> getResults() {
        return events;
    }
    public void setResults(List<Event> events) {
        this.events = events;
    }
}
