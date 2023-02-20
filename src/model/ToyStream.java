package model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ToyStream implements Iterator<Toy> {
    private Integer index;
    protected List<Toy> list = new ArrayList<Toy>();

    public ToyStream() {
        this.index = 0;
    }

    public void addToy(Toy toy) {
        list.add(toy);
    }

    public void restIndex() { this.index = 0; }
    public int size() { return this.list.size(); }

    @Override
    public boolean hasNext() {
        return this.index < this.list.size();
    }

    @Override
    public Toy next() {
        return this.list.get(this.index++);
    }
}
