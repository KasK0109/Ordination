import ordination.Laegemiddel;
import ordination.Ordination;
import ordination.PN;
import ordination.Patient;
import org.junit.Test;

import java.time.LocalDate;
import java.util.ArrayList;

import static com.sun.tools.doclint.Entity.or;

public class PatientTest {

    @Test
    public  void test_addOrdination() {
        //Arrange

        ArrayList<Ordination> ordinationer = new ArrayList<>();
        LocalDate date1 = LocalDate.of(2022, 5, 2);
        LocalDate date2 = LocalDate.of(2022, 6, 5);

        //Act
        Patient patient1 = new Patient("12345678", "Jane Jensen",63.4);
        Laegemiddel laegemiddel = new Laegemiddel("Paracatemol",3.2,1.5,2.0,"Mil");
        Ordination ordination1 = new PN(date1, date2, patient1, laegemiddel,6);

        ordinationer.add(ordination1);
        //Assert
        assert (ordinationer.contains(ordination1));
    }




        @Test
        public void test_removeOrdination (Ordination ordination) {
            ArrayList<Ordination> ordinationer = new ArrayList<>();
            ordinationer.add(ordination);

            ordinationer.remove(ordination);

            //Assert
        assert (ordinationer.isEmpty());

        }

    }

