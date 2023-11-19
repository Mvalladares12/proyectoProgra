/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package facade;

import datos.ServiciosDAO;
import java.util.List;
import javax.inject.Inject;
import modelo.Servicios;

/**
 *
 * @author mario_5ymtv0r
 */
public class ServiciosServiceImpl implements ServiciosService{
    
    @Inject
    private ServiciosDAO serviciosDAO;
    
    @Override
    public List<Servicios> listarServicios(){
        return serviciosDAO.findAllServicios();
    }
}
