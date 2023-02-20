package view;

import java.util.logging.Logger;

public class View {
    private final Logger log;
    public View(Logger log) {
        this.log = log;
    }  // чтобы писать в один и тот же лог, что и в контроллере

    public void info() {  // информация
        log.info("/info");
        System.out.println("Программа - \"Магазин игрушек\"");
    }

    public void bye() {  // Прощание
        System.out.println("Программа завершена.");
    }

}
