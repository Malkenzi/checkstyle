package cz.cuni.mff.checkstyle;


import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public final class Main {

    public static void main(final String[] args) {
        ConfigReader configReader = new ConfigReader();
        Map<String, String> map = configReader.getConfigMap();
        List<Tester> testers = new ArrayList<>();
        String inputFolderName = args[0];
        List<File> files = FileUtils.findJavaFiles(inputFolderName);

        if (map.containsKey("CheckHeader")) {
            HeaderTester headerTester = new HeaderTester(map.get("CheckHeader"));
            testers.add(headerTester);
        }

        // TODO podle configu pridavat instance testerů do testers

        for (File file : files) {
            String content = FileUtils.getContents(file);
            for(Tester tester : testers) {
                if (!tester.test(content)) System.err.println(tester.getErrorMessage());
            }
        }


    }

}
