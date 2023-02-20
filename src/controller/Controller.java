package controller;

import model.ChildStream;
import util.LoadToysFromCSV;
import util.LoadChildFromCSV;
import view.View;

import java.io.IOException;
import java.util.logging.LogManager;
import java.util.logging.Logger;
import model.Toy;
import model.ToyStream;


public class Controller {
    private final Logger log = Logger.getLogger(Controller.class.getName());
    View view = new View(this.log);  // Цепляем вьювер
    public Controller() {
        try {
            LogManager.getLogManager().readConfiguration( // берем конфиг для логов
                    Controller.class.getResourceAsStream("../log.config"));
        } catch (IOException e) {  // печаль, беда...
            System.err.println("Could not setup logger configuration: " + e.toString());
        }
    }

    public void lottery() {

    }

    public void run() {
        view.info();
        ToyStream toysStream = LoadToysFromCSV.load(log,"toys.csv", ';');
        ChildStream childStream = LoadChildFromCSV.load(log,"childs.csv", ';');

        view.printf("Исходное количество призов:%n");
        view.printAllToys(toysStream);
        toysStream.restIndex();

        this.lottery();

        view.printf("Остаток призов:%n");
        view.printAllToys(toysStream);

        while (childStream.hasNext()) {
            System.out.println(childStream.next().getName());
        }
        view.bye();
    }

}
