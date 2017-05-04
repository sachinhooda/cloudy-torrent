package com.sachin.cloudy.data.entities;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Created by sachinhooda on 25/2/17.
 */
@Entity
@Table(name = "TORRENTS_USAGE_STATS")
public class TorrentsUsageStats extends AuditableEntity {
  private static final long serialVersionUID = -4262222758493841733L;

  @ManyToOne
  @JoinColumn(name = "TORRENT_USER")
  private User torrentUser;

  public User getTorrentUser() {
    return torrentUser;
  }

  public void setTorrentUser(User torrentUser) {
    this.torrentUser = torrentUser;
  }
}
