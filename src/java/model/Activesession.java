/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author tcagla
 */
@Entity
@Table(name = "activesession")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Activesession.findAll", query = "SELECT a FROM Activesession a"),
    @NamedQuery(name = "Activesession.findByToken", query = "SELECT a FROM Activesession a WHERE a.token = :token"),
    @NamedQuery(name = "Activesession.findByUserid", query = "SELECT a FROM Activesession a WHERE a.userid = :userid")})
public class Activesession implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 64)
    @Column(name = "token")
    private String token;
    @Basic(optional = false)
    @NotNull
    @Column(name = "userid")
    private int userid;

    public Activesession() {
    }

    public Activesession(String token) {
        this.token = token;
    }

    public Activesession(String token, int userid) {
        this.token = token;
        this.userid = userid;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (token != null ? token.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Activesession)) {
            return false;
        }
        Activesession other = (Activesession) object;
        if ((this.token == null && other.token != null) || (this.token != null && !this.token.equals(other.token))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Activesession[ token=" + token + " ]";
    }
    
}
