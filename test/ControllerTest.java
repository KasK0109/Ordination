import controller.Controller;
import ordination.Laegemiddel;
import ordination.Patient;
import org.junit.Test;
import storage.Storage;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import static org.mockito.Mockito.*;
public class ControllerTest {
    public Controller controller = Controller.getController();

    @Test
    public void test_opretLaegemiddel (){
        //Arrange

        ArrayList<Laegemiddel>laegemiddelArrayList = new ArrayList<>();
         double normalVægt = 1.5;
         double underVægt = 0.5;
         double overVægt = 2;
         Laegemiddel laegemiddelheoin = new Laegemiddel("Heoin",underVægt,normalVægt,overVægt,"Mil");

         //Act
        laegemiddelArrayList.add(laegemiddelheoin);

        //Assert
        assert (laegemiddelArrayList.contains(laegemiddelheoin));
        assertEquals("Heoin",laegemiddelheoin.getNavn());
        assertEquals(0.5,underVægt);
        assertEquals(1.5,normalVægt);
        assertEquals(2,overVægt);


    }
    @Test
    public void test_anbefaletDosisPrDoegn(){
        double[] antalEnheder = {5,3,2,5};
        //Arrange
        double normalVægt = 1.5;
        double underVægt = 0.5;
        double overVægt = 2;


        Laegemiddel laegemiddel = new Laegemiddel("heoin",underVægt, normalVægt, overVægt,"Mil");

        Patient patient1 = new Patient("12345678", "Jane Jensen",63.6);
        Patient patient2 = new Patient("12345672", "Peter Madsen",130.1);
        Patient patient3 = new Patient("12345671", "Jørgen Nilsen",19.3);

        //Act
        assertEquals(underVægt*patient3.getVaegt(),controller.anbefaletDosisPrDoegn(patient3,laegemiddel));
        assertEquals(normalVægt*patient1.getVaegt(),controller.anbefaletDosisPrDoegn(patient1,laegemiddel));
        assertEquals(overVægt * patient2.getVaegt(),controller.anbefaletDosisPrDoegn(patient2,laegemiddel));





        //Assert


    }
    @Test
    // Hvis 'p' har et navn er patienten blevet oprettet
    public void opretPatient_test(){
        //Arrange
        //Act
        Patient p = new Patient("121256-0512","Jane Jensen",63.4);
        //Assert
        assertEquals(p.getNavn(),"Jane Jensen");
    }


}
