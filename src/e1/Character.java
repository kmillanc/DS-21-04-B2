package e1;

public abstract class Character{
    String name;                  //Atributos
    int energy;
    int armor;
    boolean  isDead = false;
    int tipe;                  //El tipo nos indica que personaje es 1=Elfo 2=Hobbit 3=Humanos 4=Orcos 5=Trasgo
    //Setters & getters
    public int getArmor() {
        return armor;
    }
    public int getEnergy() {
        return energy;
    }
    public String getName() {
        return name;
    }
    public void setArmor(int armor) {
        this.armor = armor;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setEnergy(int energy) {
        this.energy = energy;
    }
    //Constructor
    public Character(String name,int energy, int armor, int tipe){
        this.name = name;
        this.armor = armor;
        this.energy = energy;
        this.tipe = tipe;
    }

}
