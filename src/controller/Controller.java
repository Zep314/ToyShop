package controller;

import model.Child;
import model.ChildStream;
import util.LoadToysFromCSV;
import util.LoadChildFromCSV;
import view.View;

import java.io.IOException;
import java.util.logging.LogManager;
import java.util.logging.Logger;

import model.ToyStream;


public class Controller {
    private final Logger log = Logger.getLogger(Controller.class.getName());
    private ToyStream toysStream = new ToyStream();
    private ChildStream childStream = new ChildStream();
    private final ChildStream championsStream = new ChildStream();
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
        Child child = new Child();
        while ((this.childStream.size() > 0) && (this.toysStream.size() > 0)) {
            // child = this.childStream.getChild();
            Integer indexChild = (int)(Math.random() * this.childStream.size());
            // Вбираем приз (id игрушки)
            Integer toyIndex = (int)(Math.random() * toysStream.size());
            // Испытываем удачу для текущего ребенка
            if (toysStream.getToy(toyIndex).getChance() > Math.random()) {
                this.championsStream.addChild(this.childStream.popChild(indexChild));
                this.championsStream.setPrize(this.championsStream.size() -1,toysStream.getToy(toyIndex).getName());
                this.toysStream.removeToy(toyIndex);
            }
            this.childStream.removeChild(indexChild);
        }
    }

    public void run() {
        view.info();
        this.toysStream = LoadToysFromCSV.load(log,"toys.csv", ';');
        this.childStream = LoadChildFromCSV.load(log,"childs.csv", ';');

        view.printf("%n");
        view.printf("Исходное количество призов:%n");
        view.printAllToys(this.toysStream);

        this.lottery();

        view.printf("%nПобедители:%n");
        view.printAllChampions(this.championsStream);

        view.printf("%nОстаток призов:%n");
        view.printAllToys(this.toysStream);

        view.bye();
    }

}
