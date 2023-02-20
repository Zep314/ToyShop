package controller;

import view.View;

import java.io.IOException;
import java.util.logging.LogManager;
import java.util.logging.Logger;


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

    public void run() {
        view.info();
        view.bye();
    }

}
