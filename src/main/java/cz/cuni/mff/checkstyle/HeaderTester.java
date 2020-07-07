package cz.cuni.mff.checkstyle;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class HeaderTester implements Tester {


    private final String headerContent;

    public HeaderTester(String headerPath) {
        String content = "";
        try {
            File file = new File(headerPath);
            Scanner myReader = new Scanner(file);
            while (myReader.hasNextLine()) {
                content = content + "\n" + myReader.nextLine();
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        this.headerContent = content;
    }


    @Override
    public boolean test(String fileContent) {
        return fileContent.startsWith(this.headerContent);
    }

    @Override
    public String getErrorMessage() {
        return "bad header";
    }

    public String getHeaderContent() {
        return this.headerContent;
    }
}
