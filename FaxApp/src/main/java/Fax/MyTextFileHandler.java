package Fax;

import java.io.*;

/**
 * Created by user on 10.03.2017.
 */
public class MyTextFileHandler implements MyFileHandler {
    public void writeFile(String fileName, String fileContent) throws IOException {
        FileWriter writer = null;
        try
        {
            writer = new FileWriter(fileName);
            writer.write(fileContent);
        }
        finally {
            try {
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public String readFile(String fileName) throws IOException {
        FileReader reader = new FileReader(new File(fileName));

        BufferedReader bufferedReader = new BufferedReader(reader);

        return bufferedReader.readLine().toString();
    }
}
