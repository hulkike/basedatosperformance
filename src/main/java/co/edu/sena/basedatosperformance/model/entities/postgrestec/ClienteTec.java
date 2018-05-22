/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.basedatosperformance.model.entities.postgrestec;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Enrique
 */
@Entity
@Table(name = "cliente_tec", schema = "tecnica")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ClienteTec.findAll", query = "SELECT c FROM ClienteTec c")
    , @NamedQuery(name = "ClienteTec.findByIdCliente", query = "SELECT c FROM ClienteTec c WHERE c.idCliente = :idCliente")
    , @NamedQuery(name = "ClienteTec.findByNumeroDocumento", query = "SELECT c FROM ClienteTec c WHERE c.numeroDocumento = :numeroDocumento")
    , @NamedQuery(name = "ClienteTec.findByNombre", query = "SELECT c FROM ClienteTec c WHERE c.nombre = :nombre")})
public class ClienteTec implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_cliente", nullable = false)
    private Long idCliente;
    @Column(name = "numero_documento", length = 45)
    private String numeroDocumento;
    @Column(name = "nombre", length = 45)
    private String nombre;
    @JoinColumn(name = "id_tipo_documento", referencedColumnName = "id_tipo_documento")
    @ManyToOne(fetch = FetchType.LAZY)
    private TipoDocumentoTec idTipoDocumento;

    public ClienteTec() {
    }

    public ClienteTec(Long idCliente) {
        this.idCliente = idCliente;
    }

    public Long getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Long idCliente) {
        this.idCliente = idCliente;
    }

    public String getNumeroDocumento() {
        return numeroDocumento;
    }

    public void setNumeroDocumento(String numeroDocumento) {
        this.numeroDocumento = numeroDocumento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public TipoDocumentoTec getIdTipoDocumento() {
        return idTipoDocumento;
    }

    public void setIdTipoDocumento(TipoDocumentoTec idTipoDocumento) {
        this.idTipoDocumento = idTipoDocumento;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCliente != null ? idCliente.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ClienteTec)) {
            return false;
        }
        ClienteTec other = (ClienteTec) object;
        if ((this.idCliente == null && other.idCliente != null) || (this.idCliente != null && !this.idCliente.equals(other.idCliente))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.sena.basedatosperformance.model.entities.postgrestec.ClienteTec[ idCliente=" + idCliente + " ]";
    }
    
}
