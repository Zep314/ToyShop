package model;

// Класс, описывающий ребенка, и методы работы с ним
public class Child {
    protected String name;
    protected String prize;

    @SuppressWarnings("unused")
    public Child() {
        this.name = "";
        this.prize = null;
    }

    public Child(String name) {
        this.name = name;
        this.prize = null;
    }

    // геттеры - сеттеры
    public String getName() { return this.name; }
    public String getPrize() { return (this.prize != null) ? this.prize : ""; }

    @SuppressWarnings("unused")
    public void setName(String name) { this.name = name; }
    public void setPrize(String prize) { this.prize = prize; }

    @Override
    public String toString() {
        return String.format("Name: %s, Prize: %s"
                , getName()
                , getPrize()
        );
    }

}
