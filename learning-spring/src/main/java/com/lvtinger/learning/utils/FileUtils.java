package com.lvtinger.learning.utils;

import java.io.File;
import java.net.URL;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public final class FileUtils {
    public static List<File> getResourceInDirectory(String directory) {
        URL url = ClassUtils.getDefaultClassLoader().getResource(directory);
        if (url == null) {
            return Collections.emptyList();
        }
        String path = url.getFile();
        File file = new File(path);
        if (!file.exists() || !file.isDirectory()) {
            return Collections.emptyList();
        }

        File[] files = file.listFiles(pathname -> pathname.isFile());
        return Arrays.asList(files);
    }
}
