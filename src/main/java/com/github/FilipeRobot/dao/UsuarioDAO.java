package com.github.FilipeRobot.dao;

import com.github.FilipeRobot.model.Usuario;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;

public class UsuarioDAO {
    private final EntityManager entityManager;

    public UsuarioDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void registrar(Usuario usuario) {
        entityManager.persist(usuario);
    }

    public Usuario buscarPorID(Long id){
        Usuario usuario = entityManager.find(Usuario.class, id);
        if (usuario == null) {
            throw new NoResultException("Usuário não encontrado");
        }
        return usuario;
    }

    public Usuario buscarPorLogin(String login) {
        String jpql = "SELECT u FROM Usuario u WHERE u.login LIKE :login";

        try {
            return entityManager.createQuery(jpql, Usuario.class)
                    .setParameter("login", login)
                    .getSingleResult();
        } catch (NoResultException exception) {
            throw new NoResultException("Usuário não encontrado");
        }
    }

    public void editarUsuario(Usuario usuario){
        entityManager.merge(usuario);
    }

    public void deletarUsuario(Usuario usuario) {
        usuario = entityManager.merge(usuario);
        entityManager.remove(usuario);
    }
}
