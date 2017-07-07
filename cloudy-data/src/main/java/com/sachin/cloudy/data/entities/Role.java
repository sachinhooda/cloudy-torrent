package com.sachin.cloudy.data.entities;

import javax.persistence.*;
import java.util.Collection;
import java.util.Set;

/**
 * Created by sachinhooda on 25/5/17.
 */
@Entity
@Table(name = "ROLES")
public class Role extends AuditableEntity {

    private static final long serialVersionUID = 3823659416701565658L;

    @Column(name = "NAME", nullable = false)
    private String name;

    @Column(name = "DESCRIPTION")
    private String description;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "ROLES_PRIVILEGES", joinColumns = @JoinColumn(name = "ROLE_ID",
            referencedColumnName = "ID"), inverseJoinColumns = @JoinColumn(name = "PRIVILEGE_ID",
            referencedColumnName = "ID"))
    private Collection<Privilege> privileges;

    @ManyToMany(mappedBy = "roles")
    private Set<User> users;

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

    public Collection<Privilege> getPrivileges() {
        return privileges;
    }

    public void setPrivileges(Collection<Privilege> privileges) {
        this.privileges = privileges;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }
}
