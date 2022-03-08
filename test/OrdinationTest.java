import ordination.*;
import org.junit.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class OrdinationTest {

    @Test
    public void OpretPåDagsDato(){
        //Arrange
        Patient p = new Patient("121556-0512","Jane Jensen",63.4);
        Laegemiddel l = new Laegemiddel("Paracetamol",1,1.5,2,"ML");
        //Act
        Ordination o = new DagligFast(LocalDate.of(2022,3,4),LocalDate.of(2022,3,9),p,null,1,2,1,2);
        o.setLaegemiddel(l);
        //Assert
        assertEquals(o.getLaegemiddel(),l);
    }

}
