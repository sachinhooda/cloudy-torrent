package com.sachin.cloudy.data.entities;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * Created by sachinhooda on 25/2/17.
 */
@Entity
@Table(name = "DATA_USAGE_STATS")
public class DataUsageStats extends AuditableEntity {
    private static final long serialVersionUID = -7541990702159953002L;

    @OneToOne(mappedBy = "dataUsageStats")
    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
