import ordination.DagligSkaev;
import ordination.Dosis;
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

        DagligSkaev dagligSkaev = new DagligSkaev(date1,date2, "Jane Jensen","Paracetamol" ,"08:00 12:00, 18:00, 22:00", "5,3,2,5");
        //Act
        dagligSkaevArrayList.add(dagligSkaev);

        //Assert
        assert (dagligSkaevArrayList.contains(dagligSkaev));





    }

}
