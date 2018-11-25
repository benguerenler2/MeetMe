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
@Table(name = "poll_voter")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PollVoter.findAll", query = "SELECT p FROM PollVoter p"),
    @NamedQuery(name = "PollVoter.findByUserid", query = "SELECT p FROM PollVoter p WHERE p.pollVoterPK.userid = :userid"),
    @NamedQuery(name = "PollVoter.findByPollid", query = "SELECT p FROM PollVoter p WHERE p.pollVoterPK.pollid = :pollid")})
public class PollVoter implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PollVoterPK pollVoterPK;

    public PollVoter() {
    }

    public PollVoter(PollVoterPK pollVoterPK) {
        this.pollVoterPK = pollVoterPK;
    }

    public PollVoter(int userid, int pollid) {
        this.pollVoterPK = new PollVoterPK(userid, pollid);
    }

    public PollVoterPK getPollVoterPK() {
        return pollVoterPK;
    }

    public void setPollVoterPK(PollVoterPK pollVoterPK) {
        this.pollVoterPK = pollVoterPK;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pollVoterPK != null ? pollVoterPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PollVoter)) {
            return false;
        }
        PollVoter other = (PollVoter) object;
        if ((this.pollVoterPK == null && other.pollVoterPK != null) || (this.pollVoterPK != null && !this.pollVoterPK.equals(other.pollVoterPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.PollVoter[ pollVoterPK=" + pollVoterPK + " ]";
    }
    
}
