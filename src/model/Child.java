package model;

public class Child {
    protected String name;
    protected String prize;

    public Child() {
        this.name = "";
        this.prize = null;
    }

    public Child(String name) {
        this.name = name;
        this.prize = null;
    }

    public String getName() { return this.name; }
    public String getPrize() { return (this.prize != null) ? this.prize : ""; }

    public void setName(String name) { this.name = name; }
    public void setPrize(String name) { this.prize = prize; }

    @Override
    public String toString() {
        return String.format("Name: %s, Prize: %s"
                , getName()
                , getPrize()
        );
    }

}
