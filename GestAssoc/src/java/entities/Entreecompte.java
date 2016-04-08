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
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author lucas.beltrame
 */
@Entity
@Table(name = "entreecompte")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Entreecompte.findAll", query = "SELECT e FROM Entreecompte e"),
    @NamedQuery(name = "Entreecompte.findByIdentreeCompte", query = "SELECT e FROM Entreecompte e WHERE e.identreeCompte = :identreeCompte"),
    @NamedQuery(name = "Entreecompte.findByDate", query = "SELECT e FROM Entreecompte e WHERE e.date = :date"),
    @NamedQuery(name = "Entreecompte.findByMontant", query = "SELECT e FROM Entreecompte e WHERE e.montant = :montant")})
public class Entreecompte implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "identreeCompte")
    private Integer identreeCompte;
    @Basic(optional = false)
    @NotNull
    @Column(name = "date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 16777215)
    @Column(name = "description")
    private String description;
    @Basic(optional = false)
    @NotNull
    @Column(name = "montant")
    private float montant;
    @JoinColumn(name = "compte", referencedColumnName = "idcompte")
    @ManyToOne
    private Compte compte;

    public Entreecompte() {
    }

    public Entreecompte(Integer identreeCompte) {
        this.identreeCompte = identreeCompte;
    }

    public Entreecompte(Integer identreeCompte, Date date, String description, float montant) {
        this.identreeCompte = identreeCompte;
        this.date = date;
        this.description = description;
        this.montant = montant;
    }

    public Integer getIdentreeCompte() {
        return identreeCompte;
    }

    public void setIdentreeCompte(Integer identreeCompte) {
        this.identreeCompte = identreeCompte;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public float getMontant() {
        return montant;
    }

    public void setMontant(float montant) {
        this.montant = montant;
    }

    public Compte getCompte() {
        return compte;
    }

    public void setCompte(Compte compte) {
        this.compte = compte;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (identreeCompte != null ? identreeCompte.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Entreecompte)) {
            return false;
        }
        Entreecompte other = (Entreecompte) object;
        if ((this.identreeCompte == null && other.identreeCompte != null) || (this.identreeCompte != null && !this.identreeCompte.equals(other.identreeCompte))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Entreecompte[ identreeCompte=" + identreeCompte + " ]";
    }
    
}
