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

    public boolean usuarioExiste(String login) {
        String jpql = "SELECT u.login FROM Usuario u WHERE u.login LIKE :login";

        try {
            entityManager.createQuery(jpql, String.class)
                    .setParameter("login", login)
                    .getSingleResult();
            return true;
        } catch (NoResultException exception) {
            return false;
        }
    }
}
