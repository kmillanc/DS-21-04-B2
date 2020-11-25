package e3;

public interface Behavior {

    /* Dada la informacion que obtenga del pistolero dado determinará que acción debe
       realizar. La idea es que el pistolero (Gunslinger) delega en un objeto que
       implementa Behavior la decision de que accion tomar en un momento dado*/
    public GunslingerAction action(Gunslinger g);
}
