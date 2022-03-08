package ordination;

import net.bytebuddy.asm.Advice;
import ordination.*;
import org.junit.Test;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class PNTest {

    private PN pn;



    @Test
    @Order(1)
    public void PNTest_givDosis_foerStartDato(){
        //Arrange
        Patient p = new Patient("121256-0512", "Jane Jensen", 63.4);
        Laegemiddel l = new Laegemiddel("Paracetamol", 1, 1.5, 2, "Ml");
        pn = new PN(LocalDate.of(2022,3,8), LocalDate.of(2022, 3, 12), p, l, 10);

        //Act & Assert
        assertFalse(pn.givDosis(LocalDate.of(2022,3,7)));
    }

    @Test
    @Order(2)
    public void PNTest_givDosis_paaStartDato() {

        // Arrange
        Patient p = new Patient("121256-0512", "Jane Jensen", 63.4);
        Laegemiddel l = new Laegemiddel("Paracetamol", 1, 1.5, 2, "Ml");
        pn = new PN(LocalDate.of(2022,3,8), LocalDate.of(2022, 3, 12), p, l, 10);

        // Act & Assert
        assertTrue(pn.givDosis(LocalDate.of(2022, 3, 8)));
    }

    @Test
    @Order(3)
    public void PNTest_givDosis_efterStartDato_foerSlutDato() {

        // Arrange
        Patient p = new Patient("121256-0512", "Jane Jensen", 63.4);
        Laegemiddel l = new Laegemiddel("Paracetamol", 1, 1.5, 2, "Ml");
        pn = new PN(LocalDate.of(2022,3,8), LocalDate.of(2022, 3, 12), p, l, 10);

        // Act & Assert
        assertTrue(pn.givDosis(LocalDate.of(2022,3,10)));
    }

    @Test
    @Order(4)
    public void PNTest_givDosis_efterSlutDato() {

        // Arrange
        Patient p = new Patient("121256-0512", "Jane Jensen", 63.4);
        Laegemiddel l = new Laegemiddel("Paracetamol", 1, 1.5, 2, "Ml");
        pn = new PN(LocalDate.of(2022,3,8), LocalDate.of(2022, 3, 12), p, l, 10);

        // Act & Assert
        assertFalse(pn.givDosis(LocalDate.of(2022,3,13)));
    }

    @Test
    @Order(5)
    public void PNTest_givDosis_paaSlutDato() {

        // Arrange
        Patient p = new Patient("121256-0512", "Jane Jensen", 63.4);
        Laegemiddel l = new Laegemiddel("Paracetamol", 1, 1.5, 2, "Ml");
        pn = new PN(LocalDate.of(2022,3,8), LocalDate.of(2022, 3, 12), p, l, 10);

        // Act & Assert
        assertTrue(pn.givDosis(LocalDate.of(2022, 3, 12)));
    }

    @Test
    @Order(6)
    public void PNTest_constructor() {

        // Arrange
        Patient p = new Patient("121256-0512", "Jane Jensen", 63.4);
        Laegemiddel l = new Laegemiddel("Paracetamol", 1, 1.5, 2, "Ml");

        // Act
        pn = new PN(LocalDate.of(2022,3,8), LocalDate.of(2022, 3, 12), p, l, 10);

        // Assert
        assertEquals(pn.getStartDen(), LocalDate.of(2022,3,8));
        assertEquals(pn.getSlutDen(), LocalDate.of(2022,3,12));
        assertEquals(pn.getLaegemiddel(), l);
        assertEquals(pn.getAntalEnheder(), 10);
    }
}
