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

    public void restIndex() { this.index = 0; }
    public int size() { return this.list.size(); }

    @Override
    public boolean hasNext() {
        return this.index < this.list.size();
    }
    @Override
    public Child next() {
        return this.list.get(this.index++);
    }

}
