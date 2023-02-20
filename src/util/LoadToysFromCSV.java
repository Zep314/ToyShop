package util;
import model.Toy;
import model.ToyStream;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.logging.Logger;

public class LoadToysFromCSV {
    public static ToyStream load(Logger log, String fileName, char delimiter) {
        ToyStream stream = new ToyStream();
        try (BufferedReader br = Files.newBufferedReader(Path.of(fileName),
                StandardCharsets.UTF_8)) {
            log.info(String.format("Файл %s открыт%n",fileName));
            String line = br.readLine();
            while (line != null) {
                String[] attributes = line.split(String.valueOf(delimiter));
                Toy toy = new Toy(
                        Integer.valueOf(attributes[0])
                        , attributes[1]
                        , Integer.valueOf(attributes[2])
                        , Float.valueOf(attributes[3]));
                stream.addToy(toy);
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
