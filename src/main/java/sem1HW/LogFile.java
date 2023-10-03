package sem1HW;

import java.io.*;
import java.util.List;

public class LogFile {
    private File logFile;

    LogFile(String fileName) throws IOException {
        logFile = new File(fileName);
        if (! logFile.exists()) {
            this.logFile.createNewFile();
        }
    }

    public List<String> Read() throws IOException{
        BufferedReader fileStream = new BufferedReader(new FileReader(this.logFile));
        List<String> lines = (fileStream.lines().toList());
        fileStream.close();
        return lines;
    }

    public void Write(String argLine) throws IOException{
        BufferedReader tempReader = new BufferedReader(new FileReader(this.logFile));
        List<String> lines = (tempReader.lines().toList());
        BufferedWriter fileStream = new BufferedWriter(new FileWriter(this.logFile));
        for (String line : lines) {
            fileStream.append(line);
            fileStream.newLine();
        }
        fileStream.write(argLine);
        fileStream.newLine();
        fileStream.flush();
        fileStream.close();
        tempReader.close();
    }
}
