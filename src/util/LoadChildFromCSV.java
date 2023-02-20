package util;

import model.Child;
import model.ChildStream;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.logging.Logger;

public class LoadChildFromCSV {
    public static ChildStream load(Logger log, String fileName, char delimiter) {
        ChildStream stream = new ChildStream();
        try (BufferedReader br = Files.newBufferedReader(Path.of(fileName),
                StandardCharsets.UTF_8)) {
            log.info(String.format("Файл %s открыт%n",fileName));
            String line = br.readLine();
            while (line != null) {
                String[] attributes = line.split(String.valueOf(delimiter));
                Child child = new Child(attributes[0]);
                stream.addChild(child);
                line = br.readLine();
                log.info(String.format("Файл %s прочиан в память%n",fileName));
            }
        } catch (IOException ioe) {
            //ioe.printStackTrace();
            log.warning(String.format("Ошибка: %s%n",ioe.toString()));
            System.out.printf("Ошибка: %s%n",ioe.toString());
        }
        return stream;
    }
}
