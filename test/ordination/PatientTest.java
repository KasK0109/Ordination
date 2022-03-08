package ordination;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Order;

import java.time.LocalDate;

public class PatientTest {

    private Patient patient;

    @Test
    @Order(1)
    public void testAddOrdination() {

        // Arrange
        patient = new Patient("121256-0512", "Jane Jensen", 63.4);
        Laegemiddel lm = new Laegemiddel("Paracetamol", 1,1.5,2,"Ml");
        Ordination o = new PN(LocalDate.of(2022,3,8), LocalDate.of(2022,3,12), patient, lm,5);

        // Act
        patient.addOrdination(o);

        // Assert
        assertTrue(patient.getOrdinationer().contains(o));
    }

    @Test
    @Order(2)
    public void testRemoveOrdination() {

        // Arrange
        patient = new Patient("121256-0512", "Jane Jensen", 63.4);
        Laegemiddel lm = new Laegemiddel("Paracetamol", 1,1.5,2,"Ml");
        Ordination o = new PN(LocalDate.of(2022,3,8), LocalDate.of(2022,3,12), patient, lm,5);
        patient.addOrdination(o);

        // Act
        patient.removeOrdination(o);

        // Assert
        assertFalse(patient.getOrdinationer().contains(o));

    }
}
