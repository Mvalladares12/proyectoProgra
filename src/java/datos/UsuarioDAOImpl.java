/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package datos;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.*;
import modelo.Usuario;

/**
 *
 * @author mario_5ymtv0r
 */
@Stateless
public class UsuarioDAOImpl implements UsuarioDAO{
    
    @PersistenceContext(unitName="PPPU")
    EntityManager em;
    
    @Override
    public List<Usuario> findAllUsuario(){
        return em.createNamedQuery("Usuario.findAll").getResultList();
    }

    @Override
    public Usuario encontrarUsuario(Usuario usuario) {
        Usuario usu=null;
        try{
            Query query= em.createNamedQuery("Usuario.findByUserPassword");
            query.setParameter("usuario", usuario.getUsuario());
            query.setParameter("contrasena", usuario.getContrasena());
            List<Usuario> lista= query.getResultList();
            if(!lista.isEmpty()){
                usu=lista.get(0);
            }
        } catch (Exception x){
            throw x;
        }
        return usu;
    }
    
    @Override
    public void ingresarUsuario(Usuario usuario) {
        em.persist(usuario);
    }

}
