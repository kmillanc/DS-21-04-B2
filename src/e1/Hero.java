package e1;

public class Hero extends Character{
    //        int counterHeroes = 0;
    public Hero(String name, int energy, int armor, int tipe) {
        super(name, energy, armor, tipe);
        TheLordOfTheRings.counterHeroes++;
    }
}