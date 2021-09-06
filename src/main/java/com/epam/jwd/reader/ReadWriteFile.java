package com.epam.jwd.reader;

import com.epam.jwd.exception.ReadDataException;
import com.epam.jwd.exception.WriteDataException;
import com.epam.jwd.logger.LoggerProvider;

import java.io.*;

public class ReadWriteFile {
    private static final String NEW_LINE_REGEX = "\n";

    private static ReadWriteFile readWriteFile;

    public static ReadWriteFile getInstance() {
        if (readWriteFile == null) {
            readWriteFile = new ReadWriteFile();
        }
        return readWriteFile;
    }

    public static String readFile(String fileName) throws IOException {
        StringBuilder stringBuilder = new StringBuilder();
        try {

            File file = new File(fileName);
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String str;
            while ((str = bufferedReader.readLine()) != null) {
                stringBuilder.append(str);
                stringBuilder.append(NEW_LINE_REGEX);
            }
        } catch (IOException e) {
            throw new ReadDataException("Read from file was failed");
        }
        LoggerProvider.getLOG().trace("Reading from file success");
        return stringBuilder.toString();
    }

    public void writeFile(String fileName, String text) throws IOException {
        try {
            PrintWriter printWriter = new PrintWriter(fileName);
            printWriter.print(text);

        } catch (IOException e) {
            throw new WriteDataException("Write was failed");
        }
        LoggerProvider.getLOG().trace("Writing to file success");

    }

}
