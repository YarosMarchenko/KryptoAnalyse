package org.example.services;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;



public class FileService {
    private static final FileService fileService=new FileService();
    private static final Map<String, List<String>> files = new HashMap<>();
    private FileService() {
    }
   public static FileService getInstance(){
        return fileService;
    }

    public void create(String path) {
        files.put(path, new ArrayList<>());
    }

    public void readFile(String path) throws IOException {
        create(path);
        files.put(path, Files.readAllLines(Path.of(path)));
    }
    public List<String> getText(String path) {
        return files.get(path);
    }
    public String newFilePath(String path, String action) {
        int dotIndex = path.lastIndexOf(".");
        return path.substring(0, dotIndex) + "[" + action.toUpperCase() + "]" + path.substring(dotIndex);
    }

    public void writeFile(String path, String newPath) throws IOException {
        List<String> list = files.get(path);
        try (FileOutputStream stream = new FileOutputStream(newPath)) {
            for (String s : list) {
                stream.write(s.getBytes());
                stream.write("\n".getBytes());
            }
        }
    }
}
