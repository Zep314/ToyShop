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

    public void resetIndex() { this.index = 0; }
    public int size() { return this.list.size(); }

    public Toy getToy(Integer index) { return this.list.get(index); }

    @Override
    public boolean hasNext() {
        return this.index < this.list.size();
    }

    @Override
    public Toy next() {
        return this.list.get(this.index++);
    }

    public void removeToy(Integer id) {
        if (this.size() > 0) {
            if (this.list.get(id).getAmount() > 1) {
                this.list.get(id).setAmount(this.list.get(id).getAmount() - 1);
            } else {
                this.list.remove(this.getToy(id));
            }
        }
    }
}
