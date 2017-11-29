/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package duoc.entidades;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author devsamsung
 */
@Entity
@Table(name = "tickets")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tickets.findAll", query = "SELECT t FROM Tickets t"),
    @NamedQuery(name = "Tickets.findById", query = "SELECT t FROM Tickets t WHERE t.id = :id"),
    @NamedQuery(name = "Tickets.findByPagado", query = "SELECT t FROM Tickets t WHERE t.pagado = :pagado"),
    @NamedQuery(name = "Tickets.findByCreateAt", query = "SELECT t FROM Tickets t WHERE t.createAt = :createAt")})
public class Tickets implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "pagado")
    private Short pagado;
    @Column(name = "create_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createAt;
    @JoinColumn(name = "estacionamiento_id", referencedColumnName = "id")
    @ManyToOne
    private Estacionamientos estacionamientoId;
    @JoinColumn(name = "envio_id", referencedColumnName = "id")
    @ManyToOne
    private OpcionesEnvios envioId;
    @JoinColumn(name = "usuario_id", referencedColumnName = "id")
    @ManyToOne
    private Usuarios usuarioId;
    @JoinColumn(name = "metodo_id", referencedColumnName = "id")
    @ManyToOne
    private MetodosPagos metodoId;

    public Tickets() {
    }

    public Tickets(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Short getPagado() {
        return pagado;
    }

    public void setPagado(Short pagado) {
        this.pagado = pagado;
    }

    public Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }

    public Estacionamientos getEstacionamientoId() {
        return estacionamientoId;
    }

    public void setEstacionamientoId(Estacionamientos estacionamientoId) {
        this.estacionamientoId = estacionamientoId;
    }

    public OpcionesEnvios getEnvioId() {
        return envioId;
    }

    public void setEnvioId(OpcionesEnvios envioId) {
        this.envioId = envioId;
    }

    public Usuarios getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Usuarios usuarioId) {
        this.usuarioId = usuarioId;
    }

    public MetodosPagos getMetodoId() {
        return metodoId;
    }

    public void setMetodoId(MetodosPagos metodoId) {
        this.metodoId = metodoId;
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
        if (!(object instanceof Tickets)) {
            return false;
        }
        Tickets other = (Tickets) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "duoc.entidades.Tickets[ id=" + id + " ]";
    }
    
}
