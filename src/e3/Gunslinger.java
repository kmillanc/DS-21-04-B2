package e3;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Gunslinger{

    int loads = 0, rivalLoads = 0;

    /* Llamado por Gunfight, el pistolero decide que accion realizar
       y se lo comunica a Gunfight */
    public GunslingerAction action(){
        Random random = new Random();
        int opt = random.nextInt(4);

//        if(loads == 0 && rivalLoads == 0){
//            loads += 1;
//            rivalLoads += 1;
//            return GunslingerAction.RELOAD;
//        }

        switch (opt){
            case 0:
                loads -= 1;
                return GunslingerAction.SHOOT;
            case 1:
                loads += 1;
                return GunslingerAction.RELOAD;
            case 2:
                return GunslingerAction.MACHINE_GUN;
            case 3:
                return GunslingerAction.PROTECT;
            default:
                return null;
        }
    }

    //Devuelve el numero de cargas del pistolero
    public int getLoads(){
        return loads;
    }

    /* Usado por la clase Gunfight para comunicar al pistolero la ultima accion de su rival
       para registrarla y tenerla en cuenta en su estrategia si lo considera necesario*/
    public void rivalAction(GunslingerAction action){
        getRivalActions().add(action);
    }

    /* Devuelve la lista de acciones del rival que ha registrado el pistolero.
       Las ultimas acciones estan al final de la lista. Permite tratar de adivinar la estrategia del rival*/
    public List<GunslingerAction> getRivalActions(){
        List<GunslingerAction> l = new ArrayList<>();
        return l;
    }

    /*Devuelve las cargas del Rival*/
    public int getRivalLoads(){
        return rivalLoads;
    }

    //Establece como será el comportamiento del pistolero
    public void setBehavior(Behavior behavior){

    }
}