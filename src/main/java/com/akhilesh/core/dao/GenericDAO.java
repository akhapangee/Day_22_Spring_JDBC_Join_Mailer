package com.akhilesh.core.dao;

import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Akhilesh
 */
public interface GenericDAO<T> {
    List<T> getAll() throws ClassNotFoundException,SQLException;
    T getById(int id) throws ClassNotFoundException,SQLException;
    int insert(T t) throws ClassNotFoundException,SQLException;
    int update(T t) throws ClassNotFoundException,SQLException;
    int delete(int id) throws ClassNotFoundException,SQLException;
}
