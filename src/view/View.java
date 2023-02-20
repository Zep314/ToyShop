package view;

import model.Toy;
import model.ToyStream;

import java.util.logging.Logger;

public class View {
    private final Logger log;
    public View(Logger log) {
        this.log = log;
    }  // чтобы писать в один и тот же лог, что и в контроллере

    public void info() {  // информация
        log.info("Программа запущена");
        System.out.println("Программа - \"Магазин игрушек\"");
    }

    public void bye() {  // Прощание
        log.info("Программа завершена");
        System.out.println("Программа завершена.");
    }

    public void printAllToys(ToyStream stream) {
        Toy toy = new Toy();
        System.out.println("| ID |        Наименование        |Количество|  Вес % |");
        System.out.printf("+%s+%s+%s+%s+%n"
                , "-".repeat(4)
                , "-".repeat(28)
                , "-".repeat(10)
                , "-".repeat(8)
        );
        while (stream.hasNext()) {
            toy = stream.next();
            System.out.printf("|%4d|%28s|%10d|%8f|%n"
                    , toy.getId()
                    , toy.getName()
                    , toy.getAmount()
                    , toy.getChance()
            );
        }
    }

    public void printf(String string) {
        System.out.printf(string);
    }
}
