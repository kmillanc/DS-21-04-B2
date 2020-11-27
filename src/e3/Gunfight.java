package e3;

public class Gunfight extends Gunslinger{

    /* Ejecuta el duelo entre pistoleros de forma no iterativa (mostrandolo en consola) y determina quien es
       el ganador del mismo o si queda en empate */

    public void duel(Gunslinger g1, Gunslinger g2){
        Gunslinger winner = null;
        boolean exit = false;
        int round = 1;

        do {

            GunslingerAction g1Action;
            GunslingerAction g2Action;
            if(round == 1){
                g1Action = GunslingerAction.RELOAD;
                g2Action = GunslingerAction.RELOAD;
            }
            else{
                g1Action = g1.action();
                g2Action = g2.action();
            }

            if(loads == 5){
                g1Action = GunslingerAction.MACHINE_GUN;
            }
            else if(rivalLoads == 5){
                g2Action = GunslingerAction.MACHINE_GUN;
            }

            System.out.println("Round "+ round +"-------------------------");
            System.out.println("Gunslinger 1: " +g1Action);
            System.out.println("Gunslinger 2: " +g2Action);
            rivalAction(g2Action);


            if(g1Action == GunslingerAction.SHOOT){
                loads -= 1;
            }else {
                if(g1Action == GunslingerAction.RELOAD){
                    loads += 1;
                }
            }

            if(g2Action == GunslingerAction.SHOOT){
                rivalLoads -= 1;
            }else {
                if(g2Action == GunslingerAction.RELOAD){
                    rivalLoads += 1;
                }
            }

            if(g1Action.equals(GunslingerAction.SHOOT) && g2Action.equals(GunslingerAction.RELOAD)){
                exit = true;
                winner = g1;
            }
            else if(g1Action.equals(GunslingerAction.RELOAD) && g2Action.equals(GunslingerAction.SHOOT)){
                exit = true;
                winner = g2;
            }
            else if(g1Action.equals(GunslingerAction.SHOOT) && g2Action.equals(GunslingerAction.SHOOT)){
                exit = true;
                winner = null;
            }
            else if(g1Action.equals(GunslingerAction.MACHINE_GUN) || g2Action.equals(GunslingerAction.MACHINE_GUN)){
                exit = true;
                if(g1Action.equals(GunslingerAction.MACHINE_GUN) && !g2Action.equals(GunslingerAction.MACHINE_GUN)) {
                    winner = g1;
                }
                else if(!g1Action.equals(GunslingerAction.MACHINE_GUN)) {
                    winner = g2;
                }
                else {
                    winner = null;
                }
            }
            else if(round == 50){
                exit = true;
            }

            if(!exit) {
                System.out.println("The duel continues...");
                round++;
            }
        }while (!exit);

        System.out.println("The duel has ended\n");

        if(winner != null)
            if(winner == g1)
                System.out.println("Winner: GUNSLINGER 1");
            else
                System.out.println("Winner: GUNSLINGER 2");
        else
            System.out.println("DRAW");
    }

    public static void main(String[] args) {
        Gunfight OldWest = new Gunfight();
        Gunslinger g1 = new Gunslinger();
        Gunslinger g2 = new Gunslinger();
        OldWest.duel(g1, g2);
    }
}
