/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.duoc.motivacionSport.Entidades;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author samm
 */
@Entity
@Table(name = "gclass_horarios")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GclassHorarios.findAll", query = "SELECT g FROM GclassHorarios g"),
    @NamedQuery(name = "GclassHorarios.findById", query = "SELECT g FROM GclassHorarios g WHERE g.id = :id"),
    @NamedQuery(name = "GclassHorarios.findByNameHorario", query = "SELECT g FROM GclassHorarios g WHERE g.nameHorario = :nameHorario"),
    @NamedQuery(name = "GclassHorarios.findByCreateAt", query = "SELECT g FROM GclassHorarios g WHERE g.createAt = :createAt"),
    @NamedQuery(name = "GclassHorarios.findByUpdateAt", query = "SELECT g FROM GclassHorarios g WHERE g.updateAt = :updateAt"),
    @NamedQuery(name = "GclassHorarios.findByActive", query = "SELECT g FROM GclassHorarios g WHERE g.active = :active")})
public class GclassHorarios implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 50)
    @Column(name = "name_horario")
    private String nameHorario;
    @Column(name = "create_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createAt;
    @Column(name = "update_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updateAt;
    @Column(name = "active")
    private Short active;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "horarioIdIn")
    private List<GclassClass> gclassClassList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "horarioIdOut")
    private List<GclassClass> gclassClassList1;

    public GclassHorarios() {
    }

    public GclassHorarios(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNameHorario() {
        return nameHorario;
    }

    public void setNameHorario(String nameHorario) {
        this.nameHorario = nameHorario;
    }

    public Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }

    public Date getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(Date updateAt) {
        this.updateAt = updateAt;
    }

    public Short getActive() {
        return active;
    }

    public void setActive(Short active) {
        this.active = active;
    }

    @XmlTransient
    public List<GclassClass> getGclassClassList() {
        return gclassClassList;
    }

    public void setGclassClassList(List<GclassClass> gclassClassList) {
        this.gclassClassList = gclassClassList;
    }

    @XmlTransient
    public List<GclassClass> getGclassClassList1() {
        return gclassClassList1;
    }

    public void setGclassClassList1(List<GclassClass> gclassClassList1) {
        this.gclassClassList1 = gclassClassList1;
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
        if (!(object instanceof GclassHorarios)) {
            return false;
        }
        GclassHorarios other = (GclassHorarios) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cl.duoc.motivacionSport.Entidades.GclassHorarios[ id=" + id + " ]";
    }
    
}
