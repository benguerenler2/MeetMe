/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author tcagla
 */
@Embeddable
public class VotePK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "userid")
    private int userid;
    @Basic(optional = false)
    @NotNull
    @Column(name = "pollid")
    private int pollid;
    @Basic(optional = false)
    @NotNull
    @Column(name = "slotid")
    private int slotid;
    @Basic(optional = false)
    @NotNull
    @Column(name = "weight")
    private int weight;

    public VotePK() {
    }

    public VotePK(int userid, int pollid, int slotid, int weight) {
        this.userid = userid;
        this.pollid = pollid;
        this.slotid = slotid;
        this.weight = weight;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public int getPollid() {
        return pollid;
    }

    public void setPollid(int pollid) {
        this.pollid = pollid;
    }

    public int getSlotid() {
        return slotid;
    }

    public void setSlotid(int slotid) {
        this.slotid = slotid;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) userid;
        hash += (int) pollid;
        hash += (int) slotid;
        hash += (int) weight;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof VotePK)) {
            return false;
        }
        VotePK other = (VotePK) object;
        if (this.userid != other.userid) {
            return false;
        }
        if (this.pollid != other.pollid) {
            return false;
        }
        if (this.slotid != other.slotid) {
            return false;
        }
        if (this.weight != other.weight) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.VotePK[ userid=" + userid + ", pollid=" + pollid + ", slotid=" + slotid + ", weight=" + weight + " ]";
    }
    
}
