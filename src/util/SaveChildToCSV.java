package util;

import model.Child;
import model.ChildStream;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Logger;

// Класс, выполняющий запись списка победителей в файл CSV
public class SaveChildToCSV {
    public static void save(Logger log, String fileName, char delimiter, ChildStream stream) {
        try (PrintWriter writer = new PrintWriter(fileName)) {
            Child child;
            StringBuilder sb = new StringBuilder();
            stream.resetIndex();
            while (stream.hasNext()) {
                child = stream.next();
                sb.setLength(0);
                sb.append(child.getName());
                sb.append(delimiter);
                sb.append(child.getPrize());
                sb.append("\n");

                writer.write(sb.toString());  // пишем в файл
                log.info(String.format("Данные записаны в файл: %s%n", fileName));
            }
        } catch (IOException ioe) {
            log.warning(String.format("Ошибка записи в файл: %s%n",ioe));
            System.out.printf("Ошибка записи в файл: %s%n",ioe);
        }
    }
}
