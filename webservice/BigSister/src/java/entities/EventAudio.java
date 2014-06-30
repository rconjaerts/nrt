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
import javax.xml.bind.annotation.XmlRootElement;
import namedqueries.event;

/**
 *
 * @author Niels
 */
@Entity
@Table(name = "event_audio")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EventAudio.findAll", 
        query = "SELECT e FROM EventAudio e"),
    @NamedQuery(name = "EventAudio.findById", 
        query = "SELECT e FROM EventAudio e WHERE e.id = :id"),
    @NamedQuery(name = "EventAudio.findByAccountId", 
        query = "SELECT e FROM EventAudio e WHERE e.accountId = :accountId"),
    @NamedQuery(name = "EventAudio.findByValue", 
        query = "SELECT e FROM EventAudio e WHERE e.value = :value"),
    @NamedQuery(name = "EventAudio.liveDataByAccountAndLastTimeStamp",
        query = event.LIVE_DATA_BY_ACCOUNT_AND_LAST_TIMESTAMP)})  
//@NamedQuery(name = "EventAudio.liveDataByAccountId", query = "SELECT e FROM EventAudio e WHERE e.accountId = :accountId AND e.timestamp = (SELECT MAX(e.timestamp) FROM EventAudio e)"),
public class EventAudio implements Serializable {
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

    public EventAudio() {
    }

    public EventAudio(Integer id) {
        this.id = id;
    }

    public EventAudio(Integer id, int accountId, float value) {
        this.id = id;
        this.accountId = accountId;
        this.value = value;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EventAudio)) {
            return false;
        }
        EventAudio other = (EventAudio) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.EventAudio[ id=" + id + " ]";
    }
    
}
