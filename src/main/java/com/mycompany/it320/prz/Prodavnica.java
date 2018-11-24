/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.it320.prz;






import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Collection;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Korsn
 */
@ApiModel(value = "Store entity")
@Entity
@Table(name = "prodavnica")
@XmlRootElement

@NamedQueries({
    @NamedQuery(name = "Prodavnica.findAll", query = "SELECT p FROM Prodavnica p")
    , @NamedQuery(name = "Prodavnica.findByIdProdavnica", query = "SELECT p FROM Prodavnica p WHERE p.idProdavnica = :idProdavnica")})


public class Prodavnica implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_PRODAVNICA", nullable = false)
    @ApiModelProperty(notes = "ID store")
    private Integer idProdavnica;
    @Lob
    @Column(name = "NAZIV_PRODAVNICA", length =16777215 )
     @ApiModelProperty(notes = "store name", required = true)
    private String nazivProdavnica;
    @JoinColumn(name = "ID_USER", referencedColumnName = "ID_USER")
    @ManyToOne
     @ApiModelProperty(notes = "ID of worker in store", required = true)
    private User idUser;
  /*  @OneToMany(mappedBy = "idProdavnica")
    @ApiModelProperty(notes = "Kolekcija proizvoda")
    private Collection<Proizvod> proizvodCollection;*/

    public Prodavnica() {
    }

    public Prodavnica(Integer idProdavnica) {
        this.idProdavnica = idProdavnica;
    }

    public Integer getIdProdavnica() {
        return idProdavnica;
    }

    public void setIdProdavnica(Integer idProdavnica) {
        this.idProdavnica = idProdavnica;
    }

    public String getNazivProdavnica() {
        return nazivProdavnica;
    }

    public void setNazivProdavnica(String nazivProdavnica) {
        this.nazivProdavnica = nazivProdavnica;
    }

    public User getIdUser() {
        return idUser;
    }

    public void setIdUser(User idUser) {
        this.idUser = idUser;
    }
/*
    @XmlTransient
    public Collection<Proizvod> getProizvodCollection() {
        return proizvodCollection;
    }

    public void setProizvodCollection(Collection<Proizvod> proizvodCollection) {
        this.proizvodCollection = proizvodCollection;
    }
*/
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idProdavnica != null ? idProdavnica.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Prodavnica)) {
            return false;
        }
        Prodavnica other = (Prodavnica) object;
        if ((this.idProdavnica == null && other.idProdavnica != null) || (this.idProdavnica != null && !this.idProdavnica.equals(other.idProdavnica))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.it320.prz.Prodavnica[ idProdavnica=" + idProdavnica + " ]";
    }
    
}
