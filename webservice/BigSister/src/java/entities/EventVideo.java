/*
 * Team NRT
 * Niels Delestinne
 * Robrecht Conjaerts
 * Tom Jaspers
 */
package entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import namedqueries.event;

/**
 *
 * @author Niels
 */
@Entity
@Table(name = "event_video")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EventVideo.findAll", 
        query = "SELECT e FROM EventVideo e"),
    @NamedQuery(name = "EventVideo.findById", 
        query = "SELECT e FROM EventVideo e WHERE e.id = :id"),
    @NamedQuery(name = "EventVideo.findByAccountId", 
        query = "SELECT e FROM EventVideo e WHERE e.accountId = :accountId"),
    @NamedQuery(name = "EventVideo.findByValue", 
        query = "SELECT e FROM EventVideo e WHERE e.value = :value"),
    @NamedQuery(name = "EventVideo.findByTimestamp", 
        query = "SELECT e FROM EventVideo e WHERE e.timestamp = :timestamp"),
    @NamedQuery(name = "EventVideo.findByFilename", 
        query = "SELECT e FROM EventVideo e WHERE e.filename = :filename"),
    @NamedQuery(name = "EventVideo.liveDataByAccountAndLastTimeStamp",
        query = event.LIVE_DATA_BY_ACCOUNT_AND_LAST_TIMESTAMP)})
public class EventVideo implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "account_id")
    private int accountId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "value")
    private float value;
    @Basic(optional = false)
    @NotNull
    @Column(name = "timestamp")
    private int timestamp;
    @Size(max = 255)
    @Column(name = "filename")
    private String filename;

    public EventVideo() {
    }

    public EventVideo(Integer id) {
        this.id = id;
    }

    public EventVideo(Integer id, int accountId, float value, int timestamp) {
        this.id = id;
        this.accountId = accountId;
        this.value = value;
        this.timestamp = timestamp;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public float getValue() {
        return value;
    }

    public void setValue(float value) {
        this.value = value;
    }

    public int getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(int timestamp) {
        this.timestamp = timestamp;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EventVideo)) {
            return false;
        }
        EventVideo other = (EventVideo) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.EventVideo[ id=" + id + " ]";
    }
    
}
