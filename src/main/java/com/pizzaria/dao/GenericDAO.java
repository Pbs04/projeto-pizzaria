package com.pizzaria.dao;

import java.util.List;

import com.pizzaria.model.Entidade;
import com.pizzaria.utils.HibernateUtil;

import jakarta.persistence.EntityManager;

public abstract class GenericDAO<T extends Entidade> {
    private final Class<T> clazz;

    //construtor
    public GenericDAO(Class<T> clazz){
        this.clazz = clazz;
    }

    public void inserir(T entidade) throws Exception{
        EntityManager entityManager = HibernateUtil.getEntityManager();
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(entidade);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            if (entityManager.getTransaction().isActive()) {
                entityManager.getTransaction().rollback();
            }
            throw e;
        } finally {
            if (entityManager.isOpen()) {
                entityManager.close();
            }
        }
    }


    public void atualizar(T entidade) throws Exception{
        EntityManager entityManager = HibernateUtil.getEntityManager();
        try {
            entityManager.getTransaction().begin();
            entityManager.merge(entidade);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            if (entityManager.getTransaction().isActive()) {
                entityManager.getTransaction().rollback();
            }
            throw e;
        } finally {
            if (entityManager.isOpen()) {
                entityManager.close();
            }
        }
    }


    public void deletar(int id) throws Exception{
        EntityManager entityManager = HibernateUtil.getEntityManager();
        try {
            entityManager.getTransaction().begin();
            T entidade = entityManager.find(clazz, id);
            if(entidade != null){
                entityManager.remove(entidade);
            }
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            if (entityManager.getTransaction().isActive()) {
                entityManager.getTransaction().rollback();
            }
            throw e;
        } finally {
            if (entityManager.isOpen()) {
                entityManager.close();
            }
        }
    }


    public T buscarPorId(int id) throws Exception{
        try(EntityManager entityManager = HibernateUtil.getEntityManager()){
            return entityManager.find(clazz, id);
        }
    }


    public List<T> listarTodos() throws Exception{
        try(EntityManager entityManager = HibernateUtil.getEntityManager()){
            return entityManager.createQuery("from " + clazz.getSimpleName(), clazz).getResultList();
        }
    }

}
