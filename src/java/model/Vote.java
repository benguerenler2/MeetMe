/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author tcagla
 */
@Entity
@Table(name = "vote")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Vote.findAll", query = "SELECT v FROM Vote v"),
    @NamedQuery(name = "Vote.findByUserid", query = "SELECT v FROM Vote v WHERE v.votePK.userid = :userid"),
    @NamedQuery(name = "Vote.findByPollid", query = "SELECT v FROM Vote v WHERE v.votePK.pollid = :pollid"),
    @NamedQuery(name = "Vote.findBySlotid", query = "SELECT v FROM Vote v WHERE v.votePK.slotid = :slotid"),
    @NamedQuery(name = "Vote.findByWeight", query = "SELECT v FROM Vote v WHERE v.votePK.weight = :weight")})
public class Vote implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected VotePK votePK;

    public Vote() {
    }

    public Vote(VotePK votePK) {
        this.votePK = votePK;
    }

    public Vote(int userid, int pollid, int slotid, int weight) {
        this.votePK = new VotePK(userid, pollid, slotid, weight);
    }

    public VotePK getVotePK() {
        return votePK;
    }

    public void setVotePK(VotePK votePK) {
        this.votePK = votePK;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (votePK != null ? votePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Vote)) {
            return false;
        }
        Vote other = (Vote) object;
        if ((this.votePK == null && other.votePK != null) || (this.votePK != null && !this.votePK.equals(other.votePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Vote[ votePK=" + votePK + " ]";
    }
    
}
