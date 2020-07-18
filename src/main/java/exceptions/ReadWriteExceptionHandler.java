package exceptions;

import java.io.File;
import java.nio.file.Paths;

public class ReadWriteExceptionHandler {
    private static String path =
            Paths.get("").toAbsolutePath().toString()+ "\\src\\main\\java\\exceptions\\data.txt";
    private File file = new File(path);

    public void appendDataToFile(){

    }
    public void readDataFromFile(){

    }
}
