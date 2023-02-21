package model;

// Класс, описывающий игрушку, и методы работы с ней
public class Toy {
    protected Integer id = 0;
    protected String name;
    protected Integer amount;
    protected Float chance;

    @SuppressWarnings("unused")
    public Toy() {
        id++;
        this.name = "";
        this.amount = 0;
        this.chance = 0f;
    }

    public Toy(Integer id,
               String name,
               Integer amount,
               Float chance) {
        this.id = id;
        this.name = name;
        this.amount = amount;
        this.chance = chance;
    }

    // геттеры - сеттеры
    public Integer getId() { return id; }
    public String getName() { return this.name; }
    public  Integer getAmount() { return this.amount; }
    public Float getChance() { return this.chance; }

    @SuppressWarnings("unused")
    public void setId(Integer id) { this.id = id; }
    @SuppressWarnings("unused")
    public void setName(String name) { this.name = name; }
    public void setAmount(Integer amount) { this.amount = amount; }
    @SuppressWarnings("unused")
    public void setChance(Float chance) { this.chance = chance; }

    @Override
    public String toString() {
        return String.format("ID: %d, Name: %s, Amount: %d, Chance: %.2f"
                , getId()
                , getName()
                , getAmount()
                , getChance()
        );
    }
}
