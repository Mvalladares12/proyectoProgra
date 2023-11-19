/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package facade;

import java.util.List;
import javax.ejb.Local;
import modelo.Servicios;

/**
 *
 * @author mario_5ymtv0r
 */
@Local
public interface ServiciosFacadeLocal {

    void create(Servicios servicios);

    void edit(Servicios servicios);

    void remove(Servicios servicios);

    Servicios find(Object id);

    List<Servicios> findAll();

    List<Servicios> findRange(int[] range);

    int count();
    
}
