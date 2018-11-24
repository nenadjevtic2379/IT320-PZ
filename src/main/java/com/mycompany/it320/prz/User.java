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

@ApiModel(value = "User entity")
@Entity
@Table(name = "user")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "User.findAll", query = "SELECT u FROM User u")
    , @NamedQuery(name = "User.findByIdUser", query = "SELECT u FROM User u WHERE u.idUser = :idUser")})

public class User implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_USER", nullable = false)
    @ApiModelProperty(notes = "ID user")
    private Integer idUser;
    @Lob
    @Column(name = "IME", length = 16777215)
    @ApiModelProperty(notes = "Name user")
    private String ime;
    @Lob
    @Column(name = "PREZIME", length = 16777215)
    @ApiModelProperty(notes = "Last name user")
    private String prezime;
    @Lob
    @Column(name = "USERNAME", length = 16777215)
    @ApiModelProperty(notes = "username")
    private String username;
    @Lob
    @Column(name = "PASSWORD", length = 16777215)
    @ApiModelProperty(notes = "password")
    private String password;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Lob
    @Column(name = "EMAIL", length = 16777215)
    @ApiModelProperty(notes = "email")
    private String email;
 /*   @OneToMany(mappedBy = "idUser")
    @ApiModelProperty(notes = "The database generated product ID")
    private Collection<Prodavnica> prodavnicaCollection;
    @OneToMany(mappedBy = "idUser")
    @ApiModelProperty(notes = "The database generated product ID")
    private Collection<Proizvod> proizvodCollection;
    @OneToMany(mappedBy = "useIdUser")
    @ApiModelProperty(notes = "The database generated product ID")
    private Collection<User> userCollection; */
    @JoinColumn(name = "USE_ID_USER", referencedColumnName = "ID_USER")
    @ManyToOne
    @ApiModelProperty(notes = "ID of user who added worker")
    private User useIdUser;
    @JoinColumn(name = "ID_ROLE", referencedColumnName = "ID_ROLE")
    @ManyToOne
    @ApiModelProperty(notes = "ID role")
    private Userrole idRole;

    public User() {
    }

    public User(Integer idUser) {
        this.idUser = idUser;
    }

    public Integer getIdUser() {
        return idUser;
    }

    public void setIdUser(Integer idUser) {
        this.idUser = idUser;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
/*
    @XmlTransient
    public Collection<Prodavnica> getProdavnicaCollection() {
        return prodavnicaCollection;
    }

    public void setProdavnicaCollection(Collection<Prodavnica> prodavnicaCollection) {
        this.prodavnicaCollection = prodavnicaCollection;
    }

    @XmlTransient
    public Collection<Proizvod> getProizvodCollection() {
        return proizvodCollection;
    }

    public void setProizvodCollection(Collection<Proizvod> proizvodCollection) {
        this.proizvodCollection = proizvodCollection;
    }

    @XmlTransient
    public Collection<User> getUserCollection() {
        return userCollection;
    }

    public void setUserCollection(Collection<User> userCollection) {
        this.userCollection = userCollection;
    }
*/
    public User getUseIdUser() {
        return useIdUser;
    }

    public void setUseIdUser(User useIdUser) {
        this.useIdUser = useIdUser;
    }

    public Userrole getIdRole() {
        return idRole;
    }

    public void setIdRole(Userrole idRole) {
        this.idRole = idRole;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idUser != null ? idUser.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof User)) {
            return false;
        }
        User other = (User) object;
        if ((this.idUser == null && other.idUser != null) || (this.idUser != null && !this.idUser.equals(other.idUser))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.it320.prz.User[ idUser=" + idUser + " ]";
    }
    
}
