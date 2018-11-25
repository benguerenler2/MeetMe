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
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author tcagla
 */
@Entity
@Table(name = "gr8_poll_slot")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Gr8PollSlot.findAll", query = "SELECT g FROM Gr8PollSlot g"),
    @NamedQuery(name = "Gr8PollSlot.findBySlotid", query = "SELECT g FROM Gr8PollSlot g WHERE g.slotid = :slotid"),
    @NamedQuery(name = "Gr8PollSlot.findByPollid", query = "SELECT g FROM Gr8PollSlot g WHERE g.pollid = :pollid"),
    @NamedQuery(name = "Gr8PollSlot.findByStartTime", query = "SELECT g FROM Gr8PollSlot g WHERE g.startTime = :startTime"),
    @NamedQuery(name = "Gr8PollSlot.findByEndTime", query = "SELECT g FROM Gr8PollSlot g WHERE g.endTime = :endTime"),
    @NamedQuery(name = "Gr8PollSlot.findBySlotdate", query = "SELECT g FROM Gr8PollSlot g WHERE g.slotdate = :slotdate")})
public class Gr8PollSlot implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "slotid")
    private Integer slotid;
    @Basic(optional = false)
    @NotNull
    @Column(name = "pollid")
    private int pollid;
    @Column(name = "startTime")
    @Temporal(TemporalType.TIME)
    private Date startTime;
    @Column(name = "endTime")
    @Temporal(TemporalType.TIME)
    private Date endTime;
    @Column(name = "slotdate")
    @Temporal(TemporalType.DATE)
    private Date slotdate;

    public Gr8PollSlot() {
    }

    public Gr8PollSlot(Integer slotid) {
        this.slotid = slotid;
    }

    public Gr8PollSlot(Integer slotid, int pollid) {
        this.slotid = slotid;
        this.pollid = pollid;
    }

    public Integer getSlotid() {
        return slotid;
    }

    public void setSlotid(Integer slotid) {
        this.slotid = slotid;
    }

    public int getPollid() {
        return pollid;
    }

    public void setPollid(int pollid) {
        this.pollid = pollid;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Date getSlotdate() {
        return slotdate;
    }

    public void setSlotdate(Date slotdate) {
        this.slotdate = slotdate;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (slotid != null ? slotid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Gr8PollSlot)) {
            return false;
        }
        Gr8PollSlot other = (Gr8PollSlot) object;
        if ((this.slotid == null && other.slotid != null) || (this.slotid != null && !this.slotid.equals(other.slotid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Gr8PollSlot[ slotid=" + slotid + " ]";
    }
    
}
