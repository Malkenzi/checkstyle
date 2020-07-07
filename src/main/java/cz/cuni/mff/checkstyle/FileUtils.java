package cz.cuni.mff.checkstyle;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class FileUtils {

    public static List<File> findJavaFiles(String inputFolderName) {
        List<File> files = new ArrayList<>();
        try {
            files = Files.find(Paths.get(inputFolderName),
                    Integer.MAX_VALUE,
                    (path, basicFileAttributes) -> path.toFile().getName().matches(".*.java"))
                    .map(Path::toFile)
                    .collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return files;
    }

    public static String getContents(File file) {
        String content = "";
        try {
            Scanner myReader = new Scanner(file);
            while (myReader.hasNextLine()) {
                content = content + "\n" + myReader.nextLine();
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        return content;
    }
}
