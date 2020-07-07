package cz.cuni.mff.checkstyle;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ConfigReader {


    private Map<String, String> configMap = new HashMap<>();

    public ConfigReader() {
        try {
            File file = new File("checkstyle.config");
            Scanner myReader = new Scanner(file);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                String[] arr = data.split("=");
                String key = arr[0];
                String value = arr.length > 1 ? arr[1] : "true";

                /*if (arr.length > 1) {
                    value = arr[1];
                } else value = "true";*/


                this.configMap.put(key,value);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public Map<String, String> getConfigMap() {
        return this.configMap;
    }
}
