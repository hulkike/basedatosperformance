/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.basedatosperformance.model.entities.mysql2;

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
@Table(name = "clientes")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Clientes.findAll", query = "SELECT c FROM Clientes c")
    , @NamedQuery(name = "Clientes.findByNombre", query = "SELECT c FROM Clientes c WHERE c.nombre = :nombre")
    , @NamedQuery(name = "Clientes.findBySigla", query = "SELECT c FROM Clientes c WHERE c.clientesPK.sigla = :sigla")
    , @NamedQuery(name = "Clientes.findByNumeroDocumeno", query = "SELECT c FROM Clientes c WHERE c.clientesPK.numeroDocumeno = :numeroDocumeno")})
public class Clientes implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ClientesPK clientesPK;
    @Column(name = "nombre", length = 45)
    private String nombre;
    @JoinColumn(name = "sigla", referencedColumnName = "sigla", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private TipoDocumentos tipoDocumentos;

    public Clientes() {
    }

    public Clientes(ClientesPK clientesPK) {
        this.clientesPK = clientesPK;
    }

    public Clientes(String sigla, String numeroDocumeno) {
        this.clientesPK = new ClientesPK(sigla, numeroDocumeno);
    }

    public ClientesPK getClientesPK() {
        return clientesPK;
    }

    public void setClientesPK(ClientesPK clientesPK) {
        this.clientesPK = clientesPK;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public TipoDocumentos getTipoDocumentos() {
        return tipoDocumentos;
    }

    public void setTipoDocumentos(TipoDocumentos tipoDocumentos) {
        this.tipoDocumentos = tipoDocumentos;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (clientesPK != null ? clientesPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Clientes)) {
            return false;
        }
        Clientes other = (Clientes) object;
        if ((this.clientesPK == null && other.clientesPK != null) || (this.clientesPK != null && !this.clientesPK.equals(other.clientesPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.sena.basedatosperformance.model.entities.mysql2.Clientes[ clientesPK=" + clientesPK + " ]";
    }
    
}
