package org.jhaughton.dotcross.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "task")
public class TaskEntity {
    private static final long serialVersionUID = -2343243243242432341L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name = "name")
    private String name;
    @Column(name = "description")
    private String description;
    @Column(name = "dateCompleted")
    private Date dateCompleted;

    public TaskEntity(String name, String description, Date dateCompleted) {
        this.name = name;
        this.description = description;
        this.dateCompleted = dateCompleted;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
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
