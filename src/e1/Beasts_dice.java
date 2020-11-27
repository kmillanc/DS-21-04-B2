package e1;

public class Beasts_dice{
    public int value;       //Atributo
    //Setter & getters
    public void setValue(int value) {
        this.value = value;
    }
    public int getValue() {
        return value;
    }
    //Métodos
    public int beastsDiceRoll(){
        value = TheLordOfTheRings.getRandomNumber(90);
        return value;
    }

}