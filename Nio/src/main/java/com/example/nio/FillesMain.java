package com.example.nio;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FillesMain {

    public static void main(String[] args) throws IOException {
        Path path = Paths.get("d:/data/subdir");
        Files.createDirectories(path);
    }
}
