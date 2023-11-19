/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package facade;

import modelo.Usuario;
import datos.UsuarioDAO;
import java.util.List;
import javax.inject.Inject;

/**
 *
 * @author mario_5ymtv0r
 */
public class UsuarioServiceImpl implements UsuarioService{

    @Inject
    private UsuarioDAO usuarioDAO;
    
    
    @Override
    public Usuario encontrarUsuario(Usuario usuario) {
        return usuarioDAO.encontrarUsuario(usuario);
    }

    @Override
    public void ingresarUsuario(Usuario usuario){
        usuarioDAO.ingresarUsuario(usuario);
    }
    
    @Override
    public List<Usuario> listarUsuario(){
        return usuarioDAO.findAllUsuario();
    }
}
