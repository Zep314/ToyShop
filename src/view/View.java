package view;

import model.Child;
import model.ChildStream;
import model.Toy;
import model.ToyStream;

import java.util.logging.Logger;

// Класс - вбювер. Собраны методы отображения информации и взаимодействия с пользователем
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

    public void printAllToys(ToyStream stream) {  // Вывод на печать всего списка игрушек
        Toy toy;
        stream.resetIndex();
        System.out.println("| ID |        Наименование        |Количество|   Вес  |");
        System.out.printf("+%s+%s+%s+%s+%n"
                , "-".repeat(4)
                , "-".repeat(28)
                , "-".repeat(10)
                , "-".repeat(8)
        );
        while (stream.hasNext()) {
            toy = stream.next();
            System.out.printf("|%4d|%28s|%10d|%8s|%n"
                    , toy.getId()
                    , toy.getName()
                    , toy.getAmount()
                    , toy.getChance().toString()
            );
        }
    }

    public void printf(String string) {
        System.out.printf(string);
    }  // Просто для печати, чтобы все было во вьювере

    public void printAllChampions(ChildStream stream) {  // Вывод на печать списка детей - призеров
        Child child;
        System.out.println("|      Имя      |      Приз     |");
        System.out.printf("+%s+%s+%n"
                , "-".repeat(15)
                , "-".repeat(15)
        );
        while (stream.hasNext()) {
            child = stream.next();
            if (!child.getPrize().isEmpty()) {  // Определяем выиграл приз, или нет
                System.out.printf("|%15s|%15s|%n"
                        , child.getName()
                        , child.getPrize()
                );
            }
        }
    }
}
