package ordination;

import ordination.*;
import org.junit.Test;

import java.time.LocalDate;
import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.*;

public class OrdinationTest {

    @Test
    public void SetLaegemiddelTest(){
        //Arrange
        Patient p = new Patient("121556-0512","Jane Jensen",63.4);
        Laegemiddel l = new Laegemiddel("Paracetamol",1,1.5,2,"ML");
        Ordination o = new DagligFast(LocalDate.of(2022,3,4),LocalDate.of(2022,3,9),p,null,1,2,1,2);
        //Act
        o.setLaegemiddel(l);
        //Assert
        assertEquals(o.getLaegemiddel(),l);
    }

    @Test
     public void getLaegemiddelTest() {
        //Arrange
        Patient p = new Patient("121556-0512","Jane Jensen",63.4);
        Laegemiddel l = new Laegemiddel("Paracetamol",1,1.5,2,"ML");
        Ordination o = new DagligFast(LocalDate.of(2022,3,4),LocalDate.of(2022,3,9),p,l,1,2,1,2);
        //Act

        //Assert
        assertEquals(o.getLaegemiddel(),l);
    }
    @Test
    public void getStartDatoTest_gyldig() {
        //Arrange
        Patient p = new Patient("121556-0512","Jane Jensen",63.4);
        Laegemiddel l = new Laegemiddel("Paracetamol",1,1.5,2,"ML");
        Ordination o = new DagligFast(LocalDate.of(2022,1,5),LocalDate.of(2022,3,9),p,l,1,2,1,2);
        //Act

        //Assert
        assertEquals(o.getStartDen(),LocalDate.of(2022,1,5));
    }
    @Test
    public void getSlutDatoTest() {
        //Arrange
        Patient p = new Patient("121556-0512","Jane Jensen",63.4);
        Laegemiddel l = new Laegemiddel("Paracetamol",1,1.5,2,"ML");
        Ordination o = new DagligFast(LocalDate.of(2022,1,5),LocalDate.of(2022,5,5),p,l,1,2,1,2);
        //Act

        //Assert
        assertEquals(o.getSlutDen(),LocalDate.of(2022,5,5));
    }
    @Test
    public void getAntalDage() {
        //Arrange
        Patient p = new Patient("121556-0512","Jane Jensen",63.4);
        Laegemiddel l = new Laegemiddel("Paracetamol",1,1.5,2,"ML");
        Ordination o = new DagligFast(LocalDate.of(2022,5,1),LocalDate.of(2022,5,5),p,l,1,2,1,2);
        //Act

        //Assert
        assertEquals(o.antalDage(),5);
    }
    @Test
    public void samletDosisTest_DagligSkaev() {
        //Arrange
        LocalTime[] klokkeslet = {LocalTime.of(8,0),LocalTime.of(12,0),LocalTime.of(18,0),LocalTime.of(22,0)};
        double[] antalEnheder = {5,3,2,5};
        Patient p = new Patient("121556-0512","Jane Jensen",63.4);
        Laegemiddel l = new Laegemiddel("Paracetamol",1,1.5,2,"ML");
        DagligFast o1 = new DagligFast(LocalDate.of(2022,5,1),LocalDate.of(2022,6,1),p,l,1,2,1,2);
        DagligSkaev o2 = new DagligSkaev(LocalDate.of(2022,5,1),LocalDate.of(2022,6,1),p,l,klokkeslet, antalEnheder);
        PN o3 = new PN(LocalDate.of(2022,5,2),LocalDate.of(2022,6,2),p,l,5);
        //Act

        //Assert
        assertEquals(465,o2.samletDosis());
    }
    @Test
    public void samletDosisTest_DagligFast() {
        //Arrange
        LocalTime[] klokkeslet = {LocalTime.of(8,0),LocalTime.of(12,0),LocalTime.of(18,0),LocalTime.of(22,0)};
        double[] antalEnheder = {5,3,2,5};
        Patient p = new Patient("121556-0512","Jane Jensen",63.4);
        Laegemiddel l = new Laegemiddel("Paracetamol",1,1.5,2,"ML");
        DagligFast o1 = new DagligFast(LocalDate.of(2022,5,1),LocalDate.of(2022,6,1),p,l,5,3,2,5);
        DagligSkaev o2 = new DagligSkaev(LocalDate.of(2022,5,1),LocalDate.of(2022,6,1),p,l,klokkeslet, antalEnheder);
        PN o3 = new PN(LocalDate.of(2022,5,2),LocalDate.of(2022,6,2),p,l,5);
        //Act

        //Assert
        assertEquals(465,o1.samletDosis());
    }
    @Test
    public void samletDosisTest_PN() {
        //Arrange
        LocalTime[] klokkeslet = {LocalTime.of(8,0),LocalTime.of(12,0),LocalTime.of(18,0),LocalTime.of(22,0)};
        double[] antalEnheder = {5,3,2,5};
        Patient p = new Patient("121556-0512","Jane Jensen",63.4);
        Laegemiddel l = new Laegemiddel("Paracetamol",1,1.5,2,"ML");
        DagligFast o1 = new DagligFast(LocalDate.of(2022,5,1),LocalDate.of(2022,6,1),p,l,1,2,1,2);
        DagligSkaev o2 = new DagligSkaev(LocalDate.of(2022,5,1),LocalDate.of(2022,6,1),p,l,klokkeslet, antalEnheder);
        PN o3 = new PN(LocalDate.of(2022,5,2),LocalDate.of(2022,6,2),p,l,5);
        //Act
        o3.givDosis(LocalDate.of(2022,5,8));
        o3.givDosis(LocalDate.of(2022,5,15));
        o3.givDosis(LocalDate.of(2022,5,28));
        //Assert
        assertEquals(15,o3.samletDosis());
    }
    @Test
    public void DoegnDosisTest_DagligSkaev() {
        //Arrange
        LocalTime[] klokkeslet = {LocalTime.of(8,0),LocalTime.of(12,0),LocalTime.of(18,0),LocalTime.of(22,0)};
        double[] antalEnheder = {5,3,2,5};
        Patient p = new Patient("121556-0512","Jane Jensen",63.4);
        Laegemiddel l = new Laegemiddel("Paracetamol",1,1.5,2,"ML");
        DagligFast o1 = new DagligFast(LocalDate.of(2022,5,1),LocalDate.of(2022,6,1),p,l,1,2,1,2);
        DagligSkaev o2 = new DagligSkaev(LocalDate.of(2022,5,1),LocalDate.of(2022,6,1),p,l,klokkeslet, antalEnheder);
        PN o3 = new PN(LocalDate.of(2022,5,2),LocalDate.of(2022,6,2),p,l,5);
        //Act

        //Assert
        assertEquals(15,o2.doegnDosis());
    }
    @Test
    public void DoegnDosisTest_DagligFast() {
        //Arrange
        LocalTime[] klokkeslet = {LocalTime.of(8,0),LocalTime.of(12,0),LocalTime.of(18,0),LocalTime.of(22,0)};
        double[] antalEnheder = {5,3,2,5};
        Patient p = new Patient("121556-0512","Jane Jensen",63.4);
        Laegemiddel l = new Laegemiddel("Paracetamol",1,1.5,2,"ML");
        DagligFast o1 = new DagligFast(LocalDate.of(2022,5,1),LocalDate.of(2022,6,1),p,l,5,3,2,5);
        DagligSkaev o2 = new DagligSkaev(LocalDate.of(2022,5,1),LocalDate.of(2022,6,1),p,l,klokkeslet, antalEnheder);
        PN o3 = new PN(LocalDate.of(2022,5,2),LocalDate.of(2022,6,2),p,l,5);
        //Act

        //Assert
        assertEquals(15,o1.doegnDosis());
    }
    @Test
    public void DoegnDosisTest_PN() {
        //Arrange
        LocalTime[] klokkeslet = {LocalTime.of(8,0),LocalTime.of(12,0),LocalTime.of(18,0),LocalTime.of(22,0)};
        double[] antalEnheder = {5,3,2,5};
        Patient p = new Patient("121556-0512","Jane Jensen",63.4);
        Laegemiddel l = new Laegemiddel("Paracetamol",1,1.5,2,"ML");
        DagligFast o1 = new DagligFast(LocalDate.of(2022,5,1),LocalDate.of(2022,6,1),p,l,1,2,1,2);
        DagligSkaev o2 = new DagligSkaev(LocalDate.of(2022,5,1),LocalDate.of(2022,6,1),p,l,klokkeslet, antalEnheder);
        PN o3 = new PN(LocalDate.of(2022,5,2),LocalDate.of(2022,6,2),p,l,5);
        //Act
        o3.givDosis(LocalDate.of(2022,5,8));
        o3.givDosis(LocalDate.of(2022,5,15));
        o3.givDosis(LocalDate.of(2022,5,28));
        //Assert
        assertEquals(0.7142857142857143,o3.doegnDosis());
    }
    @Test
    public void GetTypeTest_DagligSkaev() {
        //Arrange
        LocalTime[] klokkeslet = {LocalTime.of(8,0),LocalTime.of(12,0),LocalTime.of(18,0),LocalTime.of(22,0)};
        double[] antalEnheder = {5,3,2,5};
        Patient p = new Patient("121556-0512","Jane Jensen",63.4);
        Laegemiddel l = new Laegemiddel("Paracetamol",1,1.5,2,"ML");
        DagligFast o1 = new DagligFast(LocalDate.of(2022,5,1),LocalDate.of(2022,6,1),p,l,1,2,1,2);
        DagligSkaev o2 = new DagligSkaev(LocalDate.of(2022,5,1),LocalDate.of(2022,6,1),p,l,klokkeslet, antalEnheder);
        PN o3 = new PN(LocalDate.of(2022,5,2),LocalDate.of(2022,6,2),p,l,5);
        //Act

        //Assert
        assertEquals("Daglig Skaev",o2.getType());
    }
    @Test
    public void GetTypeTest_DagligFast() {
        //Arrange
        LocalTime[] klokkeslet = {LocalTime.of(8,0),LocalTime.of(12,0),LocalTime.of(18,0),LocalTime.of(22,0)};
        double[] antalEnheder = {5,3,2,5};
        Patient p = new Patient("121556-0512","Jane Jensen",63.4);
        Laegemiddel l = new Laegemiddel("Paracetamol",1,1.5,2,"ML");
        DagligFast o1 = new DagligFast(LocalDate.of(2022,5,1),LocalDate.of(2022,6,1),p,l,1,2,1,2);
        DagligSkaev o2 = new DagligSkaev(LocalDate.of(2022,5,1),LocalDate.of(2022,6,1),p,l,klokkeslet, antalEnheder);
        PN o3 = new PN(LocalDate.of(2022,5,2),LocalDate.of(2022,6,2),p,l,5);
        //Act

        //Assert
        assertEquals("Daglig Fast",o1.getType());
    }
    @Test
    public void GetTypeTest_PN() {
        //Arrange
        LocalTime[] klokkeslet = {LocalTime.of(8,0),LocalTime.of(12,0),LocalTime.of(18,0),LocalTime.of(22,0)};
        double[] antalEnheder = {5,3,2,5};
        Patient p = new Patient("121556-0512","Jane Jensen",63.4);
        Laegemiddel l = new Laegemiddel("Paracetamol",1,1.5,2,"ML");
        DagligFast o1 = new DagligFast(LocalDate.of(2022,5,1),LocalDate.of(2022,6,1),p,l,1,2,1,2);
        DagligSkaev o2 = new DagligSkaev(LocalDate.of(2022,5,1),LocalDate.of(2022,6,1),p,l,klokkeslet, antalEnheder);
        PN o3 = new PN(LocalDate.of(2022,5,2),LocalDate.of(2022,6,2),p,l,5);
        //Act
        o3.givDosis(LocalDate.of(2022,5,8));
        o3.givDosis(LocalDate.of(2022,5,15));
        o3.givDosis(LocalDate.of(2022,5,28));
        //Assert
        assertEquals("Pro necessitate",o3.getType());
    }



}
