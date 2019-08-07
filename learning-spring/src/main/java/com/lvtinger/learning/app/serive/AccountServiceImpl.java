package com.lvtinger.learning.app.serive;

import com.lvtinger.learning.app.dao.AccountRepository;
import com.lvtinger.learning.app.entity.Account;
import com.lvtinger.learning.core.annotation.ExportService;
import org.springframework.beans.factory.annotation.Autowired;

@ExportService(
        service = AccountService.class,
        version = {"1.0"})
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountRepository repository;

    public Account register(Account account) {
        account.setId(1L);
        return repository.save(account);
    }
}
