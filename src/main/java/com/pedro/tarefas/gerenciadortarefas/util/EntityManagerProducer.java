package com.pedro.tarefas.gerenciadortarefas.util;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

@ApplicationScoped
public class EntityManagerProducer {

    private EntityManagerFactory em;

    public EntityManagerProducer(){
        this.em = Persistence.createEntityManagerFactory("tarefas");
    }

    @Produces
    @RequestScoped
    public EntityManager createEntityManager(){
        return this.em.createEntityManager();
    }

    public void closeEntityManager(@Disposes EntityManager manager){
        manager.close();
    }

}
