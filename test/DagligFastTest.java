import ordination.*;
import org.junit.Test;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;

public class DagligFastTest {

    @Test
    public void Morgenantal_0() {
        //Arrange
        Patient p = new Patient("121556-0512","Jane Jensen",63.4);
        Laegemiddel l = new Laegemiddel("Paracetamol",1,1.5,2,"ML");
        //Act
        DagligFast o1 = new DagligFast(LocalDate.of(2022,5,1),LocalDate.of(2022,6,1),p,l,0,3,4,5);
        //Assert
        assertEquals(o1.getDoser()[0].getAntal(),0);
    }
    @Test
    public void Alle_StørreEnd0() {
        //Arrange
        Patient p = new Patient("121556-0512","Jane Jensen",63.4);
        Laegemiddel l = new Laegemiddel("Paracetamol",1,1.5,2,"ML");
        //Act
        DagligFast o1 = new DagligFast(LocalDate.of(2022,5,1),LocalDate.of(2022,6,1),p,l,2,3,4,5);
        //Assert
        assertEquals(o1.getDoser()[0].getAntal(),2);
        assertEquals(o1.getDoser()[1].getAntal(),3);
        assertEquals(o1.getDoser()[2].getAntal(),4);
        assertEquals(o1.getDoser()[3].getAntal(),5);
    }
    @Test
    public void middagsAntal_0() {
        //Arrange
        Patient p = new Patient("121556-0512","Jane Jensen",63.4);
        Laegemiddel l = new Laegemiddel("Paracetamol",1,1.5,2,"ML");
        //Act
        DagligFast o1 = new DagligFast(LocalDate.of(2022,5,1),LocalDate.of(2022,6,1),p,l,2,0,4,5);
        //Assert
        assertEquals(o1.getDoser()[1].getAntal(),0);
    }
    @Test
    public void aftensAntal_0() {
        //Arrange
        Patient p = new Patient("121556-0512","Jane Jensen",63.4);
        Laegemiddel l = new Laegemiddel("Paracetamol",1,1.5,2,"ML");
        //Act
        DagligFast o1 = new DagligFast(LocalDate.of(2022,5,1),LocalDate.of(2022,6,1),p,l,2,3,0,5);
        //Assert
        assertEquals(o1.getDoser()[2].getAntal(),0);
    }
    @Test
    public void natAntal_0() {
        //Arrange
        Patient p = new Patient("121556-0512","Jane Jensen",63.4);
        Laegemiddel l = new Laegemiddel("Paracetamol",1,1.5,2,"ML");
        //Act
        DagligFast o1 = new DagligFast(LocalDate.of(2022,5,1),LocalDate.of(2022,6,1),p,l,2,3,4,0);
        //Assert
        assertEquals(o1.getDoser()[3].getAntal(),0);
    }

    @Test
    public void opretDosis_Index0() {
        //Arrange
        Patient p = new Patient("121556-0512","Jane Jensen",63.4);
        Laegemiddel l = new Laegemiddel("Paracetamol",1,1.5,2,"ML");
        ArrayList<Dosis> dosisser = new ArrayList<>();
        //Act
        DagligFast o1 = new DagligFast(LocalDate.of(2022,5,1),LocalDate.of(2022,6,1),p,l,0,0,0,0);
        o1.opretDosis(LocalTime.of(1,0),5,0);

        //Assert
        assertEquals(o1.getDoser()[0].getAntal(),5);
    }
    @Test
    public void opretDosis_Index1() {
        //Arrange
        Patient p = new Patient("121556-0512","Jane Jensen",63.4);
        Laegemiddel l = new Laegemiddel("Paracetamol",1,1.5,2,"ML");
        ArrayList<Dosis> dosisser = new ArrayList<>();
        //Act
        DagligFast o1 = new DagligFast(LocalDate.of(2022,5,1),LocalDate.of(2022,6,1),p,l,0,0,0,0);
        o1.opretDosis(LocalTime.of(1,0),6,1);

        //Assert
        assertEquals(o1.getDoser()[1].getAntal(),6);
    }
    @Test
    public void opretDosis_Index2() {
        //Arrange
        Patient p = new Patient("121556-0512","Jane Jensen",63.4);
        Laegemiddel l = new Laegemiddel("Paracetamol",1,1.5,2,"ML");
        ArrayList<Dosis> dosisser = new ArrayList<>();
        //Act
        DagligFast o1 = new DagligFast(LocalDate.of(2022,5,1),LocalDate.of(2022,6,1),p,l,0,0,0,0);
        o1.opretDosis(LocalTime.of(1,0),10,2);

        //Assert
        assertEquals(o1.getDoser()[2].getAntal(),10);
    }
    @Test
    public void opretDosis_Index3() {
        //Arrange
        Patient p = new Patient("121556-0512","Jane Jensen",63.4);
        Laegemiddel l = new Laegemiddel("Paracetamol",1,1.5,2,"ML");
        ArrayList<Dosis> dosisser = new ArrayList<>();
        //Act
        DagligFast o1 = new DagligFast(LocalDate.of(2022,5,1),LocalDate.of(2022,6,1),p,l,0,0,0,0);
        o1.opretDosis(LocalTime.of(1,0),2,3);

        //Assert
        assertEquals(o1.getDoser()[3].getAntal(),2);
    }
}
