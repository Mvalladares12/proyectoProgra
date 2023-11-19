/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package datos;

import java.util.List;
import modelo.Usuario;

/**
 *
 * @author mario_5ymtv0r
 */
public interface UsuarioDAO {
    
    public Usuario encontrarUsuario(Usuario usuario); 
    
    public void ingresarUsuario(Usuario usuario);
    
    public List<Usuario> findAllUsuario();
}
