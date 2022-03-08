package ordination;

import java.lang.reflect.Array;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;

public abstract class DagligFast<dosiser> extends Ordination {


        // composition -> 0..* dosis
        private final Dosis[] dosiser = new Dosis[4];
        public Dosis[]() {
            return dosiser.clone();
        }

        public Dosis createDosis(String name) {
            Dosis dosis = new Dosis(name);
            dosiser[]dosisers;
            return dosis;
        }






        //-----------------------------------------




    }


    // TODO


