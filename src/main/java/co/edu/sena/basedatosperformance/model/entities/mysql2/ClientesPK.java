/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.basedatosperformance.model.entities.mysql2;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author Enrique
 */
@Embeddable
public class ClientesPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "sigla", nullable = false, length = 10)
    private String sigla;
    @Basic(optional = false)
    @Column(name = "numero_documeno", nullable = false, length = 45)
    private String numeroDocumeno;

    public ClientesPK() {
    }

    public ClientesPK(String sigla, String numeroDocumeno) {
        this.sigla = sigla;
        this.numeroDocumeno = numeroDocumeno;
    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    public String getNumeroDocumeno() {
        return numeroDocumeno;
    }

    public void setNumeroDocumeno(String numeroDocumeno) {
        this.numeroDocumeno = numeroDocumeno;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (sigla != null ? sigla.hashCode() : 0);
        hash += (numeroDocumeno != null ? numeroDocumeno.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ClientesPK)) {
            return false;
        }
        ClientesPK other = (ClientesPK) object;
        if ((this.sigla == null && other.sigla != null) || (this.sigla != null && !this.sigla.equals(other.sigla))) {
            return false;
        }
        if ((this.numeroDocumeno == null && other.numeroDocumeno != null) || (this.numeroDocumeno != null && !this.numeroDocumeno.equals(other.numeroDocumeno))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.sena.basedatosperformance.model.entities.mysql2.ClientesPK[ sigla=" + sigla + ", numeroDocumeno=" + numeroDocumeno + " ]";
    }
    
}
