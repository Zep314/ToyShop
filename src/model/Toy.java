package model;

public class Toy {
    private static Integer id = 0;
    protected String name = null;
    protected Integer amount = null;
    protected Float chance = null;

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
        Toy.id = id;
        this.name = name;
        this.amount = amount;
        this.chance = chance;
    }

    public Integer getId() { return id; }
    public String getName() { return this.name; }
    public  Integer getAmount() { return this.amount; }
    public Float getChance() { return this.chance; }

    public void setName(String name) { this.name = name; }
    public void setAmount(Integer amount) { this.amount = amount; }
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
