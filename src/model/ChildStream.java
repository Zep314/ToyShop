package model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// Класс - описывает список детей, и методы для работы этого списка
public class ChildStream implements Iterator<Child> {
    private Integer index;
    protected List<Child> list = new ArrayList<>();  // Тут храним список

    public ChildStream() {
        this.index = 0;
    }

    public void addChild(Child child) {
        list.add(child);
    }  // Добавление в список нового ребенка

    public void resetIndex() { this.index = 0; }
    public int size() { return this.list.size(); }  // размер списка

    @Override
    public boolean hasNext() {
        return this.index < this.list.size();
    }  // Проверка, есть ли следующий элемент в списке
                                                                        // (для итераций)
    @Override
    public Child next() {
        return this.list.get(this.index++);
    }  // возвращаем элемент, и ставим указатель наследующий
                                                                 // (для итераций)

    // геттеры - сеттеры
    public void setPrize(Integer id, String prize) {
        this.list.get(id).setPrize(prize);
    }

    public Child getChild(Integer index) { return this.list.get(index); }
    public void removeChild(Integer index) {
        this.list.remove(this.getChild(index));
    }  // Удаление элемента из списка

    public Child popChild(Integer id) {  // Удаление элемента из списка и возвращение удаляемого элемента
        Child temp = this.getChild(id);
        this.list.remove(this.getChild(id));
        return temp;
    }

}
