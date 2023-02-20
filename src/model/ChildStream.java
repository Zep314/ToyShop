package model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ChildStream implements Iterator<Child>{
    private Integer index;
    protected List<Child> list = new ArrayList<Child>();

    public ChildStream() {
        this.index = 0;
    }

    public void addChild(Child child) {
        list.add(child);
    }

    public void resetIndex() { this.index = 0; }
    public int size() { return this.list.size(); }

    @Override
    public boolean hasNext() {
        return this.index < this.list.size();
    }
    @Override
    public Child next() {
        return this.list.get(this.index++);
    }

    public void setPrize(Integer id, String prize) {
        this.list.get(id).setPrize(prize);
    }

    public Child getChild(Integer index) { return this.list.get(index); }
    public void removeChild(Integer id) {
        this.list.remove(this.getChild(id));
    }

    public Child popChild(Integer id) {
        Child temp = this.getChild(id);
        this.list.remove(this.getChild(id));
        return temp;
    }

}
