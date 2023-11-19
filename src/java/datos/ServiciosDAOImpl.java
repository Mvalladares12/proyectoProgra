/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package datos;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import modelo.Servicios;

/**
 *
 * @author mario_5ymtv0r
 */
@Stateless
public class ServiciosDAOImpl implements ServiciosDAO{
    @PersistenceContext(unitName="PPPU")
    EntityManager em;
    
    @Override
    public List<Servicios> findAllServicios(){
        return em.createNamedQuery("Servicios.findAll").getResultList();
    }
}
