/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author lucas.beltrame
 */
@Entity
@Table(name = "evenement")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Evenement.findAll", query = "SELECT e FROM Evenement e"),
    @NamedQuery(name = "Evenement.findByIdevenement", query = "SELECT e FROM Evenement e WHERE e.idevenement = :idevenement"),
    @NamedQuery(name = "Evenement.findByNom", query = "SELECT e FROM Evenement e WHERE e.nom = :nom"),
    @NamedQuery(name = "Evenement.findByDate", query = "SELECT e FROM Evenement e WHERE e.date = :date")})
public class Evenement implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idevenement")
    private Integer idevenement;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "nom")
    private String nom;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 16777215)
    @Column(name = "description")
    private String description;
    @Basic(optional = false)
    @NotNull
    @Column(name = "date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;

    public Evenement() {
    }

    public Evenement(Integer idevenement) {
        this.idevenement = idevenement;
    }

    public Evenement(Integer idevenement, String nom, String description, Date date) {
        this.idevenement = idevenement;
        this.nom = nom;
        this.description = description;
        this.date = date;
    }

    public Integer getIdevenement() {
        return idevenement;
    }

    public void setIdevenement(Integer idevenement) {
        this.idevenement = idevenement;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idevenement != null ? idevenement.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Evenement)) {
            return false;
        }
        Evenement other = (Evenement) object;
        if ((this.idevenement == null && other.idevenement != null) || (this.idevenement != null && !this.idevenement.equals(other.idevenement))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Evenement[ idevenement=" + idevenement + " ]";
    }
    
}
