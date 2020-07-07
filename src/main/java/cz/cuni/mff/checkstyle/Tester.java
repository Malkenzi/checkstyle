package cz.cuni.mff.checkstyle;

public interface Tester {

    public boolean test(String fileContent);
    public String getErrorMessage();
}
