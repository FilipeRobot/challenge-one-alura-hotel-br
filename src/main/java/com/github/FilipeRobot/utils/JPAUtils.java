package com.github.FilipeRobot.utils;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtils {
    private static final EntityManagerFactory FACTORY = Persistence.createEntityManagerFactory("db_hotel_alura");

    public static EntityManager getEntityManager() {
        return FACTORY.createEntityManager();
    }
}
