package com.lvtinger.learning;

import com.lvtinger.learning.app.entity.Account;
import com.lvtinger.learning.app.serive.AccountService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {

    public static final String PACKAGE_NAME = "com.lvtinger.learning";

    public static void main(String[] args) {

        Account account = new Account();
        account.setUsername("risesun");
        account.setPassword("123456");

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.scan("com.lvtinger.learning");
        context.refresh();

        AccountService accountService = context.getBean(AccountService.class);
        System.out.println(accountService.register(account));
    }
}
