/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.basedatosperformance.model.entities.postgressem;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
@Table(name = "tipo_documento_sem", schema = "semantica")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoDocumentoSem.findAll", query = "SELECT t FROM TipoDocumentoSem t")
    , @NamedQuery(name = "TipoDocumentoSem.findBySigla", query = "SELECT t FROM TipoDocumentoSem t WHERE t.sigla = :sigla")
    , @NamedQuery(name = "TipoDocumentoSem.findByNombre", query = "SELECT t FROM TipoDocumentoSem t WHERE t.nombre = :nombre")})
public class TipoDocumentoSem implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "sigla", nullable = false, length = 10)
    private String sigla;
    @Column(name = "nombre", length = 45)
    private String nombre;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tipoDocumentoSem", fetch = FetchType.LAZY)
    private Collection<ClienteSem> clienteSemCollection;

    public TipoDocumentoSem() {
    }

    public TipoDocumentoSem(String sigla) {
        this.sigla = sigla;
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
    public Collection<ClienteSem> getClienteSemCollection() {
        return clienteSemCollection;
    }

    public void setClienteSemCollection(Collection<ClienteSem> clienteSemCollection) {
        this.clienteSemCollection = clienteSemCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (sigla != null ? sigla.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoDocumentoSem)) {
            return false;
        }
        TipoDocumentoSem other = (TipoDocumentoSem) object;
        if ((this.sigla == null && other.sigla != null) || (this.sigla != null && !this.sigla.equals(other.sigla))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.sena.basedatosperformance.model.entities.postgressem.TipoDocumentoSem[ sigla=" + sigla + " ]";
    }
    
}
