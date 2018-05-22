/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.basededatosperformance.mysql;

import co.edu.sena.basedatosperformance.model.entities.mysql.Cliente;
import co.edu.sena.basedatosperformance.model.entities.mysql.TipoDocumeto;
import co.edu.sena.basedatosperformance.model.entities.mysql2.Clientes;
import co.edu.sena.basedatosperformance.model.entities.mysql2.ClientesPK;
import co.edu.sena.basedatosperformance.model.entities.mysql2.TipoDocumentos;
import co.edu.sena.basedatosperformance.model.entities.postgressem.ClienteSem;
import co.edu.sena.basedatosperformance.model.entities.postgressem.ClienteSemPK;
import co.edu.sena.basedatosperformance.model.entities.postgressem.TipoDocumentoSem;
import co.edu.sena.basedatosperformance.model.entities.postgrestec.ClienteTec;
import co.edu.sena.basedatosperformance.model.entities.postgrestec.TipoDocumentoTec;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Enrique
 */
public class MysqlTest {
    
    public MysqlTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    @Test
    public void primerPrueba() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("mysqltecnica");
        EntityManager em= emf.createEntityManager();
        
        TipoDocumeto tipoDocumento = new TipoDocumeto();
        tipoDocumento.setSigla("CC");
        tipoDocumento.setNombre("Cedula de Ciudadania");
        em.getTransaction().begin();
        em.persist(tipoDocumento);
        em.getTransaction().commit();
        
        tipoDocumento = em.find(TipoDocumeto.class, 1);
        System.out.println(tipoDocumento);
        
        for (int i = 0; i < 100000000; i++) {
            Cliente ct = new Cliente();
            ct.setIdTipoDocumento(tipoDocumento);
            ct.setNombre("pedrito fernandez");
            ct.setNumeroDocumento(""+i);
            em.getTransaction().begin();
            em.persist(ct);
            em.getTransaction().commit();
        }
    }
    
    
    @Test
    public void segundaPrueba() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("mysqlsemantica");
        EntityManager em= emf.createEntityManager();
        
        TipoDocumentos td = new TipoDocumentos();
        td.setSigla("CC");
        td.setNombre("Cedula de ciudadania");
        em.getTransaction().begin();
        em.persist(td);
        em.getTransaction().commit();
        
       //td = em.find(TipoDocumentos.class, "CC");
        
        for (int i = 0; i < 1000000; i++) {
            Clientes ct = new Clientes();
            ct.setClientesPK(new ClientesPK("CC", ""+i));
            ct.setNombre("hernanado");
            em.getTransaction().begin();
            em.persist(ct);
            em.getTransaction().commit();
        }
        
        
    }
    
    @Test
    public void terceraPrueba() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgressemantica");
        EntityManager em= emf.createEntityManager();
       
        TipoDocumentoSem td = new TipoDocumentoSem();
        td.setSigla("CC");
        td.setNombre("cedula de ciudadania");
        
        em.getTransaction().begin();
        em.persist(td);
        em.getTransaction().commit();
       
        for (int i = 0; i < 10000000; i++) {
            ClienteSem ct = new ClienteSem();
            ct.setClienteSemPK(new ClienteSemPK("CC", ""+i));
            ct.setNombre("prueba");
            em.getTransaction().begin();
            em.persist(ct);
            em.getTransaction().commit();
        }
        
        
        
    }
    
    @Test
    public void cuartaPrueba() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgrestec");
        EntityManager em= emf.createEntityManager();
       
        TipoDocumentoTec tp = new TipoDocumentoTec();
        tp.setSigla("CC");
        tp.setNombre("Cedula de Ciudadania");
        em.getTransaction().begin();
        em.persist(tp);
        em.getTransaction().commit();
        
        for (int i = 0; i < 10000000; i++) {
            ClienteTec ct = new ClienteTec();
            ct.setIdTipoDocumento(tp);
            ct.setNumeroDocumento(""+i);
            ct.setNombre("adsfasdf");
            em.getTransaction().begin();
            em.persist(ct);
            em.getTransaction().commit();
        }
        
        
        
        
    }
    
    
    
}
