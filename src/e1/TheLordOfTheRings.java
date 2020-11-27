package e1;
import java.lang.Math;


public class TheLordOfTheRings {
    static int counterHeroes = 0;
    static int counterBeasts = 0;

    public static int getRandomNumber(int max) {
        return (int) (Math.random()*(max+1));
    }
















//////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public Elf h1;
    public Elf h2;
    public Human h3;

    public Orc b1;
    public Orc b2;



    public TheLordOfTheRings(){
        Elf Legolas = new Elf("Legolas" , 150, 60);
        this.h1 = Legolas;
        Elf Frodo = new Elf("Frodo" , 100, 50);
        this.h2 = Frodo;
        Human Gandalf = new Human("Gandalf" , 50, 50);
        this.h3 = Gandalf;
        Orc Lurtz = new Orc("Lurtz", 190, 50);
        this.b1 = Lurtz;
        Orc Mauhur = new Orc("Mauhur", 290, 50);
        this.b2 = Mauhur;

//        Hero Hero1 = new Elf("Legolas" , 150, 60);
//        Hero Hero2 = new Human("Gandalf" , 50, 50);
//        Hero Hero3 = new Elf("Frodo" , 100, 50);
//        Hero Hero4 = new Human("Celeborn" , 100, 50);
//        Hero Hero5 = new Human("Samsagaz" , 100, 50);
//        Hero Hero6 = new Human("Aragorn" , 100, 50);
//        Hero Hero7 = new Human("Thorin II" , 100, 50);

//        Beast Beast1 = new Orc("Lurtz", 190, 50);
//        Beast Beast2 = new Orc("Mauhur", 290, 50);
//        Beast Beast3 = new Orc("Sauron", 100, 50);
//        Beast Beast4 = new Orc("Saruman", 100, 50);
//        Beast Beast5 = new Orc("Lurtz", 100, 50);
//        Beast Beast6 = new Orc("Lurtz", 100, 50);
//        Beast Beast7 = new Orc("Lurtz", 100, 50);
    }

    public void Battle(){
        boolean finish = false;
        Heroes_dice diceH = new Heroes_dice();
        Beasts_dice diceB = new Beasts_dice();
        Hero arrayOfHeroes[] = new Hero[counterHeroes];
        Beast arrayOfBeasts[] = new Beast[counterBeasts];
        arrayOfHeroes[0] = h1;
        arrayOfHeroes[1] = h2;
        arrayOfHeroes[2] = h3;

        arrayOfBeasts[0] = b1;
        arrayOfBeasts[1] = b2;
        for(int i = 1; finish != true ;i++){
            System.out.println("Turn "+ i);
            for(int j = 0;j < Math.min(counterBeasts, counterHeroes);j++){
                int armorOfHero = arrayOfHeroes[j].armor;
                System.out.println("Fight between " + arrayOfHeroes[j].getName() + " (Energy=" + arrayOfHeroes[j].getEnergy() + ") and " + arrayOfBeasts[j].getName() + " (Energy=" + arrayOfBeasts[j].getEnergy() + ")");
                int offensivePowerH = diceH.heroesDiceRoll();
                int offensivePowerB = diceB.beastsDiceRoll();
                if(arrayOfHeroes[j].tipe == 1 && arrayOfBeasts[j].tipe == 4){
                    offensivePowerH = offensivePowerH+10;
                }
                if(arrayOfHeroes[j].tipe == 2 && arrayOfBeasts[j].tipe == 5){
                    offensivePowerH = offensivePowerH-5;
                }
                if(arrayOfBeasts[j].tipe == 4 ){
                    armorOfHero = (int)(arrayOfHeroes[j].armor * 0.9);
                }
                int damageToH = offensivePowerB - armorOfHero;
                int damageToB = offensivePowerH - arrayOfBeasts[j].armor;

                if(damageToB > 0){
                    arrayOfBeasts[j].setEnergy(arrayOfBeasts[j].getEnergy()-damageToB);
                }
                if(damageToH > 0){
                    arrayOfHeroes[j].setEnergy(arrayOfHeroes[j].getEnergy()-damageToH);
                }

                if(arrayOfHeroes[j].getEnergy() <= 0){
                    arrayOfHeroes[j].isDead = true;
                    if(j != counterHeroes){
                        for(int p = j ;p < counterHeroes-1;p++){
                            arrayOfHeroes[p] = arrayOfHeroes[p+1];
                        }
                    }
                    counterHeroes--;
                    j--;
                }
                if(arrayOfBeasts[j].getEnergy() <= 0){
                    arrayOfBeasts[j].isDead = true;
                    if(j != counterBeasts){
                        for(int p = j; p < counterBeasts-1;p++){
                            arrayOfBeasts[p] = arrayOfBeasts[p+1];
                        }
                    }
                    counterBeasts--;
                    j--;
                }
            }
            if(counterBeasts == 0 || counterHeroes == 0){
                finish = true;
                if(counterBeasts == 0){
                    System.out.println("HEROES WIN!!");
                }
                else{
                    System.out.println("BEAST WIN :(");
                }

            }
        }
    }

    public static void main(String[] args) {
        TheLordOfTheRings Game = new TheLordOfTheRings();
        Game.Battle();
    }
}