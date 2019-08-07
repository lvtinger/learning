package com.lvtinger.learning.test;

import com.lvtinger.learning.test.access.DataAccess;

import java.util.ServiceLoader;

public class Application {
    public static void main(String[] args) {
        ServiceLoader<DataAccess> accesses = ServiceLoader.load(DataAccess.class);
        accesses.forEach(
                access -> {
                    System.out.println(access.toString());
                });
    }
}
