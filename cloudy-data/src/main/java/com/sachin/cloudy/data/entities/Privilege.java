package com.sachin.cloudy.data.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by sachinhooda on 6/6/17.
 */
@Entity
@Table(name = "PRIVILEGES")
public class Privilege extends AuditableEntity{


    private static final long serialVersionUID = -2705918250155223065L;
    @Column(name = "NAME", nullable = false)
    private String name;

    @Column(name = "DESCRIPTION", nullable = true)
    private String description;

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
}
