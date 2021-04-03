package com.example.leaguessoccer.database.entity;

import java.io.Serializable;
import java.util.List;

public class ResponseEvents implements Serializable {
    private List<Event> results = null;

    public List<Event> getResults() {
        return results;
    }
    public void setResults(List<Event> results) {
        this.results = results;
    }
}
