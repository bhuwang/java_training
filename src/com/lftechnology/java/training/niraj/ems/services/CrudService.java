package com.lftechnology.java.training.niraj.ems.services;


public interface CrudService<T, S> {

    public T save(T t) throws Exception;

    public T find(S s) throws Exception;

    public boolean update(T t) throws Exception;
}
