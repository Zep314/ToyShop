package model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// Класс - описывает список игрушек - призов, и методы для работы этого списка
public class ToyStream implements Iterator<Toy> {
    private Integer index;
    protected List<Toy> list = new ArrayList<>();  // Тут храним список

    public ToyStream() {
        this.index = 0;
    }

    public void addToy(Toy toy) {
        list.add(toy);
    }  // Добавление в список нового ребенка

    public void resetIndex() { this.index = 0; }
    public int size() { return this.list.size(); }  // размер списка

    // геттеры - сеттеры
    public Toy getToy(Integer index) { return this.list.get(index); }

    @Override
    public boolean hasNext() {
        return this.index < this.list.size();
    }  // Проверка, есть ли следующий элемент в списке
                                                                        // (для итераций)

    @Override
    public Toy next() {
        return this.list.get(this.index++);
    }  // возвращаем элемент, и ставим указатель наследующий
                                                               // (для итераций)

    public void removeToy(Integer id) {  // Удаление элемента из списка (если количество игрушек еще не 0, то уменьшаем
                                         // количество, если количество = 0 - то удаляем игрушку из списка)
        if (this.size() > 0) {
            if (this.list.get(id).getAmount() > 1) {
                this.list.get(id).setAmount(this.list.get(id).getAmount() - 1);
            } else {
                this.list.remove(this.getToy(id));
            }
        }
    }
}
