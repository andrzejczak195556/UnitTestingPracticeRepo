package Fax;

import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Created by user on 10.03.2017.
 */
public interface MyFileHandler {
    void writeFile(String fileName, String fileContent) throws IOException;
    String readFile(String fileName) throws IOException;

}
