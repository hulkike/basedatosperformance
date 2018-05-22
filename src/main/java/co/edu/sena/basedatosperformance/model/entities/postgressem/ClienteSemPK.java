/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.basedatosperformance.model.entities.postgressem;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author Enrique
 */
@Embeddable
public class ClienteSemPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "sigla", nullable = false, length = 10)
    private String sigla;
    @Basic(optional = false)
    @Column(name = "numero_documento", nullable = false, length = 45)
    private String numeroDocumento;

    public ClienteSemPK() {
    }

    public ClienteSemPK(String sigla, String numeroDocumento) {
        this.sigla = sigla;
        this.numeroDocumento = numeroDocumento;
    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    public String getNumeroDocumento() {
        return numeroDocumento;
    }

    public void setNumeroDocumento(String numeroDocumento) {
        this.numeroDocumento = numeroDocumento;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (sigla != null ? sigla.hashCode() : 0);
        hash += (numeroDocumento != null ? numeroDocumento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ClienteSemPK)) {
            return false;
        }
        ClienteSemPK other = (ClienteSemPK) object;
        if ((this.sigla == null && other.sigla != null) || (this.sigla != null && !this.sigla.equals(other.sigla))) {
            return false;
        }
        if ((this.numeroDocumento == null && other.numeroDocumento != null) || (this.numeroDocumento != null && !this.numeroDocumento.equals(other.numeroDocumento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.sena.basedatosperformance.model.entities.postgressem.ClienteSemPK[ sigla=" + sigla + ", numeroDocumento=" + numeroDocumento + " ]";
    }
    
}
