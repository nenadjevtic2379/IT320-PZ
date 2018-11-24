/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.it320.prz;





import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
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
 *
 * @author Korsn
 */
@ApiModel(value = "Product entity")
@Entity
@Table(name = "proizvod")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Proizvod.findAll", query = "SELECT p FROM Proizvod p")
    , @NamedQuery(name = "Proizvod.findByIdProizvod", query = "SELECT p FROM Proizvod p WHERE p.idProizvod = :idProizvod")
    , @NamedQuery(name = "Proizvod.findByRokupotrebe", query = "SELECT p FROM Proizvod p WHERE p.rokupotrebe = :rokupotrebe")
    , @NamedQuery(name = "Proizvod.findByStanje", query = "SELECT p FROM Proizvod p WHERE p.stanje = :stanje")
    , @NamedQuery(name = "Proizvod.findByMinimum", query = "SELECT p FROM Proizvod p WHERE p.minimum = :minimum")})

public class Proizvod implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_PROIZVOD", nullable = false)
    @ApiModelProperty(notes = "ID product")
    private Integer idProizvod;
    @Lob
    @Column(name = "NAZIV_PROIZVOD", length = 16777215)
    @ApiModelProperty(notes = "product name")
    private String nazivProizvod;
    @Column(name = "ROKUPOTREBE")
    @Temporal(TemporalType.TIMESTAMP)
    @ApiModelProperty(notes = "expiration date")
    private Date rokupotrebe;
    @Column(name = "STANJE")
    @ApiModelProperty(notes = "number of product")
    private Integer stanje;
    @Column(name = "MINIMUM")
    @ApiModelProperty(notes = "minimum")
    private Integer minimum;
    @JoinColumn(name = "ID_PRODAVNICA", referencedColumnName = "ID_PRODAVNICA")
    @ManyToOne
    @ApiModelProperty(notes = "ID of store where product is located")
    private Prodavnica idProdavnica;
    @JoinColumn(name = "ID_USER", referencedColumnName = "ID_USER")
    @ManyToOne
    @ApiModelProperty(notes = "ID of user who added product")
    private User idUser;

    public Proizvod() {
    }

    public Proizvod(Integer idProizvod) {
        this.idProizvod = idProizvod;
    }

    public Integer getIdProizvod() {
        return idProizvod;
    }

    public void setIdProizvod(Integer idProizvod) {
        this.idProizvod = idProizvod;
    }

    public String getNazivProizvod() {
        return nazivProizvod;
    }

    public void setNazivProizvod(String nazivProizvod) {
        this.nazivProizvod = nazivProizvod;
    }

    public Date getRokupotrebe() {
        return rokupotrebe;
    }

    public void setRokupotrebe(Date rokupotrebe) {
        this.rokupotrebe = rokupotrebe;
    }

    public Integer getStanje() {
        return stanje;
    }

    public void setStanje(Integer stanje) {
        this.stanje = stanje;
    }

    public Integer getMinimum() {
        return minimum;
    }

    public void setMinimum(Integer minimum) {
        this.minimum = minimum;
    }

    public Prodavnica getIdProdavnica() {
        return idProdavnica;
    }

    public void setIdProdavnica(Prodavnica idProdavnica) {
        this.idProdavnica = idProdavnica;
    }

    public User getIdUser() {
        return idUser;
    }

    public void setIdUser(User idUser) {
        this.idUser = idUser;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idProizvod != null ? idProizvod.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Proizvod)) {
            return false;
        }
        Proizvod other = (Proizvod) object;
        if ((this.idProizvod == null && other.idProizvod != null) || (this.idProizvod != null && !this.idProizvod.equals(other.idProizvod))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.it320.prz.Proizvod[ idProizvod=" + idProizvod + " ]";
    }
    
}
