package sem2.Task02;

import java.io.*;
import java.time.LocalDateTime;
import java.util.List;


public class LogServerListener implements ServerListener {
    private File logFile;

    LogServerListener(String fileName) throws IOException{
        logFile = new File(fileName);
        if (!logFile.exists()){
            logFile.createNewFile();
        }
    }
    @Override
    public void getMessage(String message) {
        message = LocalDateTime.now().toString() + " " + message;
        try(BufferedReader tempReader = new BufferedReader(new FileReader(this.logFile))){
            List<String>lines = (tempReader.lines().toList());
            BufferedWriter fileStream = new BufferedWriter(new FileWriter(this.logFile));
            for(String line: lines){
                fileStream.append(line);
                fileStream.newLine();
            }
            fileStream.write(message);
            fileStream.newLine();
            fileStream.flush();
            fileStream.close();
            tempReader.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
