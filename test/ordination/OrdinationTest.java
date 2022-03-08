package ordination;


import org.junit.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.time.LocalDate;

class OrdinationTest {

    private Ordination o;

    @Test
    void OpretOrdinationTest() {

        Laegemiddel l = new Laegemiddel("Paracetamol", 1, 1.5, 2, "Ml");

        o.setLaegemiddel(l);

        assertEquals(o.getLaegemiddel(), l);
    }
}
