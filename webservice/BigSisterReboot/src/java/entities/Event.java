/*
 * Group NRT
 * Hackiothon
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

/**
 *
 * @author Niels
 */
@Entity
@Table(name = "event")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Event.findAll", query = "SELECT e FROM Event e"),
    @NamedQuery(name = "Event.findById", query = "SELECT e FROM Event e WHERE e.id = :id"),
    @NamedQuery(name = "Event.findByAccountId", query = "SELECT e FROM Event e WHERE e.accountId = :accountId"),
    @NamedQuery(name = "Event.findByValue", query = "SELECT e FROM Event e WHERE e.value = :value"),
    @NamedQuery(name = "Event.findByTimestamp", query = "SELECT e FROM Event e WHERE e.timestamp = :timestamp"),
    @NamedQuery(name = "Event.findByTypeId", query = "SELECT e FROM Event e WHERE e.typeId = :typeId"),
    @NamedQuery(name = "Event.historyDataByAccountFromTo", 
        query = "SELECT e FROM Event e WHERE e.accountId = :accountId AND e.typeId = :typeId AND e.timestamp BETWEEN :from AND :to ORDER BY e.timestamp ASC"),
    @NamedQuery(name = "Event.sleepComfort", 
        query = "SELECT e FROM Event e WHERE e.accountId = :accountId AND e.typeId = :typeId AND e.timestamp BETWEEN :from AND :to ORDER BY e.timestamp ASC"),
    @NamedQuery(name = "Event.sleepComfortActivityCount", 
        query = "SELECT COUNT(e) FROM Event e WHERE e.accountId = :accountId AND e.typeId = :typeId AND e.timestamp BETWEEN :from AND :to"),
    @NamedQuery(name = "Event.liveDataByAccountAndLastTimeStamp",
        query = "SELECT e from Event e WHERE e.accountId = :accountId AND e.typeId = :typeId AND e.timestamp > :timestamp ORDER BY e.timestamp ASC")})
public class Event implements Serializable {
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
    @Basic(optional = false)
    @NotNull
    @Column(name = "type_id")
    private int typeId;

    public Event() {
    }

    public Event(Integer id) {
        this.id = id;
    }

    public Event(Integer id, int accountId, float value, int timestamp, int typeId) {
        this.id = id;
        this.accountId = accountId;
        this.value = value;
        this.timestamp = timestamp;
        this.typeId = typeId;
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

    public int getTypeId() {
        return typeId;
    }

    public void setTypeId(int typeId) {
        this.typeId = typeId;
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
        if (!(object instanceof Event)) {
            return false;
        }
        Event other = (Event) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Event[ id=" + id + " ]";
    }
    
}
