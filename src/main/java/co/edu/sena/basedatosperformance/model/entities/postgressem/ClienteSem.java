/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.basedatosperformance.model.entities.postgressem;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
@Table(name = "cliente_sem", schema = "semantica")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ClienteSem.findAll", query = "SELECT c FROM ClienteSem c")
    , @NamedQuery(name = "ClienteSem.findBySigla", query = "SELECT c FROM ClienteSem c WHERE c.clienteSemPK.sigla = :sigla")
    , @NamedQuery(name = "ClienteSem.findByNumeroDocumento", query = "SELECT c FROM ClienteSem c WHERE c.clienteSemPK.numeroDocumento = :numeroDocumento")
    , @NamedQuery(name = "ClienteSem.findByNombre", query = "SELECT c FROM ClienteSem c WHERE c.nombre = :nombre")})
public class ClienteSem implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ClienteSemPK clienteSemPK;
    @Column(name = "nombre", length = 45)
    private String nombre;
    @JoinColumn(name = "sigla", referencedColumnName = "sigla", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private TipoDocumentoSem tipoDocumentoSem;

    public ClienteSem() {
    }

    public ClienteSem(ClienteSemPK clienteSemPK) {
        this.clienteSemPK = clienteSemPK;
    }

    public ClienteSem(String sigla, String numeroDocumento) {
        this.clienteSemPK = new ClienteSemPK(sigla, numeroDocumento);
    }

    public ClienteSemPK getClienteSemPK() {
        return clienteSemPK;
    }

    public void setClienteSemPK(ClienteSemPK clienteSemPK) {
        this.clienteSemPK = clienteSemPK;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public TipoDocumentoSem getTipoDocumentoSem() {
        return tipoDocumentoSem;
    }

    public void setTipoDocumentoSem(TipoDocumentoSem tipoDocumentoSem) {
        this.tipoDocumentoSem = tipoDocumentoSem;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (clienteSemPK != null ? clienteSemPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ClienteSem)) {
            return false;
        }
        ClienteSem other = (ClienteSem) object;
        if ((this.clienteSemPK == null && other.clienteSemPK != null) || (this.clienteSemPK != null && !this.clienteSemPK.equals(other.clienteSemPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.sena.basedatosperformance.model.entities.postgressem.ClienteSem[ clienteSemPK=" + clienteSemPK + " ]";
    }
    
}
