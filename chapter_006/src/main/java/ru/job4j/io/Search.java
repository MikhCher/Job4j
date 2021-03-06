package ru.job4j.io;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;

import static java.nio.file.FileVisitResult.CONTINUE;

public class Search implements FileVisitor<Path> {
    private static List<Path> foundFiles;
    private static String expansion;

    public static void main(String[] args) throws IOException {
        if (args.length == 0) {
            throw new IllegalStateException("Root folder and expansion are null. Use java -jar Search.jar ROOT_FOLDER EXPANSION");
        }
        if (args.length == 1) {
            throw new IllegalStateException("Root folder or expansion is null. Use java -jar Search.jar ROOT_FOLDER EXPANSION");
        }
        search(Path.of(args[0]), args[1]);
    }

    public static void setExpansion(String expansion) {
        Search.expansion = expansion;
    }

    public static List<Path> search(Path root, String ext) throws IOException {
        foundFiles = new ArrayList<>();
        setExpansion(ext);
        Files.walkFileTree(root, new Search());
        foundFiles.forEach(path -> System.out.println(path.toString()));
        return foundFiles;
    }

    @Override
    public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
        return CONTINUE;
    }

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        if (file.getFileName().toString().endsWith(expansion)) {
            foundFiles.add(file);
        }
        return CONTINUE;
    }

    @Override
    public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
        return CONTINUE;
    }

    @Override
    public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
        return CONTINUE;
    }
}