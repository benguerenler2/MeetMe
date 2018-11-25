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
public class PollVoterPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "userid")
    private int userid;
    @Basic(optional = false)
    @NotNull
    @Column(name = "pollid")
    private int pollid;

    public PollVoterPK() {
    }

    public PollVoterPK(int userid, int pollid) {
        this.userid = userid;
        this.pollid = pollid;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) userid;
        hash += (int) pollid;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PollVoterPK)) {
            return false;
        }
        PollVoterPK other = (PollVoterPK) object;
        if (this.userid != other.userid) {
            return false;
        }
        if (this.pollid != other.pollid) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.PollVoterPK[ userid=" + userid + ", pollid=" + pollid + " ]";
    }
    
}
