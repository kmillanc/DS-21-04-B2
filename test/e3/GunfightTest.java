package e3;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class GunfightTest {

    @Test
    void duel() {
        Gunfight OldWest = new Gunfight();
        Gunslinger g1 = new Gunslinger();
        Gunslinger g2 = new Gunslinger();
//        OldWest.duel(g1, g2);
        assertEquals(0, OldWest.loads);
        assertEquals(0,OldWest.rivalLoads);
        assertEquals(0,OldWest.getRivalLoads());
        assertEquals(List.of(),OldWest.getRivalActions());

        assertEquals("MACHINE_GUN",g1.action().toString());
    }


}