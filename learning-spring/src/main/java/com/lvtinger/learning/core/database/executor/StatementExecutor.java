package com.lvtinger.learning.core.database.executor;

public interface StatementExecutor {
    Object execute(Object... args);
}
