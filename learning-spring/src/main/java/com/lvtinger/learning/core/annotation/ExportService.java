package com.lvtinger.learning.core.annotation;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Documented
public @interface ExportService {
    Class<?> service();

    String[] version();
}
