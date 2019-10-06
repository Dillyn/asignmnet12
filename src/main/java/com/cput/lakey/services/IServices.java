package com.cput.lakey.services;

import java.util.List;

public interface IServices<T, ID> {
    T create(T t);
    T read(ID id);
    T update(T t);
    void delete(ID id);

    List<T> getAll();
}
