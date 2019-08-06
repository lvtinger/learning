package com.lvtinger.learning.core.database;

import com.lvtinger.learning.core.annotation.Repository;

@Repository
public interface GenericRepository<T, ID> {
    T save(T doc);

    T load(ID id);
}