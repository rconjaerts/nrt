/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
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

/**
 *
 * @author Niels
 */
@Entity
@Table(name = "snapshot")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Snapshot.findAll", query = "SELECT s FROM Snapshot s"),
    @NamedQuery(name = "Snapshot.findById", query = "SELECT s FROM Snapshot s WHERE s.id = :id"),
    @NamedQuery(name = "Snapshot.findByAccountId", query = "SELECT s FROM Snapshot s WHERE s.accountId = :accountId"),
    @NamedQuery(name = "Snapshot.findByFilename", query = "SELECT s FROM Snapshot s WHERE s.filename = :filename")})
public class Snapshot implements Serializable {
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
    @Size(min = 1, max = 255)
    @Column(name = "filename")
    private String filename;

    public Snapshot() {
    }

    public Snapshot(Integer id) {
        this.id = id;
    }

    public Snapshot(Integer id, int accountId, String filename) {
        this.id = id;
        this.accountId = accountId;
        this.filename = filename;
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
        if (!(object instanceof Snapshot)) {
            return false;
        }
        Snapshot other = (Snapshot) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Snapshot[ id=" + id + " ]";
    }
    
}
