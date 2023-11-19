/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package facade;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import modelo.Servicios;

/**
 *
 * @author mario_5ymtv0r
 */
@Stateless
public class ServiciosFacade extends AbstractFacade<Servicios> implements ServiciosFacadeLocal {

    @PersistenceContext(unitName = "PPPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ServiciosFacade() {
        super(Servicios.class);
    }
    
}
