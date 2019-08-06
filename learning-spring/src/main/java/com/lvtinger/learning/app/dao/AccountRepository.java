package com.lvtinger.learning.app.dao;

import com.lvtinger.learning.app.entity.Account;
import com.lvtinger.learning.core.annotation.Repository;
import com.lvtinger.learning.core.database.GenericRepository;

@Repository
public interface AccountRepository extends GenericRepository<Account, Long> {
}
