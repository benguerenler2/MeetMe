/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author tcagla
 */
@Entity
@Table(name = "gr8_poll")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Gr8Poll.findAll", query = "SELECT g FROM Gr8Poll g"),
    @NamedQuery(name = "Gr8Poll.findByPollid", query = "SELECT g FROM Gr8Poll g WHERE g.pollid = :pollid"),
    @NamedQuery(name = "Gr8Poll.findByUserid", query = "SELECT g FROM Gr8Poll g WHERE g.userid = :userid"),
    @NamedQuery(name = "Gr8Poll.findByEventName", query = "SELECT g FROM Gr8Poll g WHERE g.eventName = :eventName"),
    @NamedQuery(name = "Gr8Poll.findByEventDescription", query = "SELECT g FROM Gr8Poll g WHERE g.eventDescription = :eventDescription"),
    @NamedQuery(name = "Gr8Poll.findByTs", query = "SELECT g FROM Gr8Poll g WHERE g.ts = :ts")})
public class Gr8Poll implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pollid")
    private Integer pollid;
    @Basic(optional = false)
    @NotNull
    @Column(name = "userid")
    private int userid;
    @Size(max = 100)
    @Column(name = "eventName")
    private String eventName;
    @Size(max = 500)
    @Column(name = "eventDescription")
    private String eventDescription;
    @Basic(optional = false)
    @Column(name = "ts", columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    @Temporal(TemporalType.TIMESTAMP)
    private Date ts;

    public Gr8Poll() {
    }

    public Gr8Poll(Integer pollid) {
        this.pollid = pollid;
    }

    public Gr8Poll(Integer pollid, int userid) {
        this.pollid = pollid;
        this.userid = userid;
    }

    public Integer getPollid() {
        return pollid;
    }

    public void setPollid(Integer pollid) {
        this.pollid = pollid;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public String getEventDescription() {
        return eventDescription;
    }

    public void setEventDescription(String eventDescription) {
        this.eventDescription = eventDescription;
    }

    public Date getTs() {
        return ts;
    }

    public void setTs(Date ts) {
        this.ts = ts;
    }
    
    @PrePersist
    private void setPersistDefaultDate(){
        this.ts = new Date();
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pollid != null ? pollid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Gr8Poll)) {
            return false;
        }
        Gr8Poll other = (Gr8Poll) object;
        if ((this.pollid == null && other.pollid != null) || (this.pollid != null && !this.pollid.equals(other.pollid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Gr8Poll[ pollid=" + pollid + " ]";
    }
    
}
