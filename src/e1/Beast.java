package e1;

public class Beast extends Character{
    //        int counterBeasts = 0;
    public Beast(String name, int energy, int armor, int tipe) {
        super(name, energy, armor, tipe);
        TheLordOfTheRings.counterBeasts++;
    }
}

