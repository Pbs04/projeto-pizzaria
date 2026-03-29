package com.pizzaria.dao;

import java.util.List;

public interface GenericDAO<T> {
    void inserir(T obj) throws Exception;

    List<T> listar() throws Exception;

    void atualizar(T obj) throws Exception;

    void deletar(int id) throws Exception;
}
