/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author lucas.beltrame
 */
@Entity
@Table(name = "membres")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Membres.findAll", query = "SELECT m FROM Membres m"),
    @NamedQuery(name = "Membres.findByIdmembres", query = "SELECT m FROM Membres m WHERE m.idmembres = :idmembres"),
    @NamedQuery(name = "Membres.findByNom", query = "SELECT m FROM Membres m WHERE m.nom = :nom"),
    @NamedQuery(name = "Membres.findByPrenom", query = "SELECT m FROM Membres m WHERE m.prenom = :prenom"),
    @NamedQuery(name = "Membres.findByDerniereCoti", query = "SELECT m FROM Membres m WHERE m.derniereCoti = :derniereCoti")})
public class Membres implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idmembres")
    private Integer idmembres;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "nom")
    private String nom;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "prenom")
    private String prenom;
    @Column(name = "derniereCoti")
    private Integer derniereCoti;
    @JoinColumn(name = "statut", referencedColumnName = "idstatut")
    @ManyToOne(optional = false)
    private Statut statut;

    public Membres() {
    }

    public Membres(Integer idmembres) {
        this.idmembres = idmembres;
    }

    public Membres(Integer idmembres, String nom, String prenom) {
        this.idmembres = idmembres;
        this.nom = nom;
        this.prenom = prenom;
    }

    public Integer getIdmembres() {
        return idmembres;
    }

    public void setIdmembres(Integer idmembres) {
        this.idmembres = idmembres;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public Integer getDerniereCoti() {
        return derniereCoti;
    }

    public void setDerniereCoti(Integer derniereCoti) {
        this.derniereCoti = derniereCoti;
    }

    public Statut getStatut() {
        return statut;
    }

    public void setStatut(Statut statut) {
        this.statut = statut;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idmembres != null ? idmembres.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Membres)) {
            return false;
        }
        Membres other = (Membres) object;
        if ((this.idmembres == null && other.idmembres != null) || (this.idmembres != null && !this.idmembres.equals(other.idmembres))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Membres[ idmembres=" + idmembres + " ]";
    }
    
}
