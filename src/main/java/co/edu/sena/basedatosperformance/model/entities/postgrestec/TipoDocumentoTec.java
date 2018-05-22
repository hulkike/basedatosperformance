/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.basedatosperformance.model.entities.postgrestec;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Enrique
 */
@Entity
@Table(name = "tipo_documento_tec", schema = "tecnica")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoDocumentoTec.findAll", query = "SELECT t FROM TipoDocumentoTec t")
    , @NamedQuery(name = "TipoDocumentoTec.findByIdTipoDocumento", query = "SELECT t FROM TipoDocumentoTec t WHERE t.idTipoDocumento = :idTipoDocumento")
    , @NamedQuery(name = "TipoDocumentoTec.findBySigla", query = "SELECT t FROM TipoDocumentoTec t WHERE t.sigla = :sigla")
    , @NamedQuery(name = "TipoDocumentoTec.findByNombre", query = "SELECT t FROM TipoDocumentoTec t WHERE t.nombre = :nombre")})
public class TipoDocumentoTec implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_tipo_documento", nullable = false)
    private Long idTipoDocumento;
    @Basic(optional = false)
    @Column(name = "sigla", nullable = false, length = 10)
    private String sigla;
    @Column(name = "nombre", length = 45)
    private String nombre;
    @OneToMany(mappedBy = "idTipoDocumento", fetch = FetchType.LAZY)
    private Collection<ClienteTec> clienteTecCollection;

    public TipoDocumentoTec() {
    }

    public TipoDocumentoTec(Long idTipoDocumento) {
        this.idTipoDocumento = idTipoDocumento;
    }

    public TipoDocumentoTec(Long idTipoDocumento, String sigla) {
        this.idTipoDocumento = idTipoDocumento;
        this.sigla = sigla;
    }

    public Long getIdTipoDocumento() {
        return idTipoDocumento;
    }

    public void setIdTipoDocumento(Long idTipoDocumento) {
        this.idTipoDocumento = idTipoDocumento;
    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @XmlTransient
    public Collection<ClienteTec> getClienteTecCollection() {
        return clienteTecCollection;
    }

    public void setClienteTecCollection(Collection<ClienteTec> clienteTecCollection) {
        this.clienteTecCollection = clienteTecCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTipoDocumento != null ? idTipoDocumento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoDocumentoTec)) {
            return false;
        }
        TipoDocumentoTec other = (TipoDocumentoTec) object;
        if ((this.idTipoDocumento == null && other.idTipoDocumento != null) || (this.idTipoDocumento != null && !this.idTipoDocumento.equals(other.idTipoDocumento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.sena.basedatosperformance.model.entities.postgrestec.TipoDocumentoTec[ idTipoDocumento=" + idTipoDocumento + " ]";
    }
    
}
