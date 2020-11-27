package e1;

//import org.junit.jupiter.api.AfterEach;
//import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TheLordOfTheRingsTest {

    Elf elf = new Elf("Frodo", 100, 50);
    Orc orc = new Orc("Mahur", 290, 50);

    @Test
    void Battle(){
        assertSame("Frodo", elf.getName());
        assertSame("Mahur", orc.getName());

        assertEquals(100, elf.getEnergy());
        assertEquals( 290, orc.getEnergy());

        assertEquals(50, elf.getArmor());
        assertEquals(50, orc.getArmor());

        elf.setName("Legolas");
        orc.setName("Lurtz");
        assertSame("Legolas", elf.getName());
        assertSame("Lurtz", orc.getName());

    }
}