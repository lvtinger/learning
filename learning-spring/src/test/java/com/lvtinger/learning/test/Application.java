package com.lvtinger.learning.test;

import com.lvtinger.learning.utils.FileUtils;

import java.io.File;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        List<File> files = FileUtils.getResourceInDirectory("provider");
        for (File file : files) {
            System.out.println(file.getName());
        }
    }
}
