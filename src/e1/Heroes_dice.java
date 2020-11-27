package e1;

public class Heroes_dice{
    public int value;   //Atributo
    //Setter & getters
    public void setValue(int value) {
        this.value = value;
    }
    public int getValue() {
        return value;
    }
    //Métodos
    public int heroesDiceRoll(){
        value = 0;
        for(int i = 0; i < 2;i++){
            int h = TheLordOfTheRings.getRandomNumber(100);
            if(h > value){
                value = h;
            }
        }
        return value;
    }

}