package loggingLibrary.appender;

import java.io.FileWriter;
import java.io.IOException;

public class FileAppender implements Appender {

    private FileWriter file;

    public FileAppender(String filePath) throws IOException {
        this.file = new FileWriter(filePath, true );
    }
    @Override
    public void append(String message) {
        try{
            file.write(message);
            file.flush();
        } catch(Exception e) {
            System.out.println("catching exception e"+ e);
        }

    }
}
