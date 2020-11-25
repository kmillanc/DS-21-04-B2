package e3;

public class Gunfight extends Gunslinger{

    /* Ejecuta el duelo entre pistoleros de forma no iterativa (mostrandolo en consola) y determina quien es
       el ganador del mismo o si queda en empate */

    public static void duel(Gunslinger g1, Gunslinger g2){
        Gunslinger winner = null;
        boolean exit = false;
        int round = 1;

        do {
            GunslingerAction g1Action = g1.action();
            GunslingerAction g2Action = g2.action();
            System.out.println("Round "+ round +"-------------------------");
            System.out.println("Gunslinger 1: " /*+ action(g1)*/+g1Action);
            System.out.println("Gunslinger 2: " /*+ action(g2)*/+g2Action);
            //rivalAction(g2Action);

            if(g1Action.equals(GunslingerAction.SHOOT) && g2Action.equals(GunslingerAction.RELOAD)){
                exit = true;
                winner = g1;
                System.out.println("1");
            }
            else if(g1Action.equals(GunslingerAction.RELOAD) && g2Action.equals(GunslingerAction.SHOOT)){
                exit = true;
                winner = g2;
                System.out.println("2");
            }
            else if(g1Action.equals(GunslingerAction.SHOOT) && g2Action.equals(GunslingerAction.SHOOT)){
                exit = true;
                winner = null;
                System.out.println("3");
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
                System.out.println("4");
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
        Gunslinger g1 = new Gunslinger();
        Gunslinger g2 = new Gunslinger();
        duel(g1,g2);
    }
}
