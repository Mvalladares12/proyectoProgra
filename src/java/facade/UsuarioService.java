/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package facade;

import modelo.Usuario;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author mario_5ymtv0r
 */
@Local
public interface UsuarioService {
    
    public Usuario encontrarUsuario(Usuario usuario); 
    
    void ingresarUsuario(Usuario usuario);
    
    public List<Usuario> listarUsuario();
    
}
