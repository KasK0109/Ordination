package ordination;

import ordination.DagligSkaev;
import ordination.Dosis;
import ordination.Laegemiddel;
import ordination.Patient;
import org.junit.Test;

import java.lang.reflect.Array;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class DaligSkaevTest {

    @Test
    public void test_opretDosis() {
        //Arrange
        LocalTime time1 = LocalTime.of(8,00);
        ArrayList<Dosis> dosisser = new ArrayList<>();
        int antal = 5;
        Dosis dosis = new Dosis(time1,5);

        //Act
        dosisser.add(dosis);
        //Assert
        assert(dosisser.contains(dosis));

    }
    @Test
    public void test_dagligSkaev(){
        //Arrange
        ArrayList<DagligSkaev>dagligSkaevArrayList = new ArrayList<>();
        LocalDate date1 = LocalDate.of(2022,5,2);
        LocalDate date2 = LocalDate.of(2022,6,2);
        Patient patient1 = new Patient("12345678", "Jane Jensen",63.4);
        Laegemiddel laegemiddel = new Laegemiddel("Paracatemol",3.2,1.5,2.0,"Mil");
        LocalTime localTime1 = LocalTime.of(8,00);
        LocalTime[] klokkeslet = {LocalTime.of(8,0),LocalTime.of(12,0),LocalTime.of(18,0),LocalTime.of(22,0)};
        double[] antalEnheder = {5,3,2,5};


        DagligSkaev dagligSkaev = new DagligSkaev(date1,date2, patient1,laegemiddel ,klokkeslet, antalEnheder);
        //Act
        dagligSkaevArrayList.add(dagligSkaev);

        //Assert
        assert (dagligSkaevArrayList.contains(dagligSkaev));





    }

}
