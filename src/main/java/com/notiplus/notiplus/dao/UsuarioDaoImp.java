package com.notiplus.notiplus.dao;

import com.notiplus.notiplus.models.Usuario;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
@Repository
@Transactional
public class UsuarioDaoImp implements UsuarioDao {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public List<Usuario> getUsuarios() {
        String query= "FROM Usuario";

        List<Usuario> resultado=  entityManager.createQuery(query).getResultList();
        return resultado;

    }

    @Override
    public void eliminar(int id) {
        Usuario usuario = entityManager.find(Usuario.class, id);
        entityManager.remove(usuario);

    }

    @Override
    public void registrar(Usuario usuario) {
       entityManager.merge(usuario);

    }
}
