
package com.bankmisr.warehouse.entity;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author User
 */
@Entity
@Table(name = "location_level_1", catalog = "warehouse", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "LocationLevel1.findAll", query = "SELECT l FROM LocationLevel1 l"),
    @NamedQuery(name = "LocationLevel1.findById", query = "SELECT l FROM LocationLevel1 l WHERE l.id = :id"),
    @NamedQuery(name = "LocationLevel1.findByName", query = "SELECT l FROM LocationLevel1 l WHERE l.name = :name")})
public class LocationLevel1 implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "name")
    private String name;

    public LocationLevel1() {
    }

    public LocationLevel1(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof LocationLevel1)) {
            return false;
        }
        LocationLevel1 other = (LocationLevel1) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.LocationLevel1[ id=" + id + " ]";
    }
    
}
