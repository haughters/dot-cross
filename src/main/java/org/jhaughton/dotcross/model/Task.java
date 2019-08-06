package org.jhaughton.dotcross.model;

import java.util.Date;

public class Task {

    private long id;
    private String name;
    private String description;
    private Date dateCompleted;

    public Task(long id, String name, String description, Date dateCompleted) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.dateCompleted = dateCompleted;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDateCompleted() {
        return dateCompleted;
    }

    public void setDateCompleted(Date dateCompleted) {
        this.dateCompleted = dateCompleted;
    }
}
