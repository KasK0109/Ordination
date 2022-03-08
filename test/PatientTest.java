import ordination.Ordination;
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
        Ordination ordination1 = new Ordination(date1, date2, "Jane Jensen ", "Parcatemol") {
        }
        ordinationer.add(Ordination);
        //Assert
        assert (ordinationer.contains(ordination));
    }



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

